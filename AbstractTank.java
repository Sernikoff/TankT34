package TankClean;


	import java.util.Random;

	public abstract class AbstractTank {
		protected int speed;
		protected Direction direction;
		protected int x;
		protected int y;

	    protected ActionField af;
	    protected BattleField bf;
	    
	    protected AbstractTank(ActionField af, BattleField bf, int x, int y, Direction direction){
	        this.af = af;
	        this.bf = bf;
	        this.x = x;
	        this.y = y;
	        this.direction = direction;

	    }

	    public int getSpeed() {
	        return speed;
	    }

	    public Direction getDirection() {
	        return direction;
	    }


	    public int getX() {
	        return x;
	    }

	    public int getY() {
	        return y;
	    }
	    
	    public abstract void destroy() throws Exception;

	    public void turn(Direction direction) throws Exception{
	        af.processTurn(this);
	    }

	    public void move() throws Exception{
	        af.processMove(this);
	    }

	    public void fire() throws Exception{
	        Bullet bullet = new Bullet((x+25), (y+25), direction);
	        af.processFire(bullet);
	    }

	    public void updateX(int x){
	        this.x += x;
	    }

	    public void updateY(int y){
	        this.y += y;
	    }

	    
	    public void moveRandome() throws Exception{
	    	Random r = new Random();
			int i;
			while (true) {
				i = r.nextInt(5);
				if (i > 0) {
	                if (i==1) {direction = Direction.UP;}
	                if (i==2) {direction = Direction.DOWN;}
	                if (i==3) {direction = Direction.LEFT;}
	                if (i==4) {direction = Direction.RIGHT;}
	        turn(direction);
	                fire();
	                move();
				}
			}
	    }

	    
	    public void moveToQuadrant(int v, int h) throws Exception {
	        int x1 = af.getQuadrant(h);
	        int y1 = af.getQuadrant(v);
	        System.out.print("Koordinaty from: " + x + "_" + y + " to ");
	        System.out.println(x1 + "_" + y1);
	        int hX = (x1 - x) / 64;
	        int vY = (y1 - y) / 64;
	        System.out.println("hX+vY= "+hX+"+"+vY);
	        if (hX > 0) {
	            int i = 0;
	            while (i < hX) {
	                turn(Direction.RIGHT);
	                if (bf.battleField[x/64][y/64+1]=="B"){fire();}
	                af.processMove(this);
	                i++;
	            }
	        }
	        if (hX < 0) {
	            int i = 0;
	            while (i > hX) {
	                turn(Direction.LEFT);
	                if (bf.battleField[y/64][x/64-1]=="B"){fire();}
	                af.processMove(this);
	                i--;
	            }
	        }
	        if (vY > 0) {
	            int i = 0;
	            while (i < vY) {
	                turn(Direction.DOWN);
	                if (bf.battleField[y/64+1][x/64]=="B"){fire();}
	                af.processMove(this);
	                i++;
	            }
	        }
	        if (vY < 0) {
	            int i = 0;
	            while (i > vY) {
	                turn(Direction.UP);
	                if (bf.battleField[y/64-1][x/64]=="B"){fire();}
	                af.processMove(this);
	                i--;
	            }
	        }
	        Thread.sleep(1000l);
	    }

	    
	    void clean() throws Exception{
	        int i;
	        moveToQuadrant(1,1);
	        for (i = 1; i<10; i++) {
	            moveToQuadrant(i,1);
	            turn(Direction.RIGHT);
	            for (String elem : bf.battleField[i-1]) {
	                if (elem == "B") {
	                    fire();
	                    }
	                }
	            }
	        }
	    }


