package com.zpain.dbtest;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = PageHelperAutoConfiguration.class)
@MapperScan("com.zpain.dbtest.service")
@EnableTransactionManagement
public class DbtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbtestApplication.class, args);
    }

}
