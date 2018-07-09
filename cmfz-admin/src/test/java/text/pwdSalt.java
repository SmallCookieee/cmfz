package text;

/**
 * Created by zxl on 2018/7/4.
 */
public class pwdSalt {

    public static void main(String[] args) {
        String salt = EncryptionUtil.getRandomSalt(6);
        System.out.println(salt);
        String pwd = "123456";
        String password = EncryptionUtil.encryption(salt+pwd);
        System.out.println(password);
    }
}
