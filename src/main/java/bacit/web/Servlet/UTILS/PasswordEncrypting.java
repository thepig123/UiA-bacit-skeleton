package bacit.web.Servlet.UTILS;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordEncrypting {
    private final static String PASSWORD_SECRET = "12Hr!ksl_ww%123!";

    public static String encrypt(String password) {
        return DigestUtils.md5Hex(password + PASSWORD_SECRET).toUpperCase();
    }

    public static void main(String[] args) {
        encrypt("admin");
        System.out.println(encrypt("admin"));
    }
}
