package com.dyz.dev.controller;

import com.dyz.dev.model.CaseForm;
import com.dyz.dev.utils.Result;
import com.dyz.dev.utils.ResultGenerator;
import com.dyz.dev.utils.cache.CacheUtils;
import com.dyz.dev.utils.cache.NoSupportCacheType;
import com.dyz.dev.utils.es.ESTools;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.dyz.dev.utils.Constants.MODULE_NAME;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/es")
public class ElasticSearchController {
  @Autowired
  ESTools esTools;
  @Autowired
  private CacheUtils cacheUtils;

  @RequestMapping("/search")
  public Result search(String value, HttpServletRequest request) throws IOException, NoSupportCacheType {
    String moduleName = (String) cacheUtils.get(MODULE_NAME, request);
    List<CaseForm> caseFormList = new ArrayList<>();
    List<String> ms = Arrays.asList(moduleName.split(",")).stream().filter(i -> !"".equals(i)).collect(toList());
    for ( String name: ms) {
      // 多个索引查询
      caseFormList.addAll(
        new ArrayList<>(esTools.searchByBool(name.toLowerCase(), value, null, null)));
    }
    caseFormList = caseFormList.stream().distinct().collect(toList());
    // todo 搜索的索引要根据模块创建
//    List<CaseForm> caseFormList = esTools.searchByBool("index1", value, null, null);
    return ResultGenerator.successResult(caseFormList);
  }
}
