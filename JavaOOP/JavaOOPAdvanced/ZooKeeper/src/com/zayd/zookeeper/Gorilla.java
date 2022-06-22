package com.zayd.zookeeper;

public class Gorilla extends Mammal {
	// Heidi said to have constructor even if it is empty because it is good practice and also to include comments because when
	// you come back to this you won't remember what the file does and stuff so you should add comments about what it is doing
	public Gorilla() {
		// TODO Auto-generated constructor stub
	}
	
	public void throwSomething() {
		System.out.println("The gorilla just threw something and lost 5 energy!");
		this.setEnergyLevel(getEnergyLevel() - 5);
	}
	
	public void eatBananas() {
		this.setEnergyLevel(getEnergyLevel() + 10);
		System.out.println("The gorilla is happily eating a banana! His energy level went up by ten."
				+ "\nNew energy level: " + this.getEnergyLevel() + "\n");
	}
	
	public void climb() {
		this.setEnergyLevel(getEnergyLevel() - 10);
		System.out.println("The gorilla just climbed a tree! His energy level went down by ten."
				+ "\nNew energy level: " + this.getEnergyLevel() + "\n");
	}

}
