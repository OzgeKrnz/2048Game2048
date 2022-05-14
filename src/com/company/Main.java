package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// let's get started girlss
        Game gameObject=new Game();
        GUI gui=new GUI();
        //gameObject.printMatris();
        //gameObject.printMatris();

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

