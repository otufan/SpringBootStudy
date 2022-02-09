package com.TechPro.SpringBootStudy.basic_authendication;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository                                       //   <Kullanilacak model class, PK data type>
public interface StudentBean05Repository extends JpaRepository<StudentBean05, Long> {
//Repository nin ihtiyac duyacagi ID ile data alma gibi bazi methodlari kullanmak icin extend edildi

    Optional<StudentBean05> findByStudentBean05ByEmail(String email);
    //email ile data bulan method


}
