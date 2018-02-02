
public class VirtualPet {
	// default stats
	private int health;
	private int hunger;
	private int boredom;
	private int thirst;
	private int waste;
	String name;
	String description;

	// constructor
	public VirtualPet(String nameInput, String description) {
		this.name = nameInput;
		this.description = description;
		health = 100;
		hunger = 1;
		boredom = 1;
		thirst = 1;
		waste = 2;
	}

	public VirtualPet(String name, String description, int hunger, int thirst, int health) {
		this.name = name;
		this.description = description;
		this.health = health;
		this.hunger = hunger;
		this.boredom = 0;
		this.thirst = thirst;
		waste = 0;
	}

	// methods
	public String name() {
		return name;
	}

	public void checkStats() {
		if (this.health > 100) {
			this.health = 100;
		}
		if (this.hunger <= 0) {
			this.hunger = 0;
		}
		if (this.boredom <= 0) {
			this.boredom = 0;
		}
		if (this.thirst <= 0) {
			this.thirst = 0;
		}
		if (this.waste <= 0) {
			this.waste = 0;
		}
	}

	public void tickIncrease() {
		health -= 1;
		hunger += 2;
		boredom += 5;
		thirst += 1;
		waste += 3;
		this.checkStats();
	}

	public void giveTreat() {
		thirst += 3;
		hunger -= 1;
		health -= 3;
		waste += 5;
		this.checkStats();
	}

	public void play() {
		hunger += 10;
		health += 5;
		boredom -= 10;
		thirst += 10;
		this.checkStats();
	}

	public void giveWater() {
		hunger -= 3;
		thirst -= 10;
		boredom += 5;
		waste += 3;
		this.checkStats();
	}

	public void giveFood() {
		hunger -= 10;
		health -= 2;
		thirst += 3;
		waste += 5;
		this.checkStats();
	}

	public void cleanUp() {
		waste = 0;
		boredom += 20;

	}

	// getters
	public String getName() {
		return this.name;
	}

	public int checkWaste() {
		return waste;
	}

	public int getHealth() {
		return health;
	}

	public int getHunger() {
		return hunger;
	}

	public int getBoredom() {
		return boredom;
	}

	public int getThirst() {
		return thirst;
	}

	public String getStats() {
		return "Hunger: " + this.getHunger() + "\nHealth: " + this.getHealth() + "\nThirst: " + this.getThirst()
				+ "\nWaste: " + this.checkWaste();

	}

}
