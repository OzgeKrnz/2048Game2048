package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// let's get started girlss
        Game gameObject=new Game();
        //gameObject.printMatris();
        //gameObject.printMatris();

        for(int i=0;i<5;i++)
        {
            gameObject.addComponent();
        }

        gameObject.printMatris();

        for(int x =0;x<3;x++)
        {
            gameObject.pushUp();
            gameObject.printMatris();
            System.out.println("\n");
            gameObject.addComponent();
            gameObject.printMatris();
            gameObject.pushDown();
            gameObject.printMatris();
            gameObject.addComponent();
            System.out.println("\n");
            gameObject.pushLeft();
            gameObject.printMatris();
            gameObject.addComponent();
            System.out.println("\n");
            gameObject.pushRight();
            gameObject.printMatris();

        }

    }
}

//gameboard olsuturuldu.
//satır- sütün 4*4luk olusturduk.
//matrisi yazdıran method.

/*
class GameFrame extends JFrame {

    private int row;
    private int column;

    public GameFrame(){
        super();
    }
}
*/

