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
    private String username;
    private String usertype;
    private String email;
    private String pwd;
    private String confirmpwd;
    private Boolean isverified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
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

    public String getConfirmpwd() {
        return confirmpwd;
    }

    public void setConfirmpwd(String confirmpwd) {
        this.confirmpwd = confirmpwd;
    }

    public Boolean getIsverified() {
        return isverified;
    }

    public void setIsverified(Boolean isverified) {
        this.isverified = isverified;
    }

    public Person(Long id, String username, String usertype, String email, String pwd, String confirmpwd, Boolean isverified) {
        this.id = id;
        this.username = username;
        this.usertype = usertype;
        this.email = email;
        this.pwd = pwd;
        this.confirmpwd = confirmpwd;
        this.isverified = false;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", usertype='" + usertype + '\'' +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", confirmpwd='" + confirmpwd + '\'' +
                ", isverified=" + isverified +
                '}';
    }
}
