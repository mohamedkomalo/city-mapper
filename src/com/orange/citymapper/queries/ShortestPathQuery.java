package com.orange.citymapper.queries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.orange.citymapper.data.Graph;

public class ShortestPathQuery {

	private static final int DEST_NUMBER = 2;
	private static final int SOURCE_NUMBER = 1;
	private static final String QUERY_REGEXP_PATTERN = "^What is the shortest path between City (\\S+) to City (\\S+)\\?$";

	public boolean checkCorrectQuery(String queryString) {
		return queryString.matches(QUERY_REGEXP_PATTERN);
	}

	public String getResult(String string, Graph graph) {
		Pattern queryPattern = Pattern.compile(QUERY_REGEXP_PATTERN);
		Matcher matcher = queryPattern.matcher(string);
		
		matcher.find();
		String sourceCity = string.substring(matcher.regionStart(), matcher.regionEnd());
		
		matcher.find();
		String destinationCity = string.substring(matcher.regionStart(), matcher.regionEnd());
				
		return null;
	}

	public String getSource(String string) {
		return  extractCity(string, SOURCE_NUMBER);
	}

	public String getDestination(String string) {
		return extractCity(string, DEST_NUMBER);
	}

	/**
	 * @param queryString
	 * @param cityNumber TODO
	 * @return
	 */
	private String extractCity(String queryString, int cityNumber) {
		Pattern queryPattern = Pattern.compile(QUERY_REGEXP_PATTERN);
		Matcher matcher = queryPattern.matcher(queryString);
		
		matcher.find();
		
		String destination = matcher.group(cityNumber);
		return destination;
	}

}
