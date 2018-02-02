

import java.util.Scanner;

public class virtualPetApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPet pet = new VirtualPet();
		int tick = 0;
		String userResponse = "";
		System.out.println("Welcome to your all new virtual pet!");
		System.out.println("    /\\_____/\\\r\n" + "   /  o   o  \\\r\n" + "  ( ==  ^  == )\r\n" + "   )         (\r\n"
				+ "  (           )\r\n" + " ( (  )   (  ) )\r\n" + "(__(__)___(__)__)");
		System.out.println("What is his name?");
		userResponse = input.nextLine();
		pet.setName(userResponse);
		System.out.println(pet.getName() + "'s stats are: ");
		System.out.println(pet.getStats());

		while (!userResponse.equalsIgnoreCase("quit")) {
			System.out.println("Current tick: " + tick);

			System.out.println("What would you like to do? Your options are:"
					+ "\n1. Feed \n2. Give water \n3. Play \n4. Clean Up \n5. Get Status");
			userResponse = input.nextLine().toLowerCase();

			if (userResponse.equals("1") || (userResponse.equals("feed"))) {
				System.out.println("How much would you like to feed him?");
				System.out.println("1. Treat");
				System.out.println("2. Fill food bowl");
				userResponse = input.nextLine().toLowerCase();

				if (userResponse.equals("1") || (userResponse.equals("Treat"))) {
					pet.giveTreat();
				} else {
					pet.giveFood();
				}
			}

			if (userResponse.equals("2")) {
				pet.giveWater();
				System.out.println(pet.getStats());
			}

			if (userResponse.equals("3")) {
				pet.play();
				System.out.println(pet.getStats());

			}

			if (userResponse.equals("4")) {
				pet.cleanUp();
				System.out.println(pet.getStats());

			}

			if (userResponse.equals("5")) {
				System.out.println(pet.getStats());

			}
			pet.tickIncrease();
		}

		System.out.println("End of day status:");
		System.out.println(pet.getStats());
		System.out.println("Good bye forever.");
		System.exit(0);

	}
}
