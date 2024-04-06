import processing.core.PVector;

class Button
{
    PVector Pos =new PVector(0,0);
    float Width;
    float Height;
    //color Colour;
    String Text;
    Boolean Pressed =false;
    Boolean Clicked =false;
    Button(int x,int y,int w,int h,String t,int r ,int g, int b)
    {   // Constructor
        // all of this just I take all things passed by constructor to class
        Pos.x=x;
        Pos.y=y;
        Width=w;
        Height=h;
        //Colour =color(r,g,b);
        Text=t;
    }
    void update()
    {
  /*this method depend on id mouse pressed or not  if  left button is pressed it will check if it pressed in button coordinates or not
  if it pressed in area of button it will make clicked true ,I use clicked in isClicked method
  if not pressed in area of button will make clicked= false*/
        if(Main.processing.mousePressed &&Main.processing.mouseButton==Main.processing.LEFT&& !Pressed)
        {
            Pressed =true;
            if (Main.processing.mouseX>=Pos.x&&Main.processing.mouseX<=Pos.x+Width&&Main.processing.mouseY>=Pos.y&&Main.processing.mouseY<=Pos.y+Height)
            {
                Clicked=true;
            }
        }   else
        {
            Clicked=false;
            //Pressed=false;
        }
        if (!Main.processing.mousePressed)
        {
            Pressed=false; // it makes
        }
    }
    void display ()
    { // I used it to make us see where the button is when
        //fill(Colour);
        Main.processing.rect(Pos.x,Pos.y,Width,Height); // I used rectangle to let me know where is this box that I can click on it
        Main.processing.fill(0);
        Main.processing.textAlign(Main.processing.CENTER,Main.processing.CENTER); // make text in center , we don't need it
        Main.processing.text(Text,Pos.x+(Width/2),Pos.y+(Height/2)); // we don't need it too
    }
    boolean isClicked()
    { //to know if button has been clicked or not
        return Clicked;
    }
}
