package com.company;

import java.util.Random;

public class Game extends Convert {
    private int[][] gameBoard;
    private Random randomIndexler = new Random();
    boolean c;

    private int score=0;

    public Game() {

        gameBoard = new int[4][4];
        addComponent();
        addComponent();


    }

    public int[][] getGameBoard(){
        return gameBoard;
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

    public int getScore(){
        return score;
    }
    //diziye eleman eklemek için yeni method olustur.
    public void addComponent() {

        int randomSatir = randomIndexler.nextInt(4); //0-4 arası random deger olustur.
        int randomSutun = randomIndexler.nextInt(4);

        if(gameBoard[randomSatir][randomSutun]==0 ){
            gameBoard[randomSatir][randomSutun]=2;

        }
    }

    public void pushUp()
    {
        System.out.println("Pushing up...");
        for(int y=0;y<4;y++) {
            c=false;
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
                        gameBoard[x][y] = 0;
                        gameBoard[topX+1][y] = value;
                    }

                    else
                    {
                        if(c){
                            gameBoard[x][y]=0;
                            gameBoard[topX+1][y]=value;
                        }
                        else{
                            //2 aynı sayının toplanması durumu.
                            gameBoard[x][y] = 0;
                            gameBoard[topX][y] *= 2;
                            score+=gameBoard[topX][y];
                            c=true;
                        }

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
            c=false;
            for(int x=2;x>-1;x--)
            {
                if (gameBoard[x][y] != 0)
                {
                    int value = gameBoard[x][y];
                    int bottomX = x + 1;
                    while ((bottomX <= 3) && (gameBoard[bottomX][y] == 0))
                    {
                        bottomX++;
                    }

                    if (bottomX == 4)
                    {
                        //x in sütundaki tek eleman olması ve üstünün boş olması.
                        gameBoard[3][y] = value;
                        gameBoard[x][y] = 0;
                    }
                    else if (gameBoard[bottomX][y] != value)
                    {
                        //sütunun en üst ve en altında sayı olması ortaların boş olması.
                        gameBoard[x][y] = 0;
                        gameBoard[bottomX - 1][y] = value;
                    }
                    else{
                        if(c){
                            gameBoard[x][y]=0;

                            gameBoard[bottomX-1][y]=value;

                        }
                        else {
                            //2 aynı sayının toplanması durumu.
                            gameBoard[x][y] = 0;
                            gameBoard[bottomX][y] *= 2;
                            score+=gameBoard[bottomX][y];
                            c=true;
                        }
                    }
                }
            }
        }
    }

    public void pushLeft() {
        System.out.println("Pushing left...");

        for(int x=0;x<4;x++) {
            c=false;
            for(int y=1;y<4;y++) {
                if (gameBoard[x][y] != 0) {
                    int value = gameBoard[x][y];
                    int leftY = y - 1;
                    while ((leftY >= 0) && (gameBoard[x][leftY] == 0)) {

                        //x'in 0 a eşit ve büyük olması ve o degerin boş olması.
                        leftY--;
                    }

                    if (leftY == -1) {
                        //y nin satırdaki tek eleman olması ve solunun boş olması.
                        gameBoard[x][0] = value;
                        gameBoard[x][y] = 0;
                    }
                    else if (gameBoard[x][leftY] != value)
                    {
                        //satırın en sol ve en solunda sayı olması ortaların boş olması.
                        gameBoard[x][y] = 0;
                        gameBoard[x][leftY+1] = value;
                    }
                    else{
                        if(c){
                            gameBoard[x][y]=0;
                            gameBoard[x][leftY+1]=value;

                        }
                        else {
                            gameBoard[x][y] = 0;
                            //2 aynı sayının toplanması durumu.
                            gameBoard[x][leftY] *= 2;
                            score+=gameBoard[x][leftY];

                            c=true;
                        }
                    }
                }
            }
        }
    }


    public void pushRight() {
        System.out.println("Pushing right...");

        for(int x=0;x<4;x++) {
            c=false;
            for(int y=2;y>-1;y--) {
                if (gameBoard[x][y] != 0) {
                    int value = gameBoard[x][y];
                    int rightY = y + 1;
                    while ((rightY <= 3) && (gameBoard[x][rightY] == 0))
                    {
                        //x'in 0 a eşit ve büyük olması ve üstünün boş olması.
                        rightY++;
                    }

                    if (rightY == 4)
                    {
                        //x in sütundaki tek eleman olması ve üstünün boş olması.
                        gameBoard[x][3] = value;
                        gameBoard[x][y] = 0;
                    }
                    else if (gameBoard[x][rightY] != value)
                    {
                        //sütunun en üst ve en altında sayı olması ortaların boş olması.
                        gameBoard[x][y] = 0;
                        gameBoard[x][rightY-1] = value;
                    }
                    else{
                        if(c){
                            gameBoard[x][y]=0;
                            gameBoard[x][rightY-1]=value;

                        }
                        else {
                            //2 aynı sayının toplanması durumu.
                            gameBoard[x][y] = 0;
                            gameBoard[x][rightY] *= 2;
                            score+=gameBoard[x][rightY];

                            c=true;
                        }
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
