package ViettelPostAPI.entity.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VPPostExpress implements Serializable {
    private int type;
    @JsonProperty("SERVICE_CODE")
    private String serviceCode;
    @JsonProperty("SERVICE_NAME")
    private String serviceName;
    @JsonProperty("DESCRIPTION")
    private String desc;
}
