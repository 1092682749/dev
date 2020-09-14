package com.dyz.dev.configuration.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@ConfigurationProperties("elasticsearch")
public class ESConfig {
//  @Value("$")
  String server;
  Integer port;
  @Bean("elasticRestClient")
  public RestHighLevelClient restClient () throws IOException {
    RestHighLevelClient client = new RestHighLevelClient(
      RestClient.builder(
        new HttpHost(server, port, "http")));
    return client;
  }

  public String getServer() {
    return server;
  }

  public void setServer(String server) {
    this.server = server;
  }

  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }
}
