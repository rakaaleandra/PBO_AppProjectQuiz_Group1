package com.app_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    JPanel panelMain, paneltekateki, panelgambar;
    JLabel title;
    JButton tekateki, gambar, categori;
    ImageIcon gambar1, gambar2;
    ArrayList<JPanel> kosong;
    Data data;
    // Export export;
    
    Menu(JFrame frame){
        data = new Data();
        // buffing.pengisian();
        // export = new Export();
        
        try{
            // export.start();
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
            SwingUtilities.invokeLater(()->{
                this.frame = frame;
                //memberi object pada attribute
                panelMain = new JPanel(new GridLayout(1,2,100,100));
                paneltekateki = new JPanel(new BorderLayout());
                panelgambar = new JPanel(new BorderLayout());
                kosong = new ArrayList<>();
                title = new JLabel("QUIZ");
                tekateki = new JButton("Teka Teki");
                gambar = new JButton("Tebak Gambar");
                categori = new JButton("logo");
        
                //pembuatan array dan otak atik panel
                for (int i = 0; i < 8; ++i ) {
                    kosong.add(new JPanel());
                    kosong.get(i).setBackground(new Color(12,20,68,255));
                    kosong.get(i).setPreferredSize(new Dimension(100,100));
                }
        
                //mamasukkan gambar dan memanipulasi ukuran gambar
                image();
                
                //mengatur posisi
                tekateki.setHorizontalTextPosition(JLabel.CENTER);
                tekateki.setVerticalTextPosition(JLabel.BOTTOM);
                tekateki.setVerticalAlignment(JLabel.CENTER);
                tekateki.setHorizontalAlignment(JLabel.CENTER);
                gambar.setHorizontalTextPosition(JLabel.CENTER);
                gambar.setVerticalTextPosition(JLabel.BOTTOM);
                gambar.setVerticalAlignment(JLabel.CENTER);
                gambar.setHorizontalAlignment(JLabel.CENTER);
                
                //memsukkan label dan button pada panel
                paneltekateki.add(kosong.get(0), BorderLayout.NORTH);
                paneltekateki.add(kosong.get(1), BorderLayout.EAST);
                paneltekateki.add(kosong.get(2), BorderLayout.SOUTH);
                paneltekateki.add(kosong.get(3), BorderLayout.WEST);
                paneltekateki.add(tekateki, BorderLayout.CENTER);
                
                panelgambar.add(kosong.get(4), BorderLayout.NORTH);
                panelgambar.add(kosong.get(5), BorderLayout.WEST);
                panelgambar.add(kosong.get(6), BorderLayout.SOUTH);
                panelgambar.add(kosong.get(7), BorderLayout.EAST);
                panelgambar.add(gambar, BorderLayout.CENTER);
        
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
                title.setOpaque(true);
        
                //button action
                tekateki.setFocusable(false);
                gambar.setFocusable(false);
                tekateki.addActionListener(this);
                gambar.addActionListener(this);
                
                //memasukan panel pada frame
                this.frame.add(title, BorderLayout.NORTH);
                this.frame.add(panelMain, BorderLayout.CENTER);
                // frame.add(kosong.get(0), BorderLayout.WEST);
            });
            
        }catch(UnsupportedLookAndFeelException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    void image(){
        gambar1 = new ImageIcon("src/main/resources/apalah.jpg");
        gambar2 = new ImageIcon("src/main/resources/apalah.jpg");
        
        Image temp1 = gambar1.getImage();
        Image temp2 = gambar2.getImage();
        
        gambar1 = new ImageIcon(temp1.getScaledInstance(200, 200, 0));
        gambar2 = new ImageIcon(temp2.getScaledInstance(200, 200, 0));

        tekateki.setIcon(gambar1);
        gambar.setIcon(gambar2);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == tekateki) {
            System.out.println("klik");
            frame.remove(panelMain);
            Quiztekateki quiz = new Quiztekateki(frame, data.getData());
            frame.setVisible(true);
        }
        else if (e.getSource() == gambar){
            System.out.println("konci");
            frame.remove(panelMain);
            Quizgambar quiz = new Quizgambar(frame, data.getDataGambar());
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