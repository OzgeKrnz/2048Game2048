package com.company;

import javax.swing.*;
import java.awt.*;

public class Tile extends GUI{
    private int color;
    private int boxWidth=20;
    private int boxHeight=20;

    public int getBoxWidth(){
        return boxWidth;
    }
    public int getBoxHeight(){
        return  boxHeight;
    }

    public Tile(){
        //JFrame frame=new JFrame("2048");
        //Container c=getContentPane();

        //c.setLayout(new GridLayout(3,3));


        JButton b1=new JButton();
        JButton b2=new JButton();
        JButton b3=new JButton();
        JButton b4=new JButton();
        JButton b5=new JButton();
        JButton b6=new JButton();
        JButton b7=new JButton();
        JButton b8=new JButton();
        JButton b9=new JButton();
        JButton b10=new JButton();
        JButton b11=new JButton();
        JButton b12=new JButton();
        JButton b13=new JButton();
        JButton b14=new JButton();
        JButton b15=new JButton();
        JButton b16=new JButton();

        window.add(b1);
        window.add(b2);
        window.add(b3);
        window.add(b4);
        window.add(b5);
        window.add(b6);
        window.add(b7);
        window.add(b8);
        window.add(b9);
        window.add(b10);
        window.add(b11);
        window.add(b12);
        window.add(b13);
        window.add(b14);
        window.add(b15);
        window.add(b16);


        //JPanel panel=new JPanel();

        //GridLayout layout=new GridLayout(3,3);
        //panel.setLayout(layout);
        //panel.setVisible(true);

        //frame.add(b).setLocation(3,3);
        // panel.add(b);
    }

    void boxColor(Graphics g){
        g.fillRect(4,4,getBoxWidth(),getBoxHeight());

    }



}
