package tamagitchi;

public class Tamagotchi {

	String name;
	String skinColor;
	String hairColor;
	String tamagotchiType;
	boolean masked;

	int dirtLevel = 0;
	final int HEALTHMAXCAT = 10;
	final int HEALTHMAXDRAGON = 20;
	int height;
	int health;
	int lifeExpectancy;
	int hungerLevel = 0;
	int tiredness = 0;
	int toiletDesire = 0;

	public Tamagotchi(String name, String skinColor, String hairColor, String tamagotchiType) {
		// TODO Auto-generated constructor stub
		setName(name);
		setSkinColor(skinColor);
		setHairColor(hairColor);
		setTamagotchiType(tamagotchiType);
		setHeight(height);
		if (tamagotchiType.equals("Dragon")) {

			height =35;
			health = HEALTHMAXDRAGON;
			lifeExpectancy = 6;

		} else if (tamagotchiType.equals("Chat") || tamagotchiType.equals("Chien")) {
			
			height =15;
			health = HEALTHMAXCAT;
			lifeExpectancy = 4;
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

	public String getTamagotchiType() {
		return tamagotchiType;
	}

	
	public void setTiredness(int tiredness) {
		this.tiredness = tiredness;
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

	public int getToiletDesire() {
		return toiletDesire;
	}

	public void setToiletDesire(int toiletDesire) {
		this.toiletDesire = toiletDesire;
	}

	public void show() {
		System.out.println("\nVoici les caracteristique de votre tamagotchi :");
		System.out.println("Nom : " + this.name);
		System.out.println("Taille : " + this.height);
		System.out.println("Type : " + this.tamagotchiType);
		System.out.println("Couleur : " + this.skinColor);
		System.out.println("Couleur de cheveux : " + this.hairColor);
		System.out.println("Santé : " + this.health + " Vie");
		System.out.println("Faim : " + this.hungerLevel);
		System.out.println("Esperence de vie : " + this.lifeExpectancy);
		System.out.println("Fatigue : " + this.tiredness);
		System.out.println("Niveaux saleté : " + this.dirtLevel);
		System.out.println("Envie d'allez au toilet : " + this.toiletDesire);
	}
	
	public void riseHeight() {
		
		
		if ((this.tamagotchiType.equals("Chat") || this.tamagotchiType.equals("Chien"))
				) {

			this.height += 2;
		}
		if (this.tamagotchiType.equals("Dragon")) {
			this.height += 5;
		}
	}
	

	public void riseToiletDesire(int number) {
		this.toiletDesire += number;

		if (this.toiletDesire >= 100) {
			System.out.println("Votre tamagotchi a trés trés envie d'aller au toilet");
			setToiletDesire(100);
		} else if (this.toiletDesire >= 50) {
			System.out.println("Votre tamagotchi a  trés envie d'aller au toilet");
		}
	}

	public void riseDirtyLevel(int number) {

		this.dirtLevel += number;

		if (this.dirtLevel >= 100) {
			System.out.println("Votre tamagotchi est trés trés sale veuiller le laver");
			setDirtLevel(100);
		} else if (this.dirtLevel >= 50) {
			System.out.println("Votre tamagotchi est sale veuiller le laver");
		}
	}

	public void riseTiredness(int number) {
		this.tiredness += number;
		if (this.tiredness >= 100) {
			System.out.println("Votre tamagotchi est trés trés fatigué il a besoin de repos\n");
			setTiredness(100);
		} else if (this.tiredness >= 50) {
			System.out.println("Votre tamagotchi est fatigué");
		}
	}
	public void decreasestiredness(int number) {
		this.tiredness += number;
	
	}
	
	public void riseHungerLevel(int number) {
		this.hungerLevel += number;
	}
	
	
	public void decreasesHungerLevel(int number) {
		this.hungerLevel -= number;
	}

	public void decreasesToiletDisire(int number) {
		this.toiletDesire -= number;
	}

	public void riseHealth(int number) {

		if ((this.tamagotchiType.equals("Chat") || this.tamagotchiType.equals("Chien"))
				&& this.health < this.HEALTHMAXCAT) {

			this.health += number;
		}
		if (this.tamagotchiType.equals("Dragon") && this.health < this.HEALTHMAXDRAGON) {
			this.health += number;
		}

	}

	public void decreasesHealth(int number) {
		this.health -= number;
		if (this.health<=0) {
			die();
		}else if (this.health<=5) {
			System.out.println("Attention votre tamagotchi n'as plus beaucoup de vie");
		}
	}

	public void eat(int nbFood) {

		if (hungerLevel > 0) {
			decreasesHungerLevel(nbFood);
			if (hungerLevel == 0) {
				System.out.println("\nVotre tamagotchi a bien manger il n'a plus faim\n");

			} else {

				System.out.println("\nVotre tamagotchi a manger mais il a toujour faim\n");
			}

			riseDirtyLevel(5);
			riseToiletDesire(20);
			riseTiredness(5);
		} else {
			System.out.println("\nVotre tamagotchi n'a pas faim vous ne pouvez pas le nourir\n");
		}

	}

	public void goToToilet() {
		if (this.toiletDesire>=50) {
			setToiletDesire(0);
			riseDirtyLevel(5);
			riseHungerLevel(5);
			riseTiredness(3);
		}else {
			System.out.println("\nVotre tamagotchi n'as pas envie d'aller au toilet\n");
		}
		
	}
	

	
	public void rest() {
		
		if (this.tiredness<50 || this.dirtLevel>=60) {
		
			System.out.println("\nVotre tamagotchi n'est pas fatigué\n ");
		}else {
			riseHealth(1);
			setTiredness(0);
			riseHungerLevel(15);
			riseToiletDesire(10);
		}
		
		
	}

	public void expressMood() {

		if (this.health<5 || this.tiredness>=70) {
			System.out.println("Grogne de colere ");
		}else if(this.health==5 || this.tiredness>=50 ){
			System.out.println("Souris ");
		}else {
			System.out.println("Saute de joie ");
		}
		

	}

	public void seeFriends() {

		if (this.tiredness<80) {
			System.out.println("\n"+this.name+" est content d'avoir rendu visite a un ami\n");
			riseHealth(1);
			riseTiredness(20);
			riseToiletDesire(10);
			riseDirtyLevel(30);
			riseHungerLevel(20);
		}else {
			System.out.println("\nLe tamagotchi est trop fatigué pour rendre visite a un ami\n ");
		}
		

	}
	
	public void playSports() {
		if (this.tiredness<=70) {
			riseHealth(2);
			riseTiredness(60);
			riseDirtyLevel(60);
			riseHungerLevel(15);
			riseToiletDesire(10);
		}else {
			System.out.println("\nVotre tamagotchi est tros fatigué pour faire du sport\n");
		}
		
	}

	public void takeOffMask() {
		this.masked = false;
	}

	public void wash() {
		System.out.println();
		setDirtLevel(0);
		riseTiredness(2);
	}



	public void smok() {

		System.out.println("\n"+this.name+" vient de fummer\n");
		riseDirtyLevel(5);
		riseHungerLevel(20);
		if ((this.tamagotchiType.equals("Chat") || this.tamagotchiType.equals("Chien"))
				) {

			decreasesHealth(5);
			riseToiletDesire(10);
			riseTiredness(5);
		}
		if (this.tamagotchiType.equals("Dragon")) {
			decreasesHealth(1);
			riseToiletDesire(5);
			riseTiredness(2);
		}
		
	}
	
	public void die() {
		System.out.println("\nVotre tamagotchi est mort\n");
		setHealth(0);
		System.exit(-1);
	}
}
