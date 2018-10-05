package com.zipkin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zipkin.server.EnableZipkinServer;
import zipkin.storage.mysql.MySQLStorage;

import javax.sql.DataSource;

@SpringBootApplication
@RestController
@EnableZipkinServer
public class ZipkinApplication {
    private static final Logger log = LoggerFactory.getLogger(ZipkinApplication.class);

    public static void main(String[] args) {
        log.info("start");
        SpringApplication.run(ZipkinApplication.class, args);
    }

    @Bean
    public MySQLStorage mySQLStorage(DataSource datasource) {
        return MySQLStorage.builder().datasource(datasource).executor(Runnable::run).build();
    }

    @GetMapping("/kibana")
    public void kibana() {
        log.info("test kibana");
    }
}
