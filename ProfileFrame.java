import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileFrame extends JFrame implements ActionListener {

    JLabel titleLabel;
    JLabel displayNameLabel;
    JLabel passwordLabel;
    JLabel confirmPasswordLabel;

    JTextField displayNameField;
    JPasswordField passwordField;
    JPasswordField confirmPasswordField;

    JButton saveButton;
    JButton startExamButton;
    JButton logoutButton;

    public ProfileFrame() {

        setTitle("Online Examination System - Profile");
        setSize(500, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        // Title
        titleLabel = new JLabel("UPDATE PROFILE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(140, 30, 250, 30);
        add(titleLabel);

        // Display Name
        displayNameLabel = new JLabel("Display Name:");
        displayNameLabel.setBounds(60, 100, 120, 25);
        add(displayNameLabel);

        displayNameField = new JTextField();
        displayNameField.setBounds(190, 100, 220, 25);
        add(displayNameField);

        // Password
        passwordLabel = new JLabel("New Password:");
        passwordLabel.setBounds(60, 150, 120, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(190, 150, 220, 25);
        add(passwordField);

        // Confirm Password
        confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(60, 200, 120, 25);
        add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(190, 200, 220, 25);
        add(confirmPasswordField);

        // Save Button
        saveButton = new JButton("Save");
        saveButton.setBounds(50, 290, 100, 35);
        saveButton.addActionListener(this);
        add(saveButton);

        // Start Exam Button
        startExamButton = new JButton("Start Exam");
        startExamButton.setBounds(180, 290, 120, 35);
        startExamButton.addActionListener(this);
        add(startExamButton);

        // Logout Button
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(330, 290, 100, 35);
        logoutButton.addActionListener(this);
        add(logoutButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == saveButton) {

            String displayName = displayNameField.getText().trim();
            String password = String.valueOf(passwordField.getPassword());
            String confirmPassword = String.valueOf(confirmPasswordField.getPassword());

            if (displayName.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Display Name cannot be empty!",
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            if (password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Password cannot be empty!",
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            if (!password.equals(confirmPassword)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Passwords do not match!",
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            JOptionPane.showMessageDialog(
                    this,
                    "Profile Updated Successfully!");
        }

        else if (e.getSource() == startExamButton) {

            JOptionPane.showMessageDialog(
            this,
            "Exam will start now.");

            dispose();

            new ExamFrame();

        }   
        else if (e.getSource() == logoutButton) {

            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Do you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {

                dispose();
                new LoginFrame();
            }
        }
    }
}