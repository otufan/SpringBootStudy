package com.TechPro.SpringBootStudy.basic_authentication;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.TechPro.SpringBootStudy.basic_authentication.ApplicationUserPermission.STUDENT_READ;
import static com.TechPro.SpringBootStudy.basic_authentication.ApplicationUserPermission.STUDENT_WRITE;

public enum ApplicationUserRoles {//ENUM:app sabit fix datalarin saklandigi yapidir

   STUDENT(Sets.newHashSet(STUDENT_READ)), ADMIN(Sets.newHashSet(STUDENT_READ, STUDENT_WRITE));

    private final Set<ApplicationUserPermission> permissions;
    //STUDENT_READ("student:read"), STUDENT_WRITE("student:write") bu datalari cagirmak icin ve datalar uniq oldugu icin
    //set data type de variable olsuturuldu


    ApplicationUserRoles(Set<ApplicationUserPermission> permissions) {//final olan variable
        // initial olmasi icin parametreli constructor
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> izinleriGetirenMethod() {//permissions objesinin data field larini
        //STUDENT_READ, STUDENT_WRITE okumak icin
        return permissions;
    }

    public Set<SimpleGrantedAuthority> izinOnayla(){
//bu method STUDENT_READ("student:read"), STUDENT_WRITE("student:write") Role obj deki
// "student:read" ve "student:write" izinlerinin onaylanmasini return eder
//          SimpleGrantedAuthority : Authendication obj verilen bir Authority

        Set<SimpleGrantedAuthority> onaylananIzinler=izinleriGetirenMethod().//ApplicationUserPermission enum daki
                //datalari "student:read", "student:write" field larini getirir
                stream().
                map(t->new SimpleGrantedAuthority(t.getPermission())).//akisdaki fieldlar springboot security ile onaylaniyor
                collect(Collectors.toSet());//akisdan onaylanarak cikan izinler set e atandi
        onaylananIzinler.add(new SimpleGrantedAuthority("ROLE_"+this.name()));//Spring formati geregi onaylanan
        //sette ki izinleri
        return onaylananIzinler;
    }














}
