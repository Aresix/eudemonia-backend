package com.aresix.eudemoniabackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.aresix.eudemoniabackend.dao")
public class EudemoniaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EudemoniaBackendApplication.class, args);
    }

}
