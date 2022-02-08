package com.TechPro.SpringBootStudy.controller_service_repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration // Bu class ta data create edip DB'deki tabloya datalar gonderecek: SQL insert komutu ile de yapilabilir
public class StudentBean04Config {

    @Bean //obj return edilen methodlar @Bean annotaion kullanilir  @Bean sadece method level da kullanilir
    //variable class ve constructor level da kullanilmaz
    CommandLineRunner clr1(StudentBean04Repository studentRepo){



        return args -> studentRepo.saveAll(List.of(
        new StudentBean04(110L, "Heike Long", "heike@mail.com"cd )




        ));
    }







}
