package views;

import javax.swing.*;

public class SignupDialog {
    public SignupDialog(JFrame parent) {
        JDialog dialog = new JDialog(parent, "Sign Up", true);
        dialog.setSize(300, 200);
        dialog.setLayout(null);

        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        nameField.setBounds(50, 30, 200, 30);
        emailField.setBounds(50, 70, 200, 30);
        dialog.add(nameField);
        dialog.add(emailField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(50, 110, 200, 30);
        dialog.add(submitButton);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            // Call your signup method here
            // Example: userService.saveUser(new User(name, email));
            dialog.dispose();
        });

        dialog.setVisible(true);
    }
}
