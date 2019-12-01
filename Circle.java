package main;

public class Circle extends Shape{
	
	int radius;
	
	public Circle(String type, String color, int x, int y, int radius) 
	{
		super(type, color, x, y);
		this.radius = radius;
	}
	
	public String toString()
	{
		return super.toString() + "Radius: " + radius;
 	}
	

}