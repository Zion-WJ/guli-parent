package com.wj.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ：wj
 * @date ：Created in 2021/8/9 20:46
 * @description：
 * @version:
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.wj"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
