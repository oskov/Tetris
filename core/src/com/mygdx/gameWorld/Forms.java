package com.mygdx.gameWorld;

import com.badlogic.gdx.Gdx;

public enum Forms {

	
	SQUARE_FORM( new formGen() {
	public	int[][] getForm(){
		int form[][]= new int[3][3];
		
		for(int i=1;i<3;i++) {
			for(int a=0;a<2;a++) {
				form[i][a]=1;
			}	
		}

		
		return form;
	}
		
		
	}),
	J_FORM( new formGen() {
	public	int[][] getForm(){
		int form[][]= new int[3][3];
		
		/*form[1][1]=1;
		form[1][0]=1;
		form[1][2]=1;
		form[0][2]=1;	*/
	for (int i=0;i<3;i++)form[i][1]=1;
	form[2][0]=1;
		return form;
	}	
	}),
	L_FORM( new formGen() {
		public	int[][] getForm(){
			int form[][]= new int[3][3];
			
			for (int i=0;i<3;i++)form[i][1]=1;
		    form[2][2]=1;
			return form;
		}	
		}),
	Z_FORM( new formGen() {
		public	int[][] getForm(){
			int form[][]= new int[3][3];
			
			form[1][1]=1;
			form[1][0]=1;
			form[2][1]=1;
			form[2][2]=1;			
			return form;
		}
	
		}),
	S_FORM( new formGen() {
		public	int[][] getForm(){
			int form[][]= new int[3][3];
			
			form[1][1]=1;
			form[1][2]=1;
			form[2][1]=1;
			form[2][0]=1;				
			return form;
		}
	
		}),
	T_FORM( new formGen() {
		public	int[][] getForm(){
			int form[][]= new int[3][3];
			
			form[1][1]=1;
			form[2][1]=1;
			form[1][0]=1;
			form[1][2]=1;				
			return form;
		}
	
		}),
	I_FORM( new formGen() {
		public	int[][] getForm(){
			int form[][]= new int[4][4];
			
			form[0][0]=1;
			form[1][0]=1;
			form[2][0]=1;
			form[3][0]=1;			
			return form;
		}
	
		})
	
	;
	
	Forms(formGen gen){
		this.gen=gen;
	}
	
	private formGen gen;
	private interface formGen{
		
		int[][] getForm();
	}

	public int[][] generateForm(){
		
		return this.gen.getForm();
	}

}
