package com.TechPro.SpringBootStudy.basic_authendication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration //Class i configuration olarak tanimlar
@EnableWebSecurity //Tanimli oldugu class ta form based security yerine (basic authentication) configure eder
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {


    private final PasswordConfig passEncode;//final obj bir deger almali bu degeri alacagi constructor create edilmeli

    @Autowired
    public ApplicationSecurityConfig(PasswordConfig passEncode){ //PasswordConfig class tan create edilen passEncode objeye deger atayan
        //constructor
        this.passEncode=passEncode;
    }

   // @Override
   // protected void configure(HttpSecurity http) throws Exception {
   //     http.authorizeRequests().//Requestler icin yetki sorgula (get put patch delete post)
   //             anyRequest().//her request icin
   //             authenticated().//kullanici sorgula
   //             and().//neye gore
   //             httpBasic();//httpBasic e gore
//
   //     //her request te APP username ve pass (security) control edilmeli logout yapmaya gerek kalmayacak
   //     //giris yapan kisilerin yetkilerini kontrol etmiyor
//
   // }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests().
                antMatchers("/","index","/css/*","/js/*").permitAll().//antmatchers method parametresinde ki url lere izizn verir
                anyRequest().//her request icin
                authenticated().//kullnici sorgula
                and().//neye gore
                httpBasic();//httpBasic e gore

        //her request te APP username ve pass (security) control edilmeli logout yapmaya gerek kalmayacak
        //giris yapan kisilerin yetkilerini kontrol etmiyor

    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        //UserDetails admin = User.builder().username("admin").password("Noah1234").roles("admin").build(); //convension tanim
        //UserDetails student = User.builder().username("Mike").password("Mike1234").roles("student").build();
        //UserDetails master = User.builder().username("Mery").password("Mery1234").roles("Master of Universe").build();

        UserDetails admin = User.builder().username("admin").password(passEncode.passEncrypt().encode("admin1234")).roles("admin").build(); //convension tanim
        UserDetails student = User.builder().username("Mike").password(passEncode.passEncrypt().encode("Mike1234")).roles("student").build();
        UserDetails master = User.builder().username("Mery").password(passEncode.passEncrypt().encode("Mery1234")).roles("Master of Universe").build();

        // return student; --> bu return type hatasi verir
        return new InMemoryUserDetailsManager(admin, student, master ); //bu method ile UserDetails classindan olusan kullanicilar
                        //bir conteynir a konularak return edilmis oldu
    }

}
