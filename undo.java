package main;

import java.util.ArrayList;
import java.util.List;

public class undo {

	public static List<List<Shape>> removeFromList(List<List<Shape>> state_list) {
		state_list.remove(state_list.size() - 1);
		return state_list;
		
	}

	public static List<Shape> updateShapeList(List<List<Shape>> state_list, List<Shape> current_shape_list) {
		current_shape_list = new ArrayList<Shape>(state_list.get(state_list.size() - 1));
		return current_shape_list;
	}

	public static Shape updateCurrObject(Shape curr_object, int current_position, List<Shape> current_shape_list) {
		curr_object = current_shape_list.get(current_position);
		return curr_object;
	}

}
