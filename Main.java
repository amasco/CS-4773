package main;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main( String []args){
		List<String> color_list = new ArrayList<String>();
		List < List<Shape> > draw_history_list = new ArrayList < List<Shape>>();
		Shape curr_shape = null;
		List<Shape> draw_list = new ArrayList<Shape>();
		List<Shape> current_draw_list = new ArrayList<Shape>();
		int current_position = 0;
		
		//add valid colors to list
		color_list.add("Red");
		color_list.add("Blue");
		color_list.add("Yellow");
		color_list.add("Orange");
		color_list.add("Green");

		try {
			Stream<String> lines = Files.lines(Paths.get("input.txt"));
			List<String> content = lines.collect(Collectors.toList());
			
			for(int i = 0; i < content.size(); i++)
			{			
				String sub = content.get(i);
				String[] choice = sub.split(" ", 4);
				
				current_draw_list = new ArrayList<Shape>(current_draw_list);
				
				if(choice[0].equals("CREATE"))
				{
					if(choice[1].equals("RECTANGLE"))
					{
						int width = Integer.parseInt(choice[2]);
						int height = Integer.parseInt(choice[3]);					
						Rectangle rectangleObj = createRectangle.createRectangle(width, height);
						current_draw_list.add(rectangleObj);
					}
					else if(choice[1].equals("CIRCLE"))
					{
						int radius = Integer.parseInt(choice[2]);
						Circle circleObj = createCircle.createCircle(radius);
						current_draw_list.add(circleObj);
					}
				}
				else if(choice[0].equals("SELECT"))
				{
					current_position = (Integer.parseInt(choice[1]) - 1);
					if(current_position >= current_draw_list.size())
					{
						System.out.println("ERROR: invalid  shape for SELECT");
					}
					else
					{					
						curr_shape = select.select(current_draw_list, current_position, curr_shape);
					}
				}
				else if(choice[0].equals("MOVE"))
				{
					int x = Integer.parseInt(choice[1]);
					int y = Integer.parseInt(choice[2]);
					curr_shape = move.moveShape(curr_shape, x, y);
					current_draw_list.set(current_position, curr_shape);
				}
				else if(choice[0].equals("DRAW"))
				{
					draw.drawObject(curr_shape);
				}
				else if(choice[0].equals("COLOR"))
				{
					curr_shape = setColor.color(color_list, choice[1], curr_shape);
					current_draw_list.set(current_position, curr_shape);
				}
				else if(choice[0].equals("DELETE"))
				{
					delete.deleteObject(current_draw_list, curr_shape);
				}
				else if(choice[0].equals("DRAWSCENE"))
				{
					draw.drawScene(current_draw_list);
				}
				else if(choice[0].equals("UNDO"))
				{
					draw_history_list = undo.removeFromList(draw_history_list);
					current_draw_list = undo.updateShapeList(draw_history_list, current_draw_list);
					curr_shape = undo.updateCurrObject(curr_shape, current_position, current_draw_list);
					continue;
				}
				else
				{
					System.out.println("Invalid Input");
				}
				
				draw_list = copyList(current_draw_list);
				draw_history_list.add(draw_list);				
			}
			
		}	
		catch(IOException e)
		{
			System.err.format("IOException: %s%n", e);			
		}
	}

	public static List<Shape> copyList(List<Shape> list)
	{
		List<Shape> copy = new ArrayList<Shape>(list.size());
		for(Shape element: list)
			try 
			{
				copy.add(element.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		return copy;
	}
}

