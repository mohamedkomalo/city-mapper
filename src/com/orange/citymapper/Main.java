package com.orange.citymapper;

import java.io.IOException;
import java.util.Scanner;

import com.orange.citymapper.data.Graph;
import com.orange.citymapper.parsers.GraphParser;
import com.orange.citymapper.queries.ShortestPathQuery;

public class Main {
	public static void main(String[] args) throws IOException {
		FileHandler file = new FileHandler();
		String allInput = file.readFile("sample-in.txt");
		
		Graph graph = new Graph();
		GraphParser graphParser = new GraphParser(graph);
		
		Scanner restOfFile = graphParser.parseGraphText(allInput);
		
		int queries = restOfFile.nextInt();
		restOfFile.nextLine();
		
		for(int i=0; i<queries; i++){
			String queryLine = restOfFile.nextLine();
			ShortestPathQuery query = new ShortestPathQuery();
			String queryResult = query.getResult(queryLine, graph);
			System.out.println(queryResult);
		}
	}
}
