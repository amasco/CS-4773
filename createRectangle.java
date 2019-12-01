package main;

public class createRectangle {

	public static Rectangle createRectangle(int width, int height)
	{
		Rectangle rectangleObj = new Rectangle("Rectangle", "Red", 0, 0, width, height);
		return rectangleObj;
	}

}
