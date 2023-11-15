package entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;
import utils.GetInput;
import utils.ValidateCustomerInfo;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {

    private long id;
    private String name;
    private String cardType;
    private String cardId;
    private Long balance;
    private LocalDate dateOfBirth;
    private String citizenIDCard;
    private String tel;
    private String address;

    public static BankAccount importAccount(String line){

        if (StringUtils.isEmpty(line)) return null;

        String[] chars = line.split("\\|");

        return BankAccount.builder()
                .id(Long.parseLong(chars[0]))
                .name(String.valueOf(chars[1]))
                .cardType(String.valueOf(chars[2]))
                .cardId(String.valueOf(chars[3]))
                .balance(Long.parseLong(chars[4]))
                .dateOfBirth(LocalDate.parse(chars[5]))
                .citizenIDCard(String.valueOf(chars[6]))
                .tel(String.valueOf(chars[7]))
                .address(String.valueOf(chars[8]))
                .build();
    }

    public static void addCustomer(){
        long customer_id;
        String customer_name;
        String customer_cardType;
        String customer_cardId;
        LocalDate customer_dateOfBirth;
        String customer_citizenIDCard = "";
        String customer_tel;
        String customer_address;

        if (Bank.getBankAccount() == null){
            Bank.initBankAccountList();
        }

        // Input ID
        while (true){
            System.out.println("Input customer ID: ");
            try {
                customer_id = GetInput.getLong();
            } catch (Exception e) {
                System.err.println("Invalid ID format!!!");
                continue;
            }
            if(!ValidateCustomerInfo.idValid(customer_id)){
                continue;
            }
            break;
        }

        // Input name
        while (true){
            System.out.println("Input customer name: ");
            customer_name = GetInput.getString();
            if (!ValidateCustomerInfo.nameValid(customer_name)) {
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
            if (!ValidateCustomerInfo.cardIdValid(customer_cardId)) {
                continue;
            }
            break;
        }

        // Input date of birth
        while (true){
            System.out.println("Input customer date of birth (yyyy-mm-dd): ");
            customer_dateOfBirth = GetInput.getDate();
            if (!ValidateCustomerInfo.dateOfBirthValid(customer_dateOfBirth)){
                continue;
            }
            break;
        }

        //Input citizen id card
        while (true){
            System.out.println("Input customer citizen ID card: ");
            customer_citizenIDCard = GetInput.getString();
            if (!ValidateCustomerInfo.citizenIdValid(customer_citizenIDCard)) {
                System.err.println("Invalid citizen ID card!");
                continue;
            }
            break;
        }

        // Input phone number
        while (true){
            System.out.println("Input customer phone number: ");
            customer_tel = GetInput.getString();
            if (!ValidateCustomerInfo.telValid(customer_tel)) {
                System.err.println("Phone numbers cannot contain letters or characters!");
                continue;
            }
            break;
        }

        // Input address
        while (true){
            System.out.println("Input customer address: ");
            customer_address = GetInput.getString();
            if (!ValidateCustomerInfo.addressValid(customer_address)) {
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

}
