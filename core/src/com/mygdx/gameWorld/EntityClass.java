package com.mygdx.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.RandomXS128;

public class EntityClass {
	private boolean controlable;
	private Coord coord;
	private int[][] figure;
	private Forms[] forms;
	private Forms currentform;
	private Forms nextform;
	private RandomXS128 r;
	private Coord[] points;
	private int color;
	private int oldcolor;
	
	public EntityClass() {
		controlable=false;
		coord= new Coord();
		r=new RandomXS128();
		forms=Forms.values();
		nextform=forms[r.nextInt(forms.length)];
		oldcolor=r.nextInt(5)+1;
		recreate();
	}
	
	public void recreate() {
		currentform=nextform;
		coord.x=4;
		coord.y=25;
		nextform=forms[r.nextInt(forms.length)];
		figure=currentform.generateForm();
		color=r.nextInt(5)+1;
		while(color==oldcolor)color=r.nextInt(5)+1;
		oldcolor=color;
		setPoints();
	}
	
	public void rotate() {
	
		
		if(currentform!=Forms.SQUARE_FORM && currentform!=Forms.I_FORM) {
		int m=3;
		 for (int k=0; k<m/2; k++) 
	        {
	            for (int j=k; j<m-1-k; j++) 
	            {
	                
	                int tmp         = figure[k][j];
	                figure[k][j]         = figure[j][m-1-k];
	                figure[j][m-1-k]     =figure[m-1-k][m-1-j];
	                figure[m-1-k][m-1-j] = figure[m-1-j][k];
	                figure[m-1-j][k]     = tmp;
	            }
	        }
		 setPoints();
		}else
		{
			if(currentform==Forms.I_FORM) {
				for(int i=0;i<figure.length;i++) {
					int tmp=figure[i][0];
					figure[i][0]=figure[figure.length-1][figure.length-1-i];
					figure[figure.length-1][figure.length-1-i]=tmp;
					}
					
				}
			setPoints();
			}
			
		}
	
	
	public void setPoints() {
		points=new Coord[4];
		int c=0;
		for(int i=0;i<figure.length;i++) {
			for(int a=0;a<figure[i].length;a++) {
				if(figure[i][a]==1) {
				points[c]=new Coord(i+coord.x,a+coord.y);	
				
				c++;
				}
				
			}
			
		}
		
	}
	public Coord[] getPoints() {
		return points;
	}
	
	public int getColor() {
		return color;
	}
	
	public void addCoordX(int x) {
		coord.x+=x;
		for(int i=0;i<points.length;i++)points[i].x+=x;
	}
	public void addCoordY(int y) {
		coord.y+=y;
		for(int i=0;i<points.length;i++)points[i].y+=y;
	}

	public boolean isControlable() {
		return controlable;
	}

	public void setControlable(boolean controlable) {
		this.controlable = controlable;
	}

	/*public Coord getCoord() {
		return coord;
	}*/

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public Forms getCurrentform() {
		return currentform;
	}

	public void setCurrentform(Forms currentform) {
		this.currentform = currentform;
	}

	public Forms getNextform() {
		return nextform;
	}

	public void setNextform(Forms nextform) {
		this.nextform = nextform;
	}
	

	
}
