package com.orange.citymapper.queries;

import com.orange.citymapper.data.Graph;

public class RouteQuery implements IQuery {

	@Override
	public boolean checkCorrectQuery(String queryString)  {
		return queryString.matches("^Give me route between (\\S+) to (\\S+)\\?$");
	}

	@Override
	public String getResult(String string, Graph graph) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
