package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class Transaction {
    private long id;
    private String cardType;
    private String cardId;
    private String transactionType;
    private long transactionAmount;
    private Date transactionTime;
}
