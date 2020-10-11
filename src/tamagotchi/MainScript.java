package tamagotchi;

import outils.Clavier;

public class MainScript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tamagotchi[] listOfTamagotchi = new Tamagotchi[10];
		int daysCounter = 1;
		int action;
		String tamagotchiType;
		boolean corectType = false;
		System.out.println("Bienvenue dans le jeux Tamagotchi !");

		System.out.println(listOfTamagotchi.length);

		do {

			System.out.println("Veuillez entrez le type  de votre tamagotchi parmi les suivante :");
			System.out.println("Chat Chien Dragon");
			tamagotchiType = Clavier.lireString();
			if (tamagotchiType.equals("Chat") || tamagotchiType.equals("Chien") || tamagotchiType.equals("Dragon")) {
				corectType = true;
			}

		} while (corectType == false);

		System.out.println("Veuillez entrez le nom de votre tamagotchi");
		String name = Clavier.lireString();

		System.out.println("Veuillez entrez la couleur de votre tamagotchi");
		String skinColor = Clavier.lireString();

		System.out.println("Veuillez entrez la couleur du cheveux de votre tamagotchi");
		String hairColor = Clavier.lireString();
		int nbObligation = 0;

		Tamagotchi myTamagotchi = new Tamagotchi(name, skinColor, hairColor, tamagotchiType);

		for (int i = 0; i < listOfTamagotchi.length; i++) {
			if (null == listOfTamagotchi[i]) {

				listOfTamagotchi[i] = myTamagotchi;
				break;
			}
		}
		for (int i = 0; i < listOfTamagotchi.length; i++) {
			if (null == listOfTamagotchi[i]) {
				
				System.out.println("vide");
				
			}else {
				System.out.println(listOfTamagotchi[i].getName());
			}
		}

		do {

			System.out.println("\nBonjour debut du jour " + daysCounter);
			if(nbOfTamagotchiInTable(listOfTamagotchi)>0) {
				boolean askAgain = false;
				do {
					System.out.println("Voulez vous continuer avec votre tamagotchi actuel O/N");
					String response = Clavier.lireString();
					if(response.equals("O")) {
						System.out.println("Vous avez decidez de continuer avec  votre tamagotchi");
					}else if(response.equals("N")) {
						
						displayTamagotchiInTable(listOfTamagotchi);
					}else {
						System.out.println("Choix eronner \nVeuillez choisir un des proposition");
						askAgain = true;
					}
				} while (askAgain);
				
				
			}
			for (int j = 0; j < 5; j++) {

				myTamagotchi.show();
				gameMenu();
				action = Clavier.lireInt();
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
					String newHairColor = Clavier.lireString();
					myTamagotchi.setHairColor(newHairColor);
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

					System.out.println("Veuillez donner un nom a votre nouvelle tamagotchi");
					String newTamagotchiName = Clavier.lireString();
					Tamagotchi myTamagotchiChild = new Tamagotchi(newTamagotchiName, skinColor, hairColor,
							tamagotchiType);

					System.out.println("Voullez vous continuez avec la nouvel tamagotchi ?");
					break;
				}
				case 12: {

					myTamagotchi.die();
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + action);
				}

			}

			if (myTamagotchi.getDirtLevel() == 100 || myTamagotchi.getTiredness() == 100
					|| myTamagotchi.getHungerLevel() == 100 || myTamagotchi.getToiletDesire() == 100) {

				nbObligation++;
			}
			if (nbObligation > 2) {
				myTamagotchi.decreasesHealth(2);
			} else {
				myTamagotchi.decreasesHealth(1);
			}

			myTamagotchi.riseHeight();

			daysCounter++;
			myTamagotchi.decreasesdayRemaining(1);
		} while (myTamagotchi.getDayRemaining() > 0);

		System.out.println("Votre tamagotchi est mort de vieillesse");

	}

	public static void gameMenu() {
		System.out.println("\nVoici le menu du jeux :");
		System.out.println("1: pour faire manger votre tamagotchi");
		System.out.println("2: pour le faire aller au toilet");
		System.out.println("3: pour changer la couleur de ses cheveux");
		System.out.println("4: pour qu'il se repose");
		System.out.println("5: pour qu'il exprime son humeur");
		System.out.println("6: pour qu'il voit ses amis");
		System.out.println("7: pour qu'il fasse du sport");
		System.out.println("8: pour qu'il enleve/mettre sont masque");
		System.out.println("9: pour qu'il se lave");
		System.out.println("10: pour le faire fumer");
		System.out.println("11: pour qu'il se reproduise");
		System.out.println("12: pour le tuer");
	}
	
	public static int nbOfTamagotchiInTable(Tamagotchi[] tab) {
		int result = 0;
		
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != null) {
				
				result++;
				
			}
		}
		
		return result;
	}
	public static void displayTamagotchiInTable(Tamagotchi[] tab) {
		
		
		System.out.println("\nVoici la liste des tamagotchi d'ont vous disposez\n");
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != null) {
				
				System.out.println((i+1)+": Nom: "+tab[i].getName()+" Type: "+tab[i].getTamagotchiType());
				
				
			}
		}
		
		
	}

}
