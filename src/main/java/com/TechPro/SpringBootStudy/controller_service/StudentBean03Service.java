package com.TechPro.SpringBootStudy.controller_service;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentBean03Service {

    List<StudentBean03> listOfStudent=List.of(
         new StudentBean03(101L, "John Michel", "johnmic@mail.com", LocalDate.of(1987, 5,12)),
         new StudentBean03(102L, "Andre Bill", "Andre@mail.com", LocalDate.of(1989, 11,6)),
         new StudentBean03(103L, "Alice Carla", "Alice@mail.com", LocalDate.of(1982, 3,26)),
         new StudentBean03(104L, "Mary New", "mary@mail.com", LocalDate.of(1991, 1,11)));




//id ile obj datasi veren method
    public StudentBean03 getStudentById(Long id){
        if(listOfStudent.stream().filter(t->t.getId()==id).collect(Collectors.toList()).isEmpty()){
        return new StudentBean03();
        }


        return listOfStudent.stream().filter(t->t.getId()==id).findFirst().get();
    }






}
