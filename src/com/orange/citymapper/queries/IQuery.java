package com.orange.citymapper.queries;

import com.orange.citymapper.data.Graph;

public interface IQuery {

	public abstract boolean checkCorrectQuery(String queryString);

	public abstract String getResult(String queryString, Graph graph);

}