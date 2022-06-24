package com.zayd.zookeeperii;

public class Bat extends Mammal {
	public Bat() {
		setEnergyLevel(300);
	}
	
	public int fly() {
		System.out.println("Whoosh. With a flutter of its wings, the bat took off. It's energy decreased by 50");
		setEnergyLevel(getEnergyLevel() - 50);
		return getEnergyLevel();
		
	}
	
	public int eatHuman() {
		System.out.println("so- well, never mind. the bat's energy increased by 25");
		setEnergyLevel(getEnergyLevel() + 25);
		return getEnergyLevel();
		
	}
	
	public int attackTown( ) {
		System.out.println("Sirens blaring and the townsfolk wailing. The bat has lit the town ablaze with its fiery breath! At least it lost 100 energy. \nmaybe Legolas and Gimli can help us.");
		setEnergyLevel(getEnergyLevel() - 100);
		return getEnergyLevel();
	}
	
	


}
