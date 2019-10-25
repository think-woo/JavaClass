import java.util.Random;

public class dice {

	public static void main(String[] args) {

		int iFaceValue; // �ֻ��� ��
		int iSum = 0; // ��ü ���� ��
		int iCount = 0; // �ֻ��� ���� Ƚ��

		Random generator = new Random();

		// �˰���
		// 1. iFaceValue
		// 2. iSum+=iFaceValue
		// 3. iCount++
		// 4. iSum>=100�ɶ����� �ݺ�
		// 5. 4�� �ݺ����� 100,000�� �ݺ�
		// 6. ��հ� ���ϱ�

		for (int i = 0; i < 100000; i++, iSum = 0) {
			while (iSum < 100) {
				iFaceValue = generator.nextInt(6) + 1; // 1��
				iSum += iFaceValue; // 2��
				iCount++; // 3��
			} // while 4��
		} // for 5��

		System.out.println("Count >> " + (iCount / 100000.0));

	} // main()

} // dice class
