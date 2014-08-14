package com.orange.citymapper.graph.algorithms;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.orange.citymapper.graph.algorithms.Dikstra;

public class DikstraTest {

	@Test
	public void testGetShortestPathWithValidPath() {
		Map<String, Map<String, Integer>> graph = new HashMap<>();
		graph.put("Cairo", new HashMap<String, Integer>());
		graph.put("Tanta", new HashMap<String, Integer>());
		graph.put("Kenna", new HashMap<String, Integer>());
		graph.put("Sinai", new HashMap<String, Integer>());
		graph.put("Alexandria", new HashMap<String, Integer>());
		
		graph.get("Cairo").put("Alexandria",200);
		graph.get("Cairo").put("Tanta",500);
		graph.get("Alexandria").put("Kenna",100);
		graph.get("Alexandria").put("Sinai",700);
		graph.get("Kenna").put("Tanta",100);
		graph.get("Tanta").put("Kenna",100);
		graph.get("Tanta").put("Sinai",300);
		
		Dikstra dikstra = new Dikstra();

		assertEquals(200, dikstra.getShortestPath(graph, "Cairo", "Alexandria").getCost());
		assertEquals(500, dikstra.getShortestPath(graph, "Alexandria", "Sinai").getCost());
	}
	
	@Test
	public void testGetShortestPathWithInvalidPath() {
		Map<String, Map<String, Integer>> graph = new HashMap<>();
		graph.put("Cairo", new HashMap<String, Integer>());
		graph.put("Tanta", new HashMap<String, Integer>());
		graph.put("Kenna", new HashMap<String, Integer>());
		graph.put("Sinai", new HashMap<String, Integer>());
		graph.put("Alexandria", new HashMap<String, Integer>());
		
		graph.get("Cairo").put("Alexandria",200);
		graph.get("Cairo").put("Tanta",500);
		graph.get("Alexandria").put("Kenna",100);
		graph.get("Alexandria").put("Sinai",700);
		graph.get("Kenna").put("Tanta",100);
		graph.get("Tanta").put("Kenna",100);
		graph.get("Tanta").put("Sinai",300);
		
		Dikstra dikstra = new Dikstra();

		assertNull(dikstra.getShortestPath(graph, "Tanta", "Cairo"));
	}

}
