
public class Horse extends Thread {

	// data
	private String strHorseName;
	private int nSpeed; // 숫자가 작을수록 빠르다

	// method
	public Horse(String arg) {
		strHorseName = arg;
		nSpeed = (int) (Math.random() * 1000) + 1;
	}// constructor

	public void run() {
		try {
			sleep(nSpeed);
		} catch (Exception e) {

		}
		System.out.println(strHorseName + " 도착!!!");
	}// run()

}// Horse class
