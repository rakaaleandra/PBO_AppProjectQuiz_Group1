package com.app_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
    JLabel framing;
    ArrayList<picture> data;
    Font sourceSansPro;

    Quizgambar(JFrame frame, JLabel framing, ArrayList<picture> data){
        this.frame = frame;
        this.framing = framing;
        this.data = data;

        try {
            sourceSansPro = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/Font/OpenSans-VariableFont_wdth,wght.ttf"));
        } catch (Exception e) {
            System.out.println("tidak bisa laod font");
        }

        framing();
    }

    public void framing() {
        panelMain = new JPanel(new BorderLayout(30,30));
        kosong1 = new ArrayList<>();
        kosong2 = new ArrayList<>();
        kosong3 = new ArrayList<>();
        level = new ArrayList<>();
        answer = new JTextField();
        submit = new JButton("Submit");
        submit.setFont(sourceSansPro.deriveFont(20f));

        stage = new JPanel(new BorderLayout());
        stage.setPreferredSize(new Dimension(250,100));
        stage.setBackground(new Color(23,5,45,255));

        pertanyaan = new JPanel(new BorderLayout());
        pertanyaan.setPreferredSize(new Dimension(100,100));

        jawaban = new JPanel(new BorderLayout());
        jawaban.setPreferredSize(new Dimension(100,150));

        pov = new JPanel(new BorderLayout(10,10));
        pov.add(pertanyaan, BorderLayout.CENTER);
        pov.add(jawaban, BorderLayout.SOUTH);
        pov.setBackground(new Color(23,5,45,255));

        for (int i = 0; i < 4; i++) {
            kosong1.add(new JPanel());
            kosong2.add(new JPanel());
            kosong3.add(new JPanel());
            kosong1.get(i).setPreferredSize(new Dimension(10,10));
            kosong2.get(i).setPreferredSize(new Dimension(10,10));
            kosong3.get(i).setPreferredSize(new Dimension(30,30));
            kosong1.get(i).setBackground(new Color(23,5,45,255));
            kosong2.get(i).setBackground(new Color(23,5,45,255));
            kosong3.get(i).setBackground(new Color(23,5,45,255));
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
            inStage.setBackground(new Color(23,5,45,255));
            for (int i = 0; i < 10; ++i) {
                level.add(new JLabel("Level " + (i+1)));
                level.get(i).setForeground(Color.WHITE);
                level.get(i).setFont(sourceSansPro.deriveFont(18f));
                level.get(i).setVerticalAlignment(JLabel.CENTER);
                level.get(i).setHorizontalAlignment(JLabel.CENTER);
                level.get(i).setOpaque(false);
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
        answer.setFont(sourceSansPro.deriveFont(20f));
        answer.addActionListener(this);
        inJawaban.add(answer, BorderLayout.CENTER);
        inJawaban.add(submit, BorderLayout.EAST);
        povJawaban.add(hint, BorderLayout.EAST);
        povJawaban.add(inJawaban, BorderLayout.CENTER);
        jawaban.add(povJawaban, BorderLayout.CENTER);
        pov.setBackground(new Color(23,5,45,255));

        inPertanyaan = new JPanel();
        question = new ImageIcon(data.get(currentStage).link);
        questionLabel = new JLabel(question);
        inPertanyaan.add(questionLabel);
        inPertanyaan.setBackground(new Color(23,5,45,255));
        pertanyaan.add(inPertanyaan, BorderLayout.CENTER);

        panelMain.add(pov, BorderLayout.CENTER);
        panelMain.add(stage, BorderLayout.EAST);
        // panelMain.setBackground(new Color(12,20,68,255));
        panelMain.setOpaque(false);

        this.framing.add(panelMain, BorderLayout.CENTER);
        // this.frame.pack();
        this.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hint) {
            --hintCapacity;
            System.out.println("hint");
        }
        else if (e.getSource() == submit || e.getSource() == submit) {
            String jawab = answer.getText();
            if (jawab.equals(data.get(currentStage).answerRight)) {
                if (currentStage == 9) {
                    // JPanel paneling = new JPanel();
                    // JLabel label = new JLabel("Selamat Anda Berhasil");
                    // label.setForeground(Color.WHITE);
                    // label.setFont(new Font("Arial", Font.BOLD, 20));
                    // paneling.setBackground(Color.BLACK);
                    // paneling.add(label);
                    // this.framing.remove(panelMain);
                    // this.framing.add(paneling, BorderLayout.CENTER);
                    // this.frame.setVisible(true);
                    JOptionPane.showMessageDialog(frame, "<html>Karena Anda menang, maka Anda akan<br>mendapatkan hadiah dari admin<br>Silahkan hubungi : +62 812-3167-1474</html>", "Selamat Anda Berhasil", JOptionPane.WARNING_MESSAGE);      
                        System.exit(0);
                }
                else if (currentStage < 9){
                    levelUp();
                }
            }
            else {
            }
        }
    }

    public void levelUp(){
        ++currentStage;
        this.framing.remove(panelMain);
        framing();
    }
}