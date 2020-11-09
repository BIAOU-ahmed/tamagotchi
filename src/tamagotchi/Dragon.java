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
	private final int LIFE_EXPECTANCY = 20 ;
	private final int MAX_ACTION = 15 ;

	
	/**
	 * This method is the constructor he set the value of the new Dragon
	 * 
	 */
	public Dragon() {
		super();
		// TODO Auto-generated constructor stub

		chooseSkinColor();
		chooseHairColor();
		setTamagotchiType("Dragon");
		super.setHeight(35);
		super.setHealth(HEALTHMAX);
		super.setDayRemaining(LIFE_EXPECTANCY);
		super.setNbAction(MAX_ACTION);
		System.out.println(nbAction);
		super.show();
	}

	/**
	 * This method is the constructor he set the value of the new Dragon
	 * 
	 * @param skinColor
	 * @param hairColor
	 */
	public Dragon(String skinColor, String hairColor) {
		super(skinColor, hairColor);
		// TODO Auto-generated constructor stub
		super.setTamagotchiType("Dragon");
		super.setHeight(35);
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
		super.setHeight(super.getHeight() + 25);
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
		Tamagotchi myTamagotchiChild = new Cat(getSkinColor(), getHairColor());
		decreasesNbAction(1);
		return myTamagotchiChild;
	}

	
	/**
	 * This method is to allow the tamagotchi to smok
	 */
	public void smok() {
		super.smok();
		decreasesHealth(1);
		riseToiletDesire(5);
		riseTiredness(2);
	}

	
	/**
	 * 
	 * @param height
	 */
	public void setHealth(int health) {
		
		if (health > HEALTHMAX) {
			health = HEALTHMAX;
		} else if (health > 0 && health <= 10) {
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
			chooseSkinColor();
		}

	}

	
	/**
	 * This method allow the user to choose the tamagotchi hair color
	 */
	protected void chooseHairColor() {
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
			chooseHairColor();
		}

	}

	
	/**
	 * This method allow the user to choose the meal for the tamagotchi
	 */
	protected void chooseMeal() {

		int choice;
		System.out.println("Veuillez choisir la nouritures que vous souhaitez :");
		System.out.println("1) Chat \n2) Chient \n3) Humain \n4) Mamout \n5) Baleine ");

		choice = Clavier.lireInt();

		switch (choice) {
		case 1: {
			decreasesHungerLevel(5);
			break;
		}
		case 2: {
			decreasesHungerLevel(15);
			break;
		}
		case 3: {
			decreasesHungerLevel(20);
			break;
		}
		case 4: {
			decreasesHungerLevel(65);
			break;
		}
		case 5: {
			decreasesHungerLevel(100);
			break;
		}
		default:
			System.out.println("Erreur de saisie");
			chooseMeal();
		}

	}

}
