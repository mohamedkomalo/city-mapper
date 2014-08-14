package com.orange.citymapper.queries;

import com.orange.citymapper.data.Graph;

public class ReachableCitiesAtMostQuery  implements IQuery {

	public boolean checkCorrectQuery(String queryString) {
		return queryString.matches("^What are the reachable cities from (\\S+) using (\\d+) Edges at Most\\?$");
	}

	@Override
	public String getResult(String queryString, Graph graph) {
		// TODO Auto-generated method stub
		return null;
	}

}
