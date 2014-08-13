package com.orange.citymapper;

import static org.junit.Assert.*;

import org.junit.Test;

import com.orange.citymapper.data.City;
import com.orange.citymapper.data.Edge;
import com.orange.citymapper.data.Graph;
import com.orange.citymapper.parsers.GraphParser;

public class GraphParserTests {

	@Test
	public void testParseEdgeLine(){
		String edgeLineInput = "Cairo Alexandria 200";
		
		Graph graph = new Graph();
		
		GraphParser graphParser = new GraphParser(graph);
		
		graphParser.parseEdgeLine(edgeLineInput);
		
		Edge expectedOutput = new Edge(new City("Cairo"), new City("Alexandria"), 200);
		
		assertEquals(expectedOutput, graph.getEdge("Cairo",  "Alexandria"));
	}
	
	@Test
	public void testParseGraph(){
		String graphTextInput = "5 7\n" + 
								"Cairo Alexandria 200\n" + 
								"Cairo Tanta 500\n" + 
								"Alexandria Kenna 100\n" + 
								"Alexandria Sinai 700\n" + 
								"Kenna Tanta 100\n" + 
								"Tanta Kenna 100\n" + 
								"Tanta Sinai 300\n";
		
		Graph graph = new Graph();
		
		GraphParser graphParser = new GraphParser(graph);
		
		graphParser.parseGraphText(graphTextInput);
		
		Graph expectedGraph = new Graph();
		City cairo = new City("Cairo"),
			 alexendria = new City("Alexendria"),
			 tanta = new City("Tanta"),
			 kenna = new City("Kenna"),
			 sinai = new City("Sinai");
		
		expectedGraph.addEdge(new Edge(cairo, alexendria, 200));
		expectedGraph.addEdge(new Edge(cairo, tanta, 500));
		expectedGraph.addEdge(new Edge(alexendria, kenna, 100));
		expectedGraph.addEdge(new Edge(alexendria, sinai, 700));
		expectedGraph.addEdge(new Edge(kenna, tanta, 100));
		expectedGraph.addEdge(new Edge(tanta, kenna, 100));
		expectedGraph.addEdge(new Edge(tanta, sinai, 300));
		
		assertEquals(expectedGraph, graph);
	}
	
	
}
