package main;

public class Shape implements Cloneable{
	
	String type;
	String color;
	int x;
	int y;
	public Shape curr_object;
	
	public Shape(String type, String color, int x, int y) 
	{
		this.type = type;
		this.color = color;
		this.x = x;
		this.y = y;
	}


	public Shape(Shape curr_object) {
		this.curr_object = curr_object;
	}


	public Shape clone()throws CloneNotSupportedException{  
		return (Shape)super.clone();  
	   }
	
	
	public String getType() 
	{
		return type;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public int getCoordinateX() 
	{
		return x;
	}
	
	public int getCoordinateY() 
	{
		return y;
	}
	
	@Override
	public String toString()
	{
		return type + ", Color: " + color + ", " + "Origin: " + "(" + x + "," + y + "), ";
	}
	
}
