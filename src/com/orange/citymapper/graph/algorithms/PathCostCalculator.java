package com.orange.citymapper.graph.algorithms;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PathCostCalculator {

	public long calculatePathCost(Map<String, Map<String, Integer>> graph, List<String> nodes) {
		long totalCost = 0;
		
		Iterator<String> iterator = nodes.iterator();
		
		String previousNode = iterator.next();
		String currentNode;
		
		while (iterator.hasNext()) {
			currentNode = iterator.next();
			
			int currentWeight = graph.get(previousNode).get(currentNode);
			totalCost += currentWeight;
			
			previousNode = currentNode;
		}
		
		return totalCost;
	}

}
