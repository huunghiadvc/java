package utils;

import dao.BankAccountDao;
import dao.TransactionDao;
import dao.impl.BankAccountDaoImpl;
import dao.impl.TransactionDaoimpl;
import entity.*;
import service.AccountService;
import service.BankService;
import service.TransactionService;
import service.impl.AccountServiceImpl;
import service.impl.BankServiceImpl;
import service.impl.TransactionServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Controller {
    public static void userSelectionThreading() throws SQLException {

        String userConfirm = "";
        long bankAccountId;
        BankAccount bankAccountSearch;
        AccountService accountService = new AccountServiceImpl();
        BankService bankService = new BankServiceImpl();
        TransactionDao transDao = new TransactionDaoimpl();
        TransactionService transactionListService = new TransactionServiceImpl();

        String userChoose = GetInput.getString();

        switch (Integer.parseInt(userChoose)){

            case 1:
                accountService.addAccount();
                break;

            case 2:
//                System.out.println("Please wait for update!");
                if (Bank.getBankAccount() == null | Bank.getBankAccount().isEmpty()){
                    Bank.initBankAccountList();
                    System.err.println("BANK ACCOUNT IS EMPTY!!!");
                    break;
                }
                while (true){
                    System.out.println("Input bank account ID to edit: ");
                    userChoose = GetInput.getString();
                    if (!ValidateUtil.idValid(userChoose)) {
                        System.out.println("Please input integer format!");
                        continue;
                    }
                    bankAccountId = Long.parseLong(userChoose);
                    if (bankService.checkId(bankAccountId)){
                        if (accountService.editAccount(bankAccountId)) break;
                    }
                }
                break;

            case 3:
                if (Bank.checkBankData()){
                    System.out.println("Input bank account ID to delete: ");
                    userChoose = GetInput.getString();
                    if (userChoose.matches(".*[0-9].*")) {

                        bankAccountId = Long.parseLong(userChoose);
                        bankAccountSearch = Bank.searchAccount(bankAccountId);

                        System.err.println("Please input Y to confirm remove customer below:");
                        System.out.println(bankAccountSearch + "\n");
                        userConfirm = GetInput.getString();

                        if (userConfirm.equalsIgnoreCase("Y")){
                            bankService.removeAccount(bankAccountSearch);
                        }
                    }
                }
                break;

            case 4:
                bankService.show();
                break;

            case 5:
                transactionListService.show();
                break;

            case 6:
                if (FileUtils.fileCheck()){
                    try {
                        FileUtils.fileAccountReader();
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
                if (FileUtils.transactionFileCheck()){
                    System.out.println("Transaction file is not exist!");
                }
                FileUtils.transactionReader();
                break;

            case 8:
                if (!Bank.checkBankData()){
                    System.err.println("BANK ACCOUNT IS EMPTY!!!");
                    break;
                }
                if (!FileUtils.fileCheck()){
                    FileUtils.createFile();
                }
                FileUtils.fileWritter();
                break;

            case 9:
                if (TransactionList.getTransactionList().isEmpty()){
                    System.err.println("BANK ACCOUNT IS EMPTY!!!");
                    break;
                }
                FileUtils.transactionFileWritter();
                break;


            case 10:
                if (Bank.getBankAccount().isEmpty()){
                    System.out.println("Bank account is empty!\nPlease import first!");
                    break;
                }
                BankAccountDao cusDao = new BankAccountDaoImpl();
                for (BankAccount cus : Bank.getBankAccount()) {
                    cusDao.insert(cus);
                }
                break;

            case 11:
                if (TransactionList.getTransactionList().isEmpty()){
                    System.out.println("Transaction data is empty!");
                }
                int count = 0;
                List<Transaction> transactionList = TransactionList.getTransactionList();
                for (Transaction tran : transactionList) {
                    if (transDao.insert(tran)){
                        count++;
                    }
                }
                System.out.printf("Import %d transaction to database successfully!", count);
                break;

            case 12:
                transactionListService.update();
                transDao.updateTransaction();
                break;

            case 13:
                System.out.println("Input Y to exist program or N to cancel!");
                userChoose = GetInput.getString();
                if (userChoose.equalsIgnoreCase("Y")){
                    System.exit(0);
                }
                break;

            default:
                System.err.println("Please choose 1-11!");
        }
    }
}
