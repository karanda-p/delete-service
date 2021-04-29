package ru.itfbgroup.deleteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
    Формат аргумента в DELETE запросе {yyyy}-{mm}-{dd}T{hh}:{mm}:{ss}
    Пример: 2021-04-15T00:00:00
 */
@SpringBootApplication
public class DeleteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeleteServiceApplication.class, args);
    }

}
