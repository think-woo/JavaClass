
public class Dice {

	// instance data
	private int _faceValue; // �ֻ����� ��
	// '_'�� ��������� ����Ų�� (������ m_nFaceValue)
	// ���������ڸ� private�� �ؼ� ĸ��ȭ

	// ���������� ����
	// public: ��𼭳� ���� ����
	// private: �ش� Ŭ���� �������� ��� ����
	// protected: private�̱� �ѵ�, ��Ӱ����̸� ���� ����
	// ��������(=default): ���� ��Ű�� ���� ������ ��� ���� (������ ���� �ٸ�. ����X.)

	// method

	// 1.constructor(������)
	// constructor�� Ư¡
	// 1) Ŭ�����̸��� ����
	// 2) ����Ÿ���� ����

	// constructor �ۼ� ���ϸ�, �����Ϸ��� �ڵ����� default constructor ����
	public Dice() {
		_faceValue = (int) (Math.random() * 6) + 1; // 1~6
		// ���� �ʱ�ȭ���� ������, _faceValue = 0�̴�
		// �̴� �ش� Ŭ������ ��Ȳ�� ����� �ǹǷ�, �ʱ�ȭ�� �ʿ��ϴ�.
	} // default constructor

	public Dice(int arg) {
		_faceValue = (arg > 6 || arg < 1) ? roll() : arg;
	} // parameter constructor

	// constructor overloading ����
	// parameter�� ���� �� ���� ������ ������ų �� �ִ�.

	// 2. get/set
	// ĸ��ȭ�� ���� �����͸� ��ȣ�ϸ�, ���� ������ �Ұ����ϴ� �̸� �����ϰ� �ϴ� method�� �ʿ��ϴ�
	// accessor / getler / get: ��ȸ
	// mutator / selter / set: ����
	// �⺻������ 1���� �����͸��� �� �޼ҵ带 1�� ����� �ش�
	public int getFaceValue() {
		return _faceValue;
	}

	public void setFaceValue(int arg) {
		_faceValue = (arg > 6 || arg < 1) ? roll() : arg;
	}

	// 3.functional
	public int roll() {
		_faceValue = (int) (Math.random() * 6) + 1; // 1~6
		return _faceValue;
	} // roll(): �ֻ����� ������

	// 4.toString
	// ��ü�� ���۷��� Ÿ���̱� ������ �׳� ��½�Ű�� �ּҰ��� ���´�
	// toString()�� �����ϸ�, ��ü�� ����� �� �ش� ���ڿ��� ��µȴ�
	public String toString() {
		String str = "�ֻ����� ���� �� �ֽ��ϴ�. ���� �ֻ����� " + _faceValue + "�Դϴ�.";
		return str;
	}

} // Dice class
