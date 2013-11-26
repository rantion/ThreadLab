package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Animator extends JFrame{
    JButton start, stop;
    JPanel ballPanel;
    Ball ball;
    Timer timer;
    int speed = 20;
    int pause = 1;
    StartAction action = new StartAction();
    public boolean animate;

    public Animator(){


        super("Animation");
        start = new JButton("Start");
        stop = new JButton("Stop");
        Box buttons = new Box(BoxLayout.X_AXIS);
        buttons.add(start);
        buttons.add(stop);
        getContentPane().add(buttons, BorderLayout.NORTH);

        timer = new Timer(speed, action);


        ballPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                ball.paint(g);
            }
        };
        ball = new Ball(ballPanel);
        getContentPane().add(ballPanel);

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if("Stop".equals((e.getActionCommand()))){
                timer.stop();

                }
        }
        });


        start.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                if("Start".equals(e.getActionCommand())){
//                           timer = new Timer(speed);
                           timer.start();
                         }
            }
        });

    }



        public static void main(String[] args){
        JFrame f = new Animator();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(300, 300, 300, 200);
        f.setVisible(true);
        }

    private class StartAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            animate = true;
                while(animate){
                    ball.move();
                    repaint();
                    animate = false;

        }
    }
}
}
