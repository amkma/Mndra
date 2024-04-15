import processing.core.PImage;

public class Enemy
{
    float left, right, top, bottom;// coordinates of enemy
    PImage enemy; //define  enemy photo
    boolean removeEnemy; // if it true will  make is remove enemy
    int range;  //max(Y) of program (Height) , it is used to know what is maximum range of enemy can go  iyhv
    float x, y, w, h;// enemy will start from this coordinates
    float speed;
    Enemy(String filename, float startingX, float startingY, int startingW, int startingH, int sizeY,float fast)
    {// Constructor
        // all of this just I take all things passed by constructor to class
        x = startingX;
        y = startingY;
        w = startingW;
        h = startingH;
        range = sizeY;
        enemy = Main.processing.loadImage(filename);//load enemy photo
        enemy.resize(startingW, startingH); // Resize the image
        removeEnemy = false;
        speed=fast;
    }

    void displayEnemy()
    {
        y = (y < -45) ? range : y - speed;
        Main.processing.image(enemy, x, y); // display enemy photo
        // Update bounding enemy coordinates
        left = x - (w) / 2;
        right = x + (w) / 2;
        top = y + (h) / 2;
        bottom = y - (h) / 2;
    }
}

