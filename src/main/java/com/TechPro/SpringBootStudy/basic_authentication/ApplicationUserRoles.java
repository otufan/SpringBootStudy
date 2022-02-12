package com.TechPro.SpringBootStudy.basic_authentication;

import com.google.common.collect.Sets;

import java.util.Set;

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
}
