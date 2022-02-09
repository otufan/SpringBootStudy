package com.TechPro.SpringBootStudy.basic_authendication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;


@Configuration // Bu class ta data create edip DB'deki tabloya datalar gonderecek: SQL insert komutu ile de yapilabilir
public class StudentBean05Config {

    @Bean //obj olan methodlar @Bean annotaion kullanilir  @Bean sadece method level da kullanilir
    //variable class ve constructor level da kullanilmaz
    CommandLineRunner clr1(StudentBean05Repository studentRepo){
        return args -> studentRepo.saveAll(List.of(
        new StudentBean05(110L, "Heike Long", "heike@mail.com", LocalDate.of(1992, 4, 4)),
        new StudentBean05(111L, "Michel Mountain", "michel@mail.com", LocalDate.of(1989, 6, 14)),
        new StudentBean05(112L, "Wolter Price", "wolter@mail.com", LocalDate.of(1999, 11, 24)),
        new StudentBean05(113L, "Mary High", "mary@mail.com", LocalDate.of(1996, 12, 6))

        ));
    }







}
