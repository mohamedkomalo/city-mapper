package com.orange.citymapper.adapters;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.orange.citymapper.data.Edge;

class EdgeEntrySetAdapter extends AbstractSet<Entry<String, Integer>>{
	Set<Entry<String, Edge>> originalSet;

	public EdgeEntrySetAdapter(Set<java.util.Map.Entry<String, Edge>> originalSet) {
		super();
		this.originalSet = originalSet;
	}

	@Override
	public Iterator<Entry<String, Integer>> iterator() {
		return new EdgeEntryIteratorAdapter(originalSet.iterator());
	}

	@Override
	public int size() {
		return originalSet.size();
	}


}	