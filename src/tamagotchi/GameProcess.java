/**
 * 
 */
package tamagotchi;

import outils.Clavier;

/**
 * @author ahmed
 *
 */
public class GameProcess {
	
	
	public static void typeChoice() {

		
		System.out.println("Veuillez entrer le type de votre tamagotchi parmi les suivantes :");
		System.out.println("1-Chat\n2-Chien\n3-Dragon");
		int tamagotchiType = Clavier.lireInt();
		switch (tamagotchiType) {
		case 1: {
			MainScript.myTamagotchi = new Chat();
			break;
		}
		case 2: {
			MainScript.myTamagotchi = new Chien();
			break;
		}
		case 3: {
			MainScript.myTamagotchi = new Dragon();
			break;
		}
		default:
			System.out.println("error");
			typeChoice();
		}
	}
	
	/**
	 * This function is to know the number of tamagotchi in the tamagotchi list
	 * 
	 * @param tab
	 * @return the number of tamagotchi
	 */
	public static int nbOfTamagotchiInTable() {
		int result = 0;

		for (int i = 0; i < MainScript.listOfTamagotchi.length; i++) {
			if (MainScript.listOfTamagotchi[i] != null) {

				result++;

			}
		}

		return result;
	}

	/**
	 * Display the tamagotchis in the table
	 * 
	 * @param tab
	 */
	public static void displayTamagotchiInTable() {

		System.out.println("\nVoici la liste des tamagotchis dont vous disposez\n");
		for (int i = 0; i < MainScript.listOfTamagotchi.length; i++) {
			if (MainScript.listOfTamagotchi[i] != null) {

				System.out.println((i + 1) + ": Nom: " + MainScript.listOfTamagotchi[i].getName() + " Type: " + MainScript.listOfTamagotchi[i].getTamagotchiType());

			}
		}

	}

	/**
	 * this part ask for change of tamagotchi if you change the current is put in
	 * the table
	 * 
	 * @param myTamagotchi
	 * @return the new tamagotchi
	 */
	public static Tamagotchi changeTamago() {
		boolean askAgain = false;
		Tamagotchi result = MainScript.myTamagotchi;
		do {
			System.out.println("voulez-vous continuer avec votre tamagotchi actuel O/N");
			String response = Clavier.lireString();
			if (response.toLowerCase().equals("o")) {
				System.out.println("Vous avez décidez de continuer avec votre tamagotchi");
			} else if (response.toLowerCase().equals("n")) {

				displayTamagotchiInTable();
				System.out.println("Veuillez entrer le numéro du nouveau tamagotchi");
				int newtamagotchi = Clavier.lireInt();
				if (newtamagotchi <= nbOfTamagotchiInTable() && newtamagotchi > 0) {
					Tamagotchi tamagotchiTemp = MainScript.listOfTamagotchi[newtamagotchi - 1];
					if (MainScript.myTamagotchi.getHealth() > 0) {
						MainScript.listOfTamagotchi[newtamagotchi - 1] = MainScript.myTamagotchi;
					} else {
						MainScript.listOfTamagotchi[newtamagotchi - 1] = null;
					}

					result = tamagotchiTemp;
				}
			} else {
				System.out.println("Choix eronner \nveuillez choisir une des propositions");
				askAgain = true;
			}
		} while (askAgain);

		return result;

	}

	/**
	 * 
	 * this part create a new tamagotchi who's add to the table if the user chose to
	 * not take the new tamagotchi
	 * 
	 * @param myTamagotchi
	 * @param myTamagotchiChild
	 * @return
	 */


	public static boolean newTamaChosed(Tamagotchi myTamagotchiChild) {


		boolean result = false;
		Tamagotchi tamagotchiTemp = MainScript.myTamagotchi;
		System.out.println("Voullez vous continuez avec le nouveau tamagotchi ? O/N");
		String response = Clavier.lireString();
		if (response.toLowerCase().equals("o")) {
			System.out.println("Vous avez décidez de changer de tamagotchi ");

			// myTamagotchi = myTamagotchiChild;
			// myTamagotchi.setNbAction(0);
			result = true;

		} else if (response.toLowerCase().equals("n")) {

			tamagotchiTemp = myTamagotchiChild;
		} else {
			System.out.println("Choix eronner \nveuillez choisir une des propositions");

		}

		for (int i = 0; i < MainScript.listOfTamagotchi.length; i++) {
			if (null == MainScript.listOfTamagotchi[i]) {

				MainScript.listOfTamagotchi[i] = tamagotchiTemp;
				break;
			}
		}
		return result;

	}
	
