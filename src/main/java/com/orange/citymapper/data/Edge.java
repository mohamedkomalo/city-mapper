package com.orange.citymapper.data;
/***
 * represents an edge in a graph
 * @author bichoyrg
 *
 */
public class Edge {
	private City source;
	private City destination;
	private int distance;
	
	public Edge(City source, City destination, int cost) {
		super();
		this.source = source;
		this.destination = destination;
		this.distance = cost;
	}
	public City getSource() {
		return source;
	}
	public City getDestination() {
		return destination;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int cost) {
		this.distance = cost;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Edge){
			Edge e = (Edge)obj;
			return this.distance == e.distance && 
				   this.source.equals(e.source) && 
				   this.destination.equals(e.destination);
		}
		return super.equals(obj);
	}
}
