package entity;

import java.util.ArrayList;
import java.util.List;

public class TransactionList {
    private static List<Transaction> transactionList;

    public static List<Transaction> getTransactionList(){
        if (transactionList == null){
            transactionList = new ArrayList<>();
        }
        return transactionList;
    }
}
