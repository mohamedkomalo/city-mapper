package com.orange.citymapper.queries;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.orange.citymapper.data.Graph;
import com.orange.citymapper.graph.algorithms.ReachableNodesDetector;

public class ReachableCitiesAtMostQuery  implements IQuery {

	private static final String QUERY_REGEXP_PATTERN = "^What are the reachable cities from (\\S+) using (\\d+) Edges at Most\\?$";

	@Override
	public boolean checkCorrectQuery(String queryString) {
		return queryString.matches(QUERY_REGEXP_PATTERN);
	}

	@Override
	public String getResult(String queryString, Graph graph) {
		ReachableNodesDetector detector = new ReachableNodesDetector();
		List<List<String>> p = detector.getReachableNodesWithinEdges(graph.getAdjacenceyMap(), getSource(queryString), getEdges(queryString));
		String query = String.format("The reachable cities from %s using %d Edges at Most\n", getSource(queryString), getEdges(queryString));

		for(int edge=1; edge<p.size(); edge++){
			List<String> reachableEdges = p.get(edge);
		
			if(edge == 1)
				query += "Using " + edge + " Edge: " + reachableEdges.toString().replace("[", "").replace("]", "").replace(", ", " ") + '\n';
			
			else if(edge == p.size()-1)
				query += "Using " + edge + " Edges: " + reachableEdges.toString().replace("[", "").replace("]", "").replace(", ", " ");
			
			else
				query += "Using " + edge + " Edges: " + reachableEdges.toString().replace("[", "").replace("]", "").replace(", ", " ") + '\n';
		}
		return query;
	}
	
	public String getSource(String string) {
		return  extractCity(string, 1);
	}
	
	public int getEdges(String string) {
		return  Integer.valueOf(extractCity(string, 2));
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
