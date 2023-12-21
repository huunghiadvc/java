package utils;

import java.sql.PreparedStatement;

public class InstanceUtils<Object> {
    public PreparedStatement checkInstanceOf(PreparedStatement preStmt, Object obj){
//        if (obj instanceof Student){
//            StudentWrapper wrapper = new StudentWrapper((Student) obj);
//            try {
//                StatementUtilsImpl.setObject(preStmt, wrapper);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
        return preStmt;
    }
}
