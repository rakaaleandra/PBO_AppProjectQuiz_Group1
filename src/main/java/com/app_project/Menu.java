package com.app_project;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu {
    JPanel panel1, panel2;
    JLabel title;
    JButton tekateki, gambar, categori;

    Menu(JFrame frame){
        panel1 = new JPanel();
        panel2 = new JPanel();
        title = new JLabel("QUIZ");
        tekateki = new JButton("Teka Teki");
        gambar = new JButton("Tebak Gambar");
        categori = new JButton("logo");

        panel2.setLayout(new FlowLayout());

        panel1.add(title);
        panel2.add(tekateki);
        panel2.add(gambar);

        frame.setLayout(new GridLayout(2,1));
        frame.add(panel1);
        frame.add(panel2);
    }

}