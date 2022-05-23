
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    private JLabel label1;
    JLabel userLabel = new JLabel("Student ID");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JCheckBox showPassword = new JCheckBox("Show Password");
    static String userText;
    static String pwdText;



    public LoginFrame() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(3,2));
        panel.add(userLabel);
        panel.add(userTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(resetButton);

        addActionEvent();
        frame.setTitle("Login Page");
        frame.setVisible(true);
        frame.add(panel,BorderLayout.CENTER);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.matches("([0-9]{7})") && pwdText.matches("([a-zA-Z0-9]+)")) {
                GUI gui = new GUI();
                gui.setVisible(true);
                frame.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(this, "Password or student ID is incorrect !","Warning",1);
            }

        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }

    public static void main(String[] args) {
        new LoginFrame();

    }

}