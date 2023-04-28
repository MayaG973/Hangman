import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
    private JFrame homeFrame;
    private JButton startButton;
    private JFrame gameFrame;
    private ImageIcon hangman;
    private JButton letterButton;
    private JTextField textField ;
    private HangmanGame game;
    private JLabel wordLabel;

    MyFrame(){
        getHomeFrame();
    }

    public void getHomeFrame() {
        homeFrame = new JFrame();
        startButton = new JButton();

        ImageIcon image = new ImageIcon("hangman1(1).png");

        JLabel label = new JLabel();
        label.setText("Hangman");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(Color.black); // set font color of text
        label.setIconTextGap(0);
        label.setFont(new Font("MV Boli", Font.PLAIN, 20)); // set font of text
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(150,0, 250, 500);

        startButton.setBounds(200,410,130,50);
        startButton.addActionListener(this);
        startButton.setText("Start Game");
        startButton.setFocusable(false);
        startButton.setFont(new Font("MV Boli", Font.PLAIN, 14));
        startButton.setBackground(new Color(148, 251, 188));
        startButton.setBorder(BorderFactory.createEmptyBorder());

        homeFrame.setTitle("Hangman");
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setResizable(false);
        homeFrame.setSize(600,600);
        homeFrame.setLayout(null);
        homeFrame.setVisible(true);
        homeFrame.getContentPane().setBackground(new Color(148, 251, 188));
        homeFrame.add(label);
        homeFrame.add(startButton);
    }

    public void getGameFrame(){
        homeFrame.setVisible(false);

        gameFrame = new JFrame();
        JPanel redPanel = new JPanel();
        JPanel bluePanel = new JPanel();
        JPanel greenPanel = new JPanel();
        JLabel wordBankLabel = new JLabel();
        hangman = new ImageIcon("hangman1(1).png");
        JLabel hangmanLabel = new JLabel();
        JLabel wrongWordLabel = new JLabel();
        textField = new JTextField();
        game = new HangmanGame();
        wordLabel = new JLabel();
        letterButton = new JButton("Enter");

        redPanel.setBackground(new Color(148, 251, 188));
        redPanel.setBounds(0,0, 300, 300);
        redPanel.setLayout(new BorderLayout());

        bluePanel.setBackground(new Color(148, 251, 188));
        bluePanel.setBounds(300,0,300,300);
        bluePanel.setLayout(new BorderLayout());

        greenPanel.setBackground(new Color(148, 251, 188));
        greenPanel.setBounds(0, 400, 600, 200);
        greenPanel.setLayout(new BorderLayout());

        wordBankLabel.setText("Word Bank");
        wordBankLabel.setHorizontalAlignment(JLabel.CENTER);
        wordBankLabel.setFont(new Font("MV Boli", Font.PLAIN, 40));
        wrongWordLabel.setText("");
        wordBankLabel.setVerticalAlignment(JLabel.TOP);
        wordBankLabel.setHorizontalAlignment(JLabel.CENTER);
        
        hangmanLabel.setIcon(hangman);
        hangmanLabel.setVerticalAlignment(JLabel.CENTER);
        hangmanLabel.setHorizontalAlignment(JLabel.CENTER);

        textField.setPreferredSize(new Dimension(100,100));
        textField.setHorizontalAlignment(JTextField.CENTER);

        letterButton.addActionListener(this);

        String wordProgress = game.getWord();
        wordLabel.setText(wordProgress);
        wordLabel.setVerticalAlignment(JLabel.TOP);
        wordLabel.setHorizontalAlignment(JLabel.CENTER);
        wordLabel.setFont(new Font("MV Boli", Font.PLAIN, 20));

        redPanel.add(hangmanLabel);
        bluePanel.add(wordBankLabel, BorderLayout.NORTH);
        bluePanel.add(wrongWordLabel, BorderLayout.CENTER);
        greenPanel.add(wordLabel, BorderLayout.NORTH);
        greenPanel.add(letterButton, BorderLayout.WEST);
        greenPanel.add(textField, BorderLayout.CENTER);

        gameFrame.setTitle("Hangman");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        gameFrame.setSize(600, 600);
        gameFrame.setLayout(null);
        gameFrame.getContentPane().setBackground(new Color(148, 251, 188));
        gameFrame.setVisible(true);
        gameFrame.add(redPanel);
        gameFrame.add(bluePanel);
        gameFrame.add(greenPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == startButton) {
            getGameFrame();
        }
        if(e.getSource() == letterButton) {
            System.out.println("Clicked");
            String letter = textField.getText();
            if (game.checkLetter(letter)) {
                wordLabel.setText(game.getWordProgress());
            }
        }
    }

}
