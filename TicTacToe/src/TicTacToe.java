import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    boolean tmp;

    TicTacToe(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(920,920);
        frame.setTitle("Tic-Tac-Toe");
        frame.getContentPane().setBackground(new Color(128,50,250));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(50,50,50));
        textfield.setForeground(new Color(125,50,250));
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);
        // tworze title panel szerokosc 800 wysokosc 100
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);
        // tworze button panel 3 na 3
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(125,50,250));
        //Dodaje przyciski
        for(int i =0;i<9;i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Ink Free",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //TODO
        for(int i=0;i<9;i++){

            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textfield.setText("O Turn");
                        check();
                    }
                }else if(player1_turn==false){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textfield.setText("X Turn");
                        check();
                    }
                }
            }

        }

    }

    public void firstTurn(){

        if(random.nextInt(2)==0){
            player1_turn=true;
            textfield.setText("X Turn");
        }else{
            player1_turn=false;
            textfield.setText("O turn");
        }


    }
    public void check(){
        //sprawdzamy kiedy wygrywa X
        //1 rzad
        if(     (buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X") &&
                (buttons[2].getText()=="X")){
            xWins(0,1,2);
        }
        //2 rzad
        if(     (buttons[3].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[5].getText()=="X")){
            xWins(3,4,5);
        }
        //3 rzad
        if(     (buttons[6].getText()=="X") &&
                (buttons[7].getText()=="X") &&
                (buttons[8].getText()=="X")){
            xWins(6,7,8);
        }
        // 1 kolumna
        if(     (buttons[0].getText()=="X") &&
                (buttons[3].getText()=="X") &&
                (buttons[6].getText()=="X")){
            xWins(0,3,6);
        }
        // 2 kolumna
        if(     (buttons[1].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[7].getText()=="X")){
            xWins(1,4,7);
        }
        //3 kolumna
        if(     (buttons[2].getText()=="X") &&
                (buttons[5].getText()=="X") &&
                (buttons[8].getText()=="X")){
            xWins(2,5,8);
        }
        //1 przekatna
        if(     (buttons[0].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[8].getText()=="X")){
            xWins(0,4,8);
        }
        //2 przekatna
        if(     (buttons[2].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[6].getText()=="X")){
            xWins(2,4,6);
        }


        //sprawdzamy kiedy wygrywa O
        //1 rzad
        if(     (buttons[0].getText()=="O") &&
                (buttons[1].getText()=="O") &&
                (buttons[2].getText()=="O")){
            oWins(0,1,2);
        }
        //2 rzad
        if(     (buttons[3].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[5].getText()=="O")){
            oWins(3,4,5);
        }
        //3 rzad
        if(     (buttons[6].getText()=="O") &&
                (buttons[7].getText()=="O") &&
                (buttons[8].getText()=="O")){
            oWins(6,7,8);
        }
        // 1 kolumna
        if(     (buttons[0].getText()=="O") &&
                (buttons[3].getText()=="O") &&
                (buttons[6].getText()=="O")){
            oWins(0,3,6);
        }
        // 2 kolumna
        if(     (buttons[1].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[7].getText()=="O")){
            oWins(1,4,7);
        }
        //3 kolumna
        if(     (buttons[2].getText()=="O") &&
                (buttons[5].getText()=="O") &&
                (buttons[8].getText()=="O")){
            oWins(2,5,8);
        }
        //1 przekatna
        if(     (buttons[0].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[8].getText()=="O")){
            oWins(0,4,8);
        }
        //2 przekatna
        if(     (buttons[2].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[6].getText()=="O")){
            oWins(2,4,6);
        }
        //warunek sprawdza czy pola są zapełnione jeśli tak to przerywa gre remisem
        for(int i=0;i<9;i++) {
            if (buttons[i].getText() == "") {
                tmp = false;
                break;
            } else {
                tmp = true;
            }
            if(i==8&&tmp==true){
                draw();
            }
        }
    }


    public void xWins(int x,int y,int z){

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setForeground(Color.GREEN);
        textfield.setText("X Wins");
    }
    public void oWins(int x,int y,int z){

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setForeground(Color.GREEN);
        textfield.setText("O Wins");

    }
    public void draw(){
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }

        textfield.setForeground(Color.DARK_GRAY);
        textfield.setText("DRAW");
    }
}
