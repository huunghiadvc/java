package ViettelPostAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostOfficeWrapperClass implements Serializable {
    private String status;
    private String error;
    private String message;
    @JsonProperty("data")
    private List<PostOffice> postOffices;
}
