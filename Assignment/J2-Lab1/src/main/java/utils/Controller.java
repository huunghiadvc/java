package utils;

import entity.*;

public class Controller {
    public static void userSelectionThreading(){

        String userConfirm = "";
        long customerIdInput;
        Customer customerSearch;

        String userChoose = GetInput.getString();

        switch (Integer.parseInt(userChoose)){
            case 1:
                Customer.addCustomerConsole();
                break;

            case 2:
                MenuUtils.showAccountMenu();
                userChoose = GetInput.getString();
                switch (Integer.parseInt(userChoose)){
                    case 1:
                        try {
                            Bank.show(Bank.getBankAccount());
                        } catch (Exception e) {
                            System.err.println("Account list empty!!!");
                        }
                        break;
                    case 2:
                        VisaAccount.show(VisaAccount.getVisaAccount());
                        break;
                    case 3:
                        JCBAccount.show(JCBAccount.getJcbAccount());
                        break;
                    case 4:
                        HybridAccount.show(HybridAccount.getHybridAccount());
                        break;

                    default:
                        System.out.println("Error!");
                }
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
//                        customerIdInput = Long.parseLong(userChoose);
//                        customerSearch = Bank.searchCustomer(customerIdInput);
//
//                        System.out.println("Input Y to confirm data change!");
//                        userConfirm = GetInput.getString();
//
//                        if (userConfirm.equalsIgnoreCase("Y")){
//                            Bank.getBankAccount().remove(customerSearch);
//                        }
//                    }
//                }
                break;

            case 4:
                if (!Bank.getBankAccount().isEmpty()){
                    System.out.println("Input customer ID to delete: ");
                    userChoose = GetInput.getString();
                    if (userChoose.matches(".*[0-9].*")) {

                        customerIdInput = Long.parseLong(userChoose);
                        customerSearch = Bank.searchCustomer(customerIdInput);

                        System.err.println("Please input Y to confirm remove customer below:");
                        System.out.println(customerSearch + "\n");
                        userConfirm = GetInput.getString();

                        if (userConfirm.equalsIgnoreCase("Y")){
                            Bank.getBankAccount().remove(customerSearch);
                        }
                    }
                } else {
                    System.err.println("BANK ACCOUNT IS EMPTY!!!");
                }
                break;

            case 5:
                if (Bank.getBankAccount().isEmpty()){
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
