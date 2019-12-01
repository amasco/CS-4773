package main;

public class move {

	public static Shape moveShape(Shape curr_object, int x, int y) {
		curr_object.x = x;
		curr_object.y = y;
		return curr_object;
	}

}
