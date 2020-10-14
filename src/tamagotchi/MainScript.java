package tamagotchi;

import outils.Clavier;

/**
 * This Program is for a small and console clone of the tamagotchi game with
 * function chose by us
 * 
 * @author ahmed
 *
 */
public class MainScript {

	static Tamagotchi[] listOfTamagotchi = new Tamagotchi[10];

	/**
	 * Is the main of the game ask the user to do a choice of the action which he
	 * want
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int action;
		String tamagotchiType;
		boolean corectType = false;
		boolean newtamago = false;
		System.out.println("Bienvenue dans le jeu Tamagotchi !");

		do {

			System.out.println("Veuillez entrer le type de votre tamagotchi parmi les suivantes :");
			System.out.println("Chat Chien Dragon");
			tamagotchiType = Clavier.lireString();
			if (tamagotchiType.equals("Chat") || tamagotchiType.equals("Chien") || tamagotchiType.equals("Dragon")) {
				corectType = true;
			}

		} while (corectType == false);

		System.out.println("Veuillez entrer le nom de votre tamagotchi");
		String name = Clavier.lireString();

		System.out.println("Veuillez entrer la couleur de votre tamagotchi");
		String skinColor = Clavier.lireString();

		System.out.println("Veuillez entrer la couleur du cheveu de votre tamagotchi");
		String hairColor = Clavier.lireString();
		int nbObligation = 0;

		Tamagotchi myTamagotchi = new Tamagotchi(name, skinColor, hairColor, tamagotchiType);

		do {

			newtamago = false;
			System.out.println("\nBonjour début du jour "
					+ ((myTamagotchi.getLifeExpectancy() - myTamagotchi.getDayRemaining()) + 1));

			/*
			 * set the number of action according to the tamagotchi type
			 */
			if (tamagotchiType.equals("Chat") || tamagotchiType.equals("Chien")) {
				myTamagotchi.setNbAction(myTamagotchi.getACTIONMAX());
			} else if (tamagotchiType.equals("Dragon")) {
				myTamagotchi.setNbAction(myTamagotchi.getACTIONMAXDRAGON());
			}

			/*
			 * allow to play a day of the tamagotchi you chose the action and according to
			 * the choice an action is carried out
			 */

			do {

				myTamagotchi.show();
				gameMenu();
				action = Clavier.lireInt(); // ask for the action to do
				switch (action) {
				case 1: {
					myTamagotchi.eat();
					break;
				}
				case 2: {
					myTamagotchi.goToToilet();
					break;
				}
				case 3: {
					boolean askAgain = false;
					do {

						System.out.println("Veuillez entrer la nouvel couleur des cheveux de votre tamagotchi");
						String newHairColor = Clavier.lireString();
						if ((newHairColor.toLowerCase()).equals("roux")) {
							System.out.println("La couleur entrer est proscrite c'est haram !");
						}
						myTamagotchi.setHairColor(newHairColor);

					} while (askAgain);

					break;
				}
				case 4: {
					myTamagotchi.rest();
					break;
				}
				case 5: {

					myTamagotchi.expressMood();
					break;
				}
				case 6: {

					myTamagotchi.seeFriends();
					break;
				}
				case 7: {

					myTamagotchi.playSports();
					break;
				}
				case 8: {

					if (myTamagotchi.isMasked()) {

						myTamagotchi.takeOffMask();
					} else {
						myTamagotchi.putMask();
					}

					break;
				}
				case 9: {

					myTamagotchi.wash();
					break;
				}
				case 10: {

					myTamagotchi.smok();
					break;
				}
				case 11: {

					if (nbOfTamagotchiInTable(listOfTamagotchi) < 10) {
						System.out.println("Veuillez donner un nom à votre nouveau tamagotchi");
						String newTamagotchiName = Clavier.lireString();

						Tamagotchi myTamagotchiChild = new Tamagotchi(newTamagotchiName, skinColor, hairColor,
								tamagotchiType);

						newtamago = reproduce(myTamagotchi, myTamagotchiChild);
						if (newtamago) {
							myTamagotchi = myTamagotchiChild;
							myTamagotchi.setNbAction(0);
						}
					} else {
						System.out.println(
								"Impossible de se reproduire vous avez ateint le nombre maximum de tamagotchi");
					}

					break;
				}
				case 12: {

					myTamagotchi.setHealth(0);

					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + action);
				}

				myTamagotchi.decreasesNbAction(1);
			} while (myTamagotchi.getNbAction() > 0);

