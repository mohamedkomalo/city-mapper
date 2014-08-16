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
	 * @param graph graph represented as adjacency list, nodes are NodeType
	 * @param sourceNode
	 * @param destinationNode
	 * @return
	 */
	public <NodeType> Path<NodeType> getShortestPath(Map<NodeType, Map<NodeType, Integer>> graph,
										   NodeType sourceNode,
										   NodeType destinationNode){
		
		Queue<Path<NodeType>> unprocessedNodes = new PriorityQueue<Path<NodeType>>();
		unprocessedNodes.add(new Path<NodeType>(new ArrayList<NodeType>(Arrays.asList(sourceNode)), 0));
		
		Set<NodeType> visited = new HashSet<>();
		
		while(!unprocessedNodes.isEmpty()){
			Path<NodeType> currentPath = unprocessedNodes.poll();
			
			NodeType currentNode = currentPath.getLastNode();
			
			if(visited.contains(currentNode))
				continue;
			
			visited.add(currentNode);
			
			if(currentNode.equals(destinationNode))
				return currentPath;
			
			Map<NodeType, Integer> adjacencyMap = graph.get(currentNode);
			
			for(Entry<NodeType, Integer> entry : adjacencyMap.entrySet()){
				NodeType connectedNode = entry.getKey();
				int weightToConnectedNode = entry.getValue();
				
				Path<NodeType> newPath = new Path<NodeType>(currentPath);
				newPath.appendNode(connectedNode, weightToConnectedNode);
				
				unprocessedNodes.add(newPath);
			}
		}
		
		return null;
	}
	
	
	public class Path<NodeType> implements Comparable<Path<NodeType>>{
		private List<NodeType> nodes;
		private int cost;
		
		public Path(Path<NodeType> path) {
			List<NodeType> newList = new ArrayList<NodeType>(path.nodes);
			
			init(newList, path.cost);
		}
		
		public Path(List<NodeType> nodes, int cost) {
			init(nodes, cost);
		}

		/**
		 * @param nodes
		 * @param cost
		 */
		private void init(List<NodeType> nodes, int cost) {
			this.nodes = nodes;
			this.cost = cost;
		}

		public List<NodeType> getNodes() {
			return nodes;
		}
		
		public int getCost() {
			return cost;
		}
		
		public void appendNode(NodeType nodeName, int weight){
			this.nodes.add(nodeName);
			this.cost += weight;
		}
		
		public NodeType getLastNode(){
			return nodes.get(nodes.size()-1);
		}

		@Override
		public int compareTo(Path<NodeType> o) {
			return cost - o.cost;
		}
	}
}
