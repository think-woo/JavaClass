
public class Horse implements Runnable {

	// data
	private String strName;
	private int nSpeed; // 숫자가 작을수록 빠르다

	private Thread myThread; // 쓰레드 객체를 따로 선언해야 사용 가능하다

	//
	public Horse(String arg) {
		strName = arg;
		nSpeed = (int) (Math.random() * 1000) + 1;
	}// constructor

	public void start() {
		if (myThread == null) { // 쓰레드가 없는 경우
			myThread = new Thread(this); // 해당 클래스를 쓰레드로 만들어줘야 한다
		}
		myThread.start();
	}// start()

	public void stop() {
		if (myThread != null) {
			myThread.stop();
		}
	}// stop()

	public void run() {
		try {
			myThread.sleep(nSpeed);
		} catch (Exception e) {
		}
		System.out.println(strName + " 도착!!!!");

	}// run()

}// Horse class
