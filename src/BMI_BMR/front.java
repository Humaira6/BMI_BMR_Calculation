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
/**
 *
 * @author Humaira Gulshan
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class front extends JFrame implements ActionListener {

    JButton b1;
    Container c;
    JLabel id, l1;

    front() {
        super("Calculator");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BMI_BMR/images/bmi and bmr.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 150, 1360, 530);
        add(l1);
        b1 = new JButton("Press to Continue");
        b1.setBackground(Color.ORANGE);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Tahoma", Font.BOLD, 20));
        b1.setBounds(600, 600, 300, 40);
        b1.addActionListener(this);
        id = new JLabel();
        id.setBounds(0, 0, 1360, 750);
        id.setLayout(null);
        JLabel lid = new JLabel("Welcome to BMI & BMR Calculator");
        lid.setBounds(100, 30, 1500, 160);
        lid.setFont(new Font("Algerian", Font.BOLD, 60));
        lid.setForeground(Color.BLACK);

        id.add(lid);
        id.add(b1);
        add(id);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setSize(1360, 730);
        setLocation(0, 0);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            setVisible(false);
        }
        new BMI();

    }

    public static void main(String[] args) {
        new front().setVisible(true);
    }

}
