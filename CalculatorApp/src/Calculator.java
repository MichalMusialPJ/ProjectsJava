import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator implements ActionListener {
    //deklaracje
    JFrame frame;
    JPanel panel;
    JButton[] numberButtons=new JButton[10];
    JButton[] operatorButtons=new JButton[6];
    static final int FRAME_WIDTH=600;
    static final int FRAME_HEIGHT=600;
    JTextField textField;
    static final int SCREEN_WIDTH=Toolkit.getDefaultToolkit().getScreenSize().width;
    static final int SCREEN_HEIGHT=Toolkit.getDefaultToolkit().getScreenSize().height;
    JButton plusButton,minusButton,mnozButton,dzielButton,moduloButton,dotButton,clearButton;
    static final int TEXTFIELD_Y=40;
    static final int TEXTFIELD_HEIGHT=40;
    Font myFontBig = new Font("Poppins", Font.BOLD,30);
    Font myFontSmall = new Font("Poppins", Font.BOLD,20);


    //domyslny konstuktor tworzacy frame
    Calculator(){
        frame = new JFrame();
        frame.setTitle("Calculator");
        //frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setBounds(SCREEN_WIDTH/2 - FRAME_WIDTH/2,SCREEN_HEIGHT/2-FRAME_WIDTH/2, FRAME_WIDTH,FRAME_HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(3);
        frame.setBackground(Color.BLACK);

        textField = new JTextField();
        //textField.setBounds(30,40,540,20);
        textField.setBounds((FRAME_WIDTH-(FRAME_WIDTH-FRAME_WIDTH/10))/2,TEXTFIELD_Y,FRAME_WIDTH-FRAME_WIDTH/10,TEXTFIELD_HEIGHT);
        textField.setEditable(false);
        textField.setFont(myFontBig);
        textField.setBackground(Color.CYAN);
        //textField.setText("Zacznij liczyc");


        operatorButtons[0] = plusButton = new JButton("+");
        operatorButtons[1] = minusButton = new JButton("-");
        operatorButtons[2] = mnozButton = new JButton("*");
        operatorButtons[3] = dzielButton = new JButton("/");
        operatorButtons[4] = moduloButton = new JButton("Modulo");
        operatorButtons[5] = dotButton = new JButton(".");

        /*numberButtons[0] = new JButton("0");
        numberButtons[1] = new JButton("1");
        numberButtons[2] = new JButton("2");
        numberButtons[3] = new JButton("3");
        numberButtons[4] = new JButton("4");
        numberButtons[5] = new JButton("5");
        numberButtons[6] = new JButton("6");
        numberButtons[7] = new JButton("7");
        numberButtons[8] = new JButton("8");*/

        panel = new JPanel();
        //panel.setBounds(50,100,300,300);
        panel.setBounds(FRAME_WIDTH/20,100,FRAME_WIDTH-FRAME_WIDTH/10,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.GREEN);




        for(int i=0; i< operatorButtons.length;i++){
            operatorButtons[i].addActionListener(this);
            operatorButtons[i].setFont(myFontSmall);
            operatorButtons[i].setFocusable(false);
        }
        for(int i=0; i< numberButtons.length;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFontSmall);
            numberButtons[i].setFocusable(false);

        }


        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(operatorButtons[0]);
        //----
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(operatorButtons[1]);
        //---
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(operatorButtons[2]);
        //---
        panel.add(operatorButtons[3]);
        panel.add(numberButtons[0]);
        panel.add(operatorButtons[4]);
        panel.add(operatorButtons[5]);
        //---
        frame.add(textField);
        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
