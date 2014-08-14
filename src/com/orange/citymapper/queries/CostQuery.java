package com.orange.citymapper.queries;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.orange.citymapper.data.City;
import com.orange.citymapper.data.Graph;

public class CostQuery implements IQuery {

	String QUERY_REGEXP_PATTERN="^What is the Cost of Path (.*)\\?$";
	@Override
	public boolean checkCorrectQuery(String queryString) {
		return queryString.matches(QUERY_REGEXP_PATTERN);
	}

	@Override
	public String getResult(String queryString, Graph graph) {
		
		
		return null;
	}

	public List<String> extractCities(String queryString) {
	
		Pattern queryPattern = Pattern.compile(QUERY_REGEXP_PATTERN);
		Matcher matcher = queryPattern.matcher(queryString);
		
		matcher.find();
		List<String> cities= new ArrayList<String>();
		for(int i=0 ;i<matcher.groupCount();i++){
			String city = matcher.group(i);
			cities.add(city);
		}		
		
		return cities;
	}

}
