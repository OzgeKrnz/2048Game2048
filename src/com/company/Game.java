package com.company;
import java.util.ArrayList;
import java.util.Formatter.*;
import java.util.Random;
import java.util.Scanner.*;
import java.util.Random.*;

public class Game {
    private int[][] gameBoard;

    private Random randomIndexler = new Random();

    public Game() {
        gameBoard = new int[4][4];

    }
    // diziyi yazdıran method olustur. public olsun her yerden erişilebilir.
    public void printMatris() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {

                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println(" ");
    }

    //diziye eleman eklemek için yeni method olustur.
    public void addComponent() {
        //ArrayList<Integer>gameArrayList=new ArrayList<Integer>();//Matris için yer ayırdık.

            int randomSatir = randomIndexler.nextInt(4); //0-4 arası random deger olustur.
            int randomSutun = randomIndexler.nextInt(4);
            //System.out.println(randomSatir+" "+randomSutun);

            if(gameBoard[randomSatir][randomSutun]==0 ){

                gameBoard[randomSatir][randomSutun]=2;
                //gameArrayList.add(gameBoard[randomSatir][randomSutun]);
            }
             System.out.println("hello görlzz");
    }

    public void pushUp()
    {
        System.out.println("Pushing up...");
        for(int y=0;y<4;y++)
        {
            for(int x=1;x<4;x++)
            {
                if(gameBoard[x][y] != 0)
                {
                    int value =gameBoard[x][y];
                    int topX=x-1;
                    while((topX >= 0) && (gameBoard[topX][y]==0))
                    {
                        //x'in 0 a eşit ve büyük olması ve üstünün boş olması.
                        topX--;
                    }

                    if(topX==-1)
                    {
                        //x in sütundaki tek eleman olması ve üstünün boş olması.
                        gameBoard[0][y]=value;
                        gameBoard[x][y]=0;
                    }

                    else if (gameBoard[topX][y] != value)
                    {
                        //sütunun en üst ve en altında sayı olması ortaların boş olması.
                        gameBoard[topX+1][y] = value;
                        gameBoard[x][y] = 0;
                    }

                    else
                    {
                        //2 aynı sayının toplanması durumu.
                        gameBoard[topX][y] *= 2;
                        gameBoard[x][y] = 0;
                    }
                }
            }
        }
    }

    public void pushDown()
    {
        System.out.println("Pushing down...");
        for(int y=0;y<4;y++)
        {
            for(int x=2;x>-1;x--)
            {
                if (gameBoard[x][y] != 0)
                {
                    int value = gameBoard[x][y];
                    int buttomX = x + 1;
                    while ((buttomX <= 3) && (gameBoard[buttomX][y] == 0))
                    {
                        //x'in 0 a eşit ve büyük olması ve üstünün boş olması.
                        buttomX++;
                    }

                    if (buttomX == 4)
                    {
                        //x in sütundaki tek eleman olması ve üstünün boş olması.
                        gameBoard[3][y] = value;
                        gameBoard[x][y] = 0;
                    }
                    else if (gameBoard[buttomX][y] != value)
                    {
                        //sütunun en üst ve en altında sayı olması ortaların boş olması.
                        gameBoard[buttomX - 1][y] = value;
                        gameBoard[x][y] = 0;
                    }
                    else
                    {
                        //2 aynı sayının toplanması durumu.
                        gameBoard[buttomX][y] *= 2;
                        gameBoard[x][y] = 0;
                    }
                }
            }
        }
    }
}



    /*
    hepsine 0 atamıstık.  herhangi bir koordinatı 2 ile baslatıcaz. Bunun için random kordinat olusturmamız gerekiyor.
    condition olustur. karelerin 0 olma durumuna göre. Sonra 2 ata.
     */

//random deger olustur. satır ve sütün için.
//sonra gameBoard.add(gameBoard[rSatir][rSutun])'a 2 ata.
//Önce durumu kontrol et içi sıfırsa random kordinata 2 ata.
