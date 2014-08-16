package com.orange.citymapper.data;
/***
 * represents an edge in a graph
 * @author bichoyrg
 *
 */
public class Edge {
	private City source;
	private City destination;
	private int cost;
	public Edge(City source, City destination, int cost) {
		super();
		this.source = source;
		this.destination = destination;
		this.cost = cost;
	}
	public City getSource() {
		return source;
	}
	public City getDestination() {
		return destination;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Edge){
			Edge e = (Edge)obj;
			return this.cost == e.cost && 
				   this.source.equals(e.source) && 
				   this.destination.equals(e.destination);
		}
		return super.equals(obj);
	}
}
