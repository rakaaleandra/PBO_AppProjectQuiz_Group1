package com.app_project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public final class Data {
    ArrayList<question> dataListTeka = new ArrayList<>();
    ArrayList<picture> dataListGambar = new ArrayList<>();
    ArrayList<ArrayList<question>> category = new ArrayList<>();
    ArrayList<question> section;

    Data(){
        pengisianTekaTeki("src/main/java/com/app_project/data/Music.json");
        dataListTeka = category.get(0);
    }
    
    public void pengisianTekaTeki(String Link){
        section = new ArrayList<>();
        question temp;
        try {
            String content = new String(Files.readAllBytes(Paths.get(Link)));
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

            //tester
            // for (int i = 0; i < section.size(); i++) {
            //     System.out.println(section.get(i).pertanyaan);                
            //     System.out.println(section.get(i).jawaban1);                
            //     System.out.println(section.get(i).jawaban2);                
            //     System.out.println(section.get(i).jawaban3);                
            //     System.out.println(section.get(i).jawaban4);                
            //     System.out.println(section.get(i).benar);                
            // }
            category.add(section);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void pengisianGambar(String Link){
        picture temp;
        try {
            String content = new String(Files.readAllBytes(Paths.get(Link)));
            JSONObject obj = new JSONObject(content);
            JSONArray arey = obj.getJSONArray("array");
            for (int i = 0; i < arey.length(); i++) {
                JSONObject item = arey.getJSONObject(i);
                temp = new picture();
                
                temp.link = item.getString("gambar");
                temp.answerRight = item.getString("benar");

                dataListGambar.add(temp);
            }

            //tester
            // for (int i = 0; i < section.size(); i++) {
            //     System.out.println(section.get(i).pertanyaan);                
            //     System.out.println(section.get(i).jawaban1);                
            //     System.out.println(section.get(i).jawaban2);                
            //     System.out.println(section.get(i).jawaban3);                
            //     System.out.println(section.get(i).jawaban4);                
            //     System.out.println(section.get(i).benar);                
            // }
            category.add(section);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public ArrayList<question> getData(){
        return dataListTeka;
    }

    public class question{
        String pertanyaan;
        String jawaban1;
        String jawaban2;
        String jawaban3;
        String jawaban4;
        int benar;
    }
    public class picture{
        String link;
        String answerRight;
    }
}
