
public class HorseRacing {

	public static void main(String arg[]) {

		Thread h1 = new Horse("Thunder"); // �θ� Ŭ������ �ڽ��� ǰ�� �� �ִ�
		Thread h2 = new Horse("Lightening");
		Thread h3 = new Horse("volt");

		h1.start();
		h2.start();
		h3.start();

	}// main()

}// HorseRacing class
