package com.orange.citymapper.adapters;

import java.util.Iterator;
import java.util.Map.Entry;

import com.orange.citymapper.data.Edge;

class EdgeEntryIteratorAdapter implements Iterator<Entry<String, Integer>>{

	Iterator<Entry<String, Edge>> iterator;
	public EdgeEntryIteratorAdapter(Iterator<Entry<String, Edge>> iterator) {
		this.iterator = iterator;

	}
	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public Entry<String, Integer> next() {
		return new EdgeEntryAdapter(iterator.next());
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}