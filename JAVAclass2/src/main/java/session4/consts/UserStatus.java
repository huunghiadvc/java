package session4.consts;

public enum UserStatus {
    //     1 : active  , 2 : inactive  , 3 : deleted  , 4 : blocked
    ACTIVE(1),
    INACTIVE(2),
    DELETED(3),
    BLOCKED(4);
    public final int status;
    private  UserStatus(int status) {
        this.status = status;
    }
}