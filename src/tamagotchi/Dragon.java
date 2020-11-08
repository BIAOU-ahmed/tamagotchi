/**
 * 
 */
package tamagotchi;

import outils.Clavier;

/**
 * @author ahmed
 *
 */
public class Dragon extends Tamagotchi {

	private final int HEALTHMAX = 20;
	final int ACTIONMAX = 10;
	public Dragon() {
		super();
		// TODO Auto-generated constructor stub

		choiceSkinColor();
		choiceHairColor();
		setTamagotchiType("Dragon");
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
	
	
	public void changeHairColor() {
		choiceHairColor();
		super.changeHairColor();
	}
	
	public void eat() {
		if (super.getHungerLevel() > 0 && super.getToiletDesire() < 50) {
			decreasesHungerLevel();
		}
		super.eat();
	}
	
	public Tamagotchi reproduce() {
		Tamagotchi myTamagotchiChild = new Chat( getSkinColor(),getHairColor());
		decreasesNbAction(1);
		return myTamagotchiChild;
	}
	
	public void smok() {
		super.smok();
		decreasesHealth(1);
		riseToiletDesire(5);
		riseTiredness(2);
	}
	public void setHealth(int health) {
		System.out.println("set child");
		if (health > 20) {
			health = 20;
		} else if (health > 0 && health <= 10) {
			System.out.println("\nAttention votre tamagotchi n'a plus beaucoup de vie\n");
		}
		super.setHealth(health);
		
	}
	
	
	private void choiceSkinColor() {
		int choice;
		System.out.println("Veuillez entrer la couleur de votre tamagotchi parmi les suivantes");
		System.out.println("1) Bleu \n2) Rouge \n3) Noir ");
		
			choice = Clavier.lireInt();

			switch (choice) {
			case 1: {
				setSkinColor("Bleu");
				break;
			}
			case 2: {
				setSkinColor("Rouge");
				break;
			}
			case 3: {
				setSkinColor("Noir");
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
		System.out.println("1) Blanc \n2) Noir \n3) Violet ");
		
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
				setHairColor("Violet");
				break;
			}
		
			
			default:
				System.out.println("Erreur de saisie");
				choiceHairColor();
			}

		
	}

	
}
