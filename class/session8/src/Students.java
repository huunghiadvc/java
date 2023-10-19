import annocation.Table;
import utils.DateTimeUtils;

import java.util.Date;

@Table(table_name = "Student table", indexing = true, pattrioning = true)
public class Students {
    private String fullName;
    private Date dateOfBirth;
    private Date enterDate;
    private Integer age;
    private Integer ageLevel;

    public Students(String fullName, Date dateOfBirth, Date enterDate, Integer ageLevel) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.enterDate = enterDate;
        this.ageLevel = ageLevel;
        if (this.dateOfBirth != null){
            int age = DateTimeUtils.getAge(this.dateOfBirth);
            this.age = age < 0 ? null : age;
        }
        if (this.enterDate != null){
            int age = DateTimeUtils.getAge(this.enterDate);
            this.ageLevel = age < 0 ? null : age;
        }
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getAge() {
        if (this.dateOfBirth != null){
            int age = DateTimeUtils.getAge(this.dateOfBirth);
            return age < 0 ? null : age;
        }
        return null;
    }

    public Integer getAgeLevel() {
        if (this.enterDate != null){
            int age = DateTimeUtils.getAge(this.enterDate);
            return age < 0 ? null : age;
        }
        return null;
    }
}
