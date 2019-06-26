import com.ekfet.elastic.config.ElasticClientConfig;
import org.junit.jupiter.api.Test;

public class EsClientTest {

    @Test
    public  void restClientTest(){
        ElasticClientConfig.getDefaultRestClient();
    }
}
