package com.dyz.dev;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DevApplicationTests {

    @Test
    public void contextLoads() {
    }

 @Test
public void test() throws IOException {
   RestHighLevelClient client = restClient();
   SearchRequest searchRequest = new SearchRequest("index1");
   RangeQueryBuilder rangeQueryBuilder = QueryBuilders
     .rangeQuery("createDate")
     .gt("2020-06-05");
//        QueryBuilders.matchQuery("name", "Robert");
   MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("content", "讲师，清华,丁银召")
     .analyzer("ik_max_word");

   BoolQueryBuilder builder = QueryBuilders.boolQuery().must(matchQueryBuilder).must(rangeQueryBuilder);
   SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
   sourceBuilder.query(builder)
     .highlighter(new HighlightBuilder().field("content").preTags("<span class=\"highlight\">").postTags("</span>"));
   searchRequest.source(sourceBuilder);
   System.out.println(sourceBuilder.toString());
   SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
   response.getHits().forEach(i -> {
     System.out.println(i.getSourceAsString());
     System.out.println(i.getHighlightFields());
   });

 }
   //    @Test
   public RestHighLevelClient restClient () throws IOException {
     RestHighLevelClient client = new RestHighLevelClient(
       RestClient.builder(
         new HttpHost("localhost", 9200, "http")));
     return client;
//        SearchRequest searchRequest = new SearchRequest("index3");
//
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        MultiMatchQueryBuilder multiMatchQueryBuilder = new MultiMatchQueryBuilder(
//                "清华大学",
//                "name",
//                "content"
//        );
////        multiMatchQueryBuilder.analyzer("ik_max_word");
//        System.out.println(multiMatchQueryBuilder.toString());
////        multiMatchQueryBuilder.
//        searchSourceBuilder.query(multiMatchQueryBuilder);
//        searchRequest.source(searchSourceBuilder);
////        searchSourceBuilde
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        System.out.println("size" + response.getHits().getTotalHits().value);
//        response.getHits().forEach(
//                hit -> {
//                    System.out.println(hit.getSourceAsString());
//                }
//        );
     // ElasticSearch: https://mirrors.huaweicloud.com/elasticsearch/?C=N&O=D
     //logstash: https://mirrors.huaweicloud.com/logstash/?C=N&O=D
     //kibana: https://mirrors.huaweicloud.com/kibana/?C=N&O=D
   }
 }
