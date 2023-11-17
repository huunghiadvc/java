package service.impl;

import entity.Bank;
import entity.BankAccount;
import service.AccountService;
import service.BankService;
import utils.GetInput;
import utils.ValidateUtil;

import java.time.LocalDate;

public class AccountServiceImpl implements AccountService {
    @Override
    public void addAccount() {
        long customer_id;
        String customer_name;
        String customer_cardType;
        String customer_cardId;
        LocalDate customer_dateOfBirth;
        String customer_citizenIDCard = "";
        String customer_tel;
        String customer_address;
        BankService bankService = new BankServiceImpl();

        if (Bank.getBankAccount() == null){
            Bank.initBankAccountList();
        }

        // Input ID
        while (true){
            System.out.println("Input bank account ID: ");
            try {
                customer_id = GetInput.getLong();
            } catch (Exception e) {
                System.err.println("Invalid ID format!!!");
                continue;
            }
            if(bankService.checkId(customer_id)){
                System.out.println("Account ID is already exist!");
                continue;
            }
            break;
        }

        // Input name
        while (true){
            System.out.println("Input customer name: ");
            customer_name = GetInput.getString();
            if (!ValidateUtil.nameValid(customer_name)) {
                continue;
            }
            break;
        }

        //Input card type
        while (true){
            System.out.println("Input customer card type: ");
            customer_cardType = GetInput.getString();
//            if (!ValidateCustomerInfo.cardTypeValid(customer_cardType)) {
//                continue;
//            }
            break;
        }

        //Input card id
        while (true){
            System.out.println("Input customer card ID: ");
            customer_cardId = GetInput.getString();
            if (!ValidateUtil.cardIdValid(customer_cardId)) {
                continue;
            }
            break;
        }

        // Input date of birth
        while (true){
            System.out.println("Input customer date of birth (yyyy-mm-dd): ");
            customer_dateOfBirth = GetInput.getDate();
            if (!ValidateUtil.dateOfBirthValid(customer_dateOfBirth)){
                continue;
            }
            break;
        }

        //Input citizen id card
        while (true){
            System.out.println("Input customer citizen ID card: ");
            customer_citizenIDCard = GetInput.getString();
            if (!ValidateUtil.citizenIdValid(customer_citizenIDCard)) {
                System.err.println("Invalid citizen ID card!");
                continue;
            }
            break;
        }

        // Input phone number
        while (true){
            System.out.println("Input customer phone number: ");
            customer_tel = GetInput.getString();
            if (!ValidateUtil.telValid(customer_tel)) {
                System.err.println("Phone numbers cannot contain letters or characters!");
                continue;
            }
            break;
        }

        // Input address
        while (true){
            System.out.println("Input customer address: ");
            customer_address = GetInput.getString();
            if (!ValidateUtil.addressValid(customer_address)) {
                continue;
            }
            break;
        }

        BankAccount c = BankAccount.builder()
                .id(customer_id)
                .name(customer_name)
                .cardType(customer_cardType)
                .cardId(customer_cardId)
                .dateOfBirth(customer_dateOfBirth)
                .citizenIDCard(customer_citizenIDCard)
                .tel(customer_tel)
                .address(customer_address)
                .build();
        Bank.getBankAccount().add(c);
        System.err.println("|---- Add Customer Successfully ----|");
    }

    @Override
    public boolean editAccount(long id) {
        System.out.println("Please wait for update!");
        return true;
    }
}
