package ViettelPostAPI;

import ViettelPostAPI.entity.PostOffice;
import ViettelPostAPI.entity.UserData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

public class ClientUtils {
    private static final String url = "https://partner.viettelpost.vn/v2/user/Login";
    private static final String urlPostOffice = "https://partner.viettelpost.vn/v2/categories/listBuuCucVTP";
    private static final String username = "0355366152";
    private static final String password = "0972298876a";

    private static RestTemplate restTemplate;
    private static ObjectMapper obj;

    public static UserData login() throws JsonProcessingException {
        restTemplate = new RestTemplate();

        String body = "{\n" +
                "  \"USERNAME\": \""+username+"\",\n" +
                "  \"PASSWORD\": \""+password+"\"\n" +
                "}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> res = restTemplate.postForEntity(url, request, String.class);

        obj = new ObjectMapper();

        Map<String, Object> list = obj.readValue(res.getBody(), new TypeReference<Map<String, Object>>() {});

        if (list.get("status").equals(200)){
            String json = obj.writeValueAsString(list.get("data"));
            return obj.readValue(json, UserData.class);
        }

        return null;

    }

    public static List<PostOffice> getListPostOffice(String token) throws IOException {
        restTemplate = new RestTemplate();
        obj = new ObjectMapper();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("token", token);

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> res = restTemplate.exchange(urlPostOffice, HttpMethod.GET, request, String.class);

        Map<String, Object> list = obj.readValue(res.getBody(), new TypeReference<Map<String, Object>>() {});

        String json = obj.writeValueAsString(list.get("data"));
        return obj.readValue(json, new TypeReference<List<PostOffice>>() {});

    }

}
