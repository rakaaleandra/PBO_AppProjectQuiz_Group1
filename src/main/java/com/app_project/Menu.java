package com.app_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;

public class Menu implements ActionListener{
    //deklarasi attribute
    
    JFrame frame;
    JLabel framing;
    JPanel panelMain, paneltekateki, panelgambar, ingambar, intekateki;
    JLabel title, logo1, logo2;
    JButton tekateki, gambar, categori;
    ImageIcon gambar1, gambar2;
    ArrayList<JPanel> kosong;
    Data data;
    Font sourceSansPro;
    
    Menu(JFrame frame, JLabel framing){
        this.data = new Data();
        // buffing.pengisian();
        // export = new Export();
        try {
            sourceSansPro = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/Font/OpenSans-VariableFont_wdth,wght.ttf"));
        } catch (Exception e) {
            System.out.println("tidak bisa laod font");
        }
        
        try{
            // export.start();
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
            SwingUtilities.invokeLater(()->{
                this.frame = frame;
                this.framing = framing;
                //memberi object pada attribute
                panelMain = new JPanel(new GridLayout(1,2,100,100));
                paneltekateki = new JPanel(new BorderLayout());
                panelgambar = new JPanel(new BorderLayout());
                kosong = new ArrayList<>();
                title = new JLabel("QUIZ");
                tekateki = new JButton("Teka Teki");
                gambar = new JButton("Tebak Gambar");
                categori = new JButton("logo");
                logo1 = new JLabel();
                logo2 = new JLabel();
        
                //pembuatan array dan otak atik panel
                for (int i = 0; i < 8; ++i ) {
                    kosong.add(new JPanel());
                    kosong.get(i).setBackground(new Color(12,20,68,255));
                    kosong.get(i).setPreferredSize(new Dimension(100,150));
                    kosong.get(i).setOpaque(false);
                }
        
                gambar.setPreferredSize(new Dimension(50,50));
                tekateki.setPreferredSize(new Dimension(50,50));
                tekateki.setFont(sourceSansPro.deriveFont(16f));
                gambar.setFont(sourceSansPro.deriveFont(16f));
                tekateki.setBackground(Color.WHITE);
                gambar.setBackground(Color.WHITE);
                gambar.setForeground(Color.BLACK);
                tekateki.setForeground(Color.BLACK);

                //mengatur posisi
                // tekateki.setHorizontalTextPosition(JLabel.CENTER);
                // tekateki.setVerticalTextPosition(JLabel.BOTTOM);
                // tekateki.setVerticalAlignment(JLabel.CENTER);
                // tekateki.setHorizontalAlignment(JLabel.CENTER);
                // gambar.setHorizontalTextPosition(JLabel.CENTER);
                // gambar.setVerticalTextPosition(JLabel.BOTTOM);
                // gambar.setVerticalAlignment(JLabel.CENTER);
                // gambar.setHorizontalAlignment(JLabel.CENTER);
                
                //memsukkan label dan button pada panel
                paneltekateki.add(kosong.get(0), BorderLayout.NORTH);
                paneltekateki.add(kosong.get(1), BorderLayout.EAST);
                paneltekateki.add(kosong.get(2), BorderLayout.SOUTH);
                paneltekateki.add(kosong.get(3), BorderLayout.WEST);
                paneltekateki.setOpaque(false);
                intekateki = new JPanel(new BorderLayout());
                intekateki.add(logo1, BorderLayout.CENTER);
                intekateki.add(tekateki, BorderLayout.SOUTH);
                intekateki.setOpaque(false);
                paneltekateki.add(intekateki, BorderLayout.CENTER);
                
                panelgambar.add(kosong.get(4), BorderLayout.NORTH);
                panelgambar.add(kosong.get(5), BorderLayout.WEST);
                panelgambar.add(kosong.get(6), BorderLayout.SOUTH);
                panelgambar.add(kosong.get(7), BorderLayout.EAST);
                panelgambar.setOpaque(false);
                ingambar = new JPanel(new BorderLayout());
                ingambar.add(logo2, BorderLayout.CENTER);
                ingambar.add(gambar, BorderLayout.SOUTH);
                ingambar.setOpaque(false);
                panelgambar.add(ingambar, BorderLayout.CENTER);

                //mamasukkan gambar dan memanipulasi ukuran gambar
                image();
                
                panelMain.setOpaque(false);
                panelMain.add(paneltekateki);
                panelMain.add(panelgambar);
                
                // panelMain.add(tekateki);
                // panelMain.add(gambar);
                
                //mengatur posisi title
                title.setVerticalAlignment(JLabel.CENTER);
                title.setHorizontalAlignment(JLabel.CENTER);
                title.setForeground(Color.WHITE);
                title.setPreferredSize(new Dimension(50,50));
                title.setBackground(new Color(12,20,68,255));
                title.setFont(sourceSansPro.deriveFont(20f));
                title.setOpaque(false);
        
                //button action
                tekateki.setFocusable(false);
                tekateki.addActionListener(this);
                tekateki.setOpaque(false);
                gambar.setFocusable(false);
                gambar.addActionListener(this);
                gambar.setOpaque(false);
                
                //memasukan panel pada frame
                this.framing.add(title, BorderLayout.NORTH);
                this.framing.add(panelMain, BorderLayout.CENTER);
                // frame.add(kosong.get(0), BorderLayout.WEST);
                
                this.frame.setVisible(true);
            });
            
        }catch(UnsupportedLookAndFeelException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    void image(){
        gambar1 = new ImageIcon("src/main/resources/menutekateki.png");
        gambar2 = new ImageIcon("src/main/resources/pngaaa.com-5340319.png");
        
        Image temp1 = gambar1.getImage();
        Image temp2 = gambar2.getImage();
        
        gambar1 = new ImageIcon(temp1.getScaledInstance(300, 300, 0));
        gambar2 = new ImageIcon(temp2.getScaledInstance(300, 300, 0));

        logo1.setIcon(gambar1);
        logo2.setIcon(gambar2);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == tekateki) {
            framing.remove(panelMain);
            Quiztekateki quiz = new Quiztekateki(frame, framing, data.getData());
            frame.setVisible(true);
        }
        else if (e.getSource() == gambar){
            framing.remove(panelMain);
            Quizgambar quiz = new Quizgambar(frame, framing, data.getDataGambar());
            frame.setVisible(true);
        }
    }

    // public class Export extends Thread{
    //     @Override
    //     public void run(){
    //         Data buffing = new Data();
    //         buffing.pengisian();
    //         data = buffing.getData();
    //     }
    // }
}