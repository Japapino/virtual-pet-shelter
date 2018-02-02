import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;

public class PetShelter {

	private Map<String, VirtualPet> petShelter = new HashMap<String, VirtualPet>();

	public void PetShelter() {

	}

	public void addPet(VirtualPet pet) {
		petShelter.put(pet.name, pet);
	}

	public VirtualPet findPet(String name) {
		return petShelter.get(name);
	}

	public Collection<VirtualPet> allPets() {
		return petShelter.values();
	}

	public void adopt(String petName) {
		petShelter.remove(petName);
	}

	public void feedAll() {
		for (Entry<String, VirtualPet> entry : petShelter.entrySet()) {
			entry.getValue().giveFood();
		}
	}

	public void waterAll() {
		for (Entry<String, VirtualPet> entry : petShelter.entrySet()) {
			entry.getValue().giveWater();
		}
	}

	public void playWith(String name) {
		petShelter.get(name).play();

	}

	public void tickIncreaseAll() {
		for (Entry<String, VirtualPet> entry : petShelter.entrySet()) {
			entry.getValue().tickIncrease();
		}
	}

	public void listStatsAll() {
		System.out.print("Name\t");
		System.out.print("|Hunger\t");
		System.out.print("|Thirst\t");
		System.out.println("|Boredom\t");
		System.out.println("--------|-------|-------|-------");
		for (Entry<String, VirtualPet> entry : petShelter.entrySet()) {
			System.out.print(entry.getValue().getName() + "\t");
			System.out.print("|"+entry.getValue().getHunger() + "\t");
			System.out.print("|"+entry.getValue().getThirst() + "\t");
			System.out.println("|"+entry.getValue().getBoredom() + "\t");
		}
	}

	public Set<String> listNames() {
		Set<String> petsNames = petShelter.keySet();
		return petsNames;
	}

	public boolean checkForPet(String name) {
		return petShelter.containsKey(name);
	}

}
