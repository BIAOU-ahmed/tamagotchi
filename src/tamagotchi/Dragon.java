/**
 * 
 */
package tamagotchi;

/**
 * @author ahmed
 *
 */
public class Dragon extends Tamagotchi {

	private final int HEALTHMAX = 0;
	final int ACTIONMAX = 10;
	public Dragon() {
		super();
		// TODO Auto-generated constructor stub

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
	
	public void eat() {
		if (super.getHungerLevel() > 0 && super.getToiletDesire() < 50) {
			decreasesHungerLevel();
		}
		super.eat();
	}
	
	public Tamagotchi reproduce() {
		Tamagotchi myTamagotchiChild = new Chat( getSkinColor(),getHairColor());

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
	

	
}
