package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginDialog {
    public LoginDialog(JFrame parent) {
        JDialog dialog = new JDialog(parent, "Login", true);
        dialog.setSize(300, 200);
        dialog.setLayout(null);

        JTextField emailField = new JTextField();
        emailField.setBounds(50, 30, 200, 30);
        dialog.add(emailField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(50, 70, 200, 30);
        dialog.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                // Validate email and check if user exists (implement this logic)
                if (true) { // Replace this condition with actual validation
                    new UserView(email).home(); // Open UserView on successful login
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "User does not exist!");
                }
            }
        });

        dialog.setVisible(true);
    }
}
