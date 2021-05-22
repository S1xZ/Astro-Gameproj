package entity.base;

/**
 * Created by: Punya Gunawardana
 * Date created: Aprill 23, 2021
 * Time created: 8:10 PM
 */

import java.util.Random;

import application.Main;

public abstract class Enemy extends CollidableEntity {
	
	protected final static Random RAND = new Random();
	protected double speed;
	protected int score;
	
	public Enemy(double x,double y, int health) {
		this.x = x;
		this.y = y;
		this.health = health;
	}
	

	
	protected void randomPos()
	{
		if(RAND.nextInt(10) < 5) {
			y = RAND.nextDouble()*Main.WIDTH;
			x = 0;
		}
		else {
			y = 0;
			x = RAND.nextDouble()*Main.HEIGHT;
		}
	}
	
	protected void forward() {
		this.x += Math.cos(Math.toRadians(angle)) * speed;
		this.y += Math.sin(Math.toRadians(angle)) * speed;
	}
	
	@Override
	public void hit() {
		health--;
		if(health <= 0) {
			this.destroyed = true;
		}
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}

}
