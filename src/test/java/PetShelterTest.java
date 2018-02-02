import static java.math.BigDecimal.ZERO;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class PetShelterTest {
	private PetShelter underTest; 
	private VirtualPet pet; 
	private static final String petDescription = "VPET";
	private static final String petName = "TEST";
	
	
	@Before
	public void setup() {
		//arrange
		underTest = new PetShelter();
		pet = new VirtualPet(petName, petDescription); 

	}
	
	@Test
	public void shouldAddVirtualPet() {
		underTest.addPet(pet); 
		VirtualPet retrieved = underTest.findPet(petName);
		assertThat(retrieved, is(pet));
	}
	
	@Test
	public void shouldBeAbletoAddMultiplePets() {
		//arrange
		String anotherPetName = "TEST2";
		VirtualPet anotherPet = new VirtualPet(anotherPetName, petName); 
		
		//act
		underTest.addPet(pet);
		underTest.addPet(anotherPet);
		
		//assert
		Collection<VirtualPet> pets = underTest.allPets();
		
		//using matchers
		assertThat(pets, containsInAnyOrder(pet, anotherPet));
	
		//using assertEquals/True
		assertTrue(pets.contains(pet));
		assertTrue(pets.contains(anotherPet));
		assertEquals(2, pets.size()); 		
		
	}
	
	@Test 
	public void shouldRemoveAPet() {
		underTest.addPet(pet);
		underTest.adopt(petName);
		
		VirtualPet found = underTest.findPet(petName);
		assertThat(found, is(nullValue()));
	}
	
	@Test
	public void hungerShouldReduce() {
		pet.play();
		pet.play();
		pet.giveFood();
		int check = pet.getHunger();
		assertEquals(10, check);
	}
	@Test
	public void hungerShouldReduceForBoth() {
		String anotherPetName = "TEST2";
		VirtualPet anotherPet = new VirtualPet(anotherPetName, petName); 
		underTest.addPet(pet);
		underTest.addPet(anotherPet);
		pet.play();
		pet.play();
		anotherPet.play();
		anotherPet.play();
		underTest.feedAll();
		int check = pet.getHunger();
		int check1 = anotherPet.getHunger();
		assertEquals(10, check);
		assertEquals(10, check1);
	}
	
	@Test
	public void boredomShouldGoDown() {
		pet.cleanUp();
		pet.play();
		int check = pet.getBoredom();
		assertEquals(10, check);
	}
	
	@Test
	public void statsShouldChangeOverTimeForAllPets() {
		String anotherPetName = "TEST2";
		VirtualPet anotherPet = new VirtualPet(anotherPetName, petName); 
		underTest.addPet(pet);
		underTest.addPet(anotherPet);
		underTest.tickIncreaseAll();
		int check = pet.checkWaste();
		int check1 = anotherPet.checkWaste();
		assertEquals(3,check);
		assertEquals(3,check1);
		
	}
	

}
