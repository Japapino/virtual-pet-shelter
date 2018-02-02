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

}
