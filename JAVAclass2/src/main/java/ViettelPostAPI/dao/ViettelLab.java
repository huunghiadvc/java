package ViettelPostAPI.dao;

import StudentsLab.config.DataBaseConnect;
import ViettelPostAPI.entity.PostOffice;
import ViettelPostAPI.entity.UserData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ViettelLab {
    private static Connection connection;
    public static void insert(UserData user) {
        String sql = "INSERT INTO `user_viettel_lab` VALUES (?,?,?,?);";
        connection = DataBaseConnect.getConnection();
        PreparedStatement preStmt;
        try {
            preStmt = connection.prepareStatement(sql);
            preStmt.setInt(1, user.getUserId());
            preStmt.setString(2, user.getToken());
            preStmt.setString(3, user.getPartner());
            preStmt.setString(4, user.getExpired());
            preStmt.execute();
            System.out.println("insert successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void insert(List<PostOffice> postOffices) {
        String sql = "INSERT INTO post_offices " +
                "VALUES (?,?,?,?,?) " +
                "ON DUPLICATE KEY UPDATE " +
                "office_name  = values(office_name), " +
                "address  = values(address), " +
                "latitude  = values(latitude), " +
                "longitude  = values(longitude)";
        connection = DataBaseConnect.getConnection();
        PreparedStatement preStmt;
        try {
            int index = 0;
            preStmt = connection.prepareStatement(sql);
            for (PostOffice office : postOffices) {
                if (office.getMA_BUUCUC() == null){
                    office.setMA_BUUCUC("ABC");
                }
                preStmt.setString(1, office.getMA_BUUCUC());
                preStmt.setString(2, office.getTEN_BUUCUC());
                preStmt.setString(3, office.getDIA_CHI());
                preStmt.setString(4, office.getLATITUDE());
                preStmt.setString(5, office.getLONGITUDE());
                long count = preStmt.executeUpdate();
                if (count != 0) {
                    System.out.printf("%d row affected!", count);
                    index += 1;
                }
            }
            System.out.printf("Total : %d rows affected!", index);
            preStmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void insert() {
        String sql = "INSERT INTO post_offices " +
                "VALUES (?,?,?,?,?) " +
                "ON DUPLICATE KEY UPDATE " +
                "office_name  = values(office_name), " +
                "address  = values(address), " +
                "latitude  = values(latitude), " +
                "longitude  = values(longitude)";
        connection = DataBaseConnect.getConnection();
        PreparedStatement preStmt;
        PostOffice office = new PostOffice();
        office.setMA_BUUCUC("ABH");
        office.setTEN_BUUCUC("Bưu cục An Bình - CTO edit");
        office.setDIA_CHI("55 Ngô Tất Tố edit");
        office.setLATITUDE("10.02266970036229 edit");
        office.setLONGITUDE("105.75378580230834 edit");
        try {
            preStmt = connection.prepareStatement(sql);
                try {
                    preStmt.setString(1, office.getMA_BUUCUC());
                    preStmt.setString(2, office.getTEN_BUUCUC());
                    preStmt.setString(3, office.getDIA_CHI());
                    preStmt.setString(4, office.getLATITUDE());
                    preStmt.setString(5, office.getLONGITUDE());
                    int count = preStmt.executeUpdate();
                    System.out.println(count);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
