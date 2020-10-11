package tamagotchi;

public class Tamagotchi {

	String name;
	String skinColor;
	String hairColor;
	String tamagotchiType;
	boolean masked;
	final int HEALTHMAXCAT = 10;
	final int HEALTHMAXDRAGON = 20;
	final int ACTIONMAX = 5;
	final int ACTIONMAXDRAGON = 5;
	int nbAction;
	int dirtLevel = 0;
	
	int dayRemaining;
	int height;
	int health;
	int lifeExpectancy;
	int hungerLevel = 0;
	int tiredness = 0;
	int toiletDesire = 0;

	/**
	 * 
	 * @param name
	 * @param skinColor
	 * @param hairColor
	 * @param tamagotchiType
	 */
	public Tamagotchi(String name, String skinColor, String hairColor, String tamagotchiType) {
		// TODO Auto-generated constructor stub
		setName(name);
		setSkinColor(skinColor);
		setHairColor(hairColor);
		setTamagotchiType(tamagotchiType);
		setHeight(height);
		if (tamagotchiType.equals("Dragon")) {

			height = 35;
			health = HEALTHMAXDRAGON;
			lifeExpectancy = 6;
			dayRemaining = 6;
			nbAction = 5;

		} else if (tamagotchiType.equals("Chat") || tamagotchiType.equals("Chien")) {

			height = 15;
			health = HEALTHMAXCAT;
			lifeExpectancy = 4;
			dayRemaining = 4;
			nbAction = 5;
		}
	}

	
	/**
	 * @return the aCTIONMAX
	 */
	public int getACTIONMAX() {
		return ACTIONMAX;
	}


	/**
	 * @return the aCTIONMAXDRAGON
	 */
	public int getACTIONMAXDRAGON() {
		return ACTIONMAXDRAGON;
	}


	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public String getSkinColor() {
		return skinColor;
	}

	/**
	 * 
	 * @param skinColor
	 */
	public void setSkinColor(String skinColor) {
		this.skinColor = skinColor;
	}

	/**
	 * 
	 * @return
	 */
	public String getHairColor() {
		return hairColor;
	}

	/**
	 * 
	 * @param hairColor
	 */
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	/**
	 * 
	 * @return
	 */
	public String getTamagotchiType() {
		return tamagotchiType;
	}

	/**
	 * @return the dayRemaining
	 */
	public int getDayRemaining() {
		return dayRemaining;
	}

	/**
	 * @param dayRemaining the dayRemaining to set
	 */
	public void setDayRemaining(int dayRemaining) {
		this.dayRemaining = dayRemaining;
	}

	/**
	 * @return the nbAction
	 */
	public int getNbAction() {
		return nbAction;
	}

	/**
	 * @param nbAction the nbAction to set
	 */
	public void setNbAction(int nbAction) {
		this.nbAction = nbAction;
	}

	/**
	 * 
	 * @param tiredness
	 */
	public void setTiredness(int tiredness) {

		if (tiredness >= 100) {
			System.out.println("Votre tamagotchi est trés trés fatigué il a besoin de repos\n");
			tiredness = 100;
		} else if (tiredness >= 50) {
			System.out.println("Votre tamagotchi est fatigué");
		}
		if (tiredness < 0) {
			tiredness = 0;
		}

		this.tiredness = tiredness;
	}

	/**
	 * 
	 * @param tamagotchiType
	 */
	public void setTamagotchiType(String tamagotchiType) {
		this.tamagotchiType = tamagotchiType;
	}

	/**
	 * 
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * 
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * 
	 * @return
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * 
	 * @param health
	 */
	public void setHealth(int health) {

		if (this.tamagotchiType.equals("Chat") || this.tamagotchiType.equals("Chien")) {

			if (health > 10) {
				health = 10;
			} else if (health > 0 && health <= 5) {
				System.out.println("\nAttention votre tamagotchi n'as plus beaucoup de vie\n");
			}
		}
		if (this.tamagotchiType.equals("Dragon")) {

			if (health > 20) {
				health = 20;
			} else if (health > 0 && health <= 10) {
				System.out.println("\nAttention votre tamagotchi n'as plus beaucoup de vie\n");
			}
		}
		this.health = health;
		if (health <= 0) {
			health = 0;
			setNbAction(0);
			setDayRemaining(0);
			System.out.println("\nVotre tamagotchi est mort\n");

		}

	}

	/**
	 * 
	 * @return
	 */
	public int getLifeExpectancy() {
		return lifeExpectancy;
	}

	/**
	 * 
	 * @return
	 */
	public int getHungerLevel() {
		return hungerLevel;
	}

