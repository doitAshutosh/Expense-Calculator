import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java .sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

public class Calculate {
    public static void main(String[] args) {
        //expense calculator
        JFrame frame = new JFrame("Expence Calculator");

        JLabel expenceTitleLabel = new JLabel("Today Expences");
        expenceTitleLabel.setBounds(200, 10, 120, 80);
        expenceTitleLabel.setFont(new Font("Arial",Font.PLAIN,20));
        expenceTitleLabel.setForeground(Color.red);

        JLabel expenceTypeLabel = new JLabel("Expense Type");
        expenceTypeLabel.setBounds(50, 70, 120, 40);

        JTextField expenceTypeField = new JTextField();
        expenceTypeField.setBounds(150, 70, 100, 40);

        JLabel expenceAmountLabel = new JLabel("Expence Amount");
        expenceAmountLabel.setBounds(50, 140, 100, 40);

        JTextField expenceAmounTextField = new JTextField();
        expenceAmounTextField.setBounds(150, 140, 100, 40);

        JLabel incomeTitleLabel = new JLabel("Income");
        incomeTitleLabel.setBounds(200, 160, 120, 80);
        incomeTitleLabel.setFont(new Font("Arial",Font.PLAIN,20));
        incomeTitleLabel.setForeground(Color.green);

        JLabel AddAmountLabel = new JLabel("Add Amount");
        AddAmountLabel.setBounds(50, 220, 100, 40);
        JTextField AddAmounTextField = new JTextField();
        AddAmounTextField.setBounds(150, 220, 100, 40);

        JButton addButton = new JButton("ADD");
        addButton.setBounds(50, 280, 60, 40);
        addButton.setBackground(Color.GREEN);
        frame.add(addButton);
        String url = "jdbc:mysql://localhost:3307/Expense Calculator";
        String username = "root";
        String password="";
        try {
            Connection c = DriverManager.getConnection(url,username,password);
            System.out.println("databse connected");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //add the validation of empty form
                String expenceType = expenceTypeField.getText();
                int expenceAmount = expenceAmounTextField.getText().isEmpty()?0:Integer.valueOf(expenceAmounTextField.getText());
                if(expenceAmount!=0 && !expenceType.isEmpty()){

                } else
                       
                JOptionPane.showMessageDialog(null, "This Field can't be Empty");

            }
        });



        //add component
        frame.add(expenceTitleLabel);
        frame.add(expenceTypeField);
        frame.add(expenceTypeLabel);
        frame.add(expenceAmountLabel);
        frame.add(expenceAmounTextField);
        frame.add(incomeTitleLabel);
        frame.add(AddAmountLabel);
        frame.add(AddAmounTextField);
        frame.add(addButton);
        frame.setLayout(null);
        frame.setSize(500, 400);
        frame.setVisible(true);
        

    }

}
