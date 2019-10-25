
public class BankAccount {
	// �ν��Ͻ� ������
	private String strName; // �̸�
	private String strPhoneNumber; // ����ó
	private int nAccountNumber; // ���¹�ȣ
	private int nBalance; // �����ܾ�
	private boolean bDormantAccount; // ������ �޸ջ���
	private final double RATE = 0.02; // ����

	// 1.������
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
			return "Ȱ������";
		} else {
			return "�޸հ���";
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
		String s = "�̸�: " + strName + ", ���¹�ȣ: " + nAccountNumber;
		return s;
	}

	// 4.functional

	// ���¹�ȣ ����
	public int makeAccount() {
		if (strName != null) {
			return (int) (Math.random() * 90000) + 10000;
		} else {
			return 0;
		}

	}

	// �Ա�
	public void deposit(int cash) {
		if (!bDormantAccount) {
			System.out.println("�޸ջ����� �����Դϴ�.");
			return;
		}

		nBalance += cash;
		System.out.println("���� �ܾ��� " + nBalance + "�Դϴ�.");

	}

	// ���
	public void withdraw(int cash) {
		if (!bDormantAccount) {
			System.out.println("�޸ջ����� �����Դϴ�.");
			return;
		}

		if (nBalance - cash < 0) {
			System.out.println("������ �� �����ϴ�");
			System.out.println("�����ܾ�: " + nBalance);
		} else {
			nBalance -= cash;
			System.out.println("���� �ܾ��� " + nBalance + "�Դϴ�.");
		}

	}

	// �������� ���� �ݾ� ���
	public void addInterest() {
		if (!bDormantAccount) {
			System.out.println("�޸ջ����� �����Դϴ�.");
			return;
		}

		double result = (double) nBalance + (double) nBalance * RATE;
		System.out.println("�������� ���� ���� �ݾ�: " + (int) result);
	}

	// ���� �ռ�
	public void combineAccount(BankAccount account) {

		if (!bDormantAccount) {
			System.out.println("�޸ջ����� �����Դϴ�.");
			return;
		}

		if (!account.getDormantAccount()) {
			System.out.println("��ġ���� ���°� �޸ջ����Դϴ�");
			return;
		}

		account.setDormantAccount(false);

		nBalance += account.getBalance();
		System.out.println("���� �ܾ��� " + nBalance + "�Դϴ�.");
	}

	// ���������� ��ȯ
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
