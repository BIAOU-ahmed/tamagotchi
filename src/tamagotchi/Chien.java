/**
 * 
 */
package tamagotchi;

import outils.Clavier;

/**
 * @author ahmed
 *
 */
public class Chien extends Tamagotchi {

	private final int HEALTHMAX = 15;
	final int ACTIONMAX = 5;
	public Chien() {
		super();
		// TODO Auto-generated constructor stub
		
		choiceSkinColor();
		choiceHairColor();
		setTamagotchiType("Chien");
		super.setHeight(15);
		super.setHealth(HEALTHMAX);
		super.setLifeExpectancy(4);
		super.setDayRemaining(4);
		super.setNbAction(5);
	}

	public void riseHeight() {
		super.setHeight(super.getHeight() + 2);
	}

	public void decreasesHungerLevel(int number) {

		setHungerLevel(this.hungerLevel - number);
	}
	
	public void eat() {
		if (super.getHungerLevel() > 0 && super.getToiletDesire() < 50) {
			decreasesHungerLevel();
		}
		super.eat();
	}
	
	
	public void changeHairColor() {
		choiceHairColor();
		super.changeHairColor();
	}
	
	public Tamagotchi reproduce() {
		Tamagotchi myTamagotchiChild = new Chat( getSkinColor(),getHairColor());
		decreasesNbAction(1);
		return myTamagotchiChild;
	}
	
	public void smok() {
		super.smok();
		decreasesHealth(3);
		riseToiletDesire(3);
		riseTiredness(4);
	}
	public void setHealth(int health) {
		System.out.println("set child");
		if (health > 10) {
			health = 10;
		} else if (health > 0 && health <= 5) {
			System.out.println("\nAttention votre tamagotchi n'a plus beaucoup de vie\n");
		}
		super.setHealth(health);
		
	}
	
	private void choiceSkinColor() {
		int choice;
		System.out.println("Veuillez entrer la couleur de votre tamagotchi parmi les suivantes");
		System.out.println("1) Blanc \n2) Beige \n3) Blanc a tache noir");
		
			choice = Clavier.lireInt();

			switch (choice) {
			case 1: {
				setSkinColor("Blanc");
				break;
			}
			case 2: {
				setSkinColor("Beige");
				break;
			}
			case 3: {
				setSkinColor("Blanc a tache noir");
				break;
			}
			
			
			default:
				System.out.println("Erreur de saisie");
				choiceSkinColor();
			}

		
	}
	
	private void choiceHairColor() {
		int choice;
		System.out.println("Veuillez entrer la couleur des cheuveux de votre tamagotchi parmi les suivantes");
		System.out.println("1) Blanc \n2) Noir \n3) Gris ");
		
			choice = Clavier.lireInt();

			switch (choice) {
			case 1: {
				setHairColor("Blanc");
				break;
			}
			case 2: {
				setHairColor("Noir");
				break;
			}
			case 3: {
				setHairColor("Gris");
				break;
			}
		
			
			default:
				System.out.println("Erreur de saisie");
				choiceHairColor();
			}

		
	}
}
