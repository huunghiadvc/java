package lombok;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private long id;
    private String studentId;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private int tel;
    public static Student convert(String line, String header){
        if (StringUtils.isEmpty(line)) return null;
        if (line.trim().equalsIgnoreCase(header)) return null;
        String[] chars = line.split("\\|");

        return Student.builder()
                .id(Long.parseLong(chars[0]))
                .name(String.valueOf(chars[1]))
                .address(String.valueOf(chars[2]))
                .dateOfBirth(LocalDate.parse(chars[3]))
                .build();
    }
}
