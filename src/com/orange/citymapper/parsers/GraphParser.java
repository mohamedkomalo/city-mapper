package com.orange.citymapper.parsers;

import java.util.Scanner;

import com.orange.citymapper.data.City;
import com.orange.citymapper.data.Edge;
import com.orange.citymapper.data.Graph;

public class GraphParser {
	private Graph graph;
	
	public GraphParser(Graph graph) {
		this.graph = graph;
	}

	public void parseEdgeLine(String edgeLineInput) {
		String[] splitted = edgeLineInput.split(" ");
		String sourceName = splitted[0];
		String destName = splitted[1];
		int cost = Integer.valueOf(splitted[2]);
		
		graph.addEdge(new Edge(new City(sourceName), new City(destName), cost));
	}

	public void parseGraphText(String graphTextInput) {
		Scanner scanner = new Scanner(graphTextInput);
		
		scanner.nextInt();	// ignoring no of nodes because we don't need it to build the graph
		
		int edges = scanner.nextInt();
		
		scanner.nextLine();
		
		for(int i=0; i<edges; i++) {
			String edgeLine = scanner.nextLine();
			this.parseEdgeLine(edgeLine);
		}
		
	}
}
