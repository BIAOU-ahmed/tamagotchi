package tamagitchi;

import outils.Clavier;

public class MainScript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int action;
		String tamagotchiType;
		boolean corectType = false;
		System.out.println("Bienvenue dans le jeux Tamagotchi !");
		
		System.out.println("Veuillez entrez le nom de votre tamagotchi");
		String name = Clavier.lireString();
		
		System.out.println("Veuillez entrez la couleur de votre tamagotchi");
		String skinColor = Clavier.lireString();
		
		System.out.println("Veuillez entrez la taile en cm de votre tamagotchi");
		int height = Clavier.lireInt();
		
		System.out.println("Veuillez entrez la couleur du cheveux de votre tamagotchi");
		String hairColor = Clavier.lireString();
		
		
		do {
			
			System.out.println("Veuillez entrez le type  de votre tamagotchi parmi les suivante :");
			System.out.println("Chat Chien Dragon");
			tamagotchiType = Clavier.lireString();
			if (tamagotchiType.equals("Chat") || tamagotchiType.equals("Chien") || tamagotchiType.equals("Dragon")) {
				corectType = true;
			}
			
		} while (corectType==false);
		
		Tamagotchi myTamagotchi = new Tamagotchi(name,skinColor,hairColor,tamagotchiType,height);
		
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
			
			myTamagotchi.getMood();
			break;
		}
		case 6: {
			
			break;
		}
		case 7: {
			
			myTamagotchi.playSports();
			break;
		}
		case 8: {
			
			myTamagotchi.takeOffMask();
			break;
		}
		case 9: {
			
			myTamagotchi.wash();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
		
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
		System.out.println("8: pour qu'il enleve sont masque");
		System.out.println("9: pour qu'il se lave");
	}

}
