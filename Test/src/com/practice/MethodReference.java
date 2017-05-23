package com.practice;

import com.practice.EnumTest.Planet;

public class MethodReference{
	public static void main(String[] args){
	double earthWeight = Double.parseDouble("78");
    double mass = earthWeight/Planet.EARTH.surfaceGravity();
    for (Planet p : Planet.values())
    	//System.out.printf("Your weight on %s is %f%n",p, p.surfaceWeight(mass));
    	System.out.println(p);
	}
}
