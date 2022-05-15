package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

class GUI extends JPanel implements KeyListener,Runnable {

    Game game;

    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 440;
    public static final int HEIGHT = 520;
    public static final int gameBoardSize = 400;
    public static final int MARGIN = 20;
    public static final Font main = new Font("Consolas", Font.PLAIN, 40);


    JFrame window;
    GUI gui;

    //arkaplan rengi
    Color color = new Color(213, 209, 209);

    //private Thread game;
    private boolean running;
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    private long startTime;
    private long elapsed;
    private boolean set;


    public GUI() {
       GameBoard gb = new GameBoard();
       game=new Game();

      /*  Tile t=new Tile();
        t.setBounds(0,0,30,30);
        t.setVisible(true);

       */

        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(this);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout());
        northPanel.setPreferredSize(new Dimension(WIDTH, 100));


        JLabel gameLabel = new JLabel("2048", SwingConstants.CENTER); //merkeze 2048 geliyor.
        gameLabel.setFont(new Font("Consolas", Font.BOLD, 20));
        northPanel.add(gameLabel);

        northPanel.add(new JLabel("<html>Score:<br>524</html>", SwingConstants.CENTER));
        northPanel.add(new JLabel("<html>High Score:<br>22600</html>", SwingConstants.CENTER));

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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void run() {
    }

    class GameBoard extends JPanel {

        protected void paintComponent(Graphics graphics) {
            graphics.setColor(new Color(114, 107, 107));
            graphics.fillRect(0, 0, this.getWidth(), this.getHeight());

            int [][]board=game.getGameBoard();

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
            Image i1= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/0.jpg");
            graphics.drawImage(i1,0,0,this);

            Image i2= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/2.png");
            graphics.drawImage(i2,0,100,this);

            Image i3= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/4.png");
            graphics.drawImage(i3,100,0,this);

            Image i4= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/8.png");
            graphics.drawImage(i4,100,300,this);

            Image i5= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/16.png");
            graphics.drawImage(i5,300,200,this);

            Image i6= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/32.png");
            graphics.drawImage(i6,97,97,this);

            Image i7= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/64.png");
            graphics.drawImage(i7,97,97,this);

            Image i8= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/128.png");
            graphics.drawImage(i8,97,97,this);

            Image i9= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/256.png");
            graphics.drawImage(i9,97,97,this);

            Image i10= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/512.png");
            graphics.drawImage(i10,97,97,this);

            Image i11= t.getImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048/1024.png");
            graphics.drawImage(i11,0,300,this);

            Image i12= t.getImage("2048.png");
            graphics.drawImage(i12,97,97,this);


            for(int y=1;y<5;y++){
                for(int x=1;x<5;x++){
                    int X =(8*x)+(64*(x-1));
                    int Y =(8*y)+(64*(y-1));

                    int thisNum=board[y-1][x-1];

                }
            }
        }
    }
}

