/*****************************************
 * 
 * Havi Nguyen
 * HTN2115
 *
 * Class for Computer Player
 *
 ****************************************/ 

public class Computer{
    
    private int mode; //Level of difficulty 
    private int choice; 
	
    //Constuctor intializes variables
    public Computer(int m){
        mode = m;
        choice = -1;
    }
    
	//Computer plays a move
    public void move(int marblesLeft){
		
		//Dumb mode
        if (mode == 1){
			
			//Computer picks randomly 
			choice = (int)(Math.random() * ((marblesLeft/2)-1)) + 1; 
				
		}

		//Smart mode
        else {
			
			//Computer takes one if two are left
			if (marblesLeft == 2){
				choice = 1; 
			}
			
			//Computer strategy for pile left is (2^n)-1
			else {
				
				int i = 0 ; 
				while((int)((Math.pow(2,i))-1) < marblesLeft){
					i++;
				}

				choice = marblesLeft - ((int)((Math.pow(2,i-1))-1));
			}
		}
    }
    
    public int getChoice(){
		
        return choice;
    }
    
}
