package main;

import java.util.List;

public class select {

	public static Shape select(List<Shape> current_shape_list, int current_position, Shape curr_object) {
		curr_object = current_shape_list.get(current_position);
		return curr_object;
	}

}
