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
	private final int LIFE_EXPECTANCY = 10 ;
	private final int MAX_ACTION = 10 ;
	
	public Chien() {
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

	public Chien(String skinColor, String hairColor) {
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
		
		if (health > HEALTHMAX) {
			health = HEALTHMAX;
		} else if (health > 0 && health <= 7) {
			System.out.println("\nAttention votre tamagotchi n'a plus beaucoup de vie\n");
		}
		super.setHealth(health);
		
	}
	
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
