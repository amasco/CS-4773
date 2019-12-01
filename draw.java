package main;

import java.util.List;

public class draw {

	public static void drawObject(Shape curr_object) {
		System.out.println(curr_object);		
	}

	public static void drawScene(List<Shape> current_shape_list) {
		for(Shape element: current_shape_list)
			System.out.println(element);
		
	}

}
