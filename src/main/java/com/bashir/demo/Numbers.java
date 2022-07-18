package com.bashir.demo;

public class Numbers {

	private int sum = 0;
	
	public void add(int a) {
		this.sum = this.sum +a;
	}
	
	public String getSum() {
		return Integer.toString(this.sum);
	}
}
