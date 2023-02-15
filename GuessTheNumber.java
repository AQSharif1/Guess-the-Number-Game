import java.util.Scanner;

/**
 * Number Guessing Game
 * 
 * Computer generates random integer and user will have 5 chance 
 * to guess the number correctly
 * @author Abdul
 *
 */
public class GuessTheNumber {
	public static Scanner scanner = new Scanner(System.in);
	static int randomNum;
	static boolean quit = false;
	public static void main(String[] args) {
		System.out.println("WELCOME TO THE GAME");
		userName();	
		beginGame();
	}

	/**
	 * Obtain user name
	 */
	public static void userName() {
		String name;
		System.out.println("Enter Name");
		name =scanner.nextLine();
		System.out.println("Hello " + name);
	}

	/**
	 * Asks if user is ready to start game
	 * @return choice of user
	 */
	public static int startGame() {
		int choice;
		System.out.println("\nDo you wish to start the game?");
		System.out.println("1 ---> Start Game\n2---> Not yet\n3---> Quit Game");
		choice = scanner.nextInt();
		scanner.nextLine();
		return choice;
	}

	/**
	 * The User begins to play game
	 * @param randomNum
	 */
	public static void playGame(int randomNum) {
		int choice;
		int count = 0;
		int guess = 0;
		while(guess != randomNum && count < 5 ) {
			System.out.println("Pick a number from 1-10");
			guess = scanner.nextInt();
			count++;
			if(guess == randomNum) {
				System.out.println("Congratulations You Won!! \n" + guess + " is the correct number!");
			}
			else if(guess > randomNum) {
				System.out.println("Lower!");
			}
			else if(guess < randomNum) {
				System.out.println("Higher!");
			}else
				System.out.println("You lose correct number was " + randomNum);

		}
		System.out.println("\nPlay again? \n1---> Play Again \n2---> Stop Playing");
		choice = scanner.nextInt();
		if(choice == 1) {
			beginGame();
		}
		else if(choice == 2) {
			System.out.println("Goodbye");
		}
	}

	/**
	 * The game begins
	 */
	public static void beginGame() {
		while(!quit) {
			switch(startGame()){

			case 1:
				System.out.println("Game started\nGenerating Random number");
				randomNum = (int) ((Math.random() *10) +1);
				playGame(randomNum);
				quit = true;
				break;

			case 2:
				System.out.println("Not ready yet....");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Ready?");
				break;

			case 3: 
				System.out.println("Goodbye!");
				quit = true;
				break;
			default:
				startGame();
				break;
			}
		}
	}
}
