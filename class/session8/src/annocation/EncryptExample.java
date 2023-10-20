package annocation;

import java.util.Base64;
import java.util.UUID;

public class EncryptExample {

    public static void main(String[] args) {
        basicBase64();


    }

    private static void basicBase64(){
        String myLove = "Nguyễn Hữu Nghĩa";
        String myLoveEnCode = Base64.getEncoder().encodeToString(myLove.getBytes());
        System.err.println(myLoveEnCode);
        byte[] decodeMyLove = Base64.getDecoder().decode(myLoveEnCode);
        String decodeStr = new String(decodeMyLove);
        System.err.println(decodeStr);

        String myLoveEncodeNoPad = Base64.getEncoder().withoutPadding().encodeToString(myLove.getBytes());
        System.err.println(myLoveEncodeNoPad);

        System.err.println(Base64.getUrlEncoder().encodeToString("https://google.com".getBytes()));

        StringBuilder myWife = new StringBuilder();
        for (int i = 0; i <= 20; i++){
            myWife.append((UUID.randomUUID().toString()));
        }

        String myWifeFinal = myWife.toString();
        String myWifeEncodeNoPad = Base64.getEncoder().withoutPadding().encodeToString(myWifeFinal.getBytes());
        System.err.println(myWifeEncodeNoPad);
    }
}
