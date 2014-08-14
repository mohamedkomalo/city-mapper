package com.orange.citymapper.queries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.orange.citymapper.data.Graph;
import com.orange.citymapper.shortestpath.Dikstra;
import com.orange.citymapper.shortestpath.Dikstra.Path;

public class ShortestPathQuery {

	private static final int DEST_NUMBER = 2;
	private static final int SOURCE_NUMBER = 1;
	private static final String QUERY_REGEXP_PATTERN = "^[Ww]hat is the shortest path between (\\S+) to (\\S+)\\?$";

	public boolean checkCorrectQuery(String queryString) {
		return queryString.matches(QUERY_REGEXP_PATTERN);
	}

	public String getResult(String queryString, Graph graph) {
		String sourceCity = getSource(queryString);
		String destinationCity = getDestination(queryString);
		
		Dikstra dikstra = new Dikstra();
		Path result = dikstra.getShortestPath(graph.getAdjacenceyMap(), sourceCity, destinationCity);
				
		String resultFormat = "The shortest path between %s to %s is %d";
		
		String resultMessage; 
		if(result == null){
			resultMessage = "The query is wronge sir";
		}
		else{
			resultMessage = String.format(resultFormat, sourceCity, destinationCity, result.getCost());
		}
			
		return resultMessage;
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
