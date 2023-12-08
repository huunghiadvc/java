package DemoCallAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class HttpsClientUtils {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Users {
        private int id;
        private String name;
        private Long age;
    }
    public static void main(String[] args) throws JsonProcessingException {
        // call api get return String
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
        ObjectMapper mapper = new ObjectMapper();



        String url = "https://7e91035e-3186-4f4a-ade0-aac76d41e434.mock.pstmn.io/getAllUser";
//        ResponseEntity<String> res = restTemplate.getForEntity(url, String.class);
//        List<user> userList = new ArrayList<>();
//        userList.add(mapper.readValue(res.getBody(), user.class));
//        userList.forEach(System.out::println);

//        user i = restTemplate.getForObject(url, user.class);

//        System.out.println(i);

//        if (res.getStatusCode() == HttpStatus.OK){
//            System.out.println("OK");
//        }
//
//        if (res.getStatusCode() == HttpStatus.UNAUTHORIZED){
//            System.out.println("UNAUTHORIZED");
//            // not authorize , redirect login page
//        }

        // call by exchange
//        Map<String, String> header = new HashMap<>();
//        header.put("Authorization", "fwererewrew-tokendemo");
//        header.put("Connection", "Keep alive");
//        header.put("Accept-Encoding", "encoding");
//        header.put("Content-Type", "application/json");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("id", "3");

        HttpEntity<?> httpEntity = new HttpEntity<>(body, httpHeaders);
        System.out.println(httpEntity);

        ResponseEntity<Users> u2 =
                restTemplate.exchange(url , HttpMethod.GET, httpEntity, Users.class);
        Users u1 = u2.getBody();
        System.out.println(u1);
    }
}
