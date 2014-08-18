package com.orange.citymapper.data;

import java.util.HashMap;
import java.util.Map;

import com.orange.citymapper.adapters.GraphAdapter;

public class Graph {
	private Map<String, Map<String, Edge>> graph = new HashMap<>();
	
	public void addEdge(Edge edge) {
		addCityIfNotExists(edge.getSource());
		addCityIfNotExists(edge.getDestination());
		
		String destName = edge.getDestination().getName();
		String srcName = edge.getSource().getName();
		
		graph.get(srcName).put(destName, edge);
	}

	public Edge getEdge(String sourceName, String destName) {
		Map<String, Edge> adjacentMap = graph.get(sourceName);
		
		if(adjacentMap == null)
			return null;
		
		return adjacentMap.get(destName);
	}
	
	public Map<String, Map<String, Integer>> getAdjacenceyMap(){
		return new GraphAdapter(graph);
	}
	
	private void addCity(City city){
		graph.put(city.getName(), new HashMap<String, Edge>());
	}
	
	private void addCityIfNotExists(City city){
		if(!this.containsCity(city)){
			this.addCity(city);
		}		
	}
	
	private boolean containsCity(City city){
		return graph.containsKey(city.getName());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Graph){
			return graph.equals(((Graph)obj).graph);
		}
		return super.equals(obj);
	}
}
