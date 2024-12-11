package com.app_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
// import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.app_project.Data.question;

public final class Quiztekateki implements ActionListener{
    JPanel panelMain, stage, jawaban, pertanyaan, pov;
    ArrayList<JPanel> kosong1, kosong2, kosong3;
    JPanel inStage, inJawaban, inPertanyaan;
    ArrayList<JLabel> level;
    ArrayList<JButton> answer;
    JLabel question;
    JFrame frame;
    waktu time;
    int currentStage = 0;
    ArrayList<question> data;

    Quiztekateki(JFrame frame, ArrayList<question> data){
        this.data = data;
        this.frame = frame;
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
        question = new JLabel(data.get(currentStage).pertanyaan);
        inPertanyaan.add(question);
        pertanyaan.add(inPertanyaan, BorderLayout.CENTER);

        panelMain.add(pov, BorderLayout.CENTER);
        panelMain.add(stage, BorderLayout.WEST);
        panelMain.setBackground(new Color(12,20,68,255));

        this.frame.add(panelMain);
        this.frame.setVisible(true);
        time = new waktu();
        // this.time = new waktu();
        // this.time.start();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == answer.get(0)) {
            if (data.get(currentStage).benar == 1) {
                levelUp();
                // time.interrupt();
                // time.cancelTimer();
                // time.start();
            }
            else{
                // JPanel paneling = new JPanel();
                // JLabel label = new JLabel("Selamat Anda Salah");
                // label.setForeground(Color.WHITE);
                // label.setFont(new Font("Arial", Font.BOLD, 20));
                // paneling.setBackground(Color.BLACK);
                // paneling.add(label);
                // this.frame.remove(panelMain);
                // this.frame.add(paneling, BorderLayout.CENTER);
                // this.frame.setVisible(true);
                JOptionPane.showMessageDialog(frame, "Time Over! Anda akan keluar program.", "Time Over", JOptionPane.WARNING_MESSAGE);      
                    System.exit(0);
                // time.interrupt();
            }
        }
        if (e.getSource() == answer.get(1)) {
            if (data.get(currentStage).benar == 2) {
                levelUp();
                // time.interrupt();
                // time.cancelTimer();
                // time.start();
            }
            else{
                // JPanel paneling = new JPanel();
                // JLabel label = new JLabel("Selamat Anda Salah");
                // label.setForeground(Color.WHITE);
                // label.setFont(new Font("Arial", Font.BOLD, 20));
                // paneling.setBackground(Color.BLACK);
                // paneling.add(label);
                // this.frame.remove(panelMain);
                // this.frame.add(paneling, BorderLayout.CENTER);
                // this.frame.setVisible(true);
                JOptionPane.showMessageDialog(frame, "Time Over! Anda akan keluar program.", "Time Over", JOptionPane.WARNING_MESSAGE);      
                    System.exit(0);
                // time.interrupt();
            }
        }
        if (e.getSource() == answer.get(2)) {
            if (data.get(currentStage).benar == 3) {
                levelUp();
                // time.interrupt();
                // time.cancelTimer();
                // time.start();
            }
            else{
                // JPanel paneling = new JPanel();
                // JLabel label = new JLabel("Selamat Anda Salah");
                // label.setForeground(Color.WHITE);
                // label.setFont(new Font("Arial", Font.BOLD, 20));
                // paneling.setBackground(Color.BLACK);
                // paneling.add(label);
                // this.frame.remove(panelMain);
                // this.frame.add(paneling, BorderLayout.CENTER);
                // this.frame.setVisible(true);
                JOptionPane.showMessageDialog(frame, "Time Over! Anda akan keluar program.", "Time Over", JOptionPane.WARNING_MESSAGE);      
                    System.exit(0);
                // time.interrupt();
            }
        }
        if (e.getSource() == answer.get(3)) {
            if (data.get(currentStage).benar == 4) {
                levelUp();
                // time.setStopFlag(true); 
                // try {
                //     time.interrupt();
                //     time.join();
                // } catch (InterruptedException e1) {
                //     e1.getMessage();
                // }
            }
            else{
                // JPanel paneling = new JPanel();
                // JLabel label = new JLabel("Selamat Anda Salah");
                // label.setForeground(Color.WHITE);
                // label.setFont(new Font("Arial", Font.BOLD, 20));
                // paneling.setBackground(Color.BLACK);
                // paneling.add(label);
                // this.frame.remove(panelMain);
                // this.frame.add(paneling, BorderLayout.CENTER);
                // this.frame.setVisible(true);
                JOptionPane.showMessageDialog(frame, "Time Over! Anda akan keluar program.", "Time Over", JOptionPane.WARNING_MESSAGE);      
                    System.exit(0);
                // time.interrupt();
            }
        }
    }

    public void levelUp(){
        ++currentStage;
        if(currentStage < 15){
            // rehat();
            this.frame.remove(panelMain);
            framing();
        }
        else if (currentStage == 15) {
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
    }

    public void rehat(){
        // JPanel paneling = new JPanel();
        // JLabel label = new JLabel("Jawaban Anda Benar");
        // label.setForeground(Color.WHITE);
        // label.setFont(new Font("Arial", Font.BOLD, 20));
        // paneling.setBackground(Color.BLACK);
        // paneling.add(label);
        // this.frame.remove(panelMain);
        // this.frame.add(paneling, BorderLayout.CENTER);
        // this.frame.setVisible(true);
        System.out.println("Jawaban Anda Benar");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public class waktu{
        Timer timer;
        int duration = 0;

        waktu(){
            timer = new Timer(1000, e -> update());
            timer.start();
        }

        public void update(){
            duration++;
            System.out.println(duration);

            if (duration == 10) {
                JPanel paneling = new JPanel();
                paneling.setBackground(Color.BLACK);
                frame.remove(panelMain);
                frame.add(paneling);
                frame.setVisible(true);
                timer.stop();
            }

        }

        public void run(){
            // TimerTask task = new TimerTask() {
            //     @Override
            //     public void run() {
            //         if (!isCancelled) {
            //             System.out.println("Berhasil");
            //             JPanel paneling = new JPanel();
            //             paneling.setBackground(Color.BLACK);
            //             frame.remove(panelMain);
            //             frame.add(paneling);
            //             frame.setVisible(true);
            //         }
            //     }
            // };
            // timer.schedule(task, duration);
            

                try {
                    Thread.sleep(1000);
                    duration++;
                    if (i == 9) {
                        JPanel paneling = new JPanel();
                        paneling.setBackground(Color.BLACK);
                        frame.remove(panelMain);
                        frame.add(paneling);
                        frame.setVisible(true);
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            
        }
        // public void cancelTimer() {
        //     isCancelled = true;
        //     System.out.println("Gagal");
        // }
    }
}