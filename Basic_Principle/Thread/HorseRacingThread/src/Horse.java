
public class Horse extends Thread {

	// data
	private String strHorseName;
	private int nSpeed; // ���ڰ� �������� ������

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
		System.out.println(strHorseName + " ����!!!");
	}// run()

}// Horse class
