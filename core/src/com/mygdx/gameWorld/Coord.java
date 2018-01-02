package com.mygdx.gameWorld;

public class Coord {
public int x;
public int y;
Coord(){
	this.x=0;
	this.y=0;
	
	
}



	Coord(int x, int y){
		this.x=x;
		this.y=y;
		
		
	}

	
	public String toString() {
		
		
		return new String("x="+x+" y="+y);
	}

}
