package com.orange.citymapper.queries;

import static org.junit.Assert.*;

import org.junit.Test;

public class RouteQueryTests {

	@Test
	public void testRouteQueryWithValidCities() {
		RouteQuery routeQuery = new RouteQuery();
		
		boolean result = routeQuery.checkCorrectQuery("Give me route between Alexandria to Sinai?");
		
		assertTrue(result);
		}
	@Test
	public void testRouteQueryWihInvalidQuerySyntax() {
		CostQuery costQuery = new CostQuery();
		
		boolean result = costQuery.checkCorrectQuery("In the sea there are fishes");
		
		assertFalse(result);
		}
//	@Test
//	public void testGetResult(){
//		RouteQuery routeQuery = new RouteQuery();
//		
//		Graph graph = new Graph();
//		City cairo = new City("Cairo"),
//			 alexendria = new City("Alexendria"),
//			 tanta = new City("Tanta"),
//			 kenna = new City("Kenna"),
//			 sinai = new City("Sinai");
//		
//		graph.addEdge(new Edge(cairo, alexendria, 200));
//		graph.addEdge(new Edge(cairo, tanta, 500));
//		graph.addEdge(new Edge(alexendria, kenna, 100));
//		graph.addEdge(new Edge(alexendria, sinai, 700));
//		graph.addEdge(new Edge(kenna, tanta, 100));
//		graph.addEdge(new Edge(tanta, kenna, 100));
//		graph.addEdge(new Edge(tanta, sinai, 300));
//	
//		String queryResult = routeQuery.getResult("Give me route between Alexandria to Sinai?", graph);
//		assertEquals("Alexandria Kenna Tanta Sinai", queryResult);
//		
//	}

}
