//import processing.core.PImage;

import java.util.ArrayList;

class Lvl_1

{
    // Constructor
    void displayLevel(Character archer, ArrayList<Arrow> arrowList, ArrayList<Enemy> enemyList, ArrayList<Boom> boomList, int arrowsNumber, boolean state,Button home) //, boolean gameEnded
    {
        // all of this just I take all things passed by constructor to class
        int n = 0;
        Main.Enter_1 = true;
        Main.processing.  tint(255, Main.alpha);

        Main.processing.image(Main.gif, 0, 0);
        Main.processing.image(Main.score, 0, 0);
            archer.update(Main.processing.mouseY);
        archer.displayArcher();
if (Main.alpha>=255) {
    for (Enemy anEnemy : enemyList) {
        anEnemy.displayEnemy();
    }
}
        for (Arrow anArrow : arrowList)
        {
            anArrow.displayArrow();
            anArrow.moveArrow();
            anArrow.isClean();
            for (Enemy anEnemy : enemyList)
            {
                anArrow.shootEnemy(anEnemy);
            }
        }
        Main.alpha+= 0.8f;
        Main.processing. noTint();

        // Remove arrows and enemies that need to be cleaned
        for (int i = arrowList.size() - 1; i >= 0; i--)
        {
            Arrow anArrow = arrowList.get(i);
            if (anArrow.clean)
            {
                arrowList.remove(anArrow);
            }
        }

        for (int i = enemyList.size() - 1; i >= 0; i--)
        {
            Enemy anEnemy = enemyList.get(i);
            if (anEnemy.removeEnemy)
            {
                float x = anEnemy.x;
                float y = anEnemy.y;
                boomList.add(new Boom("boom.png","boomsound.wav", x, y, 90, 40));
//                Main.processing.tint(255,90);
//                Main.processing.noTint();
                enemyList.remove(anEnemy);
                Boom aBoom = boomList.get(n);
                ++n;
//                aBoom.displayReaction();
                aBoom.playsong();
                Main.updateScore=true;

            }
        }

        for (Boom aBoom : boomList)
        {
            aBoom.displayReaction();

        }

        if (state && !Main.gameEnded)
        {
            if (arrowsNumber >= 0 && enemyList.size() == 0)
            {
                System.out.println("WINNER");
                Main.alpha=0;
                Main.gameEnded = true;
                boomList.clear();
                Main.gamestate = true;
                enemyList.clear();
                Main.menu=3;
                Main.Enter_1 = false;
                if (Main.lvl==0||Main.lvl==1)
                {
                    Main.lvl=1;
                }

                else
                {
                    Main.lvl =2;
                }
            }       else if (arrowList.size() == 0 && enemyList.size() > 0 && arrowsNumber == 0)
            {
                System.out.println("GAME OVER");
                Main.alpha=0;
                Main.gameEnded = true;
                boomList.clear();
                Main.gamestate = false;
                enemyList.clear();
                Main.menu=3;
                Main.Enter_1 = false;
                if (Main.lvl==0)
                {
                    Main.lvl=0;
                }
                else if(Main.lvl==1)
                {
                    Main.lvl=1;
                }
                else {
                    Main.lvl =2;
                }
            }
            home.update();
            if(home.isClicked())
            {
               Main.Clickmouse.loop();
               Main.Clickmouse.play();
                arrowList.clear();
                boomList.clear();

                Main.music.pause();
               Main.Enter_1 = false;
               Main. accumulatedScore=0;
               Main. menu=1;
               Main.alpha=0;
            }
        }
    }
}
