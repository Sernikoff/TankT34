package TankClean;

import java.util.Random;

public class BattleField {
	private final int BF_WIDTH = 576;
    private final int BF_HEIGHT = 576;

    String[][] battleField = {
            {"B", "B", "B", "B", "B", "B", "B", "B", "B"},
            {" ", " ", " ", " ", " ", " ", " ", " ", "B"},
            {"B", "B", "B", " ", "B", " ", "B", "B", "B"},
            {"B", "B", "B", " ", " ", " ", "B", "B", "B"},
            {"B", "B", "B", " ", "B", " ", "B", "B", "B"},
            {"B", "B", " ", "B", "B", "B", " ", "B", "B"},
            {"B", "B", " ", " ", " ", " ", " ", "B", "B"},
            {"B", " ", " ", "B", "B", "B", " ", " ", "B"},
            {"B", " ", " ", "B", "B", "B", " ", " ", "B"}
    };

    public BattleField(){
    }

    public BattleField(String[][] battleField){
        this.battleField = battleField;
    }

    public String[][] getBattleField() {
        return battleField;
    }

    public int getBF_WIDTH() {
        return BF_WIDTH;
    }

    public int getBF_HEIGHT() {
        return BF_HEIGHT;
    }

    public String scanQuadrant(int x, int y) {
        return  battleField[x][y];
    }

    public void updateQuadrant(int x, int y, String field){
        battleField[x][y] = field;
    }

    public int getDimentionX(){
        return battleField.length;
    }

    public int getDimentionY(){
        return battleField[0].length;
    }
    
    public String getAgressorLocation(){
    	String str = null;
    	Random r = new Random();
    	while (true){
    		if (r.nextInt(4) > 0) {
            if (r.nextInt(4)==1) {if (str!= "128_64"){str = "128_64"; return str;}}
            if (r.nextInt(4)==2) {if (str!= "256_64"){str = "256_64"; return str;}}
            if (r.nextInt(4)==3) {if (str!= "448_64"){str = "448_64"; return str;}}
            }
         }
     }
}
