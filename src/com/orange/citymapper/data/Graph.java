package com.orange.citymapper.data;

import java.util.HashMap;
import java.util.Map;

import com.orange.citymapper.adapters.GraphAdapter;

public class Graph {
	Map<String, Map<String, Edge>> graph = new HashMap<>();
	
	public void addEdge(Edge edge) {

		String destName = edge.getDestination().getName();
		String srcName = edge.getSource().getName();
		
		if(!graph.containsKey(destName)){
			graph.put(destName, new HashMap<String, Edge>());
		}
		
		Map<String, Edge> adjacentMap = graph.get(srcName);
		
		if(adjacentMap == null){
			adjacentMap = new HashMap<>();
			graph.put(srcName, adjacentMap);
		}
		
		adjacentMap.put(destName, edge);
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
	
	public Map<String, Map<String, Integer>> getAdjacenceyMap(){
		return new GraphAdapter(graph);
	}

}
