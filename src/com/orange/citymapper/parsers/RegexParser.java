package com.orange.citymapper.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexParser {

	public static String[] extractVariables(String string, Pattern pattern){
		Matcher matcher = pattern.matcher(string);
		
		matcher.find();
		
		String[] variables = new String[matcher.groupCount()];
		
		for(int i = 1; i <= matcher.groupCount(); i++){
			variables[i-1] = matcher.group(i);
		}
		
		return variables;
	}
}
