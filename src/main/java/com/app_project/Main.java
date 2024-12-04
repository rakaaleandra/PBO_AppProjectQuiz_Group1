package com.app_project;

import java.awt.Color;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("QUIZ WORLD");
        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.darkGray);
        
        Menu menu = new Menu(frame);
        
        frame.setVisible(true);
    }
}