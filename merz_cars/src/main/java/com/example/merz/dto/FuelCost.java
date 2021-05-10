package com.example.merz.dto;

public class FuelCost {

	public int totalCost;
	
	public FuelCost() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FuelCost(int totalCost) {
		super();
		this.totalCost = totalCost;
	}
	
    public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	
}
