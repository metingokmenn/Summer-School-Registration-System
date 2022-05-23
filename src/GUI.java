import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.lang.Integer.parseInt;

public class GUI extends JFrame {
    String stuId = LoginFrame.userText;
    public static BinarySearchTree bst1 = new BinarySearchTree();
    public static BinarySearchTree bst2 = new BinarySearchTree();
    public static BinarySearchTree bst3 = new BinarySearchTree();
    public static BinarySearchTree bst4 = new BinarySearchTree();
    static Queue queue1 = new Queue(5);
    static Queue queue2 = new Queue(5);
    static Queue queue3 = new Queue(5);
    static Queue queue4 = new Queue(5);
    String[] grades = {"A","A-","B+","B","B-","C+","C","C-","D+","D","D-","F"};
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Courses");
    JLabel label1 = new JLabel("SEN2008");
    JLabel label2 = new JLabel("SEN2212");
    JLabel label3 = new JLabel("SEN2104");
    JLabel label4 = new JLabel("SEN2022");
    JLabel label5 = new JLabel("");
    JLabel label6 = new JLabel("");
    JLabel label7 = new JLabel("");
    JLabel label8 = new JLabel("");
    JComboBox<String> cmbGrade1 = new JComboBox<String>(grades);
    JComboBox<String> cmbGrade2 = new JComboBox<String>(grades);
    JComboBox<String> cmbGrade3 = new JComboBox<String>(grades);
    JComboBox<String> cmbGrade4 = new JComboBox<String>(grades);
    JButton button1 = new JButton("Register");
    JButton button2 = new JButton("Register");
    JButton button3 = new JButton("Register");
    JButton button4 = new JButton("Register");
    JButton buttonBack = new JButton("⇐");
    JButton buttonTree = new JButton("Show Student List");
    public GUI(){

        addListeners();
        JPanel panel = new JPanel();
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(7,4));
        panel.add(label);
        panel.add(new JLabel(stuId)).setForeground(Color.blue);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(label1);
        panel.add(cmbGrade1);
        panel.add(button1);
        panel.add(label5);
        panel.add(label2);
        panel.add(cmbGrade2);
        panel.add(button2);
        panel.add(label6);
        panel.add(label3);
        panel.add(cmbGrade3);
        panel.add(button3);
        panel.add(label7);
        panel.add(label4);
        panel.add(cmbGrade4);
        panel.add(button4);
        panel.add(label8);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(buttonBack);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(buttonTree);

        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Summer School Registration System");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600,600);

    }
    public static void main(String[] args) {
        new GUI();
    }

    public void addListeners(){
        cmbGrade1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    if(cmbGrade1.getSelectedItem().toString().equals("D") || cmbGrade1.getSelectedItem().toString().equals("D-")
                            || cmbGrade1.getSelectedItem().toString().equals("F") ){
                        button1.setEnabled(true);
                    }
                    else{
                        button1.setEnabled(false);
                    }
                }
            }
        });
        cmbGrade2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    if(cmbGrade2.getSelectedItem().toString().equals("D") || cmbGrade2.getSelectedItem().toString().equals("D-")
                            || cmbGrade2.getSelectedItem().toString().equals("F") ){
                        button2.setEnabled(true);
                    }
                    else{
                        button2.setEnabled(false);
                    }
                }
            }
        });
        cmbGrade3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    if(cmbGrade3.getSelectedItem().toString().equals("D") || cmbGrade3.getSelectedItem().toString().equals("D-")
                            || cmbGrade3.getSelectedItem().toString().equals("F") ){
                        button3.setEnabled(true);
                    }
                    else{
                        button3.setEnabled(false);
                    }
                }
            }
        });
        cmbGrade4.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    if(cmbGrade4.getSelectedItem().toString().equals("D") || cmbGrade4.getSelectedItem().toString().equals("D-")
                            || cmbGrade4.getSelectedItem().toString().equals("F") ){
                        button4.setEnabled(true);
                    }
                    else{
                        button4.setEnabled(false);
                    }
                }
            }
        });
        button1.addMouseListener(new MouseAdapter() {
            boolean flag = false;
            public void mouseClicked(MouseEvent e) {
                if(e.getSource() == button1){
                    for (int i = 0; i < queue1.getArray().length; i++) {
                        if(queue1.getArray()[i] == parseInt(stuId)){
                            flag = true;
                        }
                    }
                    if(flag){
                        label5.setText("The student is already enrolled !");
                        label5.setForeground(Color.red);
                    }
                    else{
                        if(queue1.addQueue(parseInt(stuId))){
                            bst1.insert(parseInt(stuId));
                            label5.setText("Successfully registered!");
                            label5.setForeground(Color.green);
                            button1.setEnabled(false);
                        }
                        else{
                            label5.setText("This section is full!");
                            label5.setForeground(Color.red);
                        }
                    }


                    System.out.println("-----------------");
                    System.out.println("Queue1");
                    queue1.outputQueue();
                    System.out.println("Tree1");
                    bst1.inorder();
                }
            }
        });
        button2.addMouseListener(new MouseAdapter() {
            boolean flag = false;
            public void mouseClicked(MouseEvent e) {
                if(e.getSource() == button2){
                    for (int i = 0; i < queue2.getArray().length; i++) {
                        if(queue2.getArray()[i] == parseInt(stuId)){
                            flag = true;
                        }
                    }
                    if(flag){
                        label6.setText("The student is already enrolled !");
                        label6.setForeground(Color.red);
                    }
                    else{
                        if(queue2.addQueue(parseInt(stuId))){
                            bst2.insert(parseInt(stuId));
                            label6.setText("Successfully registered!");
                            label6.setForeground(Color.green);
                            button2.setEnabled(false);
                        }
                        else{
                            label6.setText("This section is full!");
                            label6.setForeground(Color.red);
                        }
                    }


                    System.out.println("-----------------");
                    System.out.println("Queue2");
                    queue2.outputQueue();
                    System.out.println("Tree2");
                    bst2.inorder();
                }
            }
        });
        button3.addMouseListener(new MouseAdapter() {
            boolean flag = false;
            public void mouseClicked(MouseEvent e) {
                if(e.getSource() == button3){
                    for (int i = 0; i < queue3.getArray().length; i++) {
                        if(queue3.getArray()[i] == parseInt(stuId)){
                            flag = true;
                        }
                    }
                    if(flag){
                        label7.setText("The student is already enrolled !");
                        label7.setForeground(Color.red);
                    }
                    else{
                        if(queue3.addQueue(parseInt(stuId))){
                            bst3.insert(parseInt(stuId));
                            label7.setText("Successfully registered!");
                            label7.setForeground(Color.green);
                            button3.setEnabled(false);
                        }
                        else{
                            label7.setText("This section is full!");
                            label7.setForeground(Color.red);
                        }
                    }


                    System.out.println("-----------------");
                    System.out.println("Queue3");
                    queue3.outputQueue();
                    System.out.println("Tree3");
                    bst3.inorder();
                }
            }
        });
        button4.addMouseListener(new MouseAdapter() {
            boolean flag = false;
            public void mouseClicked(MouseEvent e) {
                if(e.getSource() == button4){
                    for (int i = 0; i < queue4.getArray().length; i++) {
                        if(queue4.getArray()[i] == parseInt(stuId)){
                            flag = true;
                        }
                    }
                    if(flag){
                        label8.setText("The student is already enrolled !");
                        label8.setForeground(Color.red);
                    }
                    else{
                        if(queue4.addQueue(parseInt(stuId))){
                            bst4.insert(parseInt(stuId));
                            label8.setText("Successfully registered!");
                            label8.setForeground(Color.green);
                            button4.setEnabled(false);
                        }
                        else{
                            label8.setText("This section is full!");
                            label8.setForeground(Color.red);
                        }
                    }


                    System.out.println("-----------------");
                    System.out.println("Queue4");
                    queue4.outputQueue();
                    System.out.println("Tree4");
                    bst4.inorder();
                }
            }
        });
        buttonBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource() == buttonBack){
                    new LoginFrame().setVisible(true);
                    frame.setVisible(false);
                }
            }
        });
        buttonTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource() == buttonTree){
                    new StudentList().setVisible(true);
                }
            }
        });
    }
}
