import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResultFrame extends JFrame implements ActionListener {

    private JLabel titleLabel;
    private JLabel scoreLabel;
    private JLabel correctLabel;
    private JLabel incorrectLabel;
    private JLabel percentageLabel;
    private JLabel timeLabel;

    private JButton logoutButton;

    public ResultFrame(int score,
                       int correct,
                       int incorrect,
                       int totalQuestions,
                       int timeTaken) {

        setTitle("Exam Result");

        setSize(500, 450);

        setLocationRelativeTo(null);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        // ==========================
        // Title
        // ==========================

        titleLabel = new JLabel("EXAM RESULT");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        titleLabel.setBounds(150, 30, 250, 30);

        add(titleLabel);

        // ==========================
        // Score
        // ==========================

        scoreLabel = new JLabel("Score : " + score + " / " + totalQuestions);

        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        scoreLabel.setBounds(100, 90, 300, 30);

        add(scoreLabel);

        // ==========================
        // Correct Answers
        // ==========================

        correctLabel = new JLabel("Correct Answers : " + correct);

        correctLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        correctLabel.setBounds(100, 130, 300, 30);

        add(correctLabel);

        // ==========================
        // Incorrect Answers
        // ==========================

        incorrectLabel = new JLabel("Incorrect Answers : " + incorrect);

        incorrectLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        incorrectLabel.setBounds(100, 170, 300, 30);

        add(incorrectLabel);

        // ==========================
        // Percentage
        // ==========================

        double percentage = ((double) score / totalQuestions) * 100;

        percentageLabel = new JLabel(String.format("Percentage : %.2f%%", percentage));

        percentageLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        percentageLabel.setBounds(100, 210, 300, 30);

        add(percentageLabel);

        // ==========================
        // Time Taken
        // ==========================

        int minutes = timeTaken / 60;

        int seconds = timeTaken % 60;

        timeLabel = new JLabel(String.format(
                "Time Taken : %02d:%02d",
                minutes,
                seconds));

        timeLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        timeLabel.setBounds(100, 250, 300, 30);

        add(timeLabel);

        // ==========================
        // Logout Button
        // ==========================

        logoutButton = new JButton("Logout");

        logoutButton.setBounds(180, 330, 120, 40);

        logoutButton.addActionListener(this);

        add(logoutButton);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == logoutButton) {

            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Do you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {

                dispose();

                new LoginFrame();

            }

        }

    }

}
