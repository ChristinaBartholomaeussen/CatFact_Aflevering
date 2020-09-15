package com.example.services;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class CatMethods implements Comparator<CatFacts> {


    public CatFacts getCatData() throws IOException {

        URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");

        BufferedReader inputFromCatURL = new BufferedReader(new InputStreamReader(catURL.openStream()));

        CatFacts data = new Gson().fromJson(inputFromCatURL, CatFacts.class);

        inputFromCatURL.close();

        return data;
    }



    @Override
    public int compare(CatFacts o1, CatFacts o2) {
        return o1.getCreatedAt().compareTo(o2.getCreatedAt());
    }





}