	public static void spacing() {
		for (int i = 0; i < 300; i++) {
			System.out.println();
		}
	}
	
	public static void gameAction() {
		
		int action;
		
		
			action = Clavier.lireInt(); // ask for the action to do

		
		switch (action) {
		case 0: {
			MainScript.myTamagotchi.show();
			break;
		}
		case 1: {
			MainScript.myTamagotchi.eat();
			break;
		}
		case 2: {
			MainScript.myTamagotchi.goToToilet();
			break;
		}
		case 3: {
			MainScript.myTamagotchi.changeHairColor();

			break;
		}
		case 4: {
			MainScript.myTamagotchi.rest();
			break;
		}
		case 5: {

			MainScript.myTamagotchi.expressMood();
			break;
		}
		case 6: {

			MainScript.myTamagotchi.seeFriends();
			break;
		}
		case 7: {

			MainScript.myTamagotchi.playSports();
			break;
		}
		case 8: {

			if (MainScript.myTamagotchi.isMasked()) {

				MainScript.myTamagotchi.takeOffMask();
			} else {
				MainScript.myTamagotchi.putMask();
			}

			break;
		}
		case 9: {

			MainScript.myTamagotchi.wash();
			break;
		}
		case 10: {

			MainScript.myTamagotchi.smok();
			break;
		}
		case 11: {

			if (nbOfTamagotchiInTable() < 10) {

				

				Tamagotchi myTamagotchiChild = MainScript.myTamagotchi.reproduce();

				MainScript.newtamago = newTamaChosed(myTamagotchiChild);

				if (MainScript.newtamago) {
					MainScript.myTamagotchi = myTamagotchiChild;
					MainScript.playing=false;
				}
			} else {
				System.out.println(
						"Impossible de se reproduire vous avez ateint le nombre maximum de tamagotchi");
			}

			break;
		}
		case 12: {

			MainScript.myTamagotchi.setHealth(0);

			break;
		}
		default:
			System.out.println("Choix incorrect veuiller entrer une action valide");
			gameAction();
			
			
		}
		
		if(MainScript.myTamagotchi.getNbAction()<=0) {
			MainScript.playing=false;
		}
		
	}
	
	
	public static void endGame() {
		
		if (!MainScript.newtamago) {
			if (MainScript.myTamagotchi.getDirtLevel() == 100 || MainScript.myTamagotchi.getTiredness() == 100
					|| MainScript.myTamagotchi.getHungerLevel() == 100 || MainScript.myTamagotchi.getToiletDesire() == 100) {

				MainScript.nbObligation++;
			}
			if (MainScript.nbObligation > 2) {
				MainScript.myTamagotchi.decreasesHealth(2);
			} else {
				if (MainScript.myTamagotchi.getHealth() > 0) {
					MainScript.myTamagotchi.decreasesHealth(1);
				}

			}

			MainScript.myTamagotchi.riseHeight();

			MainScript.myTamagotchi.decreasesdayRemaining(1);

			// check if the tamagotchi is dead of old age
			if (MainScript.myTamagotchi.getHealth() > 0 && MainScript.myTamagotchi.getDayRemaining() == 0) {
				System.out.println("Votre tamagotchi est mort de vieillesse");
			}

			// choose automatically new tamagotchi to replace who's die
			if ((MainScript.myTamagotchi.getHealth() == 0 || MainScript.myTamagotchi.getDayRemaining() == 0)
					&& (nbOfTamagotchiInTable() > 0)) {
				System.out.println("Un nouveau tamagotchi a été choisi pour vous ");

				for (int i = 0; i < MainScript.listOfTamagotchi.length; i++) {
					if (null != MainScript.listOfTamagotchi[i]) {

						MainScript.myTamagotchi = MainScript.listOfTamagotchi[i];
						MainScript.listOfTamagotchi[i] = null;

						break;
					}
				}

				

			}

			if (nbOfTamagotchiInTable() > 0) { // add "and tamagotchi.health > 0

				MainScript.myTamagotchi = changeTamago();
				System.out.println("Vous avez decider de continuer avec "+MainScript.myTamagotchi.getName());
			}
		}
	}

}
