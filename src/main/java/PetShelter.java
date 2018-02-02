import java.util.Map;
import java.util.HashMap;

public class PetShelter {
	private String petName;

	private Map<String, VirtualPet> petShelter = new HashMap<String, VirtualPet>();

	public void PetShelter() {
		
	}

	public void addPet(VirtualPet pet) {
		// TODO Auto-generated method stub
		petShelter.put(pet.name,pet);
	}

	public VirtualPet findPet(String name) {
		// TODO Auto-generated method stub
		return petShelter.get(name);
	}

}
