package com.orange.citymapper.queries;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReachableCitiesAtMostTests {

	@Test
	public void test() {
		ReachableCitiesAtMostQuery reachableCitiesQuery = new ReachableCitiesAtMostQuery();
				
				boolean result = reachableCitiesQuery.checkCorrectQuery("What are the reachable cities from Cairo using 2 Edges at Most?");
				
				assertTrue(result);
			}
		 
	}


