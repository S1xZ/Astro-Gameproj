package entity.base;

import application.Main;

/**
 * Created by: Punya Gunawardana
 * Date created: Aprill 23, 2021
 * Time created: 9:21 AM
 */

import sharedObject.IRenderable;

public abstract class Entity implements IRenderable{

	protected double x,y;
	protected static int z;
	protected boolean visible,destroyed;
	
	protected Entity(){
		visible = true;
		destroyed = false;
	}
	
	public void positionCorrection()
	{
		if (this.x > Main.WIDTH) 
		{
			this.x = 0;
		}
		if (this.x < 0)
		{
			this.x = Main.WIDTH;
		}
		if(this.y > Main.HEIGHT)
		{
			this.y = 0;
		}
		if(this.y < 0)
		{
			this.y = Main.HEIGHT;
		}
	}
	
	
	@Override
	public int getZ(){
		return z;
	}
	
	@Override
	public boolean isDestroyed(){
		return destroyed;
	}
	
	@Override
	public boolean isVisible(){
		return visible;
	}
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	
}
