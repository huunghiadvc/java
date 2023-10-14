public class Employee {
    public static final String Class_Name = "T2303E";
    private userInfo UserInfo;
    public userInfo getUserInfor(){
        return UserInfo;
    }
    public void setUserInfo(userInfo UserInfo){
        this.UserInfo = UserInfo;
    }
    public static class userInfo{
        private String userName;
        private String userPassword;
    }
}
