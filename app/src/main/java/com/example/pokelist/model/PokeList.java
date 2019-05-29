package com.example.pokelist.model;

import java.util.ArrayList;

public class PokeList {

    private ArrayList<Pojo> results;

    public PokeList(ArrayList<Pojo> results) {
        this.results = results;
    }

    public ArrayList<Pojo> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pojo> results) {
        this.results = results;
    }
}
