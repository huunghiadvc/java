package consts;

public enum TransferType {
    SEND("Send"),
    RECEIVE("Receive")
    ;

    public final String val;
    TransferType(String val) {
        this.val = val;
    }
}
