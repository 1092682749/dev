package com.dyz.dev.utils.es;

import com.alibaba.fastjson.JSON;
import com.dyz.dev.model.CaseForm;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ESTools {
  public static Logger logger = LoggerFactory.getLogger(ESTools.class.getName());
  @Autowired
  RestHighLevelClient client;

  public IndexResponse putDocument(String index, CaseForm doc) throws IOException {
    IndexRequest indexRequest = new IndexRequest(index.toLowerCase());

    indexRequest.id(doc.getCaseId().toString()).source(JSON.toJSONString(doc), XContentType.JSON);
    IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
    return response;
  }

  public List<CaseForm> searchByBool(String index, String token, Date startDate, Date endDate) throws IOException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SearchRequest searchRequest = new SearchRequest(index.toLowerCase());

//   // 构造分词查询
    MatchQueryBuilder titleQueryBuilder = QueryBuilders.matchQuery("title", token)
      .analyzer("ik_max_word");
    MatchQueryBuilder briefQueryBuilder = QueryBuilders.matchQuery("brief", token)
      .analyzer("ik_max_word");
    MatchQueryBuilder contentQueryBuilder = QueryBuilders.matchQuery("content", token)
      .analyzer("ik_max_word");
    MatchQueryBuilder tagQueryBuilder = QueryBuilders.matchQuery("tags", token)
      .analyzer("ik_max_word");

    // 构造模糊匹配
    MatchPhraseQueryBuilder titleMatchPhraseQueryBuilder = QueryBuilders.matchPhraseQuery("title", token);
    MatchPhraseQueryBuilder contentMatchPhraseQueryBuilder = QueryBuilders.matchPhraseQuery("content", token);
    MatchPhraseQueryBuilder briefMatchPhraseQueryBuilder = QueryBuilders.matchPhraseQuery("brief", token);
    MatchPhraseQueryBuilder tagsMatchPhraseQueryBuilder = QueryBuilders.matchPhraseQuery("tags", token);


    BoolQueryBuilder builder = QueryBuilders.boolQuery().should(titleQueryBuilder)
      .should(titleQueryBuilder)
      .should(contentQueryBuilder)
      .should(titleMatchPhraseQueryBuilder)
      .should(contentMatchPhraseQueryBuilder)
      .should(briefMatchPhraseQueryBuilder)
      .should(tagsMatchPhraseQueryBuilder);

    if (startDate != null && endDate != null) {
      RangeQueryBuilder rangeQueryBuilder1 = QueryBuilders
        .rangeQuery("createDate")
        .gt(sdf.format(startDate));
      RangeQueryBuilder rangeQueryBuilder2 = QueryBuilders
        .rangeQuery("createDate")
        .lt(sdf.format(endDate));
      builder.must(rangeQueryBuilder1).must(rangeQueryBuilder2);
    }

    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    sourceBuilder.query(builder)
      .highlighter(new HighlightBuilder().field("content").preTags("<span class=\"highlight\">").postTags("</span>"));
    searchRequest.source(sourceBuilder);
    logger.info(sourceBuilder.toString());
//    SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//    SearchHits searchHits = response.getHits();

    return getListFromResponse(searchRequest);
  }

  public void searchByMulti() {
//  QueryBuilders.multiMatchQuery()
  }

  public List<CaseForm> findAllByIndex(String index) throws IOException {
    SearchRequest searchRequest = new SearchRequest(index.toLowerCase());
    return getListFromResponse(searchRequest);
  }

  public List<CaseForm> getListFromResponse(SearchRequest searchRequest) throws IOException {
    SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
    List<CaseForm> caseFormList = new LinkedList<>();
    Arrays.sort(response.getHits().getHits(), new Comparator<SearchHit>() {
        @Override
        public int compare(SearchHit o1, SearchHit o2) {
          return (int) (o2.getScore() - o1.getScore());
        }
      });
      response.getHits().forEach(i -> {
        logger.info(i.getSourceAsString());
        caseFormList.add(mappingCaseForm(i));
      });
    return caseFormList;
  }
  public void searchByPhrase(String index, String token) {
    QueryBuilders.matchPhraseQuery("title", token);
  }
  public CaseForm mappingCaseForm(SearchHit hit) {
    CaseForm caseForm = new CaseForm();
    caseForm.setCaseId(Integer.valueOf(hit.getId()));
    Map<String, Object> map = hit.getSourceAsMap();
    Map<String, HighlightField> highlightFields = hit.getHighlightFields();

    caseForm.setTitle((String) map.get("title"));
//    caseForm.setContent((String) map.get("content"));
    if (highlightFields != null) {
      if (highlightFields.get("content") != null)
        caseForm.setContent(highlightFields.get("content").toString());
    }

    caseForm.setBrief((String) map.get("brief"));
    return caseForm;
  }

  public void DeleteDoc(String index, String id) throws IOException {
    DeleteRequest request = new DeleteRequest(
      index.toLowerCase(),
      id);
    DeleteResponse deleteResponse = client.delete(request, RequestOptions.DEFAULT);
  }
}
