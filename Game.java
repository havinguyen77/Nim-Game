/*****************************************
 * Havi Nguyen
 * HTN2115
 * 
 * A class for the game
 *
 ****************************************/ 

public class Game{
    
    private int marbles; 
	private int whoFirst; // Human or Computer is first
    private Human humanPlayer; 
    private Computer computerPlayer; 
	
    //Construtor method intializes all variables
    public Game(int difficulty){
		
		marbles = (int)(Math.random( ) * 90) + 10; 
		
		whoFirst = (int)(Math.random() * 2); 
		
		computerPlayer = new Computer(difficulty);  
		humanPlayer = new Human(); 
		
    }
     
	//To play the game
    public void play(){
		
		System.out.println("There are " + marbles + " generated.");
        
		//Check who will go first, 1 or 2
		while (marbles > 1){
			
			if( whoFirst == 1){
				computerFirst();
			}
			
			else{
				humanFirst();
			}
		}
    }

    //When computer is first
	public void computerFirst(){
		
		computerPlayer.move(marbles); //Computer play
		marbles = marbles - computerPlayer.getChoice();
		
		// 1 left, human lose
		if(marbles == 1) {
			
			System.out.println("The computer took 1.");
			System.out.println("You lost Nim.");
		}
		
		if( marbles > 1){
			
			System.out.println("The computer took " + computerPlayer.getChoice() + " marbles.");
			System.out.println("There are " + marbles + " left."); 

			// Human play
			humanPlayer.move(marbles);
			marbles = marbles - humanPlayer.getChoice();
			System.out.println("There are " + marbles + " left.");
			
			//Comp will take last marble
			if(marbles == 1){
				System.out.println("Congrats! You won!");
			}
		
		}

	}
	
	//When human is first
	public void humanFirst(){
		
		humanPlayer.move(marbles); //Human play
		marbles = marbles - humanPlayer.getChoice();
		
		//Comp will take last marble
		if(marbles == 1){
			System.out.println("Congrats! You won!");
		}

		if(marbles > 1){
			
			//Computer play
			computerPlayer.move(marbles);
			System.out.println("The computer took " + computerPlayer.getChoice() + " marbles.");
			marbles = marbles - computerPlayer.getChoice();
			System.out.println("There are " + marbles + " left.");
			
			//Human take last marble
			if(marbles == 1){
				System.out.println("You lost Nim.");
			}
		}

	}

}