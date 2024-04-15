import processing.core.*;
import ddf.minim.*;
import java.util.*;

public class Main extends PApplet{
    public static PApplet processing;
    public static void main(String[] args){
        PApplet.main("Main",args);
    }

    AudioPlayer music; //definition of music
    AudioPlayer song;//definition of song
    AudioPlayer boomsound;
    AudioPlayer arrowsound;
    //Movie video;
    float speed=1;
    static Minim minim;
    Character Archer;//definition of Character Object
    Button button;//definition of Button Object
    Button Continue;
    Button Home;
    Button Back;
    PFont f;
    Button lvl1;
    Button lvl2;
    boolean state;
    boolean play;
    static boolean gameEnded = false; // Flag to track whether the game has ended
    static boolean gamestate;// lose or win  ,used in end of level
    static PImage gif; // Declare a variable to hold the sky image
    PImage lvl1_start;
    static PImage score; // Declare a variable to hold the sky image

    PImage lvl2_start;
    PImage lvl3_start;
    PImage goodguy;
    PImage startbg;// Declare a variable to hold the Start image
    PImage win;// Declare a variable to hold the winner image
    PImage lose;// Declare a variable to hold the Game over image
    static boolean Enter_1;// it will be true in lvl 1 to make archer can through arrows ,if I don't use it I will make archer through arrows in start menu
    boolean Reload = true;// I make it in reloading arrows
    static boolean updateScore ;
    static int accumulatedScore;
    ArrayList<Arrow> arrowList;//definition of ArrayList of arrows
    static ArrayList<Enemy> enemyList;//definition of ArrayList of Enemy
    ArrayList<Boom> boomList;//definition of ArrayList of Boom
    static int arrowsNumber; //number of arrows I use
    static int menu =0;// make us switch between levels
    final int sizeX = 1000;// Width of game
    final int sizeY = 700;//Height of game
    static int ArcherX=80;
    static int ArcherY=100;
    static int lvl=0;
    static float alpha = 0;
    Enemy[] monsters = new Enemy[15]; // Array to hold the monsters
    ScoreSystem Score =new ScoreSystem();

