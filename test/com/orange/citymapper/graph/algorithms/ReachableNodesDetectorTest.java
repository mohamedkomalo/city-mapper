package com.orange.citymapper.graph.algorithms;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class ReachableNodesDetectorTest {
	
	@Test(timeout=10)
	public void testGetReachableNodesWithEdgeLimit(){
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

		assertEquals(Arrays.asList(null, Arrays.asList("Alexandria", "Tanta")),
					reachableNodesDetector.getReachableNodesWithinEdges(graph, "Cairo", 1));
		
		assertEquals(Arrays.asList(null, Arrays.asList("Alexandria", "Tanta"),
								   Arrays.asList("Sinai", "Kenna")),
				reachableNodesDetector.getReachableNodesWithinEdges(graph, "Cairo", 2));
	}

}
