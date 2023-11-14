package StudentsLab.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Student {
    private int id;
    private String name;
    private Date dateOfBirth;
    private String address;

}
