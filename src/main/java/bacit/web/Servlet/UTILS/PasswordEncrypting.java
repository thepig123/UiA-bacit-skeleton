package bacit.web.Servlet.UTILS;

import org.apache.commons.codec.digest.DigestUtils;


import org.junit.Test;

import static bacit.web.Servlet.UTILS.PasswordEncrypting.encrypt;
import static org.junit.Assert.assertEquals;

public class PasswordEncrypting {
    private final static String PASSWORD_SECRET = "12Hr!ksl_ww%123!";

    public static String encrypt(String password) {
        return DigestUtils.md5Hex(password + PASSWORD_SECRET).toUpperCase();
    }

    public static void main(String[] args) {
        encrypt("admin");
        System.out.println(encrypt("admin"));
    }

    @Test
    public void encryptTest() {  assertEquals("DD325BA47D1032952B0C58CEB49F877F", encrypt("12345"));
    }
}