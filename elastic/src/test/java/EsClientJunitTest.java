import com.ekfet.elastic.config.ElasticClientConfig;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class EsClientJunitTest {

    @Test
    public void TestClient(){

        RestClient restClient= ElasticClientConfig.getDefaultRestClient();

    }

  @Test
  public void TestRequest() throws IOException {
    Request request = new Request("GET", "/");
    RestClient restClient = ElasticClientConfig.getDefaultRestClient();
    Response response = restClient.performRequest(request);
    HttpEntity httpEntity = response.getEntity();
    String resultJson =
        new BufferedReader(new InputStreamReader(httpEntity.getContent()))
            .lines()
            .collect(Collectors.joining(System.lineSeparator()));
    System.out.println(resultJson);
  }
}
