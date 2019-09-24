import java.util.Scanner;

public class RockPaperScissors {
	public static void main(String[] args) {
		Scanner onesAnswer = new Scanner(System.in); // Scanner class
		Fight onesFight = new Fight(); // Fight class

		String smith; // smith's answer
		String jane; // jane's answer

		System.out.print("Smith >> ");
		smith = onesAnswer.next();
		System.out.print("Jane >> ");
		jane = onesAnswer.next();

		if (onesFight.result(smith, jane) == 1) {
			System.out.println("Smith is Win!!");
		} else if (onesFight.result(smith, jane) == 0) {
			System.out.println("Draw");
		} else {
			System.out.println("Jane is Win!!");
		}

	} // main()
} // RockPaperScissors class
