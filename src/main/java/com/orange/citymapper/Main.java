package com.orange.citymapper;

import java.io.IOException;
import java.util.Scanner;

import com.orange.citymapper.data.Graph;
import com.orange.citymapper.io.FileHandler;
import com.orange.citymapper.parsers.GraphParser;
import com.orange.citymapper.queries.IQuery;
import com.orange.citymapper.queries.QueryFactory;

public class Main {
	public static void main(String[] args) throws IOException {
		FileHandler file = new FileHandler();
		String allInput = file.readFile("sample-in.txt");
		
		Scanner input = new Scanner(allInput);
		
		Graph graph = new Graph();
		GraphParser graphParser = new GraphParser(graph);
		graphParser.parseGraphText(input);
		
		int queries = input.nextInt();
		input.nextLine();
		
		StringBuilder resultOut = new StringBuilder();
		for(int i=0; i<queries; i++){
			String queryLine = input.nextLine();
			
			IQuery queryObj = QueryFactory.createQuery(queryLine);
			
			String queryResult;
			
			if(queryObj == null)
				queryResult = "Not Supported Yet";
			else
				queryResult = queryObj.getResult(queryLine, graph);
			
			resultOut.append(queryResult + '\n');
		}
		file.writeln("out.txt", resultOut.toString());
	}

		
}
