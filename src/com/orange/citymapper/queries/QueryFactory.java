package com.orange.citymapper.queries;


public class QueryFactory {
	public static IQuery createQuery(String queryLine){
		IQuery queryObj = null;
		
		if(new ShortestPathQuery().checkCorrectQuery(queryLine))
			queryObj = new ShortestPathQuery();
		
		else if(new CostQuery().checkCorrectQuery(queryLine))
			queryObj = new CostQuery();
		
		else if(new RouteQuery().checkCorrectQuery(queryLine))
			queryObj = new RouteQuery();
		
		else if(new ReachableCitiesAtMostQuery().checkCorrectQuery(queryLine))
			queryObj = new ReachableCitiesAtMostQuery();
		
		return queryObj;
	}

}
