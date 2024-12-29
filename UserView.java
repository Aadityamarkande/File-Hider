package views;

import dao.DataDAO;
import model.Data;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserView {
    private String email;

    UserView(String email) {
        this.email = email;
    }

    public void home() {
        JFrame frame = new JFrame("User Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTextArea textArea = new JTextArea();
        JButton showFilesButton = new JButton("Show Hidden Files");
        JButton hideFileButton = new JButton("Hide New File");
        JButton unhideFileButton = new JButton("Unhide File");
        JButton exitButton = new JButton("Exit");

        showFilesButton.addActionListener(e -> {
            try {
                List<Data> files = DataDAO.getAllFiles(this.email);
                textArea.setText("ID - File Name\n");
                for (Data file : files) {
                    textArea.append(file.getId() + " - " + file.getFileName() + "\n");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        hideFileButton.addActionListener(e -> {
            String path = JOptionPane.showInputDialog("Enter the file path");
            if (path != null) {
                File f = new File(path);
                Data file = new Data(0, f.getName(), path, this.email);
                try {
                    DataDAO.hideFile(file);
                    JOptionPane.showMessageDialog(frame, "File hidden successfully!");
                } catch (SQLException | IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        unhideFileButton.addActionListener(e -> {
            String idStr = JOptionPane.showInputDialog("Enter the ID of the file to unhide");
            if (idStr != null) {
                int id = Integer.parseInt(idStr);
                try {
                    try {
                        DataDAO.unhide(id);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(frame, "File unhid successfully!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        exitButton.addActionListener(e -> System.exit(0));

        JPanel panel = new JPanel();
        panel.add(showFilesButton);
        panel.add(hideFileButton);
        panel.add(unhideFileButton);
        panel.add(exitButton);

        frame.add(panel, "North");
        frame.add(new JScrollPane(textArea), "Center");
        frame.setVisible(true);
    }
}
