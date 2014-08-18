package com.orange.citymapper.parsers;

import java.util.Collection;
import java.util.Iterator;

public class CollectionToStringConverter {

	public String convert(Collection<String> collection, char delimeter){
		StringBuilder result = new StringBuilder();
		
		Iterator<String> iterator = collection.iterator();
		while(iterator.hasNext()){
			String obj = iterator.next();
			
			result.append(obj);
			
			if(iterator.hasNext())
				result.append(delimeter);
		}
		
		return result.toString();
	}
}
