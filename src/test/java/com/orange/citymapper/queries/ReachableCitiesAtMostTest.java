package com.orange.citymapper.queries;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.orange.citymapper.data.City;
import com.orange.citymapper.data.Edge;
import com.orange.citymapper.data.Graph;

public class ReachableCitiesAtMostTest {

	@Test
	public void testCheckCorrectQuery() {
		ReachableCitiesAtMostQuery reachableCitiesQuery = new ReachableCitiesAtMostQuery();

		boolean result = reachableCitiesQuery.checkCorrectQuery("What are the reachable cities from Cairo using 2 Edges at Most?");

		assertTrue(result);
	}

	@Test
	public void testGetResult(){
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
		
		ReachableCitiesAtMostQuery reachableCitiesQuery = new ReachableCitiesAtMostQuery();
		assertEquals("The reachable cities from Cairo using 2 Edges at Most\nUsing 1 Edge: Alexendria Tanta\nUsing 2 Edges: Sinai Kenna",
					reachableCitiesQuery.getResult("What are the reachable cities from Cairo using 2 Edges at Most?", graph));
	}

}