	/**
	 * 
	 * @param hungerLevel
	 */
	public void setHungerLevel(int hungerLevel) {

		if (hungerLevel > 100) {
			hungerLevel = 100;
		}
		if (hungerLevel < 0) {
			hungerLevel = 0;
		}
		this.hungerLevel = hungerLevel;

	}

	/**
	 * 
	 * @return
	 */
	public int getTiredness() {
		return tiredness;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isMasked() {
		return masked;
	}

	/**
	 * 
	 * @param masked
	 */
	public void setMasked(boolean masked) {
		this.masked = masked;
	}

	/**
	 * 
	 * @return
	 */
	public int getDirtLevel() {
		return dirtLevel;
	}

	/**
	 * 
	 * @param dirtLevel
	 */
	public void setDirtLevel(int dirtLevel) {
		if (dirtLevel >= 100) {
			System.out.println("\nVotre tamagotchi est trés trés sale veuiller le laver\n");
			dirtLevel = 100;
		} else if (dirtLevel >= 50) {
			System.out.println("\nVotre tamagotchi est sale veuiller le laver\n");
		}
		this.dirtLevel = dirtLevel;
	}

	/**
	 * 
	 * @return
	 */
	public int getToiletDesire() {
		return toiletDesire;
	}

	/**
	 * 
	 * @param toiletDesire
	 */
	public void setToiletDesire(int toiletDesire) {

		if (toiletDesire >= 100) {
			System.out.println("\nVotre tamagotchi a trés trés envie d'aller au toilet\n");
			toiletDesire = 100;
		} else if (toiletDesire >= 50) {
			System.out.println("\nVotre tamagotchi a  trés envie d'aller au toilet\n");
		} else if (toiletDesire < 0) {
			toiletDesire = 0;
		}
		this.toiletDesire = toiletDesire;
	}

	/**
	 *  
	 */
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
		System.out.println("Il reste  : " + this.dayRemaining + " jour a vivre a vrotre tamagotchi");

		System.out.println("Fatigue : " + this.tiredness);
		System.out.println("Niveaux saleté : " + this.dirtLevel);
		System.out.println("Envie d'allez au toilet : " + this.toiletDesire);
	}

	public void decreasesdayRemaining(int number) {
		setDayRemaining(this.dayRemaining - number);
	}
	public void decreasesNbAction(int number) {
		setNbAction(this.nbAction - number);
	}

	public void riseHeight() {

		if ((this.tamagotchiType.equals("Chat") || this.tamagotchiType.equals("Chien"))) {

			setHeight(this.height + 2);
		}
		if (this.tamagotchiType.equals("Dragon")) {
			setHeight(this.height + 5);
		}
	}

	public void riseToiletDesire(int number) {
		setToiletDesire(this.toiletDesire + number);

	}

	public void riseDirtyLevel(int number) {

		setDirtLevel(this.dirtLevel + number);

	}

	public void riseTiredness(int number) {
		setTiredness(this.tiredness + number);

	}

	public void riseHungerLevel(int number) {

		setHungerLevel(this.hungerLevel + number);
	}

	public void decreasesHungerLevel(int number) {

		setHungerLevel(this.hungerLevel - number);

		if (this.hungerLevel == 0) {
			System.out.println("\nVotre tamagotchi a bien manger il n'a plus faim\n");

		} else {

			System.out.println("\nVotre tamagotchi a manger mais il a toujour faim\n");
		}
	}

	public void decreasesToiletDisire(int number) {
		setToiletDesire(this.toiletDesire - number);
	}

	public void riseHealth(int number) {

		setHealth(this.health + number);

	}

	public void decreasesHealth(int number) {
		setHealth(this.health - number);

	}

	public void eat() {

		if (hungerLevel > 0 && this.toiletDesire < 50) {

			if ((this.tamagotchiType.equals("Chat") || this.tamagotchiType.equals("Chien"))) {

				decreasesHungerLevel(35);
			}
			if (this.tamagotchiType.equals("Dragon")) {

				decreasesHungerLevel(25);
			}

			riseDirtyLevel(5);
			riseToiletDesire(15);
			riseTiredness(5);
		} else if (this.toiletDesire >= 50) {
			System.out.println(
					"\nVotre tamagotchi a trop envie d'aller au toilet pour manger il risque de se faire dessus\n");
		} else {
			System.out.println("\nVotre tamagotchi n'a pas faim vous ne pouvez pas le nourir\n");
		}

	}

