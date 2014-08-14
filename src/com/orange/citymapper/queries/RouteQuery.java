package com.orange.citymapper.queries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.orange.citymapper.data.Graph;
import com.orange.citymapper.shortestpath.Dikstra;
import com.orange.citymapper.shortestpath.Dikstra.Path;

public class RouteQuery implements IQuery {

	private static final String QUERY_REGEXP_PATTERN = "^Give me route between (\\S+) to (\\S+)\\?$";
	/* TODO: replace numbers with group names and use a good naming for the variable
	 * and extract getSource and getDest in a class of their own
	 */
	private static final int DEST_NUMBER = 2;
	private static final int SOURCE_NUMBER = 1;
	
	@Override
	public boolean checkCorrectQuery(String queryString)  {
		return queryString.matches(QUERY_REGEXP_PATTERN);
	}

	@Override
	public String getResult(String query, Graph graph) {
		String source = getSource(query),
			   destination = getDestination(query);
		
		Dikstra dikstra = new Dikstra();
		Path resultPath = dikstra.getShortestPath(graph.getAdjacenceyMap(), source, destination);
		String result;

		if(resultPath != null){
			result = resultPath.getNodes().toString();
			result = result.replaceAll("\\[", "");
			result = result.replaceAll("\\]", "");
			result = result.replaceAll(", ", " ");
		}
		else
			result = "query is wrong sir";
		
		/*
		 *  TODO replacing using regex
		 *  and extract the Query is wrong message in the IQuery interfce
		 */
		
		return result;
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
