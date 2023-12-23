package dao;

import java.util.List;
import java.util.Map;

public interface FileService<T> {
    void createFile();
    List<T> fileReader();
    void writeToFile(List<T> objList);
    boolean writeToFile(T obj);
    void updateById(long id, Map<String, String> updateLog);
    void deleteById(long id);
}
