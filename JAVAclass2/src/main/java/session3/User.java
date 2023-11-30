package session3;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jsonLab.CustomDateSerialize;
import jsonLab.CustomDeserialize;
import jsonLab.Profile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private int status;
    private int loginFail;
    @JsonSerialize(using = CustomDateSerialize.class)
    @JsonDeserialize(using = CustomDeserialize.class)
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;
//    private List<Profile> profileList;
}
