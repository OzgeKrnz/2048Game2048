package com.company;

import com.company.GUI;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Game gameObject=new Game();
        GUI gui=new GUI();
        //Tile t=new Tile();
        //t.setVisible(true);


        for(int i=0;i<5;i++) {
            gameObject.addComponent();
        }

        gameObject.printMatris();
        for(int x =0;x<3;x++) {
            gameObject.pushUp();
            gameObject.printMatris();
            gameObject.addComponent();
            gameObject.printMatris();
            gameObject.pushDown();
            gameObject.printMatris();
        }

    }
}

