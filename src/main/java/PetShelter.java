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
		System.out.println("Name    |Hunger  |Thirst  |Boredom ");
		System.out.println("--------|--------|--------|--------");
		for(Entry<String, VirtualPet> entry: petShelter.entrySet()) {
			System.out.print(entry.getValue().getName()+"   |");
			System.out.print(entry.getValue().getHunger()+"       |");
			System.out.print(entry.getValue().getThirst()+"       |");
			System.out.println(entry.getValue().getBoredom()+"       |");
		}
	}
	
	public Set<String> listNames() {
		Set<String> petsNames = petShelter.keySet(); 
		return petsNames;
	}

}
