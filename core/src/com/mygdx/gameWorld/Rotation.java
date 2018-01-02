package com.mygdx.gameWorld;

public enum Rotation {
	NORMAL(0),
	INVERT(1),
	LEFT90(2),
	RIGHT90(3);
	
	private int num;
	private static Rotation[] list= {NORMAL,INVERT,LEFT90,RIGHT90};
	
	Rotation(int num){
		this.num=num;
		
	}
	
    public static Rotation getNextRotationFrom(Rotation perviousRotation) {
        int newRotationIndex = (perviousRotation.num + 1) % list.length;
        return list[newRotationIndex];
    }
	
}
