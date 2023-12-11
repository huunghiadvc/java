package const_;


public enum DataType {
    VARCHAR("varchar"),
    DOUBLE("double"),
    BIGINT("bigint")
    ;
    public final String val;
    DataType(String val) {
        this.val = val;
    }

}
