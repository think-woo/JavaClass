import java.util.Scanner;

public class ThreeSixNine {
	public static void main(String[] args) {
		Scanner answer = new Scanner(System.in); // Scanner class

		int num;

		System.out.print("Input a number between 1 and 99 >> ");
		num = answer.nextInt();

		while (num > 0) {
			if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
				System.out.print("Clap");
			} // if()
			num /= 10;
		} // while()

	}// main()
}// ThreeSixNine class
