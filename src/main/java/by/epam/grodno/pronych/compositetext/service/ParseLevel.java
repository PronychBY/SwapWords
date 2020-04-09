package by.epam.grodno.pronych.compositetext.service;

import java.util.ArrayList;
import java.util.List;

public class ParseLevel {
	private static final String REGEX_PARAGRAPH = "\\t+([^\\t]+)";
	private static final String REGEX_SENTENCE = "[^\\.|!|\\?]+(\\.|!|\\?)";
	private static final String REGEX_WORD = "([^(\\s\\t)]+)(\\s)*";
	private static final String REGEX_SYMBOL = ".{1}";

	private static List<String> regexpOfParse = new ArrayList<String>();
	
	static{
		regexpOfParse.add(REGEX_PARAGRAPH);
		regexpOfParse.add(REGEX_SENTENCE);
		regexpOfParse.add(REGEX_WORD);
		regexpOfParse.add(REGEX_SYMBOL);
	}
	
	public static String getRegexpByLevel(int level) {
		return regexpOfParse.get(level);
	}
	public static int getNumberOfLevels() {
		return regexpOfParse.size();
	}
	
}
