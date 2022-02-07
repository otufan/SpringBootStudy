package com.TechPro.SpringBootStudy.controller_service;


import com.TechPro.SpringBootStudy.controller.StudentBean01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentBean03Controller {

    private StudentBean03Service std;

    @Autowired
    public StudentBean03Controller(StudentBean03Service std){
        this.std=std;

    }

   // @GetMapping(path = "/getStudentByid")
   // public StudentBean03 getStudentIdIle(){
//
   //     return std.getStudentById(104L);
   // }

    @GetMapping(path = "/getStudentByid/{id}")
    public StudentBean03 getStudentId(@PathVariable Long id){

        return std.getStudentById(id);
    }



}
