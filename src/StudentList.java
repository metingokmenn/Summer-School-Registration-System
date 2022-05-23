import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class StudentList extends JFrame {
    JFrame frame = new JFrame();
    JLabel label1 = new JLabel("SEN2008");
    JLabel label2 = new JLabel("SEN2212");
    JLabel label3 = new JLabel("SEN2104");
    JLabel label4 = new JLabel("SEN2022");
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;
    public StudentList(){
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(5,2));
        label5 = new JLabel(Arrays.toString(GUI.bst1.getList()).replace(',',' '));
        label6 = new JLabel(Arrays.toString(GUI.bst2.getList()).replace(',',' '));
        label7 = new JLabel(Arrays.toString(GUI.bst3.getList()).replace(',',' '));
        label8 = new JLabel(Arrays.toString(GUI.bst4.getList()).replace(',',' '));

        panel.add(label1);
        panel.add(label5);
        panel.add(label2);
        panel.add(label6);
        panel.add(label3);
        panel.add(label7);
        panel.add(label4);
        panel.add(label8);



        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Student List");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600,600);
    }

    public static void main(String[] args) {
        new StudentList();
    }
}
