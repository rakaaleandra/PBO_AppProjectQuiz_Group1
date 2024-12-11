package com.app_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.app_project.Data.picture;

public final class Quizgambar implements ActionListener{
    JPanel panelMain, stage, jawaban, pertanyaan, pov;
    ArrayList<JPanel> kosong1, kosong2, kosong3;
    JPanel inStage, inJawaban, inPertanyaan, povJawaban;
    ArrayList<JLabel> level;
    JTextField answer;
    JButton submit;
    ImageIcon question;
    JLabel questionLabel;
    JButton hint;
    int currentStage = 0, hintCapacity = 0;
    JFrame frame;
    ArrayList<picture> data;

    Quizgambar(JFrame frame, ArrayList<picture> data){
        this.frame = frame;
        this.data = data;
        framing();
    }

    public void framing() {
        panelMain = new JPanel(new BorderLayout(10,10));
        kosong1 = new ArrayList<>();
        kosong2 = new ArrayList<>();
        kosong3 = new ArrayList<>();
        level = new ArrayList<>();
        answer = new JTextField();
        submit = new JButton("Submit");

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
            kosong3.get(i).setPreferredSize(new Dimension(30,30));
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
            inStage = new JPanel(new GridLayout(10,1));
            for (int i = 0; i < 10; ++i) {
                level.add(new JLabel("Level " + (i+1)));
                level.get(i).setForeground(Color.WHITE);
                inStage.add(level.get(i));
                if (level.size() == currentStage+1) {
                    level.get(i).setBackground(Color.WHITE);
                    level.get(i).setForeground(Color.BLACK);
                    level.get(i).setOpaque(true);
                }
            }
            stage.add(inStage, BorderLayout.CENTER);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        povJawaban = new JPanel(new BorderLayout());
        hint = new JButton("HINT");
        hint.addActionListener(this);
        submit.addActionListener(this);
        inJawaban = new JPanel(new BorderLayout());
        inJawaban.add(answer, BorderLayout.CENTER);
        inJawaban.add(submit, BorderLayout.EAST);
        povJawaban.add(hint, BorderLayout.EAST);
        povJawaban.add(inJawaban, BorderLayout.CENTER);
        jawaban.add(povJawaban, BorderLayout.CENTER);

        inPertanyaan = new JPanel();
        question = new ImageIcon(data.get(currentStage).link);
        questionLabel = new JLabel(question);
        inPertanyaan.add(questionLabel);
        pertanyaan.add(inPertanyaan, BorderLayout.CENTER);

        panelMain.add(pov, BorderLayout.CENTER);
        panelMain.add(stage, BorderLayout.EAST);
        panelMain.setBackground(new Color(12,20,68,255));

        this.frame.add(panelMain);
        this.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hint) {
            --hintCapacity;
            System.out.println("hint");
        }
        else if (e.getSource() == submit) {
            String jawab = answer.getText();
            if (jawab.equals(data.get(currentStage).answerRight)) {
                if (currentStage == 10) {
                    JPanel paneling = new JPanel();
                    JLabel label = new JLabel("Selamat Anda Berhasil");
                    label.setForeground(Color.WHITE);
                    label.setFont(new Font("Arial", Font.BOLD, 20));
                    paneling.setBackground(Color.BLACK);
                    paneling.add(label);
                    this.frame.remove(panelMain);
                    this.frame.add(paneling, BorderLayout.CENTER);
                    this.frame.setVisible(true);
                }
                else if (currentStage < 10){
                    levelUp();
                }
            }
            else {
                JOptionPane.showMessageDialog(frame, "Time Over! Anda akan keluar program.", "Time Over", JOptionPane.WARNING_MESSAGE);      
                    System.exit(0);
            }
            System.out.println("submit");
        }
    }

    public void levelUp(){
        ++currentStage;
        this.frame.remove(panelMain);
        framing();
    }
}