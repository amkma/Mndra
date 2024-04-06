import processing.core.PVector;

class Button
{
    PVector Pos =new PVector(0,0);
    float Width=0;
    float Height =0;
    //color Colour;
    String Text;
    Boolean Pressed =false;
    Boolean Clicked =false;
    Button(int x,int y,int w,int h,String t,int r ,int g, int b)
    {   // Constractor
        // all of this just I take all of things passed by constactor to class
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
  if it pressed in area of button it will make clicked true ,I use cliced in isClicked method
  if not pressed in area of button will make cliked= false*/
        if(Main.processing.mousePressed ==true&&Main.processing.mouseButton==Main.processing.LEFT&&Pressed==false)
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
        if (Main.processing.mousePressed !=true)
        {
            Pressed=false; // it make
        }
    }
    void display ()
    { // I used it to make us see where the button is when
        //fill(Colour);
        Main.processing.rect(Pos.x,Pos.y,Width,Height); // i used rectangle to let me know where is this box that i can click on it
        Main.processing.fill(0);
        Main.processing.textAlign(Main.processing.CENTER,Main.processing.CENTER); // make text in center , we dont need it
        Main.processing.text(Text,Pos.x+(Width/2),Pos.y+(Height/2)); // we dont need it too
    }
    boolean isClicked()
    { //to know if button has been clicked or not
        return Clicked;
    }
}
