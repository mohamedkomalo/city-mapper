package com.orange.citymapper.queries;

import com.orange.citymapper.data.Graph;

public interface IQuery {

	public static final String DEFAULT_WRONGE_QUERY_MESSAGE = "query is wrong sir";
	
	public abstract boolean checkCorrectQuery(String queryString);

	public abstract String getResult(String queryString, Graph graph);

}