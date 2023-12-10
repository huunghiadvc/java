package ViettelPostAPI.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder

public class ExpressBody {
    @JsonProperty("TYPE")
    private int type;
}
