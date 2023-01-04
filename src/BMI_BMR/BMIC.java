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
import java.text.*;

/**
 *
 * @author Humaira Gulshan
 */
public class BMIC implements ActionListener {

    JLabel l1, l2, l3;
    Container c;
    JButton b1, b2, b3;
    JTextField t1, t2;
    JFrame f;
    JComboBox cb1, cb2;

    BMIC() {
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
        //cb1= new JComboBox(ft);
        //cb2 = new JComboBox(in);
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

        b1 = new JButton("Calculate");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Algerian", Font.BOLD, 20));
        b1.setBounds(550, 300, 300, 40);
        b1.addActionListener(this);
        f.add(b1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ab/images/BMI range.PNG"));
        Image i2 = i1.getImage().getScaledInstance(900, 320, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(85, 320, 1160, 400);
        f.add(l1);

        b2 = new JButton("Home page");
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Algerian", Font.BOLD, 20));
        b2.setBounds(1130, 10, 200, 40);
        b2.addActionListener(this);
        f.add(b2);

        b3 = new JButton("EXIT");
        b3.setBackground(Color.RED);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Algerian", Font.BOLD, 20));
        b3.setBounds(5, 10, 200, 40);
        b3.addActionListener(this);
        f.add(b3);

        f.getContentPane().setBackground(Color.GRAY);
        f.setVisible(true);
        f.setSize(1360, 760);
        f.setLocation(0, 0);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b3) {
            int b = 0;
            System.exit(b);
        } else if (t1.getText().equals("") && e.getSource() != b2 && e.getSource() != b3) {

            JOptionPane.showMessageDialog(c, "Weight should not be blank");
            //t1.requestFocus();
        } else if (e.getSource() == b2) {
            f.setVisible(false);
            new BMI();
        } else {

            try {
                double weight = Double.parseDouble(t1.getText());
                if (weight <= 0) {
                    JOptionPane.showMessageDialog(c, "Weight should be greater than 0");
                    t1.setText("");
                    //t1.requestFocus();
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

                    double bmi = weight / (height * height);
                    bmi = bmi * 10000;

                    String msg;
                    if (bmi < 18.5) {
                        msg = "You are underweight";
                    } else if (bmi >= 18.5 & bmi < 25) {
                        msg = "  Congratulations! .You are normal. Keep up the good work!";
                    } else if (bmi >= 25 && bmi < 30) {
                        msg = "You are overweight";
                    } else {
                        msg = "You are Obese";
                    }

                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setMaximumFractionDigits(2);
                    String bmis = nf.format(bmi);

                    JOptionPane.showMessageDialog(c, "BMI=" + bmis + " Kg/m^2  " + msg);
                    t1.setText("");

                    cb1.setSelectedItem("1");
                    cb2.setSelectedItem("0");

                }
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(c, "Enter proper weight");
                t1.setText("");
                //t1.requestFocus();;

            }

        }

    }

    // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    public static void main(String[] args) {
        BMIC f = new BMIC();
    }
}
