package service.impl;

import consts.CardType;
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
        long acc_id;
        String acc_name;
        String acc_cardType;
        String acc_cardId;
        LocalDate acc_dateOfBirth;
        String acc_citizenIDCard = "";
        String acc_tel;
        String acc_address;
        BankService bankService = new BankServiceImpl();

        // Input ID
        while (true){
            System.out.println("Input bank account ID: ");
            try {
                acc_id = GetInput.getLong();
            } catch (Exception e) {
                System.err.println("Invalid ID format!!!");
                continue;
            }
            if(bankService.checkId(acc_id)){
                System.out.println("Account ID is already exist!");
                continue;
            }
            break;
        }

        // Input name
        while (true){
            System.out.println("Input customer name: ");
            acc_name = GetInput.getString();
            if (!ValidateUtil.nameValid(acc_name)) {
                continue;
            }
            break;
        }

        //Input card type
        while (true){
            System.out.println("Input customer card type: ");
            acc_cardType = GetInput.getString();
            CardType type = CardType.valueOf(acc_cardType.toUpperCase());
            switch (type){
                case HYBRID:
                case JCB:
                case VISA:
                    break;
                default:
                    System.err.println("Invalid card type!");
                    continue;
            }
            break;
        }

        //Input card id
        while (true){
            System.out.println("Input customer card ID: ");
            acc_cardId = GetInput.getString();
            if (!ValidateUtil.cardIdValid(acc_cardId)) {
                System.out.println("Invalid card id!");
                continue;
            }
            break;
        }

        // Input date of birth
        while (true){
            System.out.println("Input customer date of birth (yyyy-mm-dd): ");
            acc_dateOfBirth = GetInput.getDate();
            if (!ValidateUtil.dateOfBirthValid(acc_dateOfBirth)){
                System.out.println("Invalid date of birth!");
                continue;
            }
            break;
        }

        //Input citizen id card
        while (true){
            System.out.println("Input customer citizen ID card: ");
            acc_citizenIDCard = GetInput.getString();
            if (!ValidateUtil.citizenIdValid(acc_citizenIDCard)) {
                System.err.println("Invalid citizen ID card!");
                continue;
            }
            break;
        }

        // Input phone number
        while (true){
            System.out.println("Input customer phone number: ");
            acc_tel = GetInput.getString();
            if (!ValidateUtil.telValid(acc_tel)) {
                System.err.println("Phone numbers cannot contain letters or characters!");
                continue;
            }
            break;
        }

        // Input address
        while (true){
            System.out.println("Input customer address: ");
            acc_address = GetInput.getString();
            if (!ValidateUtil.addressValid(acc_address)) {
                continue;
            }
            break;
        }

        BankAccount c = BankAccount.builder()
                .id(acc_id)
                .name(acc_name)
                .cardType(acc_cardType)
                .cardId(acc_cardId)
                .dateOfBirth(acc_dateOfBirth)
                .citizenIDCard(acc_citizenIDCard)
                .tel(acc_tel)
                .address(acc_address)
                .build();
        Bank.getBankAccountList().add(c);
        System.err.println("|---- Add Account Successfully ----|");
    }

    @Override
    public boolean editAccount(long id) {
        System.out.println("Please wait for update!");
        return true;
    }
}
