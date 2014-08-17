package com.orange.citymapper.graph.algorithms;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.orange.citymapper.graph.algorithms.PathCostCalculator;

public class PathCostCalculatorTest {

	@Test
	public void testCalcuatePathCost() {
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
		
		PathCostCalculator pathCalculator = new PathCostCalculator();
		
		assertEquals(200,
					pathCalculator.calculatePathCost(graph, Arrays.asList("Cairo", "Alexandria")));
		
		assertEquals(600,
					pathCalculator.calculatePathCost(graph, Arrays.asList("Cairo", "Tanta", "Kenna")));
		
		assertEquals(200,
					pathCalculator.calculatePathCost(graph, Arrays.asList("Alexandria", "Kenna", "Tanta")));
	}
	
	@Test
	public void testCalcuatePathCostWithInvalidPath() {
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
		
		PathCostCalculator pathCalculator = new PathCostCalculator();
		
		assertEquals(-1,
					pathCalculator.calculatePathCost(graph, Arrays.asList("Cairo", "Sinani", "Kenna")));
	}
}
