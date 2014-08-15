package com.orange.citymapper.queries;

import static org.junit.Assert.*;

import org.junit.Test;

import com.orange.citymapper.data.City;
import com.orange.citymapper.data.Edge;
import com.orange.citymapper.data.Graph;

public class RouteQueryTests {

	private static final String KENNA_NAME = "Kenna";
	private static final String SINAI_NAME = "Sinai";
	private static final String TANTA_NAME = "Tanta";
	private static final String ALEXENDRIA_NAME = "Alexendria";
	private static final String CAIRO_NAME = "Cairo";

	@Test
	public void testRouteQueryWithValidCities() {
		RouteQuery routeQuery = new RouteQuery();

		boolean result = routeQuery.checkCorrectQuery("Give me route between Alexandria to Sinai?");

		assertTrue(result);
	}

	@Test
	public void testRouteQueryWihInvalidQuerySyntax() {
		RouteQuery costQuery = new RouteQuery();

		boolean result = costQuery.checkCorrectQuery("In the sea there are fishes");

		assertFalse(result);
	}

	@Test
	public void testGetResult(){
		RouteQuery routeQuery = new RouteQuery();

		Graph graph = new Graph();
		City cairo = new City(CAIRO_NAME),
				alexendria = new City(ALEXENDRIA_NAME),
				tanta = new City(TANTA_NAME),
				kenna = new City(KENNA_NAME),
				sinai = new City(SINAI_NAME);

		graph.addEdge(new Edge(cairo, alexendria, 200));
		graph.addEdge(new Edge(cairo, tanta, 500));
		graph.addEdge(new Edge(alexendria, kenna, 100));
		graph.addEdge(new Edge(alexendria, sinai, 700));
		graph.addEdge(new Edge(kenna, tanta, 100));
		graph.addEdge(new Edge(tanta, kenna, 100));
		graph.addEdge(new Edge(tanta, sinai, 300));

		String queryResult = routeQuery.getResult(String.format("Give me route between %s to %s?", ALEXENDRIA_NAME, TANTA_NAME), graph);
		assertEquals(String.format("%s %s %s", ALEXENDRIA_NAME, KENNA_NAME, TANTA_NAME), queryResult);

	}

}
