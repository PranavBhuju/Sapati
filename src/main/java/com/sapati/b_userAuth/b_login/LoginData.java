package com.sapati.b_userAuth.b_login;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Introspected
@Serdeable.Deserializable
public class LoginData {
    private String userName;
    private String pwd;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public LoginData(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
