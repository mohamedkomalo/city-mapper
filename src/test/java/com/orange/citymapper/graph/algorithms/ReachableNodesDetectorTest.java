package com.orange.citymapper.graph.algorithms;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;


public class ReachableNodesDetectorTest {
	
	@Test()
	public void testGetReachableNodesWithEdgeLimitOne(){
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
		
		
		ReachableNodesDetector reachableNodesDetector = new ReachableNodesDetector();

		List<List<String>> reachableFromCairo = reachableNodesDetector.getReachableNodesWithinEdges(graph, "Cairo", 1);

		assertEquals(2, reachableFromCairo.size());
		
		assertNull(reachableFromCairo.get(0));
		
		assertEquals(2, reachableFromCairo.get(1).size());
		assertTrue(reachableFromCairo.get(1).contains("Alexandria"));
		assertTrue(reachableFromCairo.get(1).contains("Tanta"));
	}
	
	@Test()
	public void testGetReachableNodesWithEdgeLimitTwo(){
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
		
		
		ReachableNodesDetector reachableNodesDetector = new ReachableNodesDetector();

		List<List<String>> reachableFromCairo = reachableNodesDetector.getReachableNodesWithinEdges(graph, "Cairo", 2);

		assertEquals(3, reachableFromCairo.size());
		
		assertNull(reachableFromCairo.get(0));
		
		assertEquals(2, reachableFromCairo.get(1).size());
		assertTrue(reachableFromCairo.get(1).contains("Alexandria"));
		assertTrue(reachableFromCairo.get(1).contains("Tanta"));
		
		assertEquals(2, reachableFromCairo.get(2).size());
		assertTrue(reachableFromCairo.get(2).contains("Kenna"));
		assertTrue(reachableFromCairo.get(2).contains("Sinai"));		
	}
}
