package com.TechPro.SpringBootStudy.basic_authendication;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration //Class i configuration olarak tanimlar
@EnableWebSecurity //Tanimli oldugu class ta form based security yerine (basic authentication) configure eder
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().//Requestler icin yetki sorgula (get put patch delete post)
                anyRequest().//her request icin
                authenticated().//kullanici sorgula
                and().//neye gore
                httpBasic();//httpBasic e gore

        //her request te APP username ve pass (security) control edilmeli logout yapmaya gerek kalmayacak
        //giris yapan kisilerin yetkilerini kontrol etmiyor

    }
}
