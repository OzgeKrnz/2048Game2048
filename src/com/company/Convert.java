package com.company;


import java.awt.*;
import java.awt.image.ImageObserver;

public class Convert {
    Toolkit image=Toolkit.getDefaultToolkit();
    Image returnImage(Image img) {

        for (int i = 0; i <= 2048; i *= 2) {
            img = image.createImage("C:/Users/asus/Documents/GitHub/2048Game2048/2048" + i + ".png");

        }

        return img;
    }

}

