import java.awt.BasicStroke;
import java.awt.Point;

public class LineData {

	// data
	public Point pt1, pt2;
	public BasicStroke stroke;

	// method
	public LineData() {
		pt1 = new Point();
		pt2 = new Point();
		stroke = new BasicStroke(1);
	}// constructor 1

	public LineData(LineData obj) {
		pt1 = obj.pt1;
		pt2 = obj.pt2;
		stroke = obj.stroke;
	}// constructor 2

}// LineData class
