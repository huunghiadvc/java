package ViettelPostAPI.entity;

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
public class PostOffice implements Serializable {
    @JsonProperty("TEN_TINH")
    private String TEN_TINH;
    @JsonProperty("TEN_QUANHUYEN")
    private String TEN_QUANHUYEN;
    @JsonProperty("TEN_PHUONGXA")
    private String TEN_PHUONGXA;
    @JsonProperty("MA_BUUCUC")
    private String MA_BUUCUC;
    @JsonProperty("TEN_BUUCUC")
    private String TEN_BUUCUC;
    @JsonProperty("DIA_CHI")
    private String DIA_CHI;
    @JsonProperty("LATITUDE")
    private String LATITUDE;
    @JsonProperty("LONGITUDE")
    private String LONGITUDE;
    @JsonProperty("DIEN_THOAI")
    private String DIEN_THOAI;
    @JsonProperty("PHUTRACH")
    private String PHUTRACH;
    @JsonProperty("PHUTRACHPHONE")
    private String PHUTRACHPHONE;
}
