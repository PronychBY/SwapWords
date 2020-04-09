package by.epam.grodno.pronych.compositetext;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import by.epam.grodno.pronych.compositetext.entity.Component;
import by.epam.grodno.pronych.compositetext.service.CompositeUtils;
import by.epam.grodno.pronych.compositetext.service.TextParser;

public class App 
{

	public static void main( String[] args )
    {
	    ResourceBundle myResources = ResourceBundle.getBundle("MyResources", Locale.ENGLISH);
	    String pathToFile = myResources.getString("PathToFile");
		
		Component text = TextParser.parse(pathToFile);
        List<Component> componentList = CompositeUtils.getAllCompositeObjectsByType(text, 2);
        for(Component component: componentList) {
        	CompositeUtils.swapFirstAndLast(component);
        }
        
        System.out.println(text.getData());
    }
}
