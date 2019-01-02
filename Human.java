/*****************************************
 * Havi Nguyen
 * HTN2115
 *
 * A class for the Human player
 *
 ****************************************/ 
import java.util.Scanner;

public class Human{
   
    private int choice; 
    private Scanner input; // Human input
    
	//Constructor intializes variables
    public Human(){
        input = new Scanner(System.in);
        choice = -1;
    }
    
	//Human play a move
    public void move(int marblesLeft){
		System.out.println("How many marbles do you want to take?");

		choice = input.nextInt();
		
		//Ensures human has valid input
		while( choice <= 0 || choice > (marblesLeft/2) ){
			System.out.println("Error! You must take at least one marbles and cannot take more than half of the marbles!");
			System.out.println("How many marbles do you want to take?");

			choice = input.nextInt();
		}
    }
    
    public int getChoice(){
        return choice;
    }
    
    
}
