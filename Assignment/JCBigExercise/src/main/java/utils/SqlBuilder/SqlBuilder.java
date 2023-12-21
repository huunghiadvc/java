package utils.SqlBuilder;

import annotations.data.Column;
import entity.SearchEngine;
import utils.SqlBuilder.ClauseBuilder.*;

import java.util.List;

import static const_.StringSql.Operator.*;

public class SqlBuilder {
    public static String insert(String tableName, List<Column> columnName){
        return new InsertClause(tableName, columnName) +
                new ValuesClause(columnName.size())
                .toString()
                ;
    }

    public static String getById(String tableName, String idColumnName){
        return new SelectClause(tableName)
                + new WhereClause(idColumnName, EQUAL)
                .toString()
                ;
    }

    public static String getAll(String tableName, Integer limit, Integer offset){
        Integer[] data = {limit, offset};
        if (limit == null && offset == null){
            return new SelectClause(tableName).toString();
        }
        return new SelectClause(tableName)
                + new LimitOffsetClause(data)
                .toString()
                ;
    }

    public static String search(SearchEngine searchEngine, String tableName){
        StringBuilder sql = new StringBuilder(new SelectClause(tableName).toSql());
        if (searchEngine.getConditionList().isEmpty()){
            sql.append(new WhereClause(
                    searchEngine.getColumnList().getFirst(),
                    searchEngine.getOperatorList().getFirst()
            ));
        } else if (searchEngine.getConditionList().size() == 1){
            sql.append(new WhereClause(
                    searchEngine.getColumnList(),
                    searchEngine.getOperatorList(),
                    searchEngine.getConditionList().getFirst()
            ));
        } else {
            sql.append(new WhereClause(
                    searchEngine.getColumnList(),
                    searchEngine.getOperatorList(),
                    searchEngine.getConditionList()
            ));
        }
        return sql.toString();
    }

    public static String updateById(String tableName, String idColumnName, List<String> updates){
        return new UpdateClause(tableName, updates)
                + new WhereClause(idColumnName, EQUAL)
                .toString()
                ;
    }

    public static String deleteById(String tableName, String idColumnName, long id){
        return new DeletedClause(tableName)
                + new WhereClause(idColumnName, EQUAL)
                .toString()
                ;
    }

}
