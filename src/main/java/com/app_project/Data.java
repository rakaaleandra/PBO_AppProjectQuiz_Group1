package com.app_project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Data {
    ArrayList<question> dataList = new ArrayList<>();
    // ArrayList<ArrayList<question>> category = new ArrayList<>();
    ArrayList<question> section;

    Data(){
        section = new ArrayList<>();
        question temp;

        try {
            String content = new String(Files.readAllBytes(Paths.get("src/main/java/com/app_project/data/Music.json")));
            JSONObject obj = new JSONObject(content);
            JSONArray arey = obj.getJSONArray("array");
            for (int i = 0; i < arey.length(); i++) {
                JSONObject item = arey.getJSONObject(i);
                temp = new question();
                
                temp.pertanyaan = item.getString("pertanyaan");
                temp.jawaban1 = item.getString("string1");
                temp.jawaban2 = item.getString("string2");
                temp.jawaban3 = item.getString("string3");
                temp.jawaban4 = item.getString("string4");
                temp.benar = item.getInt("benar");

                section.add(temp);
            }

            for (int i = 0; i < section.size(); i++) {
                System.out.println(section.get(i).pertanyaan);                
                System.out.println(section.get(i).jawaban1);                
                System.out.println(section.get(i).jawaban2);                
                System.out.println(section.get(i).jawaban3);                
                System.out.println(section.get(i).jawaban4);                
                System.out.println(section.get(i).benar);                
            }
            dataList = section;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // public void pengisian(){
    //     section = new ArrayList<>();
    //     question temp;

    //     try {
    //         String content = new String(Files.readAllBytes(Paths.get("src/main/java/com/app_project/data/Music.json")));
    //         JSONObject obj = new JSONObject(content);
    //         JSONArray arey = obj.getJSONArray("array");
    //         for (int i = 0; i < arey.length(); i++) {
    //             JSONObject item = arey.getJSONObject(i);
    //             temp = new question();
                
    //             temp.pertanyaan = item.getString("pertanyaan");
    //             temp.jawaban1 = item.getString("string1");
    //             temp.jawaban2 = item.getString("string2");
    //             temp.jawaban3 = item.getString("string3");
    //             temp.jawaban4 = item.getString("string4");
    //             temp.benar = item.getInt("benar");

    //             section.add(temp);
    //         }

    //         for (int i = 0; i < section.size(); i++) {
    //             System.out.println(section.get(i).pertanyaan);                
    //             System.out.println(section.get(i).jawaban1);                
    //             System.out.println(section.get(i).jawaban2);                
    //             System.out.println(section.get(i).jawaban3);                
    //             System.out.println(section.get(i).jawaban4);                
    //             System.out.println(section.get(i).benar);                
    //         }
    //         dataList = section;
    //     } catch (IOException ex) {
    //         System.out.println(ex.getMessage());
    //     }

    //     // section.add(temp);
        
    //     // category.add(section);
    // }
    public ArrayList<question> getData(){
        return dataList;
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
