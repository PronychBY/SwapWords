package by.epam.grodno.pronych.compositetext.service;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.grodno.pronych.compositetext.entity.Leaf;
import by.epam.grodno.pronych.compositetext.entity.Component;
import by.epam.grodno.pronych.compositetext.entity.Composite;
import org.apache.log4j.Logger;

public class TextParser {
    final static Logger logger = Logger.getLogger(TextParser.class);
	
    public static List<String> getParseText(String textToParse, String regexPattern){
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(textToParse);
        List<String> result = new LinkedList<String>();
        while(matcher.find()) {
        	result.add(matcher.group()); 
        }
    	return result;
    }
    
    public static Component recParse(Component parrentComponent, String text, int level) {
	    if (logger.isInfoEnabled())	{logger.info("Parse test level:"+level);}
	    if (logger.isInfoEnabled())	{logger.info("RegExp:"+ParseLevel.getRegexpByLevel(level));}
	    

    	List<String> resultParagraph = getParseText(text, ParseLevel.getRegexpByLevel(level));
        
        for (String s: resultParagraph) {
        	
        	if (ParseLevel.getNumberOfLevels()-1 > level) {
            	Component newChild = new Composite(level + 1);
        		parrentComponent.add(newChild);
        		if (logger.isDebugEnabled())	{logger.debug("add new child to Composite:"+s);}
        		recParse(newChild, s, level + 1);
        	}
        	else{
            	Component newChild = new Leaf(s, level + 1);
            	if (logger.isDebugEnabled())	{logger.debug("add new Leaf to composite:"+s);}
           		parrentComponent.add(newChild);
        	};
        	
        }
    	
    	return null;
    }
	
	public static Component parse(String path) {
    	String wholeText = FileService.getTextFromFile(path);
    	Component textObject = parseText(wholeText);
        return textObject;
    }	

	public static Component parseText(String text) {
        
    	if (logger.isInfoEnabled())	{logger.info("begin parse test");}
        Component textObject = new Composite(0);
        recParse(textObject, text, 0);
        if (logger.isInfoEnabled())	{logger.info("end of parsing test");}
        
        return textObject;
    }	
	
	
}
