package com.orange.citymapper.data;

import org.junit.Assert;
import org.junit.Test;

import com.orange.citymapper.data.City;
import com.orange.citymapper.data.Edge;
import com.orange.citymapper.data.Graph;

public class GraphTest {

	@Test
	public void testAddEdge(){
		Graph g = new Graph();
		Edge edge = new Edge(new City("Cairo"), new City("Alex"), 100);
		
		g.addEdge(edge);
		
		Assert.assertEquals(g.getEdge("Cairo", "Alex"), edge);	
	}
	
	@Test
	public void testGetEdgeWithIvalidCities(){
		Graph g = new Graph();
		
		Assert.assertNull(g.getEdge("Cairo", "Alex"));	
	}
	
	
	
	
	
	
}
