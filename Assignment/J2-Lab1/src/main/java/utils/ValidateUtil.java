package utils;

import consts.CardType;
import consts.TransferType;
import entity.*;

import java.time.LocalDate;

public class ValidateUtil {

    public static boolean idValid(String id){
        return id.matches(".*[0-9].*");
    }

    public static boolean nameValid(String name){
        if (!name.matches(".*[a-zA-Z].*")){
            System.err.println("Invalid customer name!");
            return false;
        }
        return true;
    }

    public static boolean cardIdValid(String cardId){
        if (!cardId.matches(".*[0-9].*")){
            System.err.println("Invalid customer card ID!");
        }
        if (cardId.length() != 14) {
            System.err.println("Customer card ID need 14 digits!");
            return false;
        }
        return true;
    }
    public static boolean dateOfBirthValid(LocalDate dateOfBirth){
        if (!dateOfBirth.isBefore(LocalDate.now()) ||
                !dateOfBirth.isAfter(LocalDate.of(1950,1,1))){

            System.err.println("Invalid date of birth customer!");
            return false;

        }
        return true;
    }
    public static boolean citizenIdValid(String citizenId){
        if (!citizenId.matches(".*[0-9].*")) {
            System.err.println("Invalid customer citizen ID cards format!");
            return false;
        }
        if (citizenId.length() != 9){
            if (citizenId.length() != 16) {
                System.err.println("Invalid customer citizen ID cards length!");
                return false;
            }
        }
        return true;
    }
    public static boolean telValid(String tel){
        if (!tel.matches(".*[0-9].*") && tel.length() != 10){
            System.err.println("Invalid customer phone number!");
            return false;
        }
        return true;
    }

    public static boolean addressValid(String address){
        if (address == null || address.isEmpty()) {
            System.err.println("Invalid customer address!");
            return false;
        }
        return true;
    }

    public static boolean cardTypeValid(String a){
        CardType cardType = CardType.valueOf(a);
        return switch (cardType) {
            case VISA, HYBRID, JCB -> true;
            default -> false;
        };
    }

    public static boolean tranTypeValid(String a){
        TransferType cardType = TransferType.valueOf(a.toUpperCase());
        return switch (cardType) {
            case RECEIVE, SEND -> true;
            default -> false;
        };
    }

    public static boolean validTran(Transaction tran){
        return (cardIdValid(tran.getCardId()) | cardTypeValid(tran.getCardType())
                | tranTypeValid(tran.getTransactionType()));
    }

    public static boolean validAccount(BankAccount acc){
        return (
                nameValid(acc.getName()) | cardTypeValid(acc.getCardType()) |
                cardIdValid(acc.getCardId()) | dateOfBirthValid(acc.getDateOfBirth()) |
                citizenIdValid(acc.getCitizenIDCard()) | telValid(acc.getTel())
        );
    }



}
