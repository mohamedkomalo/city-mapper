package com.orange.citymapper.adapters;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

import com.orange.citymapper.data.Edge;

public class GraphAdapter extends AbstractMap<String, Map<String, Integer>> {
	Map<String, Map<String, Edge>> originalGraph;
	
	public GraphAdapter(Map<String, Map<String, Edge>> originalGraph) {
		this.originalGraph = originalGraph;
	}

	@Override
	public Map<String, Integer> get(Object key) {
		return new AdjacencyMapAdapter(originalGraph.get(key));
	}
	
	@Override
	public Set<java.util.Map.Entry<String, Map<String, Integer>>> entrySet() {
		throw new UnsupportedOperationException();
	}
}
