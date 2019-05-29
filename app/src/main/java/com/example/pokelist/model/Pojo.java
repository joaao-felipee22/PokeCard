package com.example.pokelist.model;

import android.content.Intent;

public class Pojo {

    private String name;
    private int number;
    private String url;

    public Pojo(String name, String url, int number) {
        this.name = name;
        this.number = number;
        this.url = url;

    }


    public int getNumber() {
        String[] urlPartes = url.split("/");
        return Integer.parseInt(urlPartes[urlPartes.length - 1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