			if (!newtamago) {
				if (myTamagotchi.getDirtLevel() == 100 || myTamagotchi.getTiredness() == 100
						|| myTamagotchi.getHungerLevel() == 100 || myTamagotchi.getToiletDesire() == 100) {

					nbObligation++;
				}
				if (nbObligation > 2) {
					myTamagotchi.decreasesHealth(2);
				} else {
					if (myTamagotchi.getHealth() > 0) {
						myTamagotchi.decreasesHealth(1);
					}

				}

				myTamagotchi.riseHeight();

				myTamagotchi.decreasesdayRemaining(1);

				// check if the tamagotchi is dead of old age
				if (myTamagotchi.getHealth() > 0 && myTamagotchi.getDayRemaining() == 0) {
					System.out.println("Votre tamagotchi est mort de vieillesse");
				}

				// choose automatically new tamagotchi to replace who's die
				if ((myTamagotchi.getHealth() == 0 || myTamagotchi.getDayRemaining() == 0)
						&& (nbOfTamagotchiInTable(listOfTamagotchi) > 0)) {
					System.out.println("Un nouveau tamagotchi a été choisi pour vous ");

					for (int i = 0; i < listOfTamagotchi.length; i++) {
						if (null != listOfTamagotchi[i]) {

							myTamagotchi = listOfTamagotchi[i];
							listOfTamagotchi[i] = null;

							break;
						}
					}

					continue;

				}
				
				
				if (nbOfTamagotchiInTable(listOfTamagotchi) > 0) { // add "and tamagotchi.health > 0

					myTamagotchi = changeTamago(myTamagotchi);
				}
			}

		} while (myTamagotchi.getDayRemaining() > 0);

	}

	/**
	 * This function display the game menu
	 */
	public static void gameMenu() {
		System.out.println("\nVoici le menu du jeu :");
		System.out.println("1: pour faire manger votre tamagotchi");
		System.out.println("2: pour le faire aller au toilet");
		System.out.println("3: pour changer la couleur de ses cheveux");
		System.out.println("4: pour qu'il se repose");
		System.out.println("5: pour qu'il exprime son humeur");
		System.out.println("6: pour qu'il voit ses amis");
		System.out.println("7: pour qu'il fasse du sport");
		System.out.println("8: pour qu'il enleve/mettre sont masques");
		System.out.println("9: pour qu'il se lave");
		System.out.println("10: pour le faire fumer");
		System.out.println("11: pour qu'il se reproduise");
		System.out.println("12: pour le tuer");
	}

	/**
	 * This function is to know the number of tamagotchi in the tamagotchi list
	 * 
	 * @param tab
	 * @return the number of tamagotchi
	 */
	public static int nbOfTamagotchiInTable(Tamagotchi[] tab) {
		int result = 0;

		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != null) {

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
	public static void displayTamagotchiInTable(Tamagotchi[] tab) {

		System.out.println("\nVoici la liste des tamagotchis dont vous disposez\n");
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != null) {

				System.out.println((i + 1) + ": Nom: " + tab[i].getName() + " Type: " + tab[i].getTamagotchiType());

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
	public static Tamagotchi changeTamago(Tamagotchi myTamagotchi) {
		boolean askAgain = false;
		Tamagotchi result = myTamagotchi;
		do {
			System.out.println("voulez-vous continuer avec votre tamagotchi actuel O/N");
			String response = Clavier.lireString();
			if (response.equals("O")) {
				System.out.println("Vous avez décidez de continuer avec votre tamagotchi");
			} else if (response.equals("N")) {

				displayTamagotchiInTable(listOfTamagotchi);
				System.out.println("Veuillez entrer le numéro du nouveau tamagotchi");
				int newtamagotchi = Clavier.lireInt();
				if (newtamagotchi <= nbOfTamagotchiInTable(listOfTamagotchi) && newtamagotchi > 0) {
					Tamagotchi tamagotchiTemp = listOfTamagotchi[newtamagotchi - 1];
					if (myTamagotchi.getHealth() > 0) {
						listOfTamagotchi[newtamagotchi - 1] = myTamagotchi;
					} else {
						listOfTamagotchi[newtamagotchi - 1] = null;
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
	public static boolean reproduce(Tamagotchi myTamagotchi, Tamagotchi myTamagotchiChild) {

		boolean result = false;
		Tamagotchi tamagotchiTemp = myTamagotchi;
		System.out.println("Voullez vous continuez avec le nouveau tamagotchi ? O/N");
		String response = Clavier.lireString();
		if (response.equals("O")) {
			System.out.println("Vous avez décidez de changer de tamagotchi ");

			// myTamagotchi = myTamagotchiChild;
			// myTamagotchi.setNbAction(0);
			result = true;

		} else if (response.equals("N")) {

			tamagotchiTemp = myTamagotchiChild;
		} else {
			System.out.println("Choix eronner \nveuillez choisir une des propositions");

		}

		for (int i = 0; i < listOfTamagotchi.length; i++) {
			if (null == listOfTamagotchi[i]) {

				listOfTamagotchi[i] = tamagotchiTemp;
				break;
			}
		}
		return result;

	}
}
