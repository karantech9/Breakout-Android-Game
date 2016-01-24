package com.example.sunil_karan.breakout;

public class Vector3f {
	public float x;
	public float y;
	public float z;
	
	public Vector3f(float _x, float _y, float _z)
	{
		x = _x;
		y = _y;
		z = _z;
	}

	public void add(Vector3f v) {
		x += v.x;
		y += v.y;
		z += v.z;
	}

	public void Mult(float f)
	{
		x *= f;
		y *= f;
		z *= f;
	}

	public void normalize() {
		float length = (float) Math.sqrt(x * x + y * y + z * z);
		
		x /= length;
		y /= length;
		z /= length;
	}
	
	public Vector3f cross(Vector3f v) {
		float _x = y * v.z - z * v.y;
		float _y = z * v.x - x * v.z;
		float _z = x * v.y - y * v.x;
		
		Vector3f c = new Vector3f(_x, _y, _z);
		
		return c;
	}
}
