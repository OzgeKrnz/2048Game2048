package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


class GUI extends JPanel implements KeyListener,Runnable {

    private static final long serialVersionUID=1L;
    public static final int WIDTH=400;
    public static final int HEIGHT =630;
    public static final Font main=new Font("Consolas", Font.PLAIN,30);
    private Thread game;
    private boolean running;
    private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);

    private long startTime;
    private long elapsed;
    private boolean set;

    public GUI(){
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        addKeyListener(this);
    }

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


class Tile {

    public static final int WIDTH=80;
    public static final int HEIGHT=80;
    public static final int SLIDE_SPEED=20;
    public static final int ARC_WIDTH=15;
    public static final int ARC_HEIGHT=15;

    public int value;
    private  BufferedImage tileImage;
    private Color background;
    private int x;
    private int y;
    private Font font;

    public Tile(int value,int x,int y){
        this.value = value;
        this.x=x;
        this.y=y;
        tileImage= new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
        drawImage();
    }

    private void drawImage() {
        Graphics2D g =(Graphics2D)tileImage.getGraphics();
    }
}
