package com.rest.model;

public class UserModel {

    private String userId;
    private String token;
    private String userName;
    private String password;
    private String phone;
    private int sex;
    private String headUrl;
    private String mail;

    public UserModel() {
    }

    public UserModel(String userId, String userName, String password, String token, String phone, int sex, String headUrl, String mail) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.sex = sex;
        this.headUrl = headUrl;
        this.mail = mail;
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
