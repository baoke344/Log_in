package com.company;

public class Users {
    private String userName;
    private String passWords;

     Users(String userName, String passWords) {
        this.setUserName(userName);
        this.setPassWords(passWords);
    }

    Users() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWords() {
        return passWords;
    }

    public void setPassWords(String passWords) {
        this.passWords = passWords;
    }

    @Override
    public String toString() {
        return "USerInformation{" +
                "userName='" + userName + '\'' +
                ", passWords='" + passWords + '\'' +
                '}';
    }
}
