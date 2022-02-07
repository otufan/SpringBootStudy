package com.TechPro.SpringBootStudy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller//SpringBoot bu class i control layer olarak tanimlar
@RestController
//Controller annotasyonu Dispatcher servisinden mutlak üzere bir View alınması zorunlu ilen RestController buna gereksinim duymaz.
// Herhangi bir Controller annotasyonu ile oluşturulmuş bir Controller'a ise sınıf bazında veya fonksiyon bazında ResponseBody
// annotastonu eklenerek Rest Response sağlanır ve herhangi bir 404 hatası alınmaz.
public class StudentBean01Controller {


    //@RequestMapping(method = RequestMethod.GET, path = "/getRequest")//sadece get işlemlerinde ve bu adresten geldiyese bu metoduu çalıştır
     //@ResponseBody     //Method un return ettigi datayi gosterir --> tavsiye edilmez
    //public String getMethod1(){
      //  return "Get Request Method calisti";
//    }

    @GetMapping(path = "/getRequest") //--> Get Requst Leri getMethod2() ile mapping yapip path deki url calisir
    //return edilen data gosterilir
    public String getMethod2(){

        return "bu daha basarili ";
    }
    @GetMapping(path = "/getObjectTight")
    public StudentBean01 getObjectTight(){
        //Tight coupling... bu cok tercih dilmez
        return new StudentBean01("Jonny", 23, "ig202333");
    }

    //Loose coupling yapilacak


    @Autowired//StudentBean01 data type de IOC conteiner a default obj create eder--Bunu variable olan yere yazacagiz
    StudentBean01 s;// StudentBean01 s=new StudentBean01(); --> tight couling
    // new StudentBean01();-->@Component, "=" -->@AutoWired
    @GetMapping(path = "/getObjectLoose")
    public StudentBean01 getObjectLoose(){
        s.setAge(41);
        s.setId("gh223882");
        s.setName("Ronny");
        return s;

    }

    // Tight Coupling...Parametreli url-->url ile girilen parametreyi return edilen datada atanmasi

    @GetMapping(path = "/getObjectParametreli/{school}")
    public StudentBean01 getObjectParametreli(@PathVariable String school){



        return new StudentBean01("Josepf", 22, String.format("se22283%s", school));
    }

    //tight coupling--List return

    @GetMapping(path = "/getObjectList")
    public List<StudentBean01> getObjectList(){


        return List.of((new StudentBean01("Andre", 21, "as12341")),
                (new StudentBean01("Ronald", 25, "wee3244")),
                (new StudentBean01("Mike", 23, "tq12723")));

    }

    //Lose coupling...
    @Autowired //Trick :@Autowired--> loose coupling deki her variable icin kullanilmali
    //StudentBean01 t;
    StudentBean02 t;


    @GetMapping(path = "/getStudy")
    public String getStudy01(){
        return t.study();//

    }

    @Autowired
            @Qualifier(value="studentBean02")// @Qualifier--> @@AutoWired ile tanimlanan obj create edilecek data type ni tanimlar.
    // Tanimlanacak data type annotaion a parametre olur
    //@Qualifier ile bu interfaceden oluşan deklarasyona IOC’deki studentBean01 veya studentBean02 adındaki bekleyen variable’lardan
    // hangisini atayacağına karar veriyoruz
    StudentInterface u;


    @GetMapping(path = "/getStudy1")
    public String getStudy02(){

        return u.study();

    }






}
