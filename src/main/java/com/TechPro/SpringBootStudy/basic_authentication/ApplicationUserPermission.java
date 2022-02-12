package com.TechPro.SpringBootStudy.basic_authentication;

public enum ApplicationUserPermission {

    STUDENT_READ("student:read"), STUDENT_WRITE("student:write");
private final String permission;//final variable oldg icin initial edilmeli. Bunun icin constructor ile iliskilendirilmeli

    ApplicationUserPermission(String permission) {
        this.permission=permission;
    }

    //Final permission variable obje ile degerini okumak icin getter method createe edildi
    // Final variable oldugu icin Setter methodu olmaz
    public String getPermission() {
        return permission;
    }
}
