package com.orange.citymapper.queries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.orange.citymapper.data.City;
import com.orange.citymapper.data.Graph;
import com.orange.citymapper.graph.algorithms.PathCostCalculator;
import com.orange.citymapper.parsers.RegexParser;

public class CostQuery implements IQuery {

	private static final String QUERY_REGEX = "What is the Cost of Path (.*)\\?";
	
	private static final Pattern QUERY_REGEX_PATTERN = Pattern.compile(QUERY_REGEX);

	private static final String THE_COST_OF_PATH_IS = "The Cost of Path %s is %d";
	private static final int ALL_CITIES = 0;
	
	@Override
	public boolean checkCorrectQuery(String queryString) {
		return queryString.matches(QUERY_REGEX);
	}

	@Override
	public String getResult(String queryString, Graph graph) {
		PathCostCalculator pathCostCalculator = new PathCostCalculator();
		
		String[] queryVariables = new RegexParser().extractVariables(queryString, QUERY_REGEX_PATTERN);
		
		String allCities = queryVariables[ALL_CITIES];
		
		List<String> cities = Arrays.asList(allCities.split(" "));
		
		long cost = pathCostCalculator.calculatePathCost(graph.getAdjacenceyMap(), cities);
		
		if(cost == -1)
			return DEFAULT_WRONGE_QUERY_MESSAGE;
		
		return String.format(THE_COST_OF_PATH_IS, allCities, cost);
	}
}
