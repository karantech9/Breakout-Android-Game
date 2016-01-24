package com.example.sunil_karan.breakout;


public abstract class GameEntity {
    // Position of the entity
    private Vector3f position;
    // Width of bounding box
	private float width;
	private float height;
    // Boolean for whether the object is dead
	private boolean dead;
	
	public GameEntity(Vector3f pos, float w, float h) {
		position = pos;
		width = w;
		height = h;
		dead = false;
	}
	
	public Vector3f getPos() {
		return position;
	}
	
	public void setPos(Vector3f p) {
		position = p;
	}
	
	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}
	
	public boolean isDead() {
		return dead;
	}
	
	public void setDead(boolean d) {
		dead = d;
	}
}
