
public class BankAccount {
	// 인스턴스 데이터
	private String strName; // 이름
	private String strPhoneNumber; // 연락처
	private int nAccountNumber; // 계좌번호
	private int nBalance; // 계좌잔액
	private boolean bDormantAccount; // 계좌의 휴먼상태
	private final double RATE = 0.02; // 이율

	// 1.생성자
	BankAccount(String name, String phoneNumber, int accountNumber, int balance, boolean dormantAccount) {
		strName = name;
		strPhoneNumber = phoneNumber;
		nAccountNumber = (999999 >= accountNumber && 100000 <= accountNumber) ? accountNumber : makeAccount();
		nBalance = balance;
		bDormantAccount = dormantAccount;
	}

	BankAccount() {
		this(null, null, 0, 0, false);
	}

	// 2.get/set
	public String getName() {
		return strName;
	}

	public String getPhoneNumber() {
		return strPhoneNumber;
	}

	public int getAccountNumber() {
		return nAccountNumber;
	}

	public int getBalance() {
		return nBalance;
	}

	public boolean getDormantAccount() {

		return bDormantAccount;
	}

	public String getDormantAccountWithComment() {
		if (bDormantAccount) {
			return "활성계좌";
		} else {
			return "휴먼계좌";
		}
	}

	public double getRATE() {
		return RATE;
	}

	public void setName(String name) {
		strName = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		strPhoneNumber = phoneNumber;
	}

	public void setAccountNumber(int accountNumber) {
		nAccountNumber = (999999 >= accountNumber && 100000 <= accountNumber) ? accountNumber : makeAccount();
	}

	public void setBalance(int balance) {
		nBalance = balance;
	}

	public void setDormantAccount(boolean dormantAccount) {
		bDormantAccount = dormantAccount;
	}

	// 3.toString
	public String toString() {
		String s = "이름: " + strName + ", 계좌번호: " + nAccountNumber;
		return s;
	}

	// 4.functional

	// 계좌번호 생성
	public int makeAccount() {
		if (strName != null) {
			return (int) (Math.random() * 90000) + 10000;
		} else {
			return 0;
		}

	}

	// 입금
	public void deposit(int cash) {
		if (!bDormantAccount) {
			System.out.println("휴먼상태의 계좌입니다.");
			return;
		}

		nBalance += cash;
		System.out.println("현재 잔액은 " + nBalance + "입니다.");

	}

	// 출금
	public void withdraw(int cash) {
		if (!bDormantAccount) {
			System.out.println("휴먼상태의 계좌입니다.");
			return;
		}

		if (nBalance - cash < 0) {
			System.out.println("인출할 수 없습니다");
			System.out.println("현재잔액: " + nBalance);
		} else {
			nBalance -= cash;
			System.out.println("현재 잔액은 " + nBalance + "입니다.");
		}

	}

	// 이자율에 따른 금액 계산
	public void addInterest() {
		if (!bDormantAccount) {
			System.out.println("휴먼상태의 계좌입니다.");
			return;
		}

		double result = (double) nBalance + (double) nBalance * RATE;
		System.out.println("이자율에 따른 계좌 금액: " + (int) result);
	}

	// 계좌 합성
	public void combineAccount(BankAccount account) {

		if (!bDormantAccount) {
			System.out.println("휴먼상태의 계좌입니다.");
			return;
		}

		if (!account.getDormantAccount()) {
			System.out.println("합치려는 계좌가 휴먼상태입니다");
			return;
		}

		account.setDormantAccount(false);

		nBalance += account.getBalance();
		System.out.println("현재 잔액은 " + nBalance + "입니다.");
	}

	// 계좌정보를 반환
	public String accountInfo() {
		return getName() + ", " + getAccountNumber();
	}

	public String accountInfoSpecific() {
		if (getDormantAccount()) {
			return accountInfo() + ", \\" + getBalance();
		} else {
			return accountInfo() + ", \\" + getBalance() + ", " + getDormantAccountWithComment();
		}
	}

} // BankAccount class
