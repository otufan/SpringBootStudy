package com.TechPro.SpringBootStudy.controller_service_repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentBean04Service {

    private StudentBean04Repository studentRepo;//Repository layer ulasmak icin data type nda obj create edildi

    //obj degerini constructor dan alacak

    @Autowired
    public StudentBean04Service(StudentBean04Repository studentRepo){
        this.studentRepo=studentRepo;

    }
    //Bu method id ile ogrenci return edecek

    public StudentBean04 selectStudentById(Long id){
        // return studentRepo.findById(id).get(); --> olmayan id hata verir code kirilir bunun icin kontrol if calismali

        if(studentRepo.findById(id).isPresent()){
            return studentRepo.findById(id).get();
        }
        return new StudentBean04();//istenen id yoksa bos cons run edilecek
    }//Repositoryden alinan datalar methodda calsitirildi. bu method control Layer da cagirilacak



}
