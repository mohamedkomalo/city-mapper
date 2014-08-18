package com.orange.citymapper.queries;

import static org.junit.Assert.*;

import org.junit.Test;

import com.orange.citymapper.data.City;
import com.orange.citymapper.data.Edge;
import com.orange.citymapper.data.Graph;
import com.orange.citymapper.queries.ShortestPathQuery;

public class ShortestPathQueryTest {

	@Test
	public void testCheckCorrectQueryWihValidQuerySyntax() {
		IQuery shortestPathQuery = new ShortestPathQuery();
		
		boolean result = shortestPathQuery.checkCorrectQuery("What is the shortest path between Cairo to Kenna?");
		
		assertTrue(result);
	}
	
	@Test
	public void testCheckCorrectQueryWihInvalidQuerySyntax() {
		IQuery shortestPathQuery = new ShortestPathQuery();
		
		boolean result = shortestPathQuery.checkCorrectQuery("In the sea there are fishes");
		
		assertFalse(result);
	}
	
	@Test
	public void testGetResult(){
		IQuery shortestPathQuery = new ShortestPathQuery();
		
		Graph graph = new Graph();
		City cairo = new City("Cairo"),
			 alexendria = new City("Alexendria"),
			 tanta = new City("Tanta"),
			 kenna = new City("Kenna"),
			 sinai = new City("Sinai");
		
		graph.addEdge(new Edge(cairo, alexendria, 200));
		graph.addEdge(new Edge(cairo, tanta, 500));
		graph.addEdge(new Edge(alexendria, kenna, 100));
		graph.addEdge(new Edge(alexendria, sinai, 700));
		graph.addEdge(new Edge(kenna, tanta, 100));
		graph.addEdge(new Edge(tanta, kenna, 100));
		graph.addEdge(new Edge(tanta, sinai, 300));

		assertEquals("The shortest path between Cairo to Kenna is 300",
					 shortestPathQuery.getResult("What is the shortest path between Cairo to Kenna?", graph));
		
		assertEquals("The shortest path between Cairo to Sinai is 700",
					 shortestPathQuery.getResult("What is the shortest path between Cairo to Sinai?", graph));
		
	}

}
