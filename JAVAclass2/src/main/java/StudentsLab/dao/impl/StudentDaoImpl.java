package StudentsLab.dao.impl;

import StudentsLab.dao.CustomerDao;
import StudentsLab.entity.Student;
import StudentsLab.config.DataBaseConnect;

import java.sql.*;

public class StudentDaoImpl implements CustomerDao {

    private Connection getConnect(){
        return DataBaseConnect.getConnection();
    }

    @Override
    public Boolean insert(Student stu) throws SQLException {
        String sqlInsert = " insert into " +
                "students (name, date_of_birth, address)"
                + " values (?, ?, ?)";
        Connection connect = getConnect();
        PreparedStatement preStmt;
        try {
            preStmt = connect.prepareStatement(sqlInsert);
            preStmt.setString (1, stu.getName());
            preStmt.setDate (2, Date.valueOf(String.valueOf(stu.getDateOfBirth())));
            preStmt.setString (3, stu.getAddress());
            preStmt.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student getById(int id) {
        Connection connection = getConnect();
        String sql = "SELECT * FROM `students` WHERE id = ?";
        // prepaid statement
        try {
            PreparedStatement preStmt = connection.prepareStatement(sql);
            preStmt.setInt(1, id);
            ResultSet rs = preStmt.executeQuery();
            Student stu = null;
            if(rs.next()){
                stu = rowMapper(rs);
            }
            return stu;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Student rowMapper(ResultSet rs){
        Student stu;
        try {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            java.util.Date dateOfBirth = (rs.getDate("date_of_birth"));
            String address = rs.getString("address");
            stu = Student.builder()
                    .id(id)
                    .name(name)
                    .dateOfBirth(dateOfBirth)
                    .address(address)
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stu;
    }

}
