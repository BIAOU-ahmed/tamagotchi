package tamagitchi;

public class Tamagotchi {

	String name;
	String color;
	String hairColor;
	String tamagotchiType;
	boolean masked;


	int height;
	int health;
	int lifeExpectancy;
	int hungerLevel;
	int tiredness;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	
	public String getTamagotchiType() {
		return tamagotchiType;
	}
	public void setTamagotchiType(String tamagotchiType) {
		this.tamagotchiType = tamagotchiType;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getLifeExpectancy() {
		return lifeExpectancy;
	}
	
	public int getHungerLevel() {
		return hungerLevel;
	}
	
	public int getTiredness() {
		return tiredness;
	}

	public boolean isMasked() {
		return masked;
	}
	public void setMasked(boolean masked) {
		this.masked = masked;
	}
	
	public void show() {
		System.out.println();
	}
	
	
	
}
