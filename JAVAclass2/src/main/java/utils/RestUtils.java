package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestUtils {
    private static RestTemplate restTemplate = new RestTemplate();
    private static Logger logger = LogManager.getLogger(RestUtils.class);

    public RestUtils() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
    }

    private HttpHeaders initHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
    // build http entity with token
    private HttpEntity<?> buildEntity(String token, Object body){
        HttpHeaders headers = initHeader();
        logger.info("Token : {}", token);
        if (token != null){
            if (!token.isEmpty()){
                headers.add("token", token);
            }
        }

        return body != null ? new HttpEntity<>(body, headers) : new HttpEntity<>(headers);
    }
    private HttpEntity<?> buildEntity(String token){
        HttpHeaders headers = initHeader();
        logger.info("Token : {}", token);
        if (token != null){
            if (!token.isEmpty()){
                headers.add("token", token);
            }
        }

        return new HttpEntity<>(headers);
    }
    private HttpEntity<?> buildEntity(){
        return buildEntity(null);
    }

    String concat(String... str){
        return String.join(",", str);
    }

    // build http entity no token
    public ResponseEntity<?> send(String path, HttpMethod method,Class<?> responseType,Object... uriVariables){
        if(uriVariables != null && uriVariables.length > 0){
            return restTemplate.exchange(path,method,buildEntity(),responseType,uriVariables);
        }else{
            return restTemplate.exchange(path,method,buildEntity(),responseType);
        }
    }
    public ResponseEntity<?> send(String token,String path, HttpMethod method,Class<?> responseType,Object... uriVariables){
        if(uriVariables != null && uriVariables.length > 0){
            return restTemplate.exchange(path,method,buildEntity(token),responseType,uriVariables);
        }else{
            return restTemplate.exchange(path,method,buildEntity(token),responseType);
        }
    }
    public ResponseEntity<?> send(String path, HttpMethod method,Object body,Class<?> responseType,Object... uriVariables){
        if(uriVariables != null && uriVariables.length > 0){
            return restTemplate.exchange(path,method,buildEntity(null, body),responseType,uriVariables);
        }else{
            return restTemplate.exchange(path,method,buildEntity(null, body),responseType);
        }
    }
    public ResponseEntity<?> send(String token,String path,Object body, HttpMethod method,Class<?> responseType,Object... uriVariables){
        if(uriVariables != null && uriVariables.length > 0){
            return restTemplate.exchange(path,method,buildEntity(token,body),responseType,uriVariables);
        }else{
            return restTemplate.exchange(path,method,buildEntity(token,body),responseType);
        }
    }

}
