package org.example.server.common.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtil {
    public static String Md5(String str) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes());
        String s = new BigInteger(1, md.digest()).toString(16);
        return s;
    }

    public static String Sha(String str) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA");
        md.update(str.getBytes());
        String s = new BigInteger(md.digest()).toString(32);
        return s;
    }
}
