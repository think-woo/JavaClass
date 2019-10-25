import java.util.Random;

public class dice {

	public static void main(String[] args) {

		int iFaceValue; // 주사위 값
		int iSum = 0; // 전체 합한 값
		int iCount = 0; // 주사위 돌린 횟수

		Random generator = new Random();

		// 알고리즘
		// 1. iFaceValue
		// 2. iSum+=iFaceValue
		// 3. iCount++
		// 4. iSum>=100될때까지 반복
		// 5. 4번 반복문은 100,000번 반복
		// 6. 평균값 구하기

		for (int i = 0; i < 100000; i++, iSum = 0) {
			while (iSum < 100) {
				iFaceValue = generator.nextInt(6) + 1; // 1번
				iSum += iFaceValue; // 2번
				iCount++; // 3번
			} // while 4번
		} // for 5번

		System.out.println("Count >> " + (iCount / 100000.0));

	} // main()

} // dice class
