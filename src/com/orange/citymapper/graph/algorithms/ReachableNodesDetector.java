package com.orange.citymapper.graph.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.Set;

public class ReachableNodesDetector {

	public List<List<String>> getReachableNodesWithinEdges(
			Map<String, Map<String, Integer>> graph, String source,
			int edgesLimit) {
		Queue<GraphTraversedNode> unprocessedTraversedNodes = new LinkedList<>();
		unprocessedTraversedNodes.add(new GraphTraversedNode(source, 0));

		Set<String> explored = new HashSet<>();

		List<List<String>> reachableNodes = new ArrayList<>();
		reachableNodes.add(null);
		
		for (int edge = 1; edge <= edgesLimit; edge++)
			reachableNodes.add(edge, new ArrayList<String>());

		while (!unprocessedTraversedNodes.isEmpty()) {
			GraphTraversedNode currentTraversedNode = unprocessedTraversedNodes.poll();
			
			String currentNode = currentTraversedNode.getCurrentNode();
			int currentLevel = currentTraversedNode.getCurrentLevel();

			explored.add(currentNode);

			if (0 < currentLevel && currentLevel <= edgesLimit) {
				reachableNodes.get(currentLevel).add(currentNode);
			}

			Map<String, Integer> adjacencyMap = graph.get(currentNode);

			int nextLevel = currentLevel + 1;

			if (nextLevel > edgesLimit)
				continue;

			for (Entry<String, Integer> entry : adjacencyMap.entrySet()) {
				String connectedNode = entry.getKey();
				if (!explored.contains(connectedNode)) {
					GraphTraversedNode graphTraversedNode = new GraphTraversedNode(
							connectedNode, nextLevel);
					unprocessedTraversedNodes.add(graphTraversedNode);

					explored.add(connectedNode);
				}
			}
		}

		return reachableNodes;
	}

	class GraphTraversedNode {
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
