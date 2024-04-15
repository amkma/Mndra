import processing.core.PImage;

class Arrow
{
    PImage arrow; // define arrow's photo
    float x, y; // Coordinates of arrow
    float width, height; // size of arrow --->7gm el-sora y3ni
    float speed = 2 ; // speed of arrow
    int range; //max(X) of program (Width) , it is used to know what is maximum range of arrow can go

    boolean clean; // it is used to know if arrow  exceed range of program
    float left, right, top, bottom;  // Coordinates for bounding box , it is used in killing enemy
    Arrow(String filename, float x, float y, int width, int height, int sizeX)
    { // Constructor
        // all of this just I take all things passed by constructor to class
        this.arrow = Main.processing.loadImage(filename); // load photo
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.arrow.resize(width, height); // Resize the image
        this.clean = false;
        this.range = sizeX;
    }

    void displayArrow()
    {
        Main.processing.image(arrow, this.x + Main.ArcherX/2, this.y + Main.ArcherY/2);// display enemy photo , this ArcherX and ArcherX see main
    }

    void moveArrow()
    {
        x += speed; //update coordinates of arrow , that make arrow move
        // Update bounding arrow coordinates
        left = x + 38;
        right = x + 42;
        top = y ;
        bottom = y ;
    }

    void isClean()
    { // this method tell us if arrow went to end of program or not
        if (x > range)
        { //if it exceeds the end of program it will return true that will  make us clean arrow
            clean = true;
        }
    }

    void shootEnemy(Enemy anEnemy)
    { // this method make us know if arrow is touched the enemy or not
        if (top >= anEnemy.bottom &&
                bottom <= anEnemy.top &&
                right > anEnemy.left &&
                left <= anEnemy.right) {
            anEnemy.removeEnemy = true; // if they touched it will return us this value to remove enemy ---> go to enemy class
        }
    }
}
