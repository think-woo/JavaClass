import java.awt.Point;

public class RectData {

	// data
	public Point pt1, pt2;
	public boolean bFill;

	// method
	public RectData() {
		pt1 = new Point();
		pt2 = new Point();
		bFill = false;
	}// constructor 1

	public RectData(RectData obj) {
		pt1 = obj.pt1;
		pt2 = obj.pt2;
		bFill = obj.bFill;
	}// constructor 2

}// RectData class
