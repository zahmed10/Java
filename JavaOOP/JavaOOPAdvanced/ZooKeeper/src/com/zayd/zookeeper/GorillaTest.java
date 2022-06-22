package com.zayd.zookeeper;

public class GorillaTest {

	public static void main(String[] args) {
		Gorilla g = new Gorilla();
		g.throwSomething();
		System.out.println("The gorilla's new energy level is " + g.getEnergyLevel() + "\n");
		
		g.eatBananas();
		
		g.climb();
		
		//Create a GorillaTest class to instantiate a gorilla and have it throw three things, eat 
		//bananas twice, and climb once.
		Gorilla two = new Gorilla();
		two.throwSomething();
		System.out.println("The gorilla's new energy level is " + two.getEnergyLevel() + "\n");
		two.throwSomething();
		System.out.println("The gorilla's new energy level is " + two.getEnergyLevel() + "\n");
		two.throwSomething();
		System.out.println("The gorilla's new energy level is " + two.getEnergyLevel() + "\n");
		
		two.eatBananas();
		two.eatBananas();
		
		two.climb();
		
		

	}

}
