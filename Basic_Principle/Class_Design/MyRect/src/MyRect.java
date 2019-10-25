
public class MyRect {
	// instance data
	private int _x, _y; // 좌표
	private int _width, _height; // 너비,높이

	// method
	// 1.constructor
	public MyRect() {
		_x = _y = 0;
		_width = _height = 0;
	}

	public MyRect(int x, int y, int w, int h) {
		_x = x;
		_y = y;
		_width = (w < 0) ? 0 : w;
		_height = (h < 0) ? 0 : h;
	}

	// 2.get/set
	public int getX() {
		return _x;
	}

	public int getY() {
		return _y;
	}

	public int getWidth() {
		return _width;
	}

	public int getHeight() {
		return _height;
	}

	public void setX(int x) {
		_x = x;
	}

	public void setY(int y) {
		_y = y;
	}

	public void setWidth(int w) {
		_width = (w < 0) ? 0 : w;
	}

	public void setHeight(int h) {
		_height = (h < 0) ? 0 : h;
	}

	public void setPosition(int x, int y) {
		_x = x;
		_y = y;
	}

	public void setSize(int width, int height) {
		_width = (width < 0) ? 0 : width;
		_height = (height < 0) ? 0 : height;
	}

	public void setBounds(int x, int y, int w, int h) {
		_x = x;
		_y = y;
		_width = (w < 0) ? 0 : w;
		_height = (h < 0) ? 0 : h;
	}

	// 3.functional
	public int getArea() {
		return _width * _height;
	}// getArea(): 사각형의 넓이를 구한다

	public String compare(MyRect rect) {
		int compare = getArea() - rect.getArea();
		String result;

		if (compare > 0)
			result = "해당 사각형의 넓이가 더 넓습니다.";
		else if (compare == 0)
			result = "두 사각형의 넓이가 같습니다.";
		else
			result = "해당 사각형의 넓이가 더 작습니다.";

		return result + " 넓이의 차이는 " + compare + "입니다.";

	}// compare(): 사각형의 넓이를 비교한다

	// 4.toString
	public String toString() {
		String str = "해당 사각형의 좌표: (" + _x + "," + _y + ") / 길이 (" + _width + "," + _height + ")";
		return str;
	}

} // MyRect class
