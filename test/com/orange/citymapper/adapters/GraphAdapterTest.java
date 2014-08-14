package com.orange.citymapper.adapters;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.orange.citymapper.data.City;
import com.orange.citymapper.data.Edge;
import com.orange.citymapper.data.Graph;
import com.orange.citymapper.queries.IQuery;
import com.orange.citymapper.queries.ShortestPathQuery;
import com.orange.citymapper.shortestpath.Dikstra;

public class GraphAdapterTest {

	@Test
	public void testGraphAdapter(){
		Graph normalGraph = new Graph();
		City cairo = new City("Cairo"),
			 alexandria = new City("Alexandria"),
			 tanta = new City("Tanta"),
			 kenna = new City("Kenna"),
			 sinai = new City("Sinai");
		
		normalGraph.addEdge(new Edge(cairo, alexandria, 200));
		normalGraph.addEdge(new Edge(cairo, tanta, 500));
		normalGraph.addEdge(new Edge(alexandria, kenna, 100));
		normalGraph.addEdge(new Edge(alexandria, sinai, 700));
		normalGraph.addEdge(new Edge(kenna, tanta, 100));
		normalGraph.addEdge(new Edge(tanta, kenna, 100));
		normalGraph.addEdge(new Edge(tanta, sinai, 300));
		
		Map<String, Map<String, Integer>> convertedGraph = normalGraph.getAdjacenceyMap();

		Map<String, Map<String, Integer>> expectedGraph = new HashMap<>();
		expectedGraph.put("Cairo", new HashMap<String, Integer>());
		expectedGraph.put("Tanta", new HashMap<String, Integer>());
		expectedGraph.put("Kenna", new HashMap<String, Integer>());
		expectedGraph.put("Sinai", new HashMap<String, Integer>());
		expectedGraph.put("Alexandria", new HashMap<String, Integer>());
		
		expectedGraph.get("Cairo").put("Alexandria",200);
		expectedGraph.get("Cairo").put("Tanta",500);
		expectedGraph.get("Alexandria").put("Kenna",100);
		expectedGraph.get("Alexandria").put("Sinai",700);
		expectedGraph.get("Kenna").put("Tanta",100);
		expectedGraph.get("Tanta").put("Kenna",100);
		expectedGraph.get("Tanta").put("Sinai",300);

		Assert.assertEquals(expectedGraph.get("Cairo"), convertedGraph.get("Cairo"));		
		Assert.assertEquals(expectedGraph.get("Alexandria"), convertedGraph.get("Alexandria"));
		Assert.assertEquals(expectedGraph.get("Kenna"), convertedGraph.get("Kenna"));
		Assert.assertEquals(expectedGraph.get("Sinai"), convertedGraph.get("Sinai"));
		Assert.assertEquals(expectedGraph.get("Tanta"), convertedGraph.get("Tanta"));
	}

	@Test
	public void testGraphAdapterWithDikstra(){
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
	
		Dikstra dikstra = new Dikstra();
		
		assertEquals(300,
					dikstra.getShortestPath(graph.getAdjacenceyMap(),"Cairo","Kenna").getCost());
		
	}
	
}
