package com.example.merz.dto;

public class CarEvent {

	public String vin;
    public Boolean fuelLid;
    public String city;
    
	public CarEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CarEvent(String vin, Boolean fuelLid, String city) {
		super();
		this.vin = vin;
		this.fuelLid = fuelLid;
		this.city = city;
	}
    
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public Boolean getFuelLid() {
		return fuelLid;
	}
	public void setFuelLid(Boolean fuelLid) {
		this.fuelLid = fuelLid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

    @Override
	public String toString() {
		return "CarEvent [vin=" + vin + ", fuelLid=" + fuelLid + ", city=" + city + "]";
	}
    
}
