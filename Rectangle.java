package main;

public class Rectangle extends Shape{
	
	int height;
	int width;
	
	public Rectangle(String type, String color, int x, int y, int width, int height) 
	{
		super(type, color, x, y);
		this.height = height;
		this.width = width;
	}
	
	public String toString()
	{
		return super.toString() + "Width: " + width + ", Height: " + height;
 	}
	

}
