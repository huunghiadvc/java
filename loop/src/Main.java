public class Main {
    public static void main(String[] args) {
        //while
        int i = 0;
        while (i < 1000) {
            i++;
        }

        // do-while: thuc hien it nhat 1 lan roi moi kiem tra dieu kien
        do {
            i++;
        } while (i < 1000);

        String[] strs = {"A" , "B"};
        String baseStr = "";
        for (String s : strs) {
            baseStr += s;
        }
        for (int j = 0; j < strs.length; j++) {
            baseStr += strs[j];
        }


    }
}
