package ViettelPostAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {
    private int userId;
    private String token;
    private String partner;
    private String phone;
    private String postcode;
    private String expired;
    private String encrypted;
    private String source;
    private String infoUpdated;
}
