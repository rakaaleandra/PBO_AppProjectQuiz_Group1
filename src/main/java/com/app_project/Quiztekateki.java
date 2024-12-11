package com.app_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.runtime.TemplateRuntime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import com.app_project.Data.question;

public final class Quiztekateki implements ActionListener{
    JPanel panelMain, stage, jawaban, pertanyaan, pov;
    ArrayList<JPanel> kosong1, kosong2, kosong3;
    JPanel inStage, inJawaban, inPertanyaan;
    ArrayList<JLabel> level;
    ArrayList<JButton> answer;
    JLabel question, timerView;
    JFrame frame;
    JLabel framing;
    waktu time;
    int currentStage = 0;
    ArrayList<question> data;

    Quiztekateki(JFrame frame, JLabel framing, ArrayList<question> data){
        this.data = data;
        this.frame = frame;
        this.framing = framing;
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
            kosong2.get(i).setPreferredSize(new Dimension(60,60));
            kosong3.get(i).setPreferredSize(new Dimension(10,10));
            kosong1.get(i).setBackground(new Color(25,25,57,255));
            kosong2.get(i).setBackground(new Color(25,25,57,255));
            kosong3.get(i).setBackground(new Color(25,25,57,255));
        }
        //before
        timerView = new JLabel();
        kosong2.get(0).add(timerView);

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
                level.get(i).setVerticalAlignment(JLabel.CENTER);
                level.get(i).setHorizontalAlignment(JLabel.CENTER);
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
        answer.get(0).setBackground(Color.WHITE);
        answer.get(0).setForeground(Color.BLACK);
        answer.get(0).addActionListener(this);
        inJawaban.add(answer.get(0));
        answer.add(new JButton(data.get(currentStage).jawaban2));
        answer.get(1).setBackground(Color.WHITE);
        answer.get(1).setForeground(Color.BLACK);
        answer.get(1).addActionListener(this);
        inJawaban.add(answer.get(1));
        answer.add(new JButton(data.get(currentStage).jawaban3));
        answer.get(2).setBackground(Color.WHITE);
        answer.get(2).setForeground(Color.BLACK);
        answer.get(2).addActionListener(this);
        inJawaban.add(answer.get(2));
        answer.add(new JButton(data.get(currentStage).jawaban4));
        answer.get(3).setBackground(Color.WHITE);
        answer.get(3).setForeground(Color.BLACK);
        answer.get(3).addActionListener(this);
        inJawaban.add(answer.get(3));

        jawaban.add(inJawaban, BorderLayout.CENTER);

        inPertanyaan = new JPanel(new GridBagLayout());
        inPertanyaan.setBackground(new Color(25,25,57,255));
        question = new JLabel(data.get(currentStage).pertanyaan);
        question.setForeground(Color.WHITE);
        inPertanyaan.add(question);
        pertanyaan.add(inPertanyaan, BorderLayout.CENTER);

        panelMain.add(pov, BorderLayout.CENTER);
        panelMain.add(stage, BorderLayout.WEST);
        panelMain.setBackground(new Color(12,20,68,255));

        this.framing.add(panelMain);
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
            }
            else{
                time.berhenti();
                JOptionPane.showMessageDialog(frame, "Game Over! Jawabanmu Salah.", "Game Over", JOptionPane.WARNING_MESSAGE);      
                    System.exit(0);
            }
        }
        if (e.getSource() == answer.get(1)) {
            if (data.get(currentStage).benar == 2) {
                levelUp();
            }
            else{
                time.berhenti();
                JOptionPane.showMessageDialog(frame, "Game Over! Jawabanmu Salah.", "Game Over", JOptionPane.WARNING_MESSAGE);      
                    System.exit(0);
                
            }
        }
        if (e.getSource() == answer.get(2)) {
            if (data.get(currentStage).benar == 3) {
                levelUp();
            }
            else{
                time.berhenti();
                JOptionPane.showMessageDialog(frame, "Game Over! Jawabanmu Salah.", "Game Over", JOptionPane.WARNING_MESSAGE);      
                    System.exit(0);
                    // new Menu(this.frame);
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
                time.berhenti();
                JOptionPane.showMessageDialog(frame, "Game Over! Jawabanmu Salah.", "Game Over", JOptionPane.WARNING_MESSAGE);      
                    System.exit(0);
                // time.interrupt();
            }
        }
    }

    public void levelUp(){
        time.berhenti();
        ++currentStage;
        if(currentStage < 15){
            JPanel paneling = new JPanel(new GridBagLayout());
            JLabel label = new JLabel("Jawabanmu benar");
            label.setForeground(Color.WHITE);
            label.setFont(new Font("Arial", Font.BOLD, 20));
            paneling.setBackground(new Color(25,25,57,255));
            paneling.add(label);
            this.pov.remove(pertanyaan);
            this.pov.remove(jawaban);
            this.pov.add(paneling, BorderLayout.CENTER);
            this.frame.setVisible(true);
            rehat();
        }
        else if (currentStage == 15) {
            JPanel paneling = new JPanel();
            JLabel label = new JLabel("Selamat Anda Berhasil");
            label.setForeground(Color.WHITE);
            label.setFont(new Font("Arial", Font.BOLD, 20));
            paneling.setBackground(Color.BLACK);
            paneling.add(label);
            this.framing.remove(panelMain);
            this.framing.add(paneling, BorderLayout.CENTER);
            this.frame.setVisible(true);
        }
    }

    public void rehat(){
        // this.frame.remove(panelMain);
        final int[] renggat = {0};
        Timer temptime = new Timer(1000, e -> {
            // question.setText("Jawaban mu benar");
            
            // answer.get(0).setOpaque(false);
            // answer.get(1).setOpaque(false);
            // answer.get(2).setOpaque(false);
            // answer.get(3).setOpaque(false);
            // JPanel panelling = new JPanel();
            // panelling.setBackground(Color.BLACK);
            // inJawaban = panelling;

            renggat[0]++;
            System.out.println(renggat[0]);
            if(renggat[0] == 3){
                ((Timer) e.getSource()).stop();
                this.framing.remove(panelMain);
                framing();
            }
        });
        temptime.start();
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
            timerView.setText(Integer.toString(duration));

            if (duration == 15) {
                JPanel paneling = new JPanel();
                paneling.setBackground(Color.BLACK);
                framing.remove(panelMain);
                framing.add(paneling);
                frame.setVisible(true);
                timer.stop();
            }

        }

        public void berhenti(){
            timer.stop();
        }

        //produk gagal
        /*
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
        */
    }
}