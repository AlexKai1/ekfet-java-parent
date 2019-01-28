package com.ekfet.elastic.config;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ElasticClientConfig {

  private static String host = "192.168.1.112";

  public static RestClient getDefaultRestClient() {
    return RestClient.builder(new HttpHost(host, 9200, "http")).build();
  }

  public static  RestClient getSnycDefaultRestClient(){
   return RestClient.builder(
            new HttpHost(host, 9200))
            .setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
              @Override
              public HttpAsyncClientBuilder customizeHttpClient(
                      HttpAsyncClientBuilder httpClientBuilder) {
                return httpClientBuilder.setDefaultIOReactorConfig(
                        IOReactorConfig.custom()
                                .setIoThreadCount(1)
                                .build());
              }
            }).build();
  }

  public static RestClient getDefaultRestClient(Map<String, String> heads) {
    Header[] defaultHeaders =
        heads
            .entrySet()
            .stream()
            .map(
                x -> {
                  return new BasicHeader(x.getKey(), x.getValue());
                })
            .collect(Collectors.toList())
            .toArray(new BasicHeader[] {});
    return RestClient.builder(new HttpHost(host, 9200, "http"))
        .setDefaultHeaders(defaultHeaders)
        .build();
  }

  public static class EsClient {
    private List<String> hosts = new ArrayList<>();
    private List<Integer> ports = new ArrayList<>();

    public List<String> getHosts() {
      return hosts;
    }

    public void setHosts(List<String> hosts) {
      this.hosts = hosts;
    }

    public List<Integer> getPorts() {
      return ports;
    }

    public void setPorts(List<Integer> ports) {
      this.ports = ports;
    }

    public void addPorts(Integer port) {
      if (port == null) {
        port = 9200;
      }
      this.ports.add(port);
    }
  }
}
