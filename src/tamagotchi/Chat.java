/**
 * 
 */
package tamagotchi;

import outils.Clavier;

/**
 * @author ahmed
 *
 */
public class Chat extends Tamagotchi {

	private final int HEALTHMAX = 10;
	private final int LIFE_EXPECTANCY = 5 ;
	private final int MAX_ACTION = 5 ;

	public Chat() {
		super();
		// TODO Auto-generated constructor stub

		chooseSkinColor();
		chooseHairColor();

		super.setTamagotchiType("Chat");
		super.setHeight(10);
		super.setHealth(HEALTHMAX);
		super.setDayRemaining(LIFE_EXPECTANCY);
		super.setNbAction(MAX_ACTION);
		System.out.println(nbAction);
		super.show();
	}

	public Chat(String skinColor, String hairColor) {
		super(skinColor, hairColor);
		// TODO Auto-generated constructor stub
		super.setTamagotchiType("Chat");
		super.setHeight(10);
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


	public void eat() {
		if (super.getHungerLevel() > 0 && super.getToiletDesire() < 50) {
			chooseMeal();
		}
		super.eat();
	}

	
	public void changeHairColor() {
		chooseHairColor();
		super.changeHairColor();
	}
	public Tamagotchi reproduce() {
		Tamagotchi myTamagotchiChild = new Chat(getSkinColor(), getHairColor());
		decreasesNbAction(1);
		return myTamagotchiChild;
	}

	public void smok() {
		super.smok();
		decreasesHealth(5);
		riseToiletDesire(10);
		riseTiredness(5);
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

	protected void chooseSkinColor() {
		int choice;
		System.out.println("Veuillez entrer la couleur de votre tamagotchi parmi les suivantes");
		System.out.println("1) Blanc \n2) Noir \n3)Gris \n4) Gris Noir\n5) Blanc Noir");
		
			choice = Clavier.lireInt();

			switch (choice) {
			case 1: {
				setSkinColor("Blanc");
				break;
			}
			case 2: {
				setSkinColor("Noir");
				break;
			}
			case 3: {
				setSkinColor("Gris");
				break;
			}
			case 4: {
				setSkinColor("Gris Noir");
				break;
			}
			case 5: {
				setSkinColor("Blanc Noir");
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
	
	protected void chooseMeal() {
		
		int choice;
		System.out.println("Veuillez choisir la nouritures que vous souhaitez :");
		System.out.println("1) Croquete pour chat \n2) souris ");
		
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
