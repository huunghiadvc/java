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

}
