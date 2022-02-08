package com.TechPro.SpringBootStudy.controller_service_repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository                                       //   <Kullanilacak model class, PK data type>
public interface StudentBean04Repository extends JpaRepository<StudentBean04, Long> {
//Repository nin ihtiyac duyacagi ID ile data alma gibi bazi methodlari kullanmak icin extend edildi

    Optional<StudentBean04> findByStudentBean04ByEmail(String email);
    //email ile data bulan method




}
