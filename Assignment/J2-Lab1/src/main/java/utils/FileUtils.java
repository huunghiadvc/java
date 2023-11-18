package utils;

import dao.impl.TransactionDaoimpl;
import entity.*;
import org.apache.commons.lang3.StringUtils;
import service.AccountService;
import service.BankService;
import service.impl.AccountServiceImpl;
import service.impl.BankServiceImpl;

import java.io.*;
import java.util.Scanner;

public class FileUtils {

    private static final File urlFile = new File("./src/main/resources/data/customer.txt");
    private static final File tranFile = new File("./src/main/resources/data/transaction.txt");
    private static final String header = "ID|NAME|CARDTYPE|CARDID|BALANCE|DATEOFBIRTH|CARDNO|MSISDN|ADDRESS|";
    private static final String headerTransaction = "ID|CARDTYPE|CARDID|TRANSACTION_TYPE|TRANSACTION_AMOUNT|TRANSACTION_TIME";
    static Scanner scanner = null;
    static FileInputStream inputStream = null;

    public static boolean fileCheck(){
        return urlFile.exists();
    }

    public static boolean transactionFileCheck(){
        return !tranFile.exists();
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

    public static void createTransactionFile(){
        File f = new File(String.valueOf(tranFile));
        boolean createFile;
        try {
            createFile = f.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (createFile){
            System.err.println("Create file at " + tranFile + " successfully!!!");
        } else {
            System.err.println("Create file at " + tranFile + " failure!!!");
        }
    }

    public static void fileAccountReader(){
        AccountService accountService = new AccountServiceImpl();
        try {
            inputStream = new FileInputStream(urlFile);
            scanner = new Scanner(inputStream);
            int count = 0;
            while (scanner.hasNextLine()){
                String str = scanner.nextLine();
                if (str.equals(header)){
                    continue;
                }
                BankAccount acc = accountService.accountBuild(str);
                BankService bankService = new BankServiceImpl();
                assert acc != null;
                if (!bankService.checkId(acc.getId()) && ValidateUtil.validAccount(acc)){
                    Bank.getBankAccountList().add(acc);
                    count++;
                }
            }
            System.out.printf("Import data of %d customer successfully!!!\n", count);
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

    public static void transactionReader(){
        try {
            inputStream = new FileInputStream(tranFile);
            scanner = new Scanner(inputStream);
            int count = 0, check = 0;
            Transaction tran;
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                if (str.equalsIgnoreCase(headerTransaction) || StringUtils.isEmpty(str)) {
                    continue;
                }
                check++;
                tran = TransactionDaoimpl.getTransaction(str);
                if (ValidateUtil.validTran(tran)){
                    TransactionList.getTransactionList().add(tran);
                    count++;
                }
            }
            if (count != 0){
                if (count == check){
                    System.out.printf("Import %d of transaction successfully!", count);
                }
                if (count < check){
                    System.out.printf("Import %d of transaction successfully!", count);
                    System.out.printf("Import %d of transaction failure!", check - count);
                }
            } else {
                System.out.printf("Import %d of transaction failure!", check);
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
        for(BankAccount bankAccount : Bank.getBankAccountList()) {
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

    public static void transactionFileWritter(){
        FileWriter writer;
        try {
            writer = new FileWriter(tranFile, true);
            if (FileUtils.transactionFileCheck()){
                FileUtils.createTransactionFile();
                writer.write(headerTransaction);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(Transaction tran : TransactionList.getTransactionList()) {
            try {
                writer.write(
                        tran.getId() + "|" + tran.getCardType() + "|" +
                                tran.getCardId() + "|" + tran.getTransactionType() + "|" +
                                tran.getTransactionAmount() + "|" + tran.getTransactionTime()
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
