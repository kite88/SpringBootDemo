package org.example.server;


import org.example.server.common.service.impl.TokenServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CommonTest {

    @Value("${config.jwt.secret}")
    private String secret;

    @Autowired
    TokenServiceImpl tokenService;

    @Test
    public void test() {
        String s = tokenService.createSign(1l);
        System.out.println(s);
    }

    @Test
    void test_1() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxLCJpc3MiOiJhdXRoMCIsImV4cCI6MTYwMjgwMDM0NiwiaWF0IjoxNjAyNzk5NzQxfQ.mroNMfTe8CSssDi4ggAY1jh0WvTY5LhXoU6xDTTOWh4";
        Long userId = tokenService.verify(token);
        System.out.println(userId);
    }
}
