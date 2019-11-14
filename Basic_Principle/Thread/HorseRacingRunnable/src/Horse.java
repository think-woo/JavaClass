
public class Horse implements Runnable {

	// data
	private String strName;
	private int nSpeed; // ���ڰ� �������� ������

	private Thread myThread; // ������ ��ü�� ���� �����ؾ� ��� �����ϴ�

	//
	public Horse(String arg) {
		strName = arg;
		nSpeed = (int) (Math.random() * 1000) + 1;
	}// constructor

	public void start() {
		if (myThread == null) { // �����尡 ���� ���
			myThread = new Thread(this); // �ش� Ŭ������ ������� �������� �Ѵ�
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
		System.out.println(strName + " ����!!!!");

	}// run()

}// Horse class
