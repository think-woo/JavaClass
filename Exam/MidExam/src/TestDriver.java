
public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BankAccount b1, b2, b3;
		b1 = new BankAccount();
		b2 = new BankAccount("John Smith", "010-1234-5678", 1, 10000, true);

		System.out.println(b1);
		System.out.println(b2);
		System.out.println();

		b1.deposit(1000);
		b2.deposit(1000);
		System.out.println();

		b1.withdraw(1000);
		b2.withdraw(1000);
		b2.withdraw(100001);
		System.out.println();

		b2.addInterest();
		System.out.println();

		b3 = new BankAccount("John Smith", "010-1234-5678", 1, 20000, true);
		System.out.println(b3);
		System.out.println();

		b2.combineAccount(b1);
		b2.combineAccount(b3);
		System.out.println(b3.getDormantAccountWithComment());

	}

}
