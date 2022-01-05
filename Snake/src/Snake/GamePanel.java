package Snake;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    //deklaracje
    static final int SCREEN_WIDTH =500;
    static final int SCREEN_HEIGHT =500;
    static final int UNIT_SIZE =20;
    static final int GAME_UNITS = (int)((SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE));
    static final int DELAY=75;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int foodEaten;
    int foodX;
    int foodY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;


    GamePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    public void startGame(){
        newFood();
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();

    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        draw(g);

    }
    public void draw(Graphics g) {

        if (running) {
            g.setColor(new Color(125,50,250));
            g.fillOval(foodX, foodY, UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.white);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(125,50,250));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            g.setColor(Color.red);
            g.setFont(new Font("Poppins",Font.BOLD,75));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score "+ foodEaten, (SCREEN_WIDTH - metrics.stringWidth("Score"+ foodEaten))/2,75);


        } else {
            gameOver(g);
        }
    }
    public void newFood(){
        foodX = (int)(random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE);
        foodY = (int)(random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE);

    }
    public void move(){
        for(int i = bodyParts;i>0;i--){
            x[i] = x[i-1];
            y[i] = y[i-1];

        }

        switch(direction){
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }
    public void check(){
        if((x[0]==foodX)&&(y[0]==foodY)){
            bodyParts++;
            foodEaten++;
            newFood();
        }

    }
    public void checkCollisions(){
        //sprawdza czy glowa koliduje z cialem Snake'a
        for(int i = bodyParts;i>0;i--){
            if((x[0] == x[i])&&(y[0] == y[i])){
                running=false;
            }
        }
        //sprawdza czy nie uderzyl w krawedz
        if(x[0]<0 ||
           x[0]> SCREEN_WIDTH ||
           y[0] < 0 ||
           y[0] > SCREEN_HEIGHT){
            running=false;
        }
    }
    public void gameOver(Graphics g){
        g.setColor(Color.red);
        g.setFont(new Font("Poppins",Font.BOLD,75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Score "+ foodEaten, (SCREEN_WIDTH - metrics.stringWidth("Score"+ foodEaten))/2,75);
        g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over"))/2,SCREEN_HEIGHT/2);
    }
    public void actionPerformed(ActionEvent e){
        //toDo
        if(running){
            move();
            check();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(direction !='R'){
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction !='L'){
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction !='D'){
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction !='U'){
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}
