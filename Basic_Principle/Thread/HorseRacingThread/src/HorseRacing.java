
public class HorseRacing {

	public static void main(String arg[]) {

		Thread h1 = new Horse("Thunder"); // 부모 클래스는 자식을 품을 수 있다
		Thread h2 = new Horse("Lightening");
		Thread h3 = new Horse("volt");

		h1.start();
		h2.start();
		h3.start();

	}// main()

}// HorseRacing class
