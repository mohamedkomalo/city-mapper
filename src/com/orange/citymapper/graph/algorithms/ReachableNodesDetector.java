package com.orange.citymapper.graph.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.Set;

public class ReachableNodesDetector {

	public List<String> getReachableNodesWithinEdges(Map<String, Map<String, Integer>> graph, String source, int edgesLimit) {
		Queue<GraphTraversedNode> unprocessedTraversedNodes = new LinkedList<>();
		unprocessedTraversedNodes.add(new GraphTraversedNode(source, 0));
		
		List<String> reachableNodes = new LinkedList<>();
		
		Set<String> visited = new HashSet<>();
		
		while(!unprocessedTraversedNodes.isEmpty()){
			GraphTraversedNode currentTraversedNode = unprocessedTraversedNodes.poll();
			String currentNode = currentTraversedNode.getCurrentNode();
			
			visited.add(currentNode);
			
			if(0 < currentTraversedNode.getCurrentLevel() && currentTraversedNode.getCurrentLevel() <= edgesLimit){
				reachableNodes.add(currentNode);
			}
			
			Map<String, Integer> adjacencyMap = graph.get(currentNode);
			
			int nextLevel = currentTraversedNode.getCurrentLevel() + 1;
			
			if(nextLevel > edgesLimit)
				continue;
			
			for(Entry<String, Integer> entry : adjacencyMap.entrySet()){
				String connectedNode = entry.getKey();
				if(!visited.contains(connectedNode)){
					GraphTraversedNode graphTraversedNode = new GraphTraversedNode(connectedNode, nextLevel);
					unprocessedTraversedNodes.add(graphTraversedNode);
				}
			}
		}
		
		return reachableNodes;
	}
	
	class GraphTraversedNode{
		private String currentNode;
		private int currentLevel;
		
		public GraphTraversedNode(String currentNode, int currentLevel) {
			this.currentNode = currentNode;
			this.currentLevel = currentLevel;
		}

		public String getCurrentNode() {
			return currentNode;
		}
		
		public int getCurrentLevel() {
			return currentLevel;
		}
	}

}
