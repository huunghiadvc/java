package jsonLab;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import session3.User;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JsonLab {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) throws JsonProcessingException {

        jsonList();

        jsonMap();

        User u = User.builder()
                .id(1)
                .username("Nghia")
                .password("123456")
                .createdAt(new Date())
                .updatedAt(new Date())
                .createdBy("admin")
                .updatedBy("admin")
//                .profileList(profileList)
                .build();

//        String jsonStr = objectMapper.writeValueAsString(u);

        String jsonStr = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(u);

        System.out.println(jsonStr);

        String jsonData = "{\"id\":1,\"username\":\"Nghia\",\"password\":\"123456\",\"status\":0,\"loginFail\":0,\"createdAt\":1701174574670,\"updatedAt\":1701174574670,\"createdBy\":\"admin\",\"updatedBy\":\"admin\"}";

        User u1 = objectMapper.readValue(jsonData, User.class);

        System.out.println(u1.toString());

        u = objectMapper.readValue(jsonData, User.class);

        System.out.println(u);

    }

    private  static void jsonList() throws JsonProcessingException {
        List<Profile> profileList = Arrays.asList(
                new Profile("Dev", 2000000),
                new Profile("Doctor", 18000000)
        );
        String json = objectMapper.writeValueAsString(profileList);

        List<Profile> parsedProfile = objectMapper.readValue(json, new TypeReference<List<Profile>>() {});

        parsedProfile.forEach(System.err::println);

    }

    private  static void jsonMap() throws JsonProcessingException {
        String jsonData = "{\"id\":1,\"username\":\"Nghia\",\"password\":\"123456\",\"status\":0,\"loginFail\":0,\"createdAt\":1701174574670,\"updatedAt\":1701174574670,\"createdBy\":\"admin\",\"updatedBy\":\"admin\"}";

        Map<String, Object> map = objectMapper.readValue(jsonData, new TypeReference<Map<String, Object>>() {});

        System.out.println(map.get("username"));

        System.out.println(map);

    }

}
