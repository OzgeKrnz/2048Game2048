package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Hashtable;
import java.util.Map;

class GUI extends JPanel {

    Game game;
    GameBoard gb;
    Map<Integer, ImageIcon> numberTiles;

    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 440;
    public static final int HEIGHT = 520;
    public static final int gameBoardSize = 400;
    public static final int MARGIN = 20;
    public static final Font main = new Font("Consolas", Font.PLAIN, 40);


    NWindow window;
    GUI gui;


    //arkaplan rengi
    Color color = new Color(213, 209, 209);

    //private Thread game;
    private boolean running;
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    private long startTime;
    private long elapsed;
    private boolean set;

    JLabel scoreL=new JLabel();


    public GUI() {
       gb = new GameBoard();
       game=new Game();
       window=new NWindow();
       window.setFocusable(true);
       window.addKeyListener(new NWindow());
       //game=new Game();

      /*  Tile t=new Tile();
        t.setBounds(0,0,30,30);
        t.setVisible(true);

       */

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout());
        northPanel.setPreferredSize(new Dimension(WIDTH, 100));


        JLabel gameLabel = new JLabel("2048", SwingConstants.CENTER); //merkeze 2048 geliyor.
        gameLabel.setFont(new Font("Ariel", Font.BOLD, 30));
        northPanel.add(gameLabel);

        scoreL= new JLabel("<html><h2>Score<br>"+game.getScore()+"</h2></html>", SwingConstants.CENTER);
        northPanel.add(scoreL);

        northPanel.setBackground(color);

        JPanel westBuffer = new JPanel();
        westBuffer.setPreferredSize(new Dimension(MARGIN, gameBoardSize));
        westBuffer.setBackground(color);

        JPanel eastBuffer = new JPanel();
        eastBuffer.setPreferredSize(new Dimension(MARGIN, gameBoardSize));
        eastBuffer.setBackground(color);

        JPanel southBuffer = new JPanel();
        southBuffer.setPreferredSize(new Dimension(WIDTH, MARGIN));
        southBuffer.setBackground(color);

        //çerceveye panel ekleme
        window.getContentPane().add(northPanel, BorderLayout.NORTH);
        window.getContentPane().add(westBuffer, BorderLayout.WEST);
        window.getContentPane().add(eastBuffer, BorderLayout.EAST);
        window.getContentPane().add(southBuffer, BorderLayout.SOUTH);
        window.getContentPane().add(gb, BorderLayout.CENTER);
        window.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        window.pack();

        window.setVisible(true);
    }
    public class NWindow extends JFrame implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            game.printMatris();
            int key=e.getKeyCode();

            if(key==KeyEvent.VK_UP){
                System.out.println("Pushing up.");
                game.printMatris();
                game.pushUp();
                game.addComponent();
                gb.repaint();
                game.printMatris();
                newScore();
            }
            else if(key==KeyEvent.VK_DOWN){
                System.out.println("Pushing down");
                game.printMatris();
                game.pushDown();
                game.addComponent();
                gb.repaint();
                game.printMatris();
                newScore();
            }
            else if(key==KeyEvent.VK_LEFT){
                System.out.println("Shifting left");
                game.printMatris();
                game.pushLeft();
                game.addComponent();
                gb.repaint();
                game.addComponent();
                newScore();
            }
            else if(key==KeyEvent.VK_RIGHT) {
                System.out.println("Shifting right");
                game.printMatris();
                game.pushRight();
                game.addComponent();
                gb.repaint();
                game.printMatris();
                newScore();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

    }

    public void newScore(){
        scoreL.setText("<html><h2>Score<br>"+game.getScore()+"</h2></html>");
    }

    class GameBoard extends JPanel {
        protected void paintComponent(Graphics graphics) {

            numberTiles=new Hashtable<>();

            graphics.setColor(new Color(136, 129, 129));
            graphics.fillRect(0, 0, this.getWidth(), this.getHeight());

            graphics.setColor(Color.lightGray);
            //int [][]board=game.getGameBoard();


            graphics.drawRect(0,0,97,97);
            graphics.drawRect(0,100,97,97);
            graphics.drawRect(0,200,97,97);
            graphics.drawRect(0,300,97,97);

            graphics.drawRect(100,0,97,97);
            graphics.drawRect(100,100,97,97);
            graphics.drawRect(100,200,97,97);
            graphics.drawRect(100,300,97,97);

            graphics.drawRect(200,0,97,97);
            graphics.drawRect(200,100,97,97);
            graphics.drawRect(200,200,97,97);
            graphics.drawRect(200,300,97,97);

            graphics.drawRect(300,0,97,97);
            graphics.drawRect(300,100,97,97);
            graphics.drawRect(300,200,97,97);
            graphics.drawRect(300,300,97,97);

            Toolkit t=Toolkit.getDefaultToolkit();

            Image i2= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/2.png");
            //graphics.drawImage(i2,200,100,this);

            Image i3= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/4.png");
            //graphics.drawImage(i3,100,0,this);

            Image i4= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/8.png");
            //graphics.drawImage(i4,100,300,this);

            Image i5= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/16.png");
            //graphics.drawImage(i5,300,200,this);

            Image i6= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/32.png");
            //graphics.drawImage(i6,100,100,this);

            Image i7= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/64.png");
            //graphics.drawImage(i7,0,200,this);

            Image i8= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/128.png");
            //graphics.drawImage(i8,200,0,this);

            Image i9= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/256.png");
            //graphics.drawImage(i9,0,300,this);

            Image i10= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/512.png");
            //graphics.drawImage(i10,300,0,this);

            Image i11= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/1024.png");
            //graphics.drawImage(i11,200,300,this);

            Image i12= t.getImage("2048.png");
            //graphics.drawImage(i12,97,97,this);

            numberTiles.put(2, new ImageIcon(i2));
            numberTiles.put(4, new ImageIcon(i3));
            numberTiles.put(8, new ImageIcon(i4));
            numberTiles.put(16, new ImageIcon(i5));
            numberTiles.put(32, new ImageIcon(i6));
            numberTiles.put(64, new ImageIcon(i7));
            numberTiles.put(128, new ImageIcon(i8));
            numberTiles.put(256, new ImageIcon(i9));
            numberTiles.put(512, new ImageIcon(i10));
            numberTiles.put(1024, new ImageIcon(i11));
            numberTiles.put(2048, new ImageIcon(i12));


            int[][] board = game.getGameBoard();
            for(int y=1 ; y<5; y++){
                for(int x=1; x<5; x++){
                    int X= (x)+(99*(x-1));
                    int Y= (y)+(99*(y-1));

                    int thisNumber= board[y-1][x-1];
                    if(numberTiles.containsKey(thisNumber)){
                        ImageIcon thisTile= numberTiles.get(thisNumber);
                        thisTile.paintIcon(this,graphics,X,Y);
                    }

                }
            }
        }
    }
}





//canvas ile haraket ettirme.