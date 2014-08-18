package com.orange.citymapper.adapters;

import java.util.Map.Entry;

import com.orange.citymapper.data.Edge;

public class EdgeEntryAdapter implements Entry<String, Integer>{

	Entry<String, Edge> originalEntry;
	
	public EdgeEntryAdapter(Entry<String, Edge> originalEntry) {
		this.originalEntry = originalEntry;
	}

	@Override
	public String getKey() {
		return originalEntry.getKey();
	}

	@Override
	public Integer getValue() {
		return originalEntry.getValue().getDistance();
	}

	@Override
	public Integer setValue(Integer value) {
		throw new UnsupportedOperationException();
	}

}
