package com.orange.citymapper.graph.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Map.Entry;

public class Dikstra {

	/***
	 * 
	 * @param graph graph represented as adjacency list, nodes are string
	 * @param sourceNode
	 * @param destinationNode
	 * @return
	 */
	public Path getShortestPath(Map<String, Map<String, Integer>> graph, String sourceNode, String destinationNode){
		Queue<Path> unprocessedNodes = new PriorityQueue<Path>();
		unprocessedNodes.add(new Path(new ArrayList<>(Arrays.asList(sourceNode)), 0));
		
		Set<String> visited = new HashSet<>();
		
		while(!unprocessedNodes.isEmpty()){
			Path currentPath = unprocessedNodes.poll();
			
			String currentNode = currentPath.getLastNode();
			
			if(visited.contains(currentNode))
				continue;
			
			visited.add(currentNode);
			
			if(currentNode.equals(destinationNode))
				return currentPath;
			
			Map<String, Integer> adjacencyMap = graph.get(currentNode);
			
			for(Entry<String, Integer> entry : adjacencyMap.entrySet()){
				String connectedNode = entry.getKey();
				int weightToConnectedNode = entry.getValue();
				
				Path newPath = new Path(currentPath);
				newPath.appendNode(connectedNode, weightToConnectedNode);
				
				unprocessedNodes.add(newPath);
			}
		}
		
		return null;
	}
	
	
	public class Path implements Comparable<Path>{
		private List<String> nodes;
		private int cost;
		
		public Path(Path path) {
			List<String> newList = new ArrayList<String>(path.nodes);
			
			init(newList, path.cost);
		}
		
		public Path(List<String> nodes, int cost) {
			init(nodes, cost);
		}

		/**
		 * @param nodes
		 * @param cost
		 */
		private void init(List<String> nodes, int cost) {
			this.nodes = nodes;
			this.cost = cost;
		}

		public List<String> getNodes() {
			return nodes;
		}
		
		public int getCost() {
			return cost;
		}
		
		public void appendNode(String nodeName, int weight){
			this.nodes.add(nodeName);
			this.cost += weight;
		}
		
		public String getLastNode(){
			return nodes.get(nodes.size()-1);
		}

		@Override
		public int compareTo(Path o) {
			return cost - o.cost;
		}
	}
}
