package by.epam.grodno.pronych.compositetext.service;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import by.epam.grodno.pronych.compositetext.entity.Component;
import by.epam.grodno.pronych.compositetext.entity.Composite;

public class CompositeUtils {
    final static Logger logger = Logger.getLogger(TextParser.class);

	public static List<Component> getAllCompositeObjectsByType(Component component, int searchingType){
	    if (logger.isInfoEnabled())	{logger.info("Search objects of type:"+searchingType);}

		List<Component> result = new LinkedList<Component>();
		for(Component componentIterator: component.getAllCompositeObjects()) {
			if (componentIterator.getType() == searchingType) {
				result.add(componentIterator);
			}
		}
		return result;
	}
	
	public static void swapFirstAndLast(Component component){
		if (!(component instanceof Composite)){
			return;
		}
	    if (logger.isInfoEnabled())	{logger.info("Begin swap objects");}
		
		List<Component> componentList = ((Composite) component).getItext();
		
		if (componentList.size() > 1) {
			Component firstObject = componentList.get(0);
			Component lastObject = componentList.get(componentList.size()-1);
			componentList.set(componentList.size()-1, firstObject);
			componentList.set(0, lastObject);
		}
	}
	
}
