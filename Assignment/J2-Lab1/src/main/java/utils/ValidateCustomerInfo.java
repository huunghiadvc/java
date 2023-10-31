package utils;

import entity.*;

import java.time.LocalDate;

public class ValidateCustomerInfo {

    public static boolean idValid(long id){
        if (!Bank.getBankAccount().isEmpty()){
            for (Customer customer : Bank.getBankAccount()) {
                if (customer.getId() == id) {
                    System.err.println("Students ID already exists! \nPlease try again!");
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean nameValid(String name){
        if (!name.matches(".*[a-zA-Z].*")){
            System.err.println("Invalid customer name!");
            return false;
        }
        return true;
    }

    public static boolean cardTypeValid(String cardType){
        for (Bank.cardType cardTypeBank : Bank.cardType.values()) {
            if (cardType.equalsIgnoreCase(String.valueOf(cardTypeBank))){
                return true;
            }
        }
        System.err.println("Invalid customer card type!");
        return false;
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

    public static boolean importCustomerValid(Customer customer){

        int count = 0;

        if (!customer.getName().matches(".*[a-zA-Z].*")){
            System.err.println("Invalid customer name! ID customer: " + customer.getId());
            count++;
        }

        if (!customer.getCardId().matches(".*[0-9].*") && customer.getCardId().length() != 14){
            System.err.println("Invalid customer card ID of customer ID: " + customer.getId());
            count++;
        }

        if (!customer.getDateOfBirth().isBefore(LocalDate.now())){
            System.err.println("Invalid date of birth customer ! ID customer: " + customer.getId());
            count++;
        }

        if (!customer.getCitizenIDCard().matches(".*[0-9].*")) {
            System.err.println("Invalid customer citizen ID cards! ID " + customer.getId());
            count++;
        }
        if (customer.getCitizenIDCard().length() != 9){
            if (customer.getCitizenIDCard().length() != 16) {
                System.err.println("Invalid customer citizen ID cards length! ID " + customer.getId());
                count++;
            }
        }

        if (!customer.getTel().matches(".*[0-9].*") && customer.getTel().length() != 10){
            System.err.println("Invalid customer phone number! ID customer: " + customer.getId());
            count++;
        }

        if (count != 0){
            System.err.printf("Adding customer ID = %s information failed. Have %d information errors!\n",
                    customer.getId(), count);
            return false;
        }

        return true;

    }

}
