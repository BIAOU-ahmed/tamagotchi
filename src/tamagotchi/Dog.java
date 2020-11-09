/**
 * 
 */
package tamagotchi;

import outils.Clavier;

/**
 * @author ahmed
 *
 */
public class Dog extends Tamagotchi {

	private final int HEALTHMAX = 15;
	private final int LIFE_EXPECTANCY = 10 ;
	private final int MAX_ACTION = 10 ;
	
	
	
	/**
	 * This method is the constructor he set the value of the new Dog
	 * 
	 */
	public Dog() {
		super();
		// TODO Auto-generated constructor stub
		
		chooseSkinColor();
		chooseHairColor();
		setTamagotchiType("Chien");
		super.setHeight(15);
		super.setHealth(HEALTHMAX);
		super.setDayRemaining(LIFE_EXPECTANCY);
		super.setNbAction(MAX_ACTION);
		System.out.println(nbAction);
		super.show();
	}

	/**
	 * This method is the constructor he set the value of the new Dog
	 * @param skinColor
	 * @param hairColor
	 */
	public Dog(String skinColor, String hairColor) {
		super(skinColor, hairColor);
		// TODO Auto-generated constructor stub
		super.setTamagotchiType("Chien");
		super.setHeight(15);
		super.setHealth(HEALTHMAX);
		super.setDayRemaining(LIFE_EXPECTANCY);
		super.setNbAction(MAX_ACTION);
	}
	
	

	
	/**
	 * @return the mAX_ACTION
	 */
	public int getMAX_ACTION() {
		return MAX_ACTION;
	}

	/**
	 * @return the lIFE_EXPECTANCY
	 */
	public int getLIFE_EXPECTANCY() {
		return LIFE_EXPECTANCY;
	}

	/**
	 * rise the number of height by "number" depending on the tamagotchi type
	 */
	public void riseHeight() {
		super.setHeight(super.getHeight() + 5);
	}


	
	/**
	 * this method allows to feed the tamagotchi after having eaten the hunger
	 * decrease and the dirty level, toilet desire and tiredness rise
	 */
	public void eat() {
		if (super.getHungerLevel() > 0 && super.getToiletDesire() < 90) {
			chooseMeal();
		}
		super.eat();
	}
	
	
	/**
	 * This method is just to change the tamagotchi's hair color
	 */
	public void changeHairColor() {
		chooseHairColor();
		super.changeHairColor();
	}

	/**
	 * This method create a new tamagotchi who can be used by the user if he want to change tamagotchi
	 */
	public Tamagotchi reproduce() {
		Tamagotchi myTamagotchiChild = new Cat( getSkinColor(),getHairColor());
		decreasesNbAction(1);
		return myTamagotchiChild;
	}
	
	
	/**
	 * This method is to allow the tamagotchi to smok
	 */
	public void smok() {
		super.smok();
		decreasesHealth(3);
		riseToiletDesire(3);
		riseTiredness(4);
	}
	
	/**
	 * 
	 * @param height
	 */
	public void setHealth(int health) {
		
		if (health > HEALTHMAX) {
			health = HEALTHMAX;
		} else if (health > 0 && health <= 7) {
			System.out.println("\nAttention votre tamagotchi n'a plus beaucoup de vie\n");
		}
		super.setHealth(health);
		
	}
	
	/**
	 * This method allow the user to choose the tamagotchi skin color
	 */
	protected void chooseSkinColor() {
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
				chooseSkinColor();
			}

		
	}
	
	
	/**
	 * This method allow the user to choose the tamagotchi hair color
	 */
	protected void chooseHairColor() {
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
				chooseHairColor();
			}

		
	}
	
	/**
	 * This method allow the user to choose the meal for the tamagotchi
	 */
	protected void chooseMeal() {
		
		int choice;
		System.out.println("Veuillez choisir la nouritures que vous souhaitez :");
		System.out.println("1) Croquete pour chien \n2) Un os ");
		
			choice = Clavier.lireInt();

			switch (choice) {
			case 1: {
				decreasesHungerLevel(35);
				break;
			}
			case 2: {
				decreasesHungerLevel(100);
				break;
			}
			default:
				System.out.println("Erreur de saisie");
				chooseMeal();
			}
			
	}
}
