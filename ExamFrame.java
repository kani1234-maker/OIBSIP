import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ExamFrame extends JFrame implements ActionListener {

    // ==========================
    // GUI Components
    // ==========================

    JLabel titleLabel;
    JLabel timerLabel;
    JLabel questionNumberLabel;

    JTextArea questionArea;

    JRadioButton option1;
    JRadioButton option2;
    JRadioButton option3;
    JRadioButton option4;

    ButtonGroup optionsGroup;

    JButton previousButton;
    JButton nextButton;
    JButton submitButton;

    // ==========================
    // Data Members
    // ==========================

    ArrayList<Question> questions;

    AnswerManager answerManager;

    int currentQuestion = 0;

    Timer timer;

    int totalSeconds = 30 * 60;   //30 Minutes

    // ==========================
    // Constructor
    // ==========================

    public ExamFrame() {

        questions = QuestionBank.getQuestions();

        answerManager = new AnswerManager(questions.size());

        initializeFrame();

        initializeComponents();

        loadQuestion();

        startTimer();

        setVisible(true);

    }

    // ==========================
    // Frame
    // ==========================

    private void initializeFrame() {

        setTitle("Online Examination System");

        setSize(800,600);

        setLocationRelativeTo(null);

        setLayout(null);

        setResizable(false);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {

                int choice = JOptionPane.showConfirmDialog(
                        ExamFrame.this,
                        "Are you sure you want to quit?\nYour exam progress will be lost.",
                        "Exit Exam",
                        JOptionPane.YES_NO_OPTION);

                if(choice==JOptionPane.YES_OPTION){

                    System.exit(0);

                }

            }

        });

    }

    // ==========================
    // Components
    // ==========================

    private void initializeComponents(){

        titleLabel=new JLabel("ONLINE EXAMINATION SYSTEM");

        titleLabel.setFont(new Font("Arial",Font.BOLD,22));

        titleLabel.setBounds(180,20,400,30);

        add(titleLabel);


        timerLabel=new JLabel("Time Left : 30:00");

        timerLabel.setFont(new Font("Arial",Font.BOLD,18));

        timerLabel.setForeground(Color.RED);

        timerLabel.setBounds(600,20,170,30);

        add(timerLabel);


        questionNumberLabel=new JLabel();

        questionNumberLabel.setFont(new Font("Arial",Font.BOLD,18));

        questionNumberLabel.setBounds(50,80,200,30);

        add(questionNumberLabel);


        questionArea=new JTextArea();

        questionArea.setBounds(50,120,680,80);

        questionArea.setFont(new Font("Arial",Font.PLAIN,18));

        questionArea.setEditable(false);

        questionArea.setLineWrap(true);

        questionArea.setWrapStyleWord(true);

        add(questionArea);


        option1=new JRadioButton();

        option2=new JRadioButton();

        option3=new JRadioButton();

        option4=new JRadioButton();

        option1.setBounds(70,230,500,30);

        option2.setBounds(70,280,500,30);

        option3.setBounds(70,330,500,30);

        option4.setBounds(70,380,500,30);

        option1.setFont(new Font("Arial",Font.PLAIN,17));

        option2.setFont(new Font("Arial",Font.PLAIN,17));

        option3.setFont(new Font("Arial",Font.PLAIN,17));

        option4.setFont(new Font("Arial",Font.PLAIN,17));

        optionsGroup=new ButtonGroup();

        optionsGroup.add(option1);

        optionsGroup.add(option2);

        optionsGroup.add(option3);

        optionsGroup.add(option4);

        add(option1);

        add(option2);

        add(option3);

        add(option4);


        previousButton=new JButton("Previous");

        nextButton=new JButton("Next");

        submitButton=new JButton("Submit");

        previousButton.setBounds(120,470,120,40);

        nextButton.setBounds(320,470,120,40);

        submitButton.setBounds(520,470,120,40);

        previousButton.addActionListener(this);

        nextButton.addActionListener(this);

        submitButton.addActionListener(this);

        add(previousButton);

        add(nextButton);

        add(submitButton);

    }

    // ==========================
    // Load Question
    // ==========================

    private void loadQuestion(){

        Question q=questions.get(currentQuestion);

        questionNumberLabel.setText("Question "+(currentQuestion+1)+" / "+questions.size());

        questionArea.setText(q.getQuestion());

        String options[]=q.getOptions();

        option1.setText(options[0]);

        option2.setText(options[1]);

        option3.setText(options[2]);

        option4.setText(options[3]);

        optionsGroup.clearSelection();

        int savedAnswer=answerManager.getAnswer(currentQuestion);

        if(savedAnswer==0)
            option1.setSelected(true);

        else if(savedAnswer==1)
            option2.setSelected(true);

        else if(savedAnswer==2)
            option3.setSelected(true);

        else if(savedAnswer==3)
            option4.setSelected(true);

        previousButton.setEnabled(currentQuestion!=0);

        if(currentQuestion==questions.size()-1){

            nextButton.setEnabled(false);

        }else{

            nextButton.setEnabled(true);

        }
    }
    // ==========================
    // Save Selected Answer
    // ==========================

    private void saveAnswer() {

        int selected = -1;

        if (option1.isSelected())
            selected = 0;

        else if (option2.isSelected())
            selected = 1;

        else if (option3.isSelected())
            selected = 2;

        else if (option4.isSelected())
            selected = 3;

        answerManager.saveAnswer(currentQuestion, selected);

    }

    // ==========================
    // Timer
    // ==========================

    private void startTimer() {

        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                totalSeconds--;

                int minutes = totalSeconds / 60;

                int seconds = totalSeconds % 60;

                timerLabel.setText(String.format("Time Left : %02d:%02d", minutes, seconds));

                if (totalSeconds <= 0) {

                    timer.stop();

                    JOptionPane.showMessageDialog(
                            ExamFrame.this,
                            "Time is over!\nYour exam will be submitted automatically."
                    );

                    submitExam();

                }

            }

        });

        timer.start();

    }

    // ==========================
    // Button Events
    // ==========================

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == nextButton) {

            saveAnswer();

            if (currentQuestion < questions.size() - 1) {

                currentQuestion++;

                loadQuestion();

            }

        }

        else if (e.getSource() == previousButton) {

            saveAnswer();

            if (currentQuestion > 0) {

                currentQuestion--;

                loadQuestion();

            }

        }

        else if (e.getSource() == submitButton) {

            saveAnswer();

            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to submit the exam?",
                    "Submit Exam",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {

                timer.stop();

                submitExam();

            }

        }

    }
        // ==========================
    // Submit Exam
    // ==========================

    private void submitExam() {

        saveAnswer();

        int correct = 0;
        int incorrect = 0;

        int[] answers = answerManager.getAllAnswers();

        for (int i = 0; i < questions.size(); i++) {

            if (answers[i] == questions.get(i).getCorrectAnswer()) {
                correct++;
            } else {
                incorrect++;
            }

        }

        int score = correct;

        int totalQuestions = questions.size();

        int totalExamTime = 30 * 60;

        int timeTaken = totalExamTime - totalSeconds;

        dispose();

        new ResultFrame(
                score,
                correct,
                incorrect,
                totalQuestions,
                timeTaken
        );

    }
}