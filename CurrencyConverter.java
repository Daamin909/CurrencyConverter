import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class CurrencyConverter extends JFrame implements ActionListener {
    String[] list = {"Choose Currency", "INR", "USD"};
    JComboBox<String> jc, jc2;
    JTextField result, jtf;
    JButton jb;
    JPanel p;
    JLabel f, t;
    Double x;

    CurrencyConverter() {
        super("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 100);
        f = new JLabel("From");
        t = new JLabel("To");
        setResizable(false);
        p = new JPanel();
        p.setLayout(new FlowLayout()); 
        jb = new JButton("Convert");
        jtf = new JTextField("", 10);
        jc = new JComboBox<>(list);
        jtf.setToolTipText("Enter amount here");
        result = new JTextField("***Converted amount***", 20);
        result.setEditable(false);
        jb.addActionListener(this);
        jc2 = new JComboBox<>(list);
        p.add(f);
        p.add(jc);
        p.add(jtf);
        p.add(t);
        p.add(jc2);
        p.add(result);
        p.add(jb);
        add(p);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CurrencyConverter(); 
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (jtf.getText().isEmpty()) {
                throw new NumberFormatException();
            }
            x = Double.parseDouble(jtf.getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Error: Enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }

        int d = jc.getSelectedIndex();
        int y = jc2.getSelectedIndex();
        if (d == 1) {
            if (y == 1) {
                result.setText(Double.toString(x));
            } else if (y == 2) {
                double z = x * 0.012;
                result.setText("$" + Double.toString(z));
            } else {
                JOptionPane.showMessageDialog(null, "Error: Choose an option", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (d == 2) {
            if (y == 2) {
                result.setText("$" + Double.toString(x));
            } else if (y == 1) {
                double z = x * 83.45;
                result.setText(Double.toString(z));
            } else {
                JOptionPane.showMessageDialog(null, "Error: Choose an option", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: Choose an option", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}