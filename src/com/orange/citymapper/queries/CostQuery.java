package com.orange.citymapper.queries;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.orange.citymapper.data.City;
import com.orange.citymapper.data.Graph;
import com.orange.citymapper.parsers.RegexParser;

public class CostQuery implements IQuery {

	private static final String QUERY_REGEX = "What is the Cost of Path (.*)\\?";
	
	private static final Pattern QUERY_REGEX_PATTERN = Pattern.compile(QUERY_REGEX);

	private static final int ALL_CITIES = 0;
	
	@Override
	public boolean checkCorrectQuery(String queryString) {
		return queryString.matches(QUERY_REGEX);
	}

	@Override
	public String getResult(String queryString, Graph graph) {
		
		
		return null;
	}

	public String[] extractCities(String queryString) {
		String[] queryVariables = new RegexParser().extractVariables(queryString, QUERY_REGEX_PATTERN);
		
		return queryVariables[ALL_CITIES].split(" ");
	}

}
