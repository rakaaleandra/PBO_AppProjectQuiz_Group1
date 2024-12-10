package com.app_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.app_project.Data.question;

public final class Quiztekateki implements ActionListener{
    JPanel panelMain, stage, jawaban, pertanyaan, pov;
    ArrayList<JPanel> kosong1, kosong2, kosong3;
    JPanel inStage, inJawaban, inPertanyaan;
    ArrayList<JLabel> level;
    ArrayList<JButton> answer;
    JLabel question;
    static JFrame frame;
    waktu time;
    int currentStage = 0;
    ArrayList<question> data;

    Quiztekateki(JFrame frame, ArrayList<question> data){
        this.data = data;
        Quiztekateki.frame = frame;
        framing();
    }

    public void framing(){
        panelMain = new JPanel(new BorderLayout(10,10));
        kosong1 = new ArrayList<>();
        kosong2 = new ArrayList<>();
        kosong3 = new ArrayList<>();
        level = new ArrayList<>();
        answer = new ArrayList<>();

        stage = new JPanel(new BorderLayout());
        stage.setPreferredSize(new Dimension(250,100));

        pertanyaan = new JPanel(new BorderLayout());
        pertanyaan.setPreferredSize(new Dimension(100,100));

        jawaban = new JPanel(new BorderLayout());
        jawaban.setPreferredSize(new Dimension(100,150));

        pov = new JPanel(new BorderLayout(10,10));
        pov.add(pertanyaan, BorderLayout.CENTER);
        pov.add(jawaban, BorderLayout.SOUTH);
        pov.setBackground(new Color(12,20,68,255));

        for (int i = 0; i < 4; i++) {
            kosong1.add(new JPanel());
            kosong2.add(new JPanel());
            kosong3.add(new JPanel());
            kosong1.get(i).setPreferredSize(new Dimension(10,10));
            kosong2.get(i).setPreferredSize(new Dimension(10,10));
            kosong3.get(i).setPreferredSize(new Dimension(10,10));
            kosong1.get(i).setBackground(new Color(25,25,57,255));
            kosong2.get(i).setBackground(new Color(25,25,57,255));
            kosong3.get(i).setBackground(new Color(25,25,57,255));
        }
        stage.add(kosong1.get(0), BorderLayout.NORTH);
        stage.add(kosong1.get(1), BorderLayout.WEST);
        stage.add(kosong1.get(2), BorderLayout.SOUTH);
        stage.add(kosong1.get(3), BorderLayout.EAST);
        pertanyaan.add(kosong2.get(0), BorderLayout.NORTH);
        pertanyaan.add(kosong2.get(1), BorderLayout.WEST);
        pertanyaan.add(kosong2.get(2), BorderLayout.SOUTH);
        pertanyaan.add(kosong2.get(3), BorderLayout.EAST);
        jawaban.add(kosong3.get(0), BorderLayout.NORTH);
        jawaban.add(kosong3.get(1), BorderLayout.WEST);
        jawaban.add(kosong3.get(2), BorderLayout.SOUTH);
        jawaban.add(kosong3.get(3), BorderLayout.EAST);

        try {
            inStage = new JPanel(new GridLayout(15,1));
            for (int i = 0; i < 15; ++i) {
                level.add(new JLabel("Level " + (i+1)));
                level.get(i).setForeground(Color.WHITE);
                inStage.add(level.get(i));
            }
            stage.add(inStage, BorderLayout.CENTER);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        inJawaban = new JPanel(new GridLayout(2,2));
        //kalau data array
        // for (int i = 0; i < 4; i++) {
        //     answer.add(new JButton("Jawaban" + i));
        //     answer.get(i).addActionListener(this);
        //     inJawaban.add(answer.get(i));
        // }

        //kalau data manual
        answer.add(new JButton(data.get(currentStage).jawaban1));
        answer.get(0).addActionListener(this);
        inJawaban.add(answer.get(0));
        answer.add(new JButton(data.get(currentStage).jawaban2));
        answer.get(1).addActionListener(this);
        inJawaban.add(answer.get(1));
        answer.add(new JButton(data.get(currentStage).jawaban3));
        answer.get(2).addActionListener(this);
        inJawaban.add(answer.get(2));
        answer.add(new JButton(data.get(currentStage).jawaban4));
        answer.get(3).addActionListener(this);
        inJawaban.add(answer.get(3));

        jawaban.add(inJawaban, BorderLayout.CENTER);

        inPertanyaan = new JPanel();
        question = new JLabel("pertanyaan");
        inPertanyaan.add(question);
        pertanyaan.add(inPertanyaan, BorderLayout.CENTER);

        panelMain.add(pov, BorderLayout.CENTER);
        panelMain.add(stage, BorderLayout.WEST);
        panelMain.setBackground(new Color(12,20,68,255));

        frame.add(panelMain);
        frame.setVisible(true);
        time = new waktu();
        time.start();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == answer.get(0)) {
            if (data.get(currentStage).benar == 1) {
                levelUp();
                time.interrupt();
                // time.start();
            }
            else{
                JPanel paneling = new JPanel();
                paneling.setBackground(Color.BLACK);
                System.out.println("dontol");
                time.interrupt();
            }
        }
        if (e.getSource() == answer.get(1)) {
            if (data.get(currentStage).benar == 2) {
                levelUp();
                time.interrupt();
                // time.start();
            }
            else{
                JPanel paneling = new JPanel();
                paneling.setBackground(Color.BLACK);
                System.out.println("dontol");
                time.interrupt();
            }
        }
        if (e.getSource() == answer.get(2)) {
            if (data.get(currentStage).benar == 3) {
                levelUp();
                time.interrupt();
                // time.start();
            }
            else{
                JPanel paneling = new JPanel();
                paneling.setBackground(Color.BLACK);
                System.out.println("dontol");
                time.interrupt();
            }
        }
        if (e.getSource() == answer.get(3)) {
            if (data.get(currentStage).benar == 4) {
                levelUp();
                time.interrupt();
                // time.start();
            }
            else{
                JPanel paneling = new JPanel();
                paneling.setBackground(Color.BLACK);
                System.out.println("dontol");
                time.interrupt();
            }
        }
    }

    public void levelUp(){
        ++currentStage;
        // answer.set(0, new JButton(data.get(currentStage).jawaban1));
        // answer.set(1, new JButton(data.get(currentStage).jawaban2));
        // answer.set(2, new JButton(data.get(currentStage).jawaban3));
        // answer.set(3, new JButton(data.get(currentStage).jawaban4));
        frame.remove(panelMain);
        framing();
    }

    public class waktu extends Thread{
        @Override
        public void run(){
            
            JPanel paneling = new JPanel();
            paneling.setBackground(Color.BLACK);
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    Thread.sleep(1000);
                    if (i == 9) {
                        frame.remove(panelMain);
                        frame.add(paneling);
                        frame.setVisible(true);
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}