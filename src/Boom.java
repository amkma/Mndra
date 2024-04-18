import ddf.minim.AudioPlayer;
import processing.core.PImage;


class Boom
{
    AudioPlayer boomsong;
    boolean fadingOut = false;
    int startTime = Main.processing.millis();
    float alpha = 255;
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
        Main.processing.tint(255, alpha); // Apply transparency without changing color
        Main.processing.image(boom, x, y);

        // Gradually decrease the alpha value
        alpha -= 2; // Adjust the decrement rate for desired fade speed
        Main.processing.noTint();//make the others don't fade

    }

    void playsong()
    {
        boomsong.loop();
    //boomsong.pause();
        boomsong.play();
        boomsong.setGain(-15.0f);//control boom volume (negative is lower, positive is higher),kiss me mandour

    }
    }

