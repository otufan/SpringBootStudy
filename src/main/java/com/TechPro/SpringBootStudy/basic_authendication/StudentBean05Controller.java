package com.TechPro.SpringBootStudy.basic_authendication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentBean05Controller {

    private StudentBean05Service stdSrvc;//Service layer a ulasmak icin obj create edildi


    @Autowired
    public StudentBean05Controller(StudentBean05Service stdSrvc){

        this.stdSrvc=stdSrvc;

    }

    //bu method id ile ogrenci return eden  service methodu cagiracak
    @GetMapping(path = "/selectStudentById/{id}")
    public StudentBean05 selectStudentById(@PathVariable Long id){

    return stdSrvc.selectStudentById(id);


    }



}
