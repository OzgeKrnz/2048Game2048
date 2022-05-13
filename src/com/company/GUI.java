package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


class GUI extends JPanel implements KeyListener,Runnable {

    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 630;
    public static final int gameBoardSize = 500;
    public static final int MARGIN = 16;
    public static final Font main = new Font("Consolas", Font.PLAIN, 40);

    /*
        JFrame window = new JFrame("2048");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setResizable(false);

        window.add(gui);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

     */
    JFrame window;
    GUI gui;

//arkaplan rengi
    Color color = new Color(213, 209, 209);

    private Thread game;
    private boolean running;
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    private long startTime;
    private long elapsed;
    private boolean set;

    public GUI() {
        GameBoard gb=new GameBoard();
        //gb.paintComponent();

        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(this);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout());
        northPanel.setPreferredSize(new Dimension(WIDTH, 112));


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

    static class GameBoard extends JPanel{
        protected void paintComponent(Graphics graphics) {
            graphics.setColor(new Color(114, 107, 107));
            graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
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

    /*
        private void update(){

        }


        private void render(){
            Graphics2D g = (Graphics2D) image.getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0,0,WIDTH,HEIGHT);
            //render board
            g.dispose();
            Graphics2D g2d=(Graphics2D) getGraphics();
            g2d.drawImage(image,0,0,null);
            g2d.dispose();
        }

        @Override
        public void run(){
            int fps=0,updates=0;
            long fpsTimer=System.currentTimeMillis();
            double nsPerUpdate=100000000.0/60;

            //last update time in nanosec
            double then= System.nanoTime();
            double unprocessed=0;

            while (running) {
                boolean shoulRender = false;
                double now = System.nanoTime();
                unprocessed+=(now-then)/nsPerUpdate;
                then = now;

                //update queue
                while (unprocessed >= 1) {
                    updates++;
                    update();
                    unprocessed--;
                    shoulRender = true;
                }

                //render
                if (shoulRender) {
                    fps++;
                    render();
                    shoulRender = false;
                } else {
                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            //fps timer

            if(System.currentTimeMillis()-fpsTimer>1000){
                System.out.println("%d fps %d updates"+ fps+ updates);
                System.out.println();
                fps=0;
                updates=0;
                fpsTimer+=1000;
            }
        }
        public synchronized void start(){
            if(running) return;
            running=true;
            game=new Thread(this,"game");
            game.start();
        }
        public synchronized  void stop(){
            if(!running) return;
            running=false;
            System.exit(0);
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e){

        }
        @Override
        public void keyReleased(KeyEvent e){

        }
    }

    */
    class Tile {

        public static final int WIDTH = 80;
        public static final int HEIGHT = 80;
        public static final int SLIDE_SPEED = 20;
        public static final int ARC_WIDTH = 15;
        public static final int ARC_HEIGHT = 15;

        public int value;
        private BufferedImage tileImage;
        private Color background;
        private int x;
        private int y;
        private Font font;

        public Tile(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
            tileImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
            drawImage();
        }

        private void drawImage() {
            Graphics2D g = (Graphics2D) tileImage.getGraphics();
        }
    }
}


