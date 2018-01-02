package com.mygdx.gameWorld;

import com.badlogic.gdx.Gdx;

public class GameWorld {
	  private int[][] GameField;
	  private int x=10;
	  private int y=30;
	  private int counter;
	  private int intense=20; 
	  private EntityClass entclass;
	  private Coord[] points;
	  private int score;
	  /* 
	   * 1-original
	   * 2-red
	   * 3-blue
	   * 4-green
	   * 5-yellow
	   * -100 - null
	   * */
	  public int[][] getGameField(){
		  
		  return GameField;
	  }
	  
	  public GameWorld(){
		  score=0;
		  entclass=new EntityClass();
		  GameField= new int[x][y];
		  counter=intense;
		  for(int i=0;i<GameField.length;i++) {
			  for(int a=0;a<GameField[i].length;a++) {
				  GameField[i][a]=-100;
			  }
			  
			  
		  }
		  
	  }
	  
	
    public void update(float delta) {
    	counter++;
    	if(counter%intense==0) {
    		boolean correct = true;
    		points=entclass.getPoints();
			int color=entclass.getColor();
    		for(Coord c: points) {
    		
					if(!(c.y!=0 && GameField[c.x][c.y-1]<0)) {
						correct=false;
						break;
					}	
    		}
    		
    		if(correct) {
    			entclass.addCoordY(-1);
    		}else {
    			for(Coord c: points) {GameField[c.x][c.y]=color;c.x=0;c.y=28;}
    			check();
						entclass.recreate();
						points=entclass.getPoints();
						for(Coord c: points) 
						if(GameField[c.x][c.y]>0) {System.out.println("GameOver"); clean(); score=0; return;}
    			
    		}
    		

    	}
    	
    }
    
    public void rotate() {
		boolean correct=true;
		entclass.rotate();
		points=entclass.getPoints();
		for(int a=0;a<points.length;a++) {
			if((points[a].x<0 || points[a].x>9) ||GameField[points[a].x][points[a].y]>0  ) {
				correct =false;
				break;
		
			}
		}
		if(!correct) {
			for(int i=0;i<3;i++)entclass.rotate();	
		    points=entclass.getPoints();
		}
    	
    }
    
    
    public void move(int i) {
		points=entclass.getPoints();
		boolean correct=true;
for(int a=0;a<points.length;a++) {
	if((points[a].x+i<0 || points[a].x+i>9) ||GameField[points[a].x+i][points[a].y]>0  ) {
		correct =false;
		return;
		
	}
}		if(correct) {
    	entclass.addCoordX(i);
		points=entclass.getPoints();
}
    }
    
    private void check() {
    	int strike=0;
    	for(int y0=0;y0<y;y0++) {
    		boolean check=true;
    		for(int x0=0;x0<x;x0++) {
    			if(GameField[x0][y0]<0) {
    				check=false;
    				break;
    			}
    			
    		}
    		if(check) {
    			System.out.println(check);
    			score+=100+50*strike;
    			intense=15-score/1000;
    			System.out.println(intense);
    			strike++;
    			for(int y1=y0;y1<y-2;y1++) {
    				for(int x0=0;x0<x;x0++) {
    				
    				GameField[x0][y1]=GameField[x0][y1+1];
    				}
    			}
    		
    			y0=-1;
    		}
    		
    	}
    	
    }
    
    public int getScore() {return score;}
    
    public void down() {counter=intense-1; update(0);}
    public Coord[] getPoints() {return points;}
    
    public int getColor() {return entclass.getColor();}
    
    public void clean() {
    	  for(int i=0;i<GameField.length;i++) {
			  for(int a=0;a<GameField[i].length;a++) {
				  GameField[i][a]=-100;
			  }
			  entclass.recreate();
			  
			  
		  }
    	
    }
    
    public Forms getForm(int i) {
    	if(i==0)return entclass.getCurrentform();else 
    	return entclass.getNextform();
    }
    
}