	public void goToToilet() {
		if (this.toiletDesire >= 50) {
			System.out.println(this.name + "\nest allé au toilet il n'a plus envie d'aller au toilet\n");
			setToiletDesire(0);
			riseDirtyLevel(5);
			riseHungerLevel(5);
			riseTiredness(3);
		} else {
			System.out.println("\nVotre tamagotchi n'as pas envie d'aller au toilet\n");
		}

	}

	public void rest() {

		if (this.dirtLevel >= 60 || this.tiredness < 50 || this.toiletDesire >= 75 || this.hungerLevel >= 65) {

			if (this.dirtLevel >= 60) {
				System.out.println("\nVotre tamagotchi est trop sale pour se reposer");
			} else if (this.tiredness < 50) {
				System.out.println("\nVotre tamagotchi n'est pas assez fatigué pour se reposer");
			} else if (this.toiletDesire >= 75) {
				System.out.println("\nVotre tamagotchi est trop envie d'aller au toilet pour se reposer");
			} else if (this.hungerLevel >= 65) {
				System.out.println("\nVotre tamagotchi a trop faim pour se reposer");
			}

		} else {
			System.out.println(this.name + " c'est bien reposé et est plein d'energie pour tous faire");
			riseHealth(1);
			setTiredness(0);
			riseHungerLevel(15);
			riseToiletDesire(10);
		}

	}

	public void expressMood() {

		if (this.health < 5 || this.tiredness >= 70) {
			System.out.println("Grogne de colere ");
		} else if (this.health == 5 || this.tiredness >= 50) {
			System.out.println("Souris ");
		} else {
			System.out.println("Saute de joie ");
		}

	}

	public void seeFriends() {

		if (this.tiredness < 65 && this.toiletDesire < 50 && this.hungerLevel < 50 && this.dirtLevel < 40) {
			System.out.println("\n" + this.name + " est content d'avoir rendu visite a un ami\n");
			riseHealth(1);
			riseTiredness(20);
			riseToiletDesire(10);
			riseDirtyLevel(30);
			riseHungerLevel(20);
		} else {

			if (this.dirtLevel >= 40) {
				System.out.println("\nVotre tamagotchi est trop sale pour rendre visite a ses amis");
			} else if (this.tiredness >= 65) {
				System.out.println("\nLe tamagotchi est trop fatigué pour rendre visite a un ami\n ");
			} else if (this.toiletDesire >= 50) {
				System.out.println("\nVotre tamagotchi a trop envie d'aller au toilet pour rendre visite a un ami");
			} else if (this.hungerLevel >= 50) {
				System.out.println("\nVotre tamagotchi a trop faim pour rendre visite a un ami");
			}
		}

	}

	public void playSports() {
		if (this.tiredness < 70 && this.toiletDesire < 65 && this.hungerLevel < 70) {
			System.out.println(this.name + " viens de faire du sport  ");
			riseHealth(2);
			riseTiredness(60);
			riseDirtyLevel(60);
			riseHungerLevel(15);
			riseToiletDesire(5);
		} else {
			if (this.tiredness >= 70) {
				System.out.println("\nVotre tamagotchi est tros fatigué pour faire du sport\n");
			} else if (this.toiletDesire >= 65) {
				System.out.println("\nVotre tamagotchi a trop envie d'aller au toilet pour faire du sport");
			} else if (this.hungerLevel >= 50) {
				System.out.println("\nVotre tamagotchi a trop faim pour faire du sport");
			}
		}

	}

	public void takeOffMask() {
		this.masked = false;
		System.out.println("Votre tamagotchi a bien enlevé son masque");
	}

	public void putMask() {
		this.masked = true;
		System.out.println("Votre tamagotchi a bien mis son masque");
	}

	public void wash() {

		if (this.toiletDesire < 50 && this.dirtLevel >= 30) {
			System.out.println("\n" + this.name + " c'est bien laver il est tous propre :)\n");
			setDirtLevel(0);
			riseTiredness(2);
		} else {

			if (this.dirtLevel < 30) {
				System.out.println("\nVotre tamagotchi n'est pas assez sale pour se douché");
			} else if (this.toiletDesire >= 50) {
				System.out.println("\nLe tamagotchi a trop envie d'aller au toilet pour aller se douché \n ");
			}
		}

		System.out.println();

	}

	public void smok() {

		System.out.println("\n" + this.name + " vient de fummer\n");
		riseDirtyLevel(5);
		riseHungerLevel(20);
		if ((this.tamagotchiType.equals("Chat") || this.tamagotchiType.equals("Chien"))) {

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

	public void breed() {
		System.out.println("\nVotre tamagotchi est mort\n");
		setHealth(0);
		System.exit(-1);
	}

	public void die() {

		setHealth(0);
		setDayRemaining(0);
	}
}
