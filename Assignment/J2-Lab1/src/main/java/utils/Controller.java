package utils;

import consts.TransferType;
import dao.CustomerDao;
import dao.TransactionDao;
import dao.impl.CustomerDaoImpl;
import dao.impl.TransactionDaoimpl;
import entity.*;

import java.sql.SQLException;
import java.util.List;

public class Controller {
    public static void userSelectionThreading() throws SQLException {

        String userConfirm = "";
        long bankAccountId;
        BankAccount bankAccountSearch;

        String userChoose = GetInput.getString();

        switch (Integer.parseInt(userChoose)){
            case 1:
                BankAccount.addCustomer();
                break;

            case 2:
                if (Bank.checkBankData()){
                    Bank.show(Bank.getBankAccount());
                    break;
                }
                System.out.println("Bank account is empty!\nPlease import first!");
                break;

            case 3:
                System.out.println("Please wait for update!");
//                if (Bank.getBankAccount() == null){
//                    Bank.initBankAccountList();
//                    System.err.println("BANK ACCOUNT IS EMPTY!!!");
//                    break;
//                }
//                if (!Bank.getBankAccount().isEmpty()){
//                    System.out.println("Input customer ID to edit: ");
//                    userChoose = GetInput.getString();
//                    if (userChoose.matches(".*[0-9].*")) {
//
//                        bankAccountId = Long.parseLong(userChoose);
//                        bankAccountSearch = Bank.searchAccount(bankAccountId);
//
//                        System.out.println("Input Y to confirm data change!");
//                        userConfirm = GetInput.getString();
//
//                        if (userConfirm.equalsIgnoreCase("Y")){
//                            Bank.getBankAccount().remove(bankAccountSearch);
//                        }
//                    }
//                }
                break;

            case 4:
                if (Bank.checkBankData()){
                    System.out.println("Input customer ID to delete: ");
                    userChoose = GetInput.getString();
                    if (userChoose.matches(".*[0-9].*")) {

                        bankAccountId = Long.parseLong(userChoose);
                        bankAccountSearch = Bank.searchAccount(bankAccountId);

                        System.err.println("Please input Y to confirm remove customer below:");
                        System.out.println(bankAccountSearch + "\n");
                        userConfirm = GetInput.getString();

                        if (userConfirm.equalsIgnoreCase("Y")){
                            Bank.getBankAccount().remove(bankAccountSearch);
                        }
                    }
                }
                break;

            case 5:
                if (!Bank.checkBankData()){
                    System.err.println("BANK ACCOUNT IS EMPTY!!!");
                    break;
                }
                if (!FileUtils.fileCheck()){
                    FileUtils.createFile();
                }
                FileUtils.fileWritter();
                break;

            case 6:
                if (FileUtils.fileCheck()){
                    try {
                        FileUtils.fileReader();
                    } catch (Exception e){
                        System.err.println("Import data failure!!!");
                        break;
                    }
                    System.out.printf("Import data of %d customer successfully!!!\n", Bank.getBankAccount().size());
                } else {
                    System.err.println("Import data failure! File not found!");
                }
                break;

            case 7:
                if (Bank.getBankAccount().isEmpty()){
                    System.out.println("Bank account is empty!\nPlease import first!");
                    break;
                }
                CustomerDao cusDao = new CustomerDaoImpl();
                for (BankAccount cus : Bank.getBankAccount()) {
                    cusDao.insert(cus);
                }
                break;

            case 8:
                TransactionDao transDao = new TransactionDaoimpl();
                if (FileUtils.transactionFileCheck()){
                    List<Transaction> transactionLog = FileUtils.transactionReader();
                    int count = 0;
                    assert transactionLog != null;
                    for (Transaction tran : transactionLog) {
                        if (transDao.insert(tran)){
                            count++;
                        }
                    }
                    if (count == transactionLog.size()){
                        System.out.printf("Insert %d transaction log to database successfully!", count);
                    } else {
                        System.out.printf("Insert %d transaction log to database successfully!", count);
                        System.err.printf("Insert %d transaction log to database failure!", count);
                    }
                    transDao.updateTransaction(transactionLog);
                } else {
                    System.err.println("Import data failure! File not found!");
                }
                break;

            case 9:
                System.out.println("Input Y to exist program or N to cancel!");
                userChoose = GetInput.getString();
                if (userChoose.equalsIgnoreCase("Y")){
                    System.exit(0);
                }
                break;

            default:
                System.err.println("Please choose 1-5!");
        }
    }
}
