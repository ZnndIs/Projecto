package Jogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceJogo {
    Jogo jogo = new Jogo("Nome");
    public static void main(String[] args) {

        JFrame frame = new JFrame("Jogo");
        frame.setSize(500, 400);
        JPanel p1 = new JPanel();
        p1.setLayout(new GridBagLayout());

        JButton start = new JButton("Comecar o jogo");
        start.setSize(80,50);
        frame.add(p1, BorderLayout.CENTER);
        p1.add(start);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
