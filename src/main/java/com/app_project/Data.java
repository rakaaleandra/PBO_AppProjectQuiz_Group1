package com.app_project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

public final class Data {
    ArrayList<question> dataListTeka = new ArrayList<>();
    ArrayList<picture> dataListGambarFix = new ArrayList<>();
    ArrayList<picture> dataListGambar = new ArrayList<>();
    ArrayList<ArrayList<question>> category = new ArrayList<>();
    ArrayList<question> section;
    HashSet<question> used1 = new HashSet<>();
    HashSet<picture> used2 = new HashSet<>();
    picture spesial = new picture();

    Data(){
        Random rand = new Random();

        pengisianTekaTeki("src/main/java/com/app_project/data/Music.json");
        pengisianTekaTeki("src/main/java/com/app_project/data/Informatika.json");
        pengisianTekaTeki("src/main/java/com/app_project/data/Film.json");
        pengisianTekaTeki("src/main/java/com/app_project/data/FnB.json");
        pengisianTekaTeki("src/main/java/com/app_project/data/Game.json");
        pengisianTekaTeki("src/main/java/com/app_project/data/Geografi.json");
        pengisianTekaTeki("src/main/java/com/app_project/data/PengetahuanUmum.json");
        // pengisianGambar("src/main/java/com/app_project/data/Gambar.json");
        pengisianGambar("src/main/java/com/app_project/data/Gambar(2).json");

        for (int i = 0; i < 15; ++i) {
            question temp;
            for (;;) {
                temp = category.get(rand.nextInt(category.size())).get(rand.nextInt(15));
                if (!used1.contains(temp)) {
                    used1.add(temp);
                    break;
                }
            }
            dataListTeka.add(temp);
        }
        // dataListTeka = category.get(1);
        for (int i = 0; i < 9; i++) {
            picture temp;
            for (;;) {
                temp = dataListGambar.get(rand.nextInt(dataListGambar.size()));
                if (!used2.contains(temp)) {
                    used2.add(temp);
                    break;
                }
            }
            dataListGambarFix.add(temp);
        }
        spesial.link = "src/main/resources/TekaTekiGambar/10 Jawaban/DosenAkhir.png";
        spesial.answerRight = new ArrayList<>();
        spesial.answerRight.add("Afrizal");
        spesial.answerRight.add("afrizal");
        spesial.answerRight.add("Afrizal Doewes");
        spesial.answerRight.add("afrizal doewes");
        spesial.hint = "Dosen PBO";
        dataListGambarFix.add(spesial);
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
                temp.answerRight = new ArrayList<>();
                
                temp.link = item.getString("link");
                JSONArray arey2 = item.getJSONArray("benar");
                for (int j = 0; j < arey2.length(); j++) {
                    temp.answerRight.add(arey2.getString(j));
                }
                temp.hint = item.getString("hint");

                dataListGambar.add(temp);
            }

            //tester
            // for (int i = 0; i < dataListGambar.size(); i++) {
            //     System.out.println(dataListGambar.get(i).link);
            //     for (int j = 0; j < dataListGambar.get(i).answerRight.size(); j++) {
            //         System.out.println(dataListGambar.get(i).answerRight.get(j));      
            //     }
            //     System.out.println(dataListGambar.get(i).hint);
            // }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public ArrayList<question> getData(){
        return dataListTeka;
    }

    public ArrayList<picture> getDataGambar(){
        return dataListGambarFix;
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
        ArrayList<String> answerRight;
        String hint;
    }
}
