package com.app_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{
    // static Image gambaring;
    static JFrame frame;
    static ArrayList<JPanel> kosongan;
    static void awalan(){
        frame = new JFrame("QUIZ WORLD");
        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        ImageIcon logo = new ImageIcon("src/main/resources/quiz-planet-logo.2684035.png");
        frame.setIconImage(logo.getImage());    
        // gambaring = new ImageIcon("src/main/resources/bg1.jpg").getImage();        

        frame.setLayout(new BorderLayout());
        frame.setBackground(Color.BLACK);
        // try {
        //     frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/main/resources/bg1.jpg")))));
        // } catch (IOException e) {
        //     System.out.println(e.getMessage());
        // }
        
        kosongan = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            kosongan.add(new JPanel());
            kosongan.get(i).setBackground(new Color(12,20,68,255));
            kosongan.get(i).setPreferredSize(new Dimension(50,50));
            kosongan.get(i).setOpaque(false);
        }
        frame.add(kosongan.get(0), BorderLayout.WEST);
        frame.add(kosongan.get(1), BorderLayout.EAST);
        frame.add(kosongan.get(2), BorderLayout.SOUTH);
    }
    static void akhiran(){
        
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        awalan();

        // Container container = frame.getContentPane();

        Menu menu = new Menu(frame);
        
        akhiran();
    }
}