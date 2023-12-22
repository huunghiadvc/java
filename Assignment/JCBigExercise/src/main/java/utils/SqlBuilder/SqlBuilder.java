package utils.SqlBuilder;

import annotations.data.Column;
import entity.SearchEngine;
import static utils.SqlBuilder.CreateSqlClause.*;
import java.util.List;

public class SqlBuilder {
    public static String insert(String tableName, List<Column> columnName){
        return insertBuilder(tableName, columnName) +
                valuesBuilder(columnName.size())
                ;
    }

    public static String getById(String tableName, String idColumnName){
        return selectBuilder(tableName) + whereBuilder(idColumnName);
    }

    public static String getAll(String tableName, Integer limit, Integer offset){
        if (limit == null && offset == null){
            return selectBuilder(tableName);
        }
        return selectBuilder(tableName) + limitOffsetClause(limit, offset);
    }

    public static String search(SearchEngine searchEngine, String tableName){
        return selectBuilder(tableName) + whereBuilder(searchEngine);
    }

    public static String updateById(String tableName, String idColumnName, List<String> updateCol){
        return updateBuilder(tableName, updateCol)
                + whereBuilder(idColumnName)
                ;
    }

    public static String deleteById(String tableName, String idColumnName){
        return deleteBuilder(tableName)
                + whereBuilder(idColumnName)
                ;
    }

}
