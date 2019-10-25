
public class MyRectExam {
	public static void main(String[] args) {
		MyRect r1, r2;

		r1 = new MyRect();
		r2 = new MyRect(10, 10, 40, 80);

		System.out.println(r1);
		System.out.println(r2);
		System.out.println();

		r1.setPosition(20, 20);
		r1.setSize(70, 50);

		System.out.println(r1);
		System.out.println(r2);
		System.out.println();

		System.out.println(r1.compare(r2));

	}

}// MyRectExam class
