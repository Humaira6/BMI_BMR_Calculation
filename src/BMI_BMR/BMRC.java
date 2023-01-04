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
import java.text.NumberFormat;
import javax.swing.*;

public class BMRC implements ActionListener {

    JLabel l1, l2, l3, l4, l5;
    Container c;
    JButton b1, b2, b3, b4;
    JTextField t1, t2;
    JFrame f;
    JComboBox cb1, cb2;

    BMRC() {
        f = new JFrame("BMI");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        l1 = new JLabel("Enter your Weight in KG");
        l1.setBounds(350, 30, 700, 160);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        f.add(l1);

        t1 = new JTextField();
        t1.setBounds(850, 90, 250, 30);
        t1.setForeground(Color.BLACK);
        t1.setFont(new Font("Tahoma", Font.BOLD, 20));
        f.add(t1);

        l2 = new JLabel("Enter your Height in Feet");
        l2.setBounds(350, 90, 700, 160);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahoma", Font.BOLD, 20));
        f.add(l2);
        String[] ft = {"1", "2", "3", "4", "5", "6", "7"};
        String[] in = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};

        cb1 = new JComboBox(ft);
        cb1.setBounds(850, 150, 250, 30);
        cb1.setForeground(Color.BLACK);
        cb1.setFont(new Font("Tahoma", Font.BOLD, 20));
        f.add(cb1);

        l3 = new JLabel("Enter your Height in Inches");
        l3.setBounds(350, 150, 700, 160);
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Tahoma", Font.BOLD, 20));
        f.add(l3);

        cb2 = new JComboBox(in);
        cb2.setBounds(850, 210, 250, 30);
        cb2.setForeground(Color.BLACK);
        cb2.setFont(new Font("Tahoma", Font.BOLD, 20));
        f.add(cb2);
        f.getContentPane().setBackground(Color.GRAY);

        l4 = new JLabel("Enter your Age in Years");
        l4.setBounds(350, 220, 700, 160);
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Tahoma", Font.BOLD, 20));
        f.add(l4);
        t2 = new JTextField();
        t2.setBounds(850, 280, 250, 30);
        t2.setForeground(Color.BLACK);
        t2.setFont(new Font("Tahoma", Font.BOLD, 20));
        f.add(t2);

        l5 = new JLabel("Select Gender To Calculate");
        l5.setBounds(600, 270, 700, 160);
        l5.setForeground(Color.CYAN);
        l5.setFont(new Font("Tahoma", Font.BOLD, 20));
        f.add(l5);

        b1 = new JButton("MAlE");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Algerian", Font.BOLD, 20));
        b1.setBounds(350, 380, 250, 40);
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("FEMALE");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Algerian", Font.BOLD, 20));
        b2.setBounds(850, 380, 250, 40);
        b2.addActionListener(this);
        f.add(b2);

        b3 = new JButton("EXIT");
        b3.setBackground(Color.RED);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Algerian", Font.BOLD, 20));
        b3.setBounds(1130, 10, 200, 40);
        b3.addActionListener(this);
        f.add(b3);

        b4 = new JButton("Home page");
        b4.setBackground(Color.RED);
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("Algerian", Font.BOLD, 20));
        b4.setBounds(5, 10, 200, 40);
        b4.addActionListener(this);
        f.add(b4);

        f.setVisible(true);
        f.setSize(1360, 750);
        f.setLocation(0, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b3) {
            int b = 0;
            System.exit(b);
        } else if (t1.getText().equals("") && e.getSource() != b3 && e.getSource() != b4) {

            JOptionPane.showMessageDialog(c, "Weight should not be blank");
            t1.requestFocus();
        } else if (e.getSource() == b4) {
            f.setVisible(false);
            new BMI();
        } else {

            try {
                double weight = Double.parseDouble(t1.getText());
                if (weight <= 0) {
                    JOptionPane.showMessageDialog(c, "Weight should be greater than 0 ");
                    t1.setText("");
                    t1.requestFocus();
                } else if (t2.getText().equals("")) {
                    JOptionPane.showMessageDialog(c, "Age should not be blank");
                } else {
                    Object ftitem = cb1.getSelectedItem();
                    String ft = (String) ftitem;
                    int foot = Integer.parseInt(ft);

                    Object lnitem = cb2.getSelectedItem();
                    String ln = (String) ftitem;
                    int Inches = Integer.parseInt(ln);

                    //convert FT to inches
                    while (foot > 0) {
                        Inches += 12;
                        foot--;
                    }
                    double height = Inches * 2.54;

                    double bmrM = 0;
                    int a = Integer.parseInt(t2.getText());

                    if (e.getSource() == b1) {
                        bmrM = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * a);

                    } else if (e.getSource() == b2) {

                        bmrM = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * a);

                    }

                    NumberFormat nf = NumberFormat.getInstance();

                    nf.setMaximumFractionDigits(2);

                    String bmrs = nf.format(bmrM);

                    JOptionPane.showMessageDialog(c, "BMR =" + bmrs + "  Calories/Day");

                    t1.setText("");
                    t2.setText("");
                    cb1.setSelectedItem("1");
                    cb2.setSelectedItem("0");

                }

            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(c, "Check your weight or age and Enter proper Value");
                t1.setText("");
                t2.setText("");
            }

        }
    }

    public static void main(String[] args) {
        BMRC b = new BMRC();
    }
}
