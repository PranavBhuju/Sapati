package com.sapati.a_common.useCustom.response;

import com.sapati.a_common.entities.Person;
import io.micronaut.http.HttpStatus;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public class CustomResponse {
    private String message;
    private HttpStatus status;
    private  List<Person> userList;

    public CustomResponse() {
    }

    public CustomResponse(String message, HttpStatus status,List<Person> userList) {
        this.message = message;
        this.status = status;
        this.userList=userList;
    }
    public CustomResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public  List<Person> getUserList() {
        return userList;
    }

    public void setUserList(List <Person> userList) {
        this.userList = userList;
    }
}