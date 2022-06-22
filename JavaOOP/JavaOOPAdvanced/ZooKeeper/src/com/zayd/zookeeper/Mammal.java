package com.zayd.zookeeper;

public class Mammal {
	private int energyLevel;
	
	//Constructor
	public Mammal() {
		setEnergyLevel(100);
	}
	
	public int displayEnergy() {
		System.out.println("The energy level is " + this.getEnergyLevel());
		return getEnergyLevel();
	}

	// ---Getters and Setters---
	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
}
