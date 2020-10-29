/**
 * 
 */
package tamagotchi;

/**
 * @author ahmed
 *
 */
public class Chat extends Tamagotchi {

	private final int HEALTHMAX = 10;
	final int ACTIONMAX = 5;
	
	public Chat() {
		super();
		// TODO Auto-generated constructor stub
		setTamagotchiType("Chat");
		super.setHeight(15);
		super.setHealth(HEALTHMAX);
		super.setLifeExpectancy(4);
		super.setDayRemaining(4);
		super.setNbAction(5);
	}
	public Chat(String skinColor, String hairColor) {
		super(skinColor,hairColor);
		// TODO Auto-generated constructor stub
		setTamagotchiType("Chat");
		super.setHeight(15);
		super.setHealth(HEALTHMAX);
		super.setLifeExpectancy(4);
		super.setDayRemaining(4);
		super.setNbAction(5);
	}

	public void riseHeight() {
		super.setHeight(super.getHeight() + 2);
	}
	
	public void decreasesHungerLevel() {
		
		setHungerLevel(this.hungerLevel - 35);
		super.decreasesHungerLevel();
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
	
}
