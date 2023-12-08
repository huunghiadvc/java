package const_;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class VPLoginRes implements Serializable {
    private String status;
    private boolean error;
    private String message;
    private Data data;
    @lombok.Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data {
        private String userId;
        private String token;
        private String partner;
        private String phone;
        private String postcode;
        private Date expired;
        private String encrypted;
        private int source;
        private String infoUpdated;
    }
}
