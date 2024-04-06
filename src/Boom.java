import ddf.minim.AudioPlayer;
import processing.core.PImage;

class Boom
{
    AudioPlayer boomsong;

    PImage boom;// define boom image
    float x,y,h,w; // coordinate of boom photo
    float displayTime;
    Boom(String filename,String boomsongg,float startingX,float startingY,int startingW,int startingH)
    {// Constractor
        // all of this just I take all of things passed by constactor to class
        boom = Main.processing.loadImage(filename); // load photo to program
        x=startingX;
        y=startingY;
        h=startingH;
        w=startingW;
        boom.resize((int)w,(int)h); // size of boom
        boomsong = Main.minim.loadFile(boomsongg);
    }
    void displayReaction(){
        Main.processing.image(boom,x,y); // display boom photo
    }
    void moveReaction()
    {
        y+=2; // it will make boom move but I still do not know how I can use it
    }
    void playsong()
    {
        boomsong.loop();
//boomsong.pause();
        boomsong.play();

    }
}
