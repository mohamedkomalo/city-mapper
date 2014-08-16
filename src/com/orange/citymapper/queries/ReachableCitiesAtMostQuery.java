package com.orange.citymapper.queries;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.orange.citymapper.data.Graph;
import com.orange.citymapper.graph.algorithms.ReachableNodesDetector;
import com.orange.citymapper.parsers.CollectionToStringConverter;
import com.orange.citymapper.parsers.RegexParser;

public class ReachableCitiesAtMostQuery implements IQuery {

	private static final String QUERY_REGEX = "[Ww]hat are the reachable cities from (\\S+) using (\\d+) Edges at Most\\?";
	
	private static final Pattern QUERY_REGEX_PATTERN = Pattern.compile(QUERY_REGEX);
	
	private static final String REACHABLE_CITIES_FROM_CITY_USING_EDGE = "The reachable cities from %s using %d Edges at Most";
	private static final String USING_EDGE_CITIES = "Using %d Edge: %s";
	private static final String USING_EDGES_CITIES = "Using %d Edges: %s";


	private static final int SOURCE_CITY = 0;
	private static final int AT_MOST_EDGES = 1;

	@Override
	public boolean checkCorrectQuery(String queryString) {
		return queryString.matches(QUERY_REGEX);
	}

	@Override
	public String getResult(String queryString, Graph graph) {
		String[] queryVariables = RegexParser.extractVariables(queryString, QUERY_REGEX_PATTERN);

		String sourceCity = queryVariables[SOURCE_CITY];
		int noOfEdges = Integer.valueOf(queryVariables[AT_MOST_EDGES]);

		ReachableNodesDetector detector = new ReachableNodesDetector();

		List<List<String>> allReachableCities;
		
		allReachableCities = detector.getReachableNodesWithinEdges(graph.getAdjacenceyMap(),
																   sourceCity,
																   noOfEdges);

		StringBuilder result = new StringBuilder();

		result.append(String.format(REACHABLE_CITIES_FROM_CITY_USING_EDGE, sourceCity, noOfEdges));
		result.append('\n');

		for (int edgesUsed = 1; edgesUsed < allReachableCities.size(); edgesUsed++) {

			List<String> reachableCities = allReachableCities.get(edgesUsed);
			
			String reachableCitiesStr = new CollectionToStringConverter().convert(reachableCities, ' ');
			
			String format = USING_EDGES_CITIES;
			
			if(edgesUsed == 1)
				format = USING_EDGE_CITIES;
			
			String currentLine = String.format(format, edgesUsed, reachableCitiesStr);
			
			result.append(currentLine);
			
			if(edgesUsed != allReachableCities.size()-1)
				result.append('\n');

		}

		return result.toString();
	}
}
