import java.util.ArrayList;

class ScoreSystem {

    void displayScore( ArrayList<Enemy> enemyList, int arrowsNumber)
    {
        int enemy = (15-enemyList.size());
        int score = (arrowsNumber+1)*enemy;
        //bar
        Main.processing.  fill(220);
        Main.processing.   stroke(100);
        Main.processing. strokeWeight(3);
        //score
//        fill(#E0DECD); // Bright yellow
        while(Main.updateScore) {
           Main.accumulatedScore+=score;
            Main.updateScore=false;

        }
        Main.processing.textSize(32);
        Main.processing.  text(Main.accumulatedScore,137,63);
        Main.processing.  text( enemy ,1000-87,45);
        Main.processing.  text(arrowsNumber ,1000-87,103);

    }

}
