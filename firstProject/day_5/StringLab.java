public class StringLab {
    public static void main(String[] args) {
        String a = "a"; // immutable object, only getter, no setter
        a = "b"; // recreate object a
        // StringBuilder + StringBuffer : mutable object , can edit value

        String c = "c";
        String d = "c";
        if(c == d){ // compare reference : tham chiếu
            // fasle;
            // true because StringPool
            System.out.println("c == d");
        }
        if (c.equals(d)){ // compare value : tham trị///
            // true
            System.out.println("c == d");
        }
    }
}
