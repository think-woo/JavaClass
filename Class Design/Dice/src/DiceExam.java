//Ŭ������ �׽�Ʈ�ϱ� ���� ����̹� Ŭ����
public class DiceExam {
	public static void main(String[] args) {

		Dice d1, d2;

		d1 = new Dice();
		d2 = new Dice(100);

		System.out.println(d1.getFaceValue());
		System.out.println(d2.getFaceValue());
		System.out.println();

		d1.setFaceValue(100);

		System.out.println(d1.getFaceValue());
		System.out.println(d2.getFaceValue());
		System.out.println();

		System.out.println(d1);
		System.out.println(d2);

	}// main()
}// DiceExam class
