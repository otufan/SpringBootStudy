package com.TechPro.SpringBootStudy.controller;


import org.springframework.stereotype.Component;

@Component//bilesen tamamlayici anlamina gelir : kullanilan classtan objeleri IOC create eder
public class StudentBean01 implements StudentInterface{ //component sayesinde ioc yani konteynira obje uretecegiz

    //new StudentBean01(); --> bu tight coupling ama @Component lose coupling (obj injection)

    //pojo plan old java obj

    private String name;
    private  int age;
    private String  id;

    public StudentBean01() {
        System.out.println("parametresiz constructor run edildi...");
    }

    public StudentBean01(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StudentBean01{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public String study() {
        return "StudentBean01 class dan geliyor";
    }
}
