/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BMI_BMR;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Humaira Gulshan
 */
public class BMI implements ActionListener {

    JLabel l1;
    JButton b1, b2, b3;
    JFrame f;
    Container c;

    BMI() {
        f = new JFrame("Home");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        l1 = new JLabel("Select One To Calculate");
        l1.setBounds(500, 30, 700, 160);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Algerian", Font.BOLD, 30));
        f.add(l1);

        b1 = new JButton("BMI");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Algerian", Font.BOLD, 20));
        b1.setBounds(550, 200, 300, 40);
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("BMR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Algerian", Font.BOLD, 20));
        b2.setBounds(550, 400, 300, 40);
        b2.addActionListener(this);
        f.add(b2);

        b3 = new JButton("EXIT");
        b3.setBackground(Color.RED);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Algerian", Font.BOLD, 20));
        b3.setBounds(1130, 10, 200, 40);
        b3.addActionListener(this);
        f.add(b3);

//f.add(b1);
        f.getContentPane().setBackground(Color.GRAY);
        f.setVisible(true);
        f.setSize(1360, 750);
        f.setLocation(0, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b3) {
            int b = 0;
            System.exit(b);
        }

        if (e.getSource() == b1) {
            f.setVisible(false);
            new BMIC();
        } else if (e.getSource() == b2) {
            f.setVisible(false);
            new BMRC();
        }
        //.setVisible(true);
    }

    public static void main(String[] args) {
        BMI f = new BMI();
    }

}
