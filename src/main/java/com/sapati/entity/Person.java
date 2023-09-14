package com.sapati.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;


@Serdeable
@MappedEntity(value = "Person")
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String userType;
    private String email;
    private String pwd;
    private String confirmPwd;
    private Boolean isVerified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public Person(Long id, String userName, String userType, String email, String pwd, String confirmPwd, Boolean isVerified) {
        this.id = id;
        this.userName = userName;
        this.userType = userType;
        this.email = email;
        this.pwd = pwd;
        this.confirmPwd = confirmPwd;
        this.isVerified = isVerified;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userType='" + userType + '\'' +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", confirmPwd='" + confirmPwd + '\'' +
                ", isVerified=" + isVerified +
                '}';
    }
}
