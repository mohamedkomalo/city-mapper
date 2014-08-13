package com.orange.citymapper.data;

public class City {
	private String name;
	
	public City(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof City)
			return name.equals(((City)obj).name);
		
		return super.equals(obj);
	}
}
