package tamagitchi;

public class Tamagotchi {

	String name;
	String skinColor;
	String mood = "Neutre";
	String hairColor;
	String tamagotchiType;
	boolean masked;

	int dirtLevel=0;
	final int HEALTHMAXCAT=10;
	final int HEALTHMAXDRAGON=20;
	int height;
	int health;
	int lifeExpectancy;
	int hungerLevel = 0;
	int tiredness = 0;

	public Tamagotchi(String name, String skinColor, String hairColor, String tamagotchiType, int height) {
		// TODO Auto-generated constructor stub
		setName(name);
		setSkinColor(skinColor);
		setHairColor(hairColor);
		setTamagotchiType(tamagotchiType);
		setHeight(height);
		if (tamagotchiType.equals("Dragon")) {

			health = HEALTHMAXDRAGON;
			lifeExpectancy = 15;
			
		} else if (tamagotchiType.equals("Chat") || tamagotchiType.equals("Chien")) {
			health = HEALTHMAXCAT;
			lifeExpectancy = 8;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSkinColor() {
		return skinColor;
	}

	public void setSkinColor(String skinColor) {
		this.skinColor = skinColor;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	
	
	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
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

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHealth() {
		return health;
	}
	
	

	public void setHealth(int health) {
		this.health = health;
	}

	public int getLifeExpectancy() {
		return lifeExpectancy;
	}

	public int getHungerLevel() {
		return hungerLevel;
	}
	public void setHungerLevel(int hungerLevel) {
		this.hungerLevel = hungerLevel;
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

	
	public int getDirtLevel() {
		return dirtLevel;
	}

	public void setDirtLevel(int dirtLevel) {
		this.dirtLevel = dirtLevel;
	}

	
	public void show() {
		System.out.println("Voici les caracteristique de votre tamagotchi :");
		System.out.println("Nom : "+this.name);
		System.out.println("Taille : "+this.height);
		System.out.println("Type : "+this.tamagotchiType);
		System.out.println("Couleur : "+this.skinColor);
		System.out.println("Couleur de cheveux : "+this.hairColor);
		System.out.println("Santé : "+this.health+" Vie");
		System.out.println("Faim : "+this.hungerLevel);
		System.out.println("Esperence de vie : "+ this.lifeExpectancy);
		System.out.println("Fatigue : "+this.tiredness);
	}
	
	public void riseDirtyLevel(int number) {
		this.dirtLevel += number;
	}
	public void riseHungerLevel(int number) {
		this.hungerLevel += number;
	}
	
	public void riseHealth(int number) {
		if((this.tamagotchiType.equals("Chat") || this.tamagotchiType.equals("Chien")) && this.health< this.HEALTHMAXCAT ) {
			
			this.health += number;
		}
		if(this.tamagotchiType.equals("Gragon")  && this.health< this.HEALTHMAXDRAGON ) {
			this.health += number;
		}
		
		
	}
	
	public void decreasesHealth(int number) {
		this.health -= number;
	}
	public void eat() {
		if(hungerLevel>=50) {
			setHungerLevel(0);
			System.out.println("Votre tamagotchi n'a plus faim");
		}else {
			System.out.println("Votre tamagotchi n'a pas faim vous ne pouvez pas le nourir");
		}
		
	}


	public void goToToilet() {
		riseDirtyLevel(5);
		riseHungerLevel(2);
	}
	
	public void rest() {
		
		riseHealth(1);
		
	}
	
	public void playSports() {
		riseHealth(5);
	}
	
	public void takeOffMask() {
		this.masked = false;
	}

	public void wash() {
		setDirtLevel(0);
	}
	public void die() {
		setHealth(0);
	}
	public void smok() {
		setHealth(0);
	}
}
