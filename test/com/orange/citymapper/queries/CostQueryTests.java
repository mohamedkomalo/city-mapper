package com.orange.citymapper.queries;

import static org.junit.Assert.*;

import org.junit.Test;

public class CostQueryTests {

	@Test
	public void testCostQueryWithValidMultipleCities() {
		CostQuery costQuery = new CostQuery();

		boolean result = costQuery.checkCorrectQuery("What is the Cost of Path Cairo Sinai Tanta?");

		assertTrue(result);
	}
	@Test
	public void testCostQueryWithValidTwoCities() {
		CostQuery costQuery = new CostQuery();

		boolean result = costQuery.checkCorrectQuery("What is the Cost of Path Sinai Tanta?");

		assertTrue(result);
	}
	
	@Test
	public void testCostQueryWihInvalidQuerySyntax() {
		CostQuery costQuery = new CostQuery();

		boolean result = costQuery.checkCorrectQuery("In the sea there are fishes");

		assertFalse(result);
	}
	
	//	@Test
	//	public void testGetResult(){
	//		CostQuery costQuery = new CostQuery();
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
	//		String queryResult = costQuery.getResult("What is the Cost of Path Cairo Sinai Tanta?", graph);
	//		assertEquals("The Cost of Path Cairo Tanta Sinai is 800 ", queryResult);
	//		
	//	}

}

