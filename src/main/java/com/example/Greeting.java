package com.example;

public class Greeting {
	public Greeting(int strength, String greeting) {
		super();
		this.strength = strength;
		this.greeting = greeting;
	}
	int strength;
	String greeting;
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

}
