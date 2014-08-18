package com.orange.citymapper.adapters;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

import com.orange.citymapper.data.Edge;

class AdjacencyMapAdapter extends AbstractMap<String, Integer>{
		
		private Map<String, Edge> originalMap;
		
		AdjacencyMapAdapter(Map<String, Edge> originalMap){
			this.originalMap = originalMap;
		}
		
		@Override
		public int size() {
			return originalMap.size();
		}
		
		@Override
		public Integer get(Object key) {
			if(!originalMap.containsKey(key))
				return null;
			
			return originalMap.get(key).getDistance();
		}
		
		@Override
		public Set<Entry<String, Integer>> entrySet() {
			return new EdgeEntrySetAdapter(originalMap.entrySet());
		}	
	}