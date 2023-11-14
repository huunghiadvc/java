package session6_reflection.test.VIDU;

import session6_reflection.Jpa.JpaRepositoryCloneImpl;
import session6_reflection.entity.Students;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository extends JpaRepositoryCloneImpl<Students> {
    public StudentRepository() {
        super(Students.class);
    }

    @Override
    protected List<Students> rowMapper(ResultSet rs) {
        List<Students> studentList = new ArrayList<>();
        try {
            while (rs.next()){
                studentList.add(
                        Students.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .dateOfBirth(rs.getDate("date_of_birth"))
                        .address(rs.getString("address"))
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

}
