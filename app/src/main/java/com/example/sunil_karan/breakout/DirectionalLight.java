package com.example.sunil_karan.breakout;

public class DirectionalLight extends Baselight{
    // The direction of the light
	Vector3f direction;
	
	public DirectionalLight() {
		super();
		direction = new Vector3f(0.0f, 0.0f, 0.0f);
	}

}
