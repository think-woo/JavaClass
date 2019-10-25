
public class Dice {

	// instance data
	private int _faceValue; // 주사위의 값
	// '_'는 멤버변수를 가리킨다 (원래는 m_nFaceValue)
	// 접근지정자를 private로 해서 캡슐화

	// 접근지정자 종류
	// public: 어디서나 접근 가능
	// private: 해당 클래스 내에서만 사용 가능
	// protected: private이긴 한데, 상속관계이면 접근 가능
	// 지정안함(=default): 같은 패키지 내에 있으면 사용 가능 (버전에 따라 다름. 권장X.)

	// method

	// 1.constructor(생성자)
	// constructor의 특징
	// 1) 클래스이름과 동일
	// 2) 리턴타입이 없다

	// constructor 작성 안하면, 컴파일러가 자동으로 default constructor 생성
	public Dice() {
		_faceValue = (int) (Math.random() * 6) + 1; // 1~6
		// 만약 초기화하지 않으면, _faceValue = 0이다
		// 이는 해당 클래스의 상황과 모순이 되므로, 초기화가 필요하다.
	} // default constructor

	public Dice(int arg) {
		_faceValue = (arg > 6 || arg < 1) ? roll() : arg;
	} // parameter constructor

	// constructor overloading 상태
	// parameter는 여러 개 만들어서 편리성을 증가시킬 수 있다.

	// 2. get/set
	// 캡슐화를 통해 데이터를 보호하면, 직접 접근이 불가능하니 이를 가능하게 하는 method가 필요하다
	// accessor / getler / get: 조회
	// mutator / selter / set: 변경
	// 기본적으로 1개의 데이터마다 각 메소드를 1씩 만들어 준다
	public int getFaceValue() {
		return _faceValue;
	}

	public void setFaceValue(int arg) {
		_faceValue = (arg > 6 || arg < 1) ? roll() : arg;
	}

	// 3.functional
	public int roll() {
		_faceValue = (int) (Math.random() * 6) + 1; // 1~6
		return _faceValue;
	} // roll(): 주사위를 굴린다

	// 4.toString
	// 객체는 레퍼런스 타입이기 때문에 그냥 출력시키면 주소값이 나온다
	// toString()를 정의하면, 객체를 출력할 때 해당 문자열이 출력된다
	public String toString() {
		String str = "주사위를 굴릴 수 있습니다. 현재 주사위는 " + _faceValue + "입니다.";
		return str;
	}

} // Dice class
