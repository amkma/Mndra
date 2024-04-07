import ddf.minim.AudioPlayer;
import processing.core.PImage;

class Boom
{
    AudioPlayer boomsong;
    boolean fadingOut = false;
    int startTime = Main.processing.millis();
    PImage boom;// define boom image
    float x,y,h,w; // coordinate of boom photo
    float displayTime;
    Boom(String filename,String boomsongg,float startingX,float startingY,int startingW,int startingH)
    {// Constructor
        // all of this just I take all things passed by constructor to class
        boom = Main.processing.loadImage(filename); // load photo to program
        x=startingX;
        y=startingY;
        h=startingH;
        w=startingW;
        boom.resize((int)w,(int)h); // size of boom
        boomsong = Main.minim.loadFile(boomsongg);
//        Main.processing.tint(255,60);
    }
    void displayReaction(){
        Main.processing.image(boom,x,y); // display boom photo
    }
    void moveReaction()
    {
        y+=2; // it will make boom move, but I still do not know how I can use it
    }
    void playsong()
    {
        boomsong.loop();
    //boomsong.pause();
        boomsong.play();

    }
    void draw(){            }

    }

