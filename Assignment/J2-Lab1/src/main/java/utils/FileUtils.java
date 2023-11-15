package utils;

import dao.impl.TransactionDaoimpl;
import entity.*;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    private static final File urlFile = new File("./src/main/resources/data/customer.txt");
    private static final File transactionFile = new File("./src/main/resources/data/transaction.txt");
    private static final String header = "ID|NAME|CARDTYPE|CARDID|BALANCE|DATEOFBIRTH|CARDNO|MSISDN|ADDRESS|";
    private static final String headerTransaction = "ID|CARDTYPE|CARDID|TRANSACTION_TYPE|TRANSACTION_AMOUNT|TRANSACTION_TIME";
    static Scanner scanner = null;
    static FileInputStream inputStream = null;

    public static boolean fileCheck(){
        return urlFile.exists();
    }

    public static boolean transactionFileCheck(){
        return transactionFile.exists();
    }

    public static void createFile(){
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

    public static void fileReader(){
        Bank.initBankAccountList();
        try {
            inputStream = new FileInputStream(urlFile);
            scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()){
                String str = scanner.nextLine();
                if (str.equals(header)){
                    continue;
                }
                BankAccount c = BankAccount.importAccount(str);
                Bank.getBankAccount().add(c);
            }
        }catch (FileNotFoundException e) {
            System.err.println("File not found!" + e.getMessage());
        } finally {
            try {
                assert inputStream != null;
                inputStream.close();
            } catch (IOException e) {
                System.err.println("IOException " + e.getMessage());
            }
        }
    }

    public static List<Transaction> transactionReader(){
        try {
            inputStream = new FileInputStream(transactionFile);
            scanner = new Scanner(inputStream);
            List<Transaction> transactionList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                if (str.equalsIgnoreCase(headerTransaction) || StringUtils.isEmpty(str)) {
                    continue;
                }
                transactionList.add(TransactionDaoimpl.getTransaction(str));
            }
            for (Transaction e : transactionList
                 ) {
                System.out.println(e.toString());
            }
            return transactionList;
        }catch (FileNotFoundException e) {
            System.err.println("File not found!" + e.getMessage());
        }
        return null;
    }

    public static void fileWritter(){
        FileWriter writer;
        try {
            writer = new FileWriter(urlFile, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.write(header);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(BankAccount bankAccount : Bank.getBankAccount()) {
            try {
                writer.write(
                        bankAccount.getId() + "|" + bankAccount.getName() + "|" +
                                bankAccount.getCardType() + "|" + bankAccount.getCardId() + "|" +
                                bankAccount.getDateOfBirth() + "|" + bankAccount.getCitizenIDCard() + "|" +
                                bankAccount.getTel() + "|" + bankAccount.getAddress()
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
