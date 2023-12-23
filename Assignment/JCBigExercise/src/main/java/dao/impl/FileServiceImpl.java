package dao.impl;

import annotations.data.Id;
import annotations.data.Table;
import config.DataFileSource;
import dao.FileService;
import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class FileServiceImpl<T> implements FileService<T> {
    private final String urlFile;
    private final String fileName;
    private final String backupFileName;
    private String group;
    List<Field> objColumn;
    private final String header;

    protected abstract T rowMapper(String line);

    public FileServiceImpl(Class<?> clazz) {
        objColumn = new ArrayList<>();
        Table tableAnnotation = clazz.getAnnotation(Table.class);
        if (tableAnnotation != null){
            fileName = tableAnnotation.tableName();
            group = tableAnnotation.group();
        } else {
            fileName = clazz.getSimpleName();
        }
        this.urlFile = DataFileSource.getMainUrl() + group + fileName + ".txt";
        this.backupFileName = fileName + "_backup";
        StringBuilder builder  = new StringBuilder();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            if (f.getAnnotations().length != 0){
                if (f.equals(fields[fields.length-1])){
                    builder.append(f.getName().toUpperCase());
                    objColumn.add(f);
                    continue;
                }
                builder.append(f.getName().toUpperCase()).append("|");
                objColumn.add(f);
            }
        }
        this.header = builder.toString();
    }

    @Override
    public void createFile() {
        File f = new File(String.valueOf(urlFile));
        boolean createFile;
        try {
            createFile = f.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (createFile){
            System.err.println("Create file at " + urlFile + " successfully!!!");
        } else {
            System.err.println("Create file at " + urlFile + " failure!!!");
        }
    }

    @Override
    public List<T> fileReader() {
        List<T> objectRepo = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(urlFile))) {
            int count = 0;
            String line;
            while ((line = reader.readLine()) != null){
                if (line.equalsIgnoreCase(header)){
                    continue;
                }
                T obj = rowMapper(line);
                if (obj != null){
                    objectRepo.add(obj);
                    count++;
                }
            }
            System.out.printf("Import data of %d from %s file successfully!!!\n", count, fileName);
            return objectRepo;
        } catch (FileNotFoundException ex){
            createFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void writeToFile(List<T> objList) {
        int count = 0;
        for (T t : objList) {
            if (writeToFile(t)){
                count++;
            }
        }
        if (count > 0){
            System.out.println("Write " + count + " "+ fileName + " successfully at " + urlFile);
        }
    }

    @Override
    public boolean writeToFile(T obj) {
        String objLine = convertObjToString(obj).toString();
        List<String> txtData = getTxtData();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(urlFile, true))) {
            if (txtData.isEmpty()){
                writer.write(header);
                writer.newLine();
            } else {
                txtData.remove(header);
                for (String line : txtData) {
                    if (line.equalsIgnoreCase(objLine)){
                        System.err.println("OBJECT "+ objLine +" is already exist!");
                        return false;
                    }
                    if (isIdExist(objLine, line)){
                        System.err.println("OBJECT "+ objLine +" has the same id as another object in the file!" +
                                " Please update object!");
                        return false;
                    }
                }
            }
            writer.write(objLine);
            writer.newLine();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateById(long id, Map<String, String> updateLog){
        try {
            T obj = convertStringToObjectWithId(id);
            if (obj == null){
                System.out.println("Cannot find object with id " + id);
            } else {
                String oldLine = convertObjToString(obj).toString();
                StringBuilder newLine = new StringBuilder();
                for (Field f : objColumn){
                    f.setAccessible(true);
                    if (updateLog.get(f.getName()) != null){
                        newLine.append(updateLog.get(f.getName()));
                    } else {
                        newLine.append(f.get(obj));
                    }
                    if (!f.equals(objColumn.getLast())){
                        newLine.append("|");
                    }
                }
                updateFileData(newLine.toString(), oldLine);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    };
    @Override
    public void deleteById(long id){
        T obj = convertStringToObjectWithId(id);
        if (obj == null){
            System.err.println("Cannot find object with id " + id);
        } else {
            String line = convertObjToString(obj).toString();
            updateFileData(null, line);
        }
    };

    private List<String> getTxtData(){
        List<String> txtData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(urlFile))) {
            String str;
            while ((str = reader.readLine()) != null) {
                txtData.add(str);
            }
        } catch (FileNotFoundException e) {
            createFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return txtData;
    }

    private void updateFileData(String newLine, String oldLine){
        List<String> txtData = getTxtData();
        if (!txtData.isEmpty()){
            for (String line : txtData){
                if (oldLine.equalsIgnoreCase(line)){
                    if (newLine != null){
                        int index = txtData.indexOf(line);
                        txtData.set(index, newLine);
                        break;
                    }
                    txtData.remove(line);
                    break;
                }
            }
            writeListToFile(txtData);
        } else {
            System.err.println("Txt file is empty!");
        }
    }

    private void writeListToFile(List<String> data){
        String backup = DataFileSource.getMainUrl()+group+ backupFileName + ".tmp";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(backup))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        } catch (FileNotFoundException e){
            createFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                Files.copy(
                        Path.of(backup),
                        Path.of(urlFile),
                        StandardCopyOption.REPLACE_EXISTING
                );
                System.out.println("Transfer file successfully!");
            } catch (IOException e) {
                System.err.println("ERROR while transfer from tmp file to data file!");
                System.out.println("Tmp file in " + backup);
                System.out.println("Data file in " + urlFile);
            }
        }
    }

    private Field getIdField(){
        for (Field f : objColumn){
            f.setAccessible(true);
            if (f.getAnnotation(Id.class) != null){
                return f;
            }
        }
        return null;
    }

    private T convertStringToObjectWithId(long id){
        Field idField = getIdField();
        if (idField == null){
            throw new NullPointerException("Cannot get id field!");
        }
        long idColVal;
        List<T> objList = fileReader();
        try {
            for (T t : objList) {
                idColVal = (long) idField.get(t);
                if (idColVal == id) {
                    return t;
                } else {
                    return null;
                }
            }
        } catch(IllegalAccessException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    private StringBuilder convertObjToString(T obj){
        try {
            StringBuilder line = new StringBuilder();
            for (Field f : objColumn) {
                f.setAccessible(true);
                if (f.equals(objColumn.getLast())){
                    line.append(f.get(obj).toString());
                    continue;
                }
                line.append(f.get(obj).toString()).append("|");
            }
            return line;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isIdExist(String txtLine, String str) {
        long idColVal = -1;
        long objId = -2;
        Field idField = getIdField();
        try {
            idField.setAccessible(true);
            objId = (Long) idField.get(rowMapper(str));
            idColVal = (long) idField.get(rowMapper(txtLine));
            return idColVal == objId;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
