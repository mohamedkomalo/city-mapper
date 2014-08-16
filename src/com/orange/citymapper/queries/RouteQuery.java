package com.orange.citymapper.queries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.orange.citymapper.data.Graph;
import com.orange.citymapper.graph.algorithms.Dikstra;
import com.orange.citymapper.graph.algorithms.Dikstra.Path;
import com.orange.citymapper.parsers.CollectionToStringConverter;
import com.orange.citymapper.parsers.RegexParser;

public class RouteQuery implements IQuery {

	private static final String WRONG_QUERY_MESSAGE = IQuery.DEFAULT_WRONGE_QUERY_MESSAGE;
	
	private static final String QUERY_REGEX = "^Give me route between (\\S+) to (\\S+)\\?$";
	
	private static Pattern QUERY_REGEX_PATTERN = Pattern.compile(QUERY_REGEX);

	private static final int SOURCE_CITY = 0;
	
	private static final int DESTINATION_CITY = 1;
	
	@Override
	public boolean checkCorrectQuery(String queryString)  {
		return queryString.matches(QUERY_REGEX);
	}

	@Override
	public String getResult(String query, Graph graph) {
		String[] queryVariables = RegexParser.extractVariables(query, QUERY_REGEX_PATTERN);
		
		String sourceCity = queryVariables[SOURCE_CITY],
			   destinationCity = queryVariables[DESTINATION_CITY];
		
		Dikstra dikstra = new Dikstra();
		Path shortestPath = dikstra.getShortestPath(graph.getAdjacenceyMap(), sourceCity, destinationCity);
		
		if(shortestPath != null){
			String route = new CollectionToStringConverter().convert(shortestPath.getNodes(), ' ');
		
			return route;	
		}
		
		return WRONG_QUERY_MESSAGE;
	}
}
