package entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;
import utils.GetInput;
import utils.ValidateUtil;

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
    private long balance;
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

}
