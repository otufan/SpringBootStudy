package com.TechPro.SpringBootStudy.controller_service_repository;


import com.TechPro.SpringBootStudy.controller_service.StudentBean03Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentBean04Controller {

    private StudentBean04Service stdSrvc;//Service layer a ulasmak icin obj create edildi


    @Autowired
    public StudentBean04Controller(StudentBean04Service stdSrvc){

        this.stdSrvc=stdSrvc;

    }

    //bu method id ile ogrenci return eden  service methodu cagiracak
    @GetMapping(path = "/selectStudentById/{id}")
    public StudentBean04 selectStudentById(@PathVariable Long id){

    return stdSrvc.selectStudentById(id);


    }



}
