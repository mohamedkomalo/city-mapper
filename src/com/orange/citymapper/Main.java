package com.orange.citymapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.orange.citymapper.data.Graph;
import com.orange.citymapper.parsers.GraphParser;
import com.orange.citymapper.queries.CostQuery;
import com.orange.citymapper.queries.IQuery;
import com.orange.citymapper.queries.ReachableCitiesAtMostQuery;
import com.orange.citymapper.queries.RouteQuery;
import com.orange.citymapper.queries.ShortestPathQuery;

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
			
			IQuery queryObj = createQuery(queryLine);
			
			String queryResult;
			
			if(queryObj == null)
				queryResult = "Not Supported Yet";
			else
				queryResult = queryObj.getResult(queryLine, graph);
			
			resultOut.append(queryResult + '\n');
		}
		file.writeln("out.txt", resultOut.toString());
	}

	static IQuery createQuery(String queryLine){
		IQuery queryObj = null;
		
		if(new ShortestPathQuery().checkCorrectQuery(queryLine))
			queryObj = new ShortestPathQuery();
		
		else if(new CostQuery().checkCorrectQuery(queryLine))
			queryObj = new CostQuery();
		
		else if(new RouteQuery().checkCorrectQuery(queryLine))
			queryObj = new RouteQuery();
		
		else if(new ReachableCitiesAtMostQuery().checkCorrectQuery(queryLine))
			queryObj = new ReachableCitiesAtMostQuery();
		
		return queryObj;
	}
	
}
