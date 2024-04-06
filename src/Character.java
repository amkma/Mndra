import processing.core.PImage;

class Character
{
    PImage Archer;
    float x, y;
    float width, height;

    Character(String filename, float x, float y, float width, float height)
    {// Constractor
        // all of this just I take all of things passed by constactor to class
        this.Archer = Main.processing.loadImage(filename); // Load image of archer to program
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.Archer.resize((int)width, (int)height); // Resize the image
    }

    void update(float mouseY)
    {
        // Update the y-position based on mouseY
        this.y = mouseY;
    }

    void displayArcher()
    {
        Main.processing.image(Archer, x, y); // display Archer photo
    }

    void setImage(String imagePath)
    {// this method make us to change image of archer when we clicked on mouse
        this.Archer = Main.processing.loadImage(imagePath); // this change archer photo with one I will pass
        this.Archer.resize((int)width, (int)height); // Resize the image
    }
}
