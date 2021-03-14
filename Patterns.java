import java.util.Scanner;

public class Patterns {
	public static void main(String[] args) {

		// no. of lines.
		int N;

		Scanner sc = new Scanner(System.in);

		// for choosing one pattern
		int choice;

		// for repeating the task
		char again;

		System.out.println("What pattern you want to print........");
		System.out.println("For STARS pattern press enter 1.");
		System.out.println("For ALPHABATE pattern press enter 2.");

		do {

			System.out.println("Enter the number of lines");
			N = sc.nextInt();

			System.out.println("Enter the choice");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				printPattern1(N);
				break;
			case 2:
				printPattern2(N);
				break;
			default:
				System.out.println("invalid input");
			}

			System.out.println("Do you want to perform again,press 'y' for yes or 'n' for no");
			again = sc.next().charAt(0);

		} while (again == 'y' || again == 'Y');

	}

	private static void printPattern1(int N) {

		// copying numbers of lines
		int line = N;

		// reducing "line" variable by one at every iteration for maintaining spaces
		for (int i = 1; i <= N; i++, line--) {
			//
			// printing spaces before the "*"
			for (int j = 1; j < line; j++)
				System.out.print(" ");

			// printing "*" and a space after every "*"
			for (int j = 0; j < i; j++)
				System.out.print("* ");

			// finally moving cursor in next line
			System.out.println();
		}
	}

	private static void printPattern2(int N) {
		// copying numbers of lines
		int line = N - 1;

		// initial character
		char character = 'A';

		// reducing "line" variable by two at every iteration for maintaining spaces
		for (int i = 1; i <= N; i++, line--) {
			//
			// printing spaces before the "*"
			for (int j = 0; j < line * 2; j++)
				System.out.print(" ");

			// printing "*" and a space after every "*"
			for (int j = 0; j < i; j++)
			{
				System.out.print(character++ + " ");
				
				//when we have number of lines > 6,we have to initialize again with 'A'
				//for well structured pattern. Otherwise we will get different types of 
				//character in pattern.
				if(character=='Z')
					character='A';
			}

			// finally moving cursor in next line
			System.out.println();
		}
	}

}
