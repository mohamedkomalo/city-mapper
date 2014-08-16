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
		unprocessedNodes.add(new Path<NodeType>(sourceNode));
		
		Set<NodeType> visitedBefore = new HashSet<>();
		
		while(!unprocessedNodes.isEmpty()){
			Path<NodeType> currentPath = unprocessedNodes.poll();
			
			NodeType currentNode = currentPath.getLastNode();
			
			if(currentNode.equals(destinationNode))
				return currentPath;
						
			if(visitedBefore.contains(currentNode))
				continue;

			visitedBefore.add(currentNode);
			
			Map<NodeType, Integer> connectedNeighbours = graph.get(currentNode);
			
			for(Entry<NodeType, Integer> entry : connectedNeighbours.entrySet()){
				NodeType neighboureNode = entry.getKey();
				int weightToNeighbourNode = entry.getValue();
				
				Path<NodeType> newPath = new Path<NodeType>(currentPath);
				newPath.appendNode(neighboureNode, weightToNeighbourNode);
				
				unprocessedNodes.add(newPath);
			}
		}
		
		return null;
	}
	
	
	public class Path<NodeType> implements Comparable<Path<NodeType>>{
		private List<NodeType> nodes;
		private int cost;
		
		public Path(NodeType node) {
			init(new ArrayList<NodeType>(Arrays.asList(node)), 0);
		}
		
		public Path(List<NodeType> nodes, int cost) {
			init(nodes, cost);
		}
		
		public Path(Path<NodeType> path) {
			init(new ArrayList<NodeType>(path.nodes), path.cost);
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
