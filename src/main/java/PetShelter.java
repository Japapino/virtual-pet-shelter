import java.util.Map;
import java.util.Map.Entry;
import java.util.Collection;
import java.util.HashMap;

public class PetShelter {

	private Map<String, VirtualPet> petShelter = new HashMap<String, VirtualPet>();

	public void PetShelter() {
		
	}

	public void addPet(VirtualPet pet) {
		petShelter.put(pet.name,pet);
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
		for(Entry<String, VirtualPet> entry: petShelter.entrySet()) {
			entry.getValue().giveFood();
		}

		
	}

}
