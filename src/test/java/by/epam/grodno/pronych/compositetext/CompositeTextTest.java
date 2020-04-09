package by.epam.grodno.pronych.compositetext;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import by.epam.grodno.pronych.compositetext.entity.Component;
import by.epam.grodno.pronych.compositetext.service.CompositeUtils;
import by.epam.grodno.pronych.compositetext.service.TextParser;


public class CompositeTextTest {
	
	@Test
	public void testSwapFirstAndLastWord() {
    	String testText = "	Do you enjoy reading stories? In this section, read our entertaining stories.";
    	Component text = TextParser.parseText(testText);
        
    	List<Component> componentList = CompositeUtils.getAllCompositeObjectsByType(text, 2);
        for(Component component: componentList) {
        	CompositeUtils.swapFirstAndLast(component);
        }
        
    	String resultTestText = "stories?you enjoy reading Do stories.this section, read our entertaining In ";
		
		Assert.assertEquals(text.getData(), resultTestText);
	}

}
