package main;

import java.util.List;

public class setColor {

	public static Shape color(List<String> color_list, String choice, Shape curr_object) {
		String color =  choice.toString();
		if(!color_list.contains(color))
			System.out.println("Invalid color");
		else
			curr_object.color = color;
		return curr_object;
	}

}
