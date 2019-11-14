import java.awt.Color;
import java.awt.Point;

public class OvalData {

	// data
	public Point pt;
	public int nSize;
	public Color col;

	// method
	public OvalData() {
		pt = new Point();
		nSize = 40;
		col = Color.pink;
	}// constructor 1

	public OvalData(OvalData obj) {
		pt = obj.pt;
		nSize = obj.nSize;
		col = obj.col;
	}// constructor 2

}// DrawData class
