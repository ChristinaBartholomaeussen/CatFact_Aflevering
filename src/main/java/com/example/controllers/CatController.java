package com.example.controllers;

import com.example.services.CatFacts;
import com.example.services.CatMethods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Collections;

@Controller
public class CatController {

    @GetMapping("/")
    @ResponseBody
    public String welcome()
    {
        return "Welcome";
    }

    @GetMapping("/getSingle")
    @ResponseBody
    public String getSingle() throws IOException {

        CatMethods methods = new CatMethods();
        return methods.getCatData().toString();

    }


    @GetMapping("/getTen")
    @ResponseBody
    public ArrayList<CatFacts> getTen() throws IOException {

        ArrayList<CatFacts> facts = new ArrayList<>();

        CatMethods methods = new CatMethods();


        for(int i = 0; i < 10; i++)
        {
            facts.add(methods.getCatData());
        }


        return facts;

    }

    @GetMapping("/getTenSortByDate")
    @ResponseBody
    public ArrayList<CatFacts> getTenSortByDate() throws IOException {

        ArrayList<CatFacts> facts = new ArrayList<>();

        CatMethods methods = new CatMethods();

        for(int i = 0; i < 10; i++)
        {
            facts.add(methods.getCatData());
        }

        Collections.sort(facts);

        return facts;
    }

    @GetMapping("/contains")
    @ResponseBody
    public String contains(@RequestParam char x, @RequestParam int n) throws IOException {

        CatMethods methods = new CatMethods();

        int count = 0;

        char[] facts = methods.getCatData().getText().toCharArray();

        for(char character : facts)
        {
            if(x == character)
            {
                count++;
            }
        }

        //Jeg har valgt at tolke opgaven således, at hvis facten indeholder den specikke karakter
        //mindst n antal af gange, så printer den en fact. Ellers er det næsten umuligt at få printet
        //en fact. Hvis det skulle være lige præcis det samme antal gange, skulle '>=' skiftes ud med '=='

        //Jeg har desuden valgt kun at printe den spefikke fact uden createdAt og updatedAt
        if(count >= n)
        {
            return methods.getCatData().getText();
        }
        else
        {
            return "Sorry no luck";
        }


    }


}

