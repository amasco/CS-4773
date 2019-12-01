package main;

public class createCircle {

	public static Circle createCircle(int radius) {
		Circle circleObj = new Circle("Circle", "Blue", 0, 0, radius);
		return circleObj;
	}

}
