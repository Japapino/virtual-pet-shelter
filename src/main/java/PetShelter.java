import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;

public class PetShelter {

	private Map<String, VirtualPet> inhabitants = new HashMap<String, VirtualPet>();

	public void addPet(VirtualPet pet) {
		inhabitants.put(pet.name, pet);
	}

	public VirtualPet findPet(String name) {
		return inhabitants.get(name);
	}

	public Collection<VirtualPet> allPets() {
		return inhabitants.values();
	}

	public void adopt(String petName) {
		inhabitants.remove(petName);
	}

	public void feedAll() {
		for (Entry<String, VirtualPet> entry : inhabitants.entrySet()) {
			entry.getValue().giveFood();
		}
	}

	public void waterAll() {
		for (Entry<String, VirtualPet> entry : inhabitants.entrySet()) {
			entry.getValue().giveWater();
		}
	}

	public void playWith(String name) {
		inhabitants.get(name).play();

	}

	public void tickIncreaseAll() {
		for (Entry<String, VirtualPet> entry : inhabitants.entrySet()) {
			entry.getValue().tickIncrease();
		}
	}

	public void listStatsAll() {
		System.out.print("Name\t");
		System.out.print("|Hunger\t");
		System.out.print("|Thirst\t");
		System.out.print("|Boredom");
		System.out.println("|Waste\t");
		System.out.println("--------|-------|-------|-------|-------");
		for (Entry<String, VirtualPet> entry : inhabitants.entrySet()) {
			System.out.print(entry.getValue().getName() + "\t");
			System.out.print("|" + entry.getValue().getHunger() + "\t");
			System.out.print("|" + entry.getValue().getThirst() + "\t");
			System.out.print("|" + entry.getValue().getBoredom() + "\t");
			System.out.println("|" + entry.getValue().checkWaste() + "\t");
		}
		System.out.println("--------|-------|-------|-------|------");
	}

	public Set<String> listNames() {
		Set<String> petsNames = inhabitants.keySet();
		return petsNames;
	}

	public boolean checkForPet(String name) {
		return inhabitants.containsKey(name);
	}

	public void cleanHabitats() {
		for (Entry<String, VirtualPet> entry : inhabitants.entrySet()) {
			entry.getValue().cleanUp();
			;
		}
	}

	public void giveTreatTo(String response) {
		inhabitants.get(response).giveTreat();
	}

	public String cleanliness() {
		String needsCleaning = "";
		for(VirtualPet pet: inhabitants.values()) {
			if (pet.poopCheck() >= 1) {
				needsCleaning += pet.getName() + " ";
			}
		}
		
		return needsCleaning;
	}

}
