package com.example.fuadmaska.quindlogin.Response;

import java.util.ArrayList;

public class ResponseLogin {

    Boolean result;
    String pesan;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
    public ArrayList<User> getUser(){
        return user;
    }

    ArrayList<User> user = new ArrayList();
}
