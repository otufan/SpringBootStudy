package com.TechPro.SpringBootStudy.basic_authendication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {


    @Bean
        public PasswordEncoder passEncrypt(){//return type obj olan bir methoddur. Bbu method password encode ettigi icin
            //password olan class a call edilmelidir

            return new BCryptPasswordEncoder(10);   // crypto guvenlik seviyesidir genelde 10-8 kullanilir

        }



}
