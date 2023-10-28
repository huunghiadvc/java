package lombok;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private long id;
    private String studentId;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String tel;
}
