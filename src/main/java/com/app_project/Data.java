package com.app_project;

import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONParserConfiguration;

public class Data {
    ArrayList<question> dataList = new ArrayList<>();
    ArrayList<ArrayList<question>> category = new ArrayList<>();
    ArrayList<question> section = new ArrayList<>();
    public void pengisian(){
        question temp = new question();

        JSONObject obj = new JSONObject();

        section.add(temp);
        
        category.add(section);
    }
    public class question{
        String pertanyaan;
        String jawaban1;
        String jawaban2;
        String jawaban3;
        String jawaban4;
        int benar;
    }
}
