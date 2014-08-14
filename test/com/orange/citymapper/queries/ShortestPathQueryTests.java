package com.orange.citymapper.queries;

import static org.junit.Assert.*;

import org.junit.Test;

import com.orange.citymapper.data.City;
import com.orange.citymapper.data.Edge;
import com.orange.citymapper.data.Graph;
import com.orange.citymapper.queries.ShortestPathQuery;

public class ShortestPathQueryTests {

	@Test
	public void testCheckCorrectQueryWihValidQuerySyntax() {
		ShortestPathQuery shortestPathQuery = new ShortestPathQuery();
		
		boolean result = shortestPathQuery.checkCorrectQuery("What is the shortest path between City Cairo to City Kenna?");
		
		assertTrue(result);
	}
	
	@Test
	public void testCheckCorrectQueryWihInvalidQuerySyntax() {
		ShortestPathQuery shortestPathQuery = new ShortestPathQuery();
		
		boolean result = shortestPathQuery.checkCorrectQuery("In the sea there are fishes");
		
		assertFalse(result);
	}
	

}
