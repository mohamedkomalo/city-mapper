package com.orange.citymapper.queries;

public class ReachableCitiesAtMostQuery {

	public boolean checkCorrectQuery(String queryString) {
		return queryString.matches("^What are the reachable cities from (\\S+) using (\\d+) Edges at Most\\?$");
	}

}
