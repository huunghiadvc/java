package utils;

import entity.*;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class FileUtils {

    private static final File urlFile = new File("./src/main/resources/customer.txt");
    private static final String header = "ID|NAME|CARDTYPE|CARDID|DATEOFBIRTH|CARDNO|MSISDN|ADDRESS|";
    static Scanner scanner = null;
    static FileInputStream inputStream = null;

    public static boolean fileCheck(){
        return urlFile.exists();
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
                Customer c = Customer.importCustomer(str, header);

                if (!Objects.isNull(c) && ValidateCustomerInfo.importCustomerValid(c)) {

                    if (c.getCardType().equals(Bank.cardType.VISA.toString())){
                        VisaAccount.initVisaAccountList();
                        if (VisaAccount.checkCustomer(c.getCitizenIDCard())){
                            VisaAccount.getVisaAccount().add(c);
                            Bank.getBankAccount().add(c);
                        } else {
                            System.err.println("Customer have another VISA account!");
                        }

                    }
                    else if (c.getCardType().equalsIgnoreCase(Bank.cardType.JCB.toString())) {
                            JCBAccount.initJcbAccountList();
                            if (JCBAccount.checkCustomer(c.getCitizenIDCard())){
                                JCBAccount.getJcbAccount().add(c);
                                Bank.getBankAccount().add(c);
                            } else {
                                System.err.println("Customer have another JCB account!");
                            }
                    }
                    else if (c.getCardType().equalsIgnoreCase(Bank.cardType.HYBRID.toString())) {
                            HybridAccount.initHybirdAccountList();
                            if (HybridAccount.checkCustomer(c.getCitizenIDCard())){
                                HybridAccount.getHybridAccount().add(c);
                                Bank.getBankAccount().add(c);
                            } else {
                                System.err.println("Customer have another Hybrid account!");
                            }
                    } else {
                            System.err.println("Error card type format!!!");
                    }
                }
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
        for(Customer customer : Bank.getBankAccount()) {
            try {
                writer.write(
                        customer.getId() + "|" + customer.getName() + "|" +
                                customer.getCardType() + "|" + customer.getCardId() + "|" +
                                customer.getDateOfBirth() + "|" + customer.getCitizenIDCard() + "|" +
                                customer.getTel() + "|" + customer.getAddress()
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
