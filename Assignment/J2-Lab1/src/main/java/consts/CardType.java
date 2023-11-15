package consts;

public enum CardType {
    VISA("Visa"),
    JCB("JCB"),
    HYBRID("Hybrid");

    public final String val;
    CardType(String val) {
        this.val = val;
    }
}
