package kz.tsb.katoelasticwrapper;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/kato")
public class KatoRestController {

    @GetMapping("/{id}")
    public ResponseEntity<?>getSettlementChilds(@PathVariable("id") Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        String source = "{\n" +
                "  \"size\": 100,\n" +
                "  \"query\": {\n" +
                "    \"filtered\": {\n" +
                "      \"query\": {\n" +
                "        \"bool\": {\n" +
                "          \"must\": [\n" +
                "            {\n" +
                "              \"match\": {\n" +
                "                \"Parent\": "+ id +"\n" +
                "              }\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";

        String url = "http://data.egov.kz/api/v2/kato?source={source}";
        Settlement[] settlements = restTemplate.getForObject(url, Settlement[].class, source);

        return new ResponseEntity<>(settlements, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getKato() {

        RestTemplate restTemplate = new RestTemplate();

        String source = "{\n" +
                "  \"size\": 1000,\n" +
                "  \"query\": {\n" +
                "    \"filtered\": {\n" +
                "      \"query\": {\n" +
                "        \"bool\": {\n" +
                "          \"must\": [\n" +
                "            {\n" +
                "              \"range\": {\n" +
                "                \"AreaType\": {\n" +
                "                  \"gte\": 0,\n" +
                "                  \"lte\": 1\n" +
                "                }\n" +
                "              }\n" +
                "            },\n" +
                "            {\n" +
                "              \"match\": {\n" +
                "                \"Level\": 2\n" +
                "              }\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"sort\" : [\n" +
                "      {\n" +
                "        \"NameKaz\": \"asc\"\n" +
                "      }\n" +
                "   ]\n" +
                "}";

        String url = "http://data.egov.kz/api/v2/kato?source={source}";
        Settlement[] settlements = restTemplate.getForObject(url, Settlement[].class, source);

        return new ResponseEntity<>(settlements, HttpStatus.OK);
    }

}
