package TankClean;

public class T34 extends AbstractTank {
	
	public T34(ActionField af, BattleField bf){
		 this(af, bf, 0, 64, Direction.RIGHT);
	}
	
	public T34(ActionField af, BattleField bf, int x, int y, Direction direction){
		super(af, bf, x, y, direction);
		speed=20;
    }
	
	   public void destroy() throws Exception{
	        updateX(-100);
	        updateY(-100);
	        af.repaint();
	    }
}
