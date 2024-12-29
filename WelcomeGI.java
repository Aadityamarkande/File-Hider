package views;

import javax.swing.*;

public class WelcomeGI {
    public WelcomeGI() {
        JFrame frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Sign Up");

        loginButton.addActionListener(e -> new LoginDialog(frame));
        signupButton.addActionListener(e -> new SignupDialog(frame));

        JPanel panel = new JPanel();
        panel.add(loginButton);
        panel.add(signupButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
