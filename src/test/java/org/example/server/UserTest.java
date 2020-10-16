package org.example.server;

import org.example.server.common.util.EncryptionUtil;
import org.example.server.user.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@SpringBootTest
public class UserTest {

    @Test
    public void test() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String s = EncryptionUtil.Md5("123123");
        String str = Base64.getEncoder().encodeToString(s.getBytes("UTF-8"));
        System.out.println(str);
    }

}
