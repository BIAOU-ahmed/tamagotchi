package tamagotchi;


/**
 * This Program is for a small and console clone of the tamagotchi game with
 * function chose by us
 * 
 * @author ahmed
 *
 */
public class MainScript {

	static Tamagotchi[] listOfTamagotchi = new Tamagotchi[10];
	static Tamagotchi myTamagotchi = null;
	static boolean newtamago = false;
	static int nbObligation = 0;
	static boolean playing = true;
	/**
	 * Is the main of the game ask the user to do a choice of the action which he
	 * want
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		System.out.println("Bienvenue dans le jeu Tamagotchi !");

		GameProcess.typeChoice();

	
		
		do {

			newtamago = false;
			System.out.println("\nBonjour début du jour "
					+ ((myTamagotchi.getLifeExpectancy() - myTamagotchi.getDayRemaining()) + 1));

			/*
			 * set the number of action according to the tamagotchi type
			 */
			if(myTamagotchi.getNbAction()==0) {
				myTamagotchi.setNbAction(myTamagotchi.getACTIONMAX());
			}
			
			
			

			/*
			 * allow to play a day of the tamagotchi you chose the action and according to
			 * the choice an action is carried out
			 */
			playing=true;

			do {

				
				
				myTamagotchi.gameMenu();
				
				GameProcess.gameAction();
				

				
			
			} while (playing);

			GameProcess.endGame();

		} while (myTamagotchi.getDayRemaining() > 0);

	}


	


}
