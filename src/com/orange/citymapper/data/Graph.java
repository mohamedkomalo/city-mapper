package com.orange.citymapper.data;

import java.util.HashMap;
import java.util.Map;

public class Graph {
	Map<String, Map<String, Edge>> graph = new HashMap<>();
	
	public void addEdge(Edge edge) {
		Map<String, Edge> adjacentMap = graph.get(edge.getSource().getName());
		
		if(adjacentMap == null){
			adjacentMap = new HashMap<>();
			graph.put(edge.getSource().getName(), adjacentMap);
		}
		
		adjacentMap.put(edge.getDestination().getName(), edge);
	}

	public Edge getEdge(String sourceName, String destName) {
		Map<String, Edge> adjacentMap = graph.get(sourceName);
		
		if(adjacentMap == null)
			return null;
		
		return adjacentMap.get(destName);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Graph){
			return graph.equals((Map<String, Map<String, Edge>>) graph);
		}
		return super.equals(obj);
	}

}
