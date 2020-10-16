package org.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 入口
 */
@SpringBootApplication
@EnableTransactionManagement
public class App {
    public static void main(String[] args) {
        try {
            SpringApplication.run(App.class, args);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
