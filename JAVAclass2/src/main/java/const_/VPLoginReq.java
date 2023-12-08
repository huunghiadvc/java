package const_;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VPLoginReq {
    @JsonProperty("USERNAME")
    private String username;
    @JsonProperty("PASSWORD")
    private String password;
}