    public void settings(){
        size(1000,700);
    }
    public void setup(){
        processing = this;
        frameRate(100);
        f=createFont("VIP Arabic Typo.otf",25,true);
        textFont(f);
        button =new Button (385,80,250,80,"Play",0,111,154);
        Continue =new Button (365,540,290,80,"CONTINUE",0,111,154);
        lvl1 =new Button (150,405,200,55,"lvl1",0,111,154);
        lvl2 =new Button (630,405,220,55,"lvl2",0,111,154);
        Home =new Button (910,620,50,50,"Home",0,111,154);
        Back =new Button (365,540,300,70,"BACK",0,111,154);
        minim =new Minim(this);
        music =minim.loadFile("Om_Kalsoum.wav");
        arrowsound =minim.loadFile("arrowsound.wav");
        boomsound =minim.loadFile("boomsound.wav");
        song =minim.loadFile("melody.wav");
        win=loadImage("winner.jpg");
        lose=loadImage("Gameover.jpg");
        startbg =loadImage("startbg.jpg");
        goodguy =loadImage("goodguy.png");
        score =loadImage("Score.png");
        gif = loadImage("bg2.jpg"); // Load your GIF file
        lvl1_start = loadImage("lvl0.jpg");
        lvl2_start = loadImage("lvl1.jpg");
        lvl3_start = loadImage("lvl2.jpg");
        gif.resize(width, height); // Resize the GIF to fit the canvas
        win.resize(width, height);
        lvl1_start.resize(width,height);
        lvl2_start.resize(width,height);
        lvl3_start.resize(width,height);
        lose.resize(width, height);
        score.resize(width, height);

        startbg.resize(width,height);
        Archer = new Character("shooterr.png", 0, mouseY,ArcherX, ArcherY);
        arrowList = new ArrayList<>();
        enemyList = new ArrayList<>();
        boomList= new ArrayList<>();
        state = false;
        updateScore = false;
        accumulatedScore=0;
    }
    public void draw(){
        switch (menu)
        {
            case 0:
            {
                song.play();
                tint(255, alpha);
                image(startbg,0,0);
                alpha+= 0.08f;
                noTint();
                button.update();
                //button.display();
                if(button.isClicked())
                {
                    alpha=0;
                    menu=1;
                    //println("Arrows Number = 20");
                }
            }

            break;
            case 1:
            {

                arrowsNumber = 20;
//                Reload=true;
                Reload = true;
                Archer.setImage("shooterr.png");
                float startX = sizeX - 45; // Adjust the starting x-coordinate
                float startY = sizeY; // Adjust the y-coordinate if needed
                int monsterWidth = 35; // Adjust the width of each monster
                float spacing = 5;
                int monsterHeight = 60; // Adjust the spacing between monsters
                gameEnded = false;

                if(lvl==0)
                {
                    tint(255, alpha);

                    image(lvl1_start,0,0);
                    alpha+= 0.3f;
                    noTint();
                    lvl1.update();
                    //lvl1.display();
                    if(lvl1.isClicked())
                    {
                        alpha=0;
                        for (int i = 0; i < monsters.length; i++)
                        { // making array of monsters that have defence x coordinates ,don't ask me ho can I get this equation
                            monsters[i] = new Enemy("monsterr.png", startX - i * (monsterWidth + spacing), startY, monsterWidth, monsterHeight, sizeY,speed);
                            enemyList.add(monsters[i]);
                        }
                        menu=2;
                        music.loop();
                    }
                }
                if (lvl==1)
                {
                    music.loop();
                    music.pause();
                    tint(255, alpha);
                    image(lvl2_start,0,0);
                    alpha+= 0.3f;
                    noTint();
                    lvl1.update();
                    lvl2.update();
                    if(lvl1.isClicked())
                    {
                        alpha=0;

                        accumulatedScore=0;
                        for (int i = 0; i < monsters.length; i++)
                        { // making array of monsters that have defence x coordinates ,don't ask me ho can I get this equation
                            monsters[i] = new Enemy("monsterr.png", startX - i * (monsterWidth + spacing), startY, monsterWidth, monsterHeight, sizeY,speed);
                            enemyList.add(monsters[i]);
                        }
                        menu=2;
                        arrowList.clear();
                    }
                    else if(lvl2.isClicked())
                    {
                        alpha=0;

                        int x =(int)random (0,5);
                        int y =(int)random (5,10);
                        int z =(int)random (10,15);

                        for (int i = 0; i < monsters.length; i++)
                        { // making array of monsters that have defence x coordinates ,don't ask me ho can I get this equation
                            monsters[i] = new Enemy("monsterr.png", startX - i * (monsterWidth + spacing), random(750,1200), monsterWidth, monsterHeight, sizeY,speed);
                            enemyList.add(monsters[i]);
                        }
                        monsters[x] = new Enemy("goodguy.png", startX - x * (monsterWidth + spacing), random(750,1200), monsterWidth, monsterHeight, sizeY,random(0.8F, 1.5F));
                        monsters[y] = new Enemy("goodguy.png", startX - y * (monsterWidth + spacing), random(750,1200), monsterWidth, monsterHeight, sizeY,random(0.8F, 1.5F));
                        monsters[z] = new Enemy("goodguy.png", startX - z * (monsterWidth + spacing), random(750,1200), monsterWidth, monsterHeight, sizeY,random(0.8F, 1.5F));
                        enemyList.set(x, monsters[x]);
                        enemyList.set(y, monsters[y]);
                        enemyList.set(z, monsters[z]);
                        menu=4;
                        arrowList.clear();

                    }
                }
                else if(lvl==2)
                {
                    music.loop();
                    music.pause();
                 
                    tint(255, alpha);
                    image(lvl3_start,0,0);
                    alpha+= 0.3f;
                    noTint();
                    lvl1.update();
                    lvl2.update();
                    if(lvl1.isClicked())
                    {
                        alpha=0;

                        accumulatedScore=0;
                        for (int i = 0; i < monsters.length; i++)
                        { // making array of monsters that have defence x coorrdinates ,don't ask me ho can I get this equation
                            monsters[i] = new Enemy("monsterr.png", startX - i * (monsterWidth + spacing), startY, monsterWidth, monsterHeight, sizeY,speed);
                            enemyList.add(monsters[i]);
                        }
                        menu=2;
                        arrowList.clear();
                    }if(lvl2.isClicked())
                {
                    alpha=0;
                    accumulatedScore=0;
                    int x =(int)random (0,5);
                    int y =(int)random (5,10);
                    int z =(int)random (10,15);
                    for (int i = 0; i < monsters.length; i++)
                    { // making array of monsters that have defence x coorrdinates ,don't ask me ho can I get this equation
                        monsters[i] = new Enemy("monsterr.png", startX - i * (monsterWidth + spacing), random(750,1200), monsterWidth, monsterHeight, sizeY,speed);
                        enemyList.add(monsters[i]);
                    }
                    monsters[x] = new Enemy("goodguy.png", startX - x * (monsterWidth + spacing), random(750,1200), monsterWidth, monsterHeight, sizeY,random(0.8F, 1.5F));
                    monsters[y] = new Enemy("goodguy.png", startX - y * (monsterWidth + spacing), random(750,1200), monsterWidth, monsterHeight, sizeY,random(0.8F, 1.5F));
                    monsters[z] = new Enemy("goodguy.png", startX - z * (monsterWidth + spacing), random(750,1200), monsterWidth, monsterHeight, sizeY,random(0.8F, 1.5F));
                    enemyList.set(x, monsters[x]);
                    enemyList.set(y, monsters[y]);
                    enemyList.set(z, monsters[z]);
                    arrowList.clear();
                    menu=4;
                }
                }
            }

            break;
            case 2:
            {
                song.pause();
                music.play();
                Lvl_1 lvl1 = new Lvl_1();
                lvl1.displayLevel(Archer, arrowList, enemyList, boomList, arrowsNumber, state,Home);//, gameEnded
                Score.displayScore(  enemyList,  arrowsNumber);
            }
            break;
            case 3:
            {

                if (gamestate)
                {
                    music.pause();
                    song.play();
                    tint(255, alpha);
                    image(win, 0, 0);
                    alpha+= 0.05f;
                    noTint();
                    //Continue.display();
                    Continue.update();
                    if(Continue.isClicked())
                    {
                        alpha=0;
                        play=Continue.isClicked();
                        arrowsNumber = 20;
                        menu=1;
                        song.loop();
                    }

                }
                else
                {
                    music.pause();
                    enemyList.clear();
                    song.play();
                    tint(255, alpha);
                    image(lose, 0, 0);
                    alpha+= 0.05f;
                    noTint();
                    //Back.display();
                    Back.update();
                    if(Back.isClicked())
                    {
                        //song.loop();
                        menu=1;
                        arrowsNumber = 20;
                        //music.close();
                        accumulatedScore=0;
                        alpha=0;

                    }
                }
            }
            break;
            case 4:
            {
                song.pause();
                music.play();
                Lvl_2 lvl2 = new Lvl_2();
                lvl2.displayLevel(Archer, arrowList, enemyList, boomList, arrowsNumber, state,Home);//, gameEnded
                Score.displayScore(  enemyList,  arrowsNumber);

            }
            break;
            case 5:
            {
                if (gamestate)
                {
                    music.pause();
                    song.play();
                    tint(255, alpha);
                    image(win, 0, 0);
                    alpha+= 0.05f;
                    noTint();
                    //Continue.display();
                    Continue.update();
                    if(Continue.isClicked())
                    {
                        alpha=0;
                        arrowsNumber = 20;
                        menu=1;
                        song.loop();
                    }
                }
                else
                {
                    music.pause();
                    enemyList.clear();
                    song.play();
                    tint(255, alpha);
                    image(lose, 0, 0);
                    alpha+= 0.05f;
                    noTint();
                    //Back.display();
                    Back.update();
                    if(Back.isClicked())
                    {
                        //song.loop();
                        menu=1;
                        alpha=0;
                        arrowsNumber = 20;
                        //music.close();
                        accumulatedScore=0;
                    }
                }
            }
        }

    }


    public void mousePressed()
    {
        if (mouseButton == LEFT && Reload && arrowsNumber >= 0&&Enter_1&&!gameEnded&&alpha>=255)
        {
            arrowList.add(new Arrow("arrowr.png", 0, mouseY+12, 45, 15, sizeX));
            --arrowsNumber;
            Archer.setImage("shooterra.png");
            Reload = false;
            println("Arrows Number = " + arrowsNumber);
            if(!gameEnded)
            {
                arrowsound.loop();
                arrowsound.pause();
                arrowsound.play();

            }
            state = true;
        }
        if (mouseButton == RIGHT && arrowsNumber > 0) {
            Reload = true;
            Archer.setImage("shooterr.png");
        }
    }
}