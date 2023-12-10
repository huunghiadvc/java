package ViettelPostAPI.const_;

public enum VPServiceType {
    INLAND_EXPRESS_01(1),
    INLAND_EXPRESS_02(2),
    INTERNATIONAL_EXPRESS(3),
    VOUCHER_EXPRESS(4),
    BANKING(5)
    ;
    public final int type;

    VPServiceType(int type) {
        this.type = type;
    }
}
