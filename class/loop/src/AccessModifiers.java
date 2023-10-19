public class AccessModifiers {
    public static String publicVariable;
    static String staticVariable;
    protected String protectedVariable;
    private String privateVariable;

    private void privateFuntion(){
        System.err.println(privateVariable);
    }
}
