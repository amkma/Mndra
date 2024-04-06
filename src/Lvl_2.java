
import java.util.ArrayList;

public class Lvl_2 {
    void displayLevel(Character archer, ArrayList<Arrow> arrowList, ArrayList<Enemy> enemyList, ArrayList<Boom> boomList, int arrowsNumber, boolean state) //, boolean gameEnded
    {
        int n = 0;
        Main.Enter_1 = true;
        Main.processing.image(Main.gif, 0, 0);
        archer.update(Main.processing.mouseY);
        archer.displayArcher();

        for (Enemy anEnemy : enemyList)
        {
            anEnemy.displayEnemy();
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
                enemyList.remove(anEnemy);
                Boom aBoom = boomList.get(n);
                ++n;
                aBoom.displayReaction();
                aBoom.playsong();
            }
        }

        for (Boom aBoom : boomList)
        {
            aBoom.displayReaction();
        }

        if (state && !Main.gameEnded)
        {
            if (arrowsNumber >= 0 && enemyList.isEmpty())
            {
               System.out.println("WINNER");
                Main.gameEnded = true;
                boomList.clear();
                Main.gamestate = true;
                enemyList.clear();
                arrowList.clear();
                Main.menu=5;
                Main.Enter_1 = false;
                Main.lvl=2;
            }       else if (arrowList.isEmpty() && enemyList.size() > 0 && arrowsNumber == 0)
            {
                Main. println("GAME OVER");
                Main.gameEnded = true;
                boomList.clear();
                Main.gamestate = false;
                enemyList.clear();
                arrowList.clear();
                Main. menu=5;
                Main. Enter_1 = false;

            }
        }

    }
}