package com.orange.citymapper.queries;

import com.orange.citymapper.data.Graph;

public class CostQuery implements IQuery {

	public boolean checkCorrectQuery(String queryString) {
		return queryString.matches("^What is the Cost of Path (.*)\\?$");
	}

	public String getResult(String queryString, Graph graph) {

		
		return null;
	}

}
