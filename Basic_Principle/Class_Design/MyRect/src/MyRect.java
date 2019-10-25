
public class MyRect {
	// instance data
	private int _x, _y; // ��ǥ
	private int _width, _height; // �ʺ�,����

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
	}// getArea(): �簢���� ���̸� ���Ѵ�

	public String compare(MyRect rect) {
		int compare = getArea() - rect.getArea();
		String result;

		if (compare > 0)
			result = "�ش� �簢���� ���̰� �� �н��ϴ�.";
		else if (compare == 0)
			result = "�� �簢���� ���̰� �����ϴ�.";
		else
			result = "�ش� �簢���� ���̰� �� �۽��ϴ�.";

		return result + " ������ ���̴� " + compare + "�Դϴ�.";

	}// compare(): �簢���� ���̸� ���Ѵ�

	// 4.toString
	public String toString() {
		String str = "�ش� �簢���� ��ǥ: (" + _x + "," + _y + ") / ���� (" + _width + "," + _height + ")";
		return str;
	}

} // MyRect class
