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

	public void riseHeight() {
		super.setHeight(super.getHeight() + 2);
	}



	public void changeHairColor() {
		chooseHairColor();
		super.changeHairColor();
	}

	public void eat() {
		if (super.getHungerLevel() > 0 && super.getToiletDesire() < 50) {
			chooseMeal();
		}
		super.eat();
	}

	public Tamagotchi reproduce() {
		Tamagotchi myTamagotchiChild = new Chat(getSkinColor(), getHairColor());
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
		
		if (health > HEALTHMAX) {
			health = HEALTHMAX;
		} else if (health > 0 && health <= 10) {
			System.out.println("\nAttention votre tamagotchi n'a plus beaucoup de vie\n");
		}
		super.setHealth(health);

	}

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
