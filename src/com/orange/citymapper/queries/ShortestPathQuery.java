package com.orange.citymapper.queries;

import com.orange.citymapper.data.Graph;

public class ShortestPathQuery {

	public boolean checkCorrectQuery(String queryString) {
		return queryString.matches("^What is the shortest path between City (\\S+) to City (\\S+)\\?$");
	}

	public String getResult(String string, Graph graph) {
		return null;
	}

}
