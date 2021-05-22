package entity.base;


/**
 * Created by: Punya Gunawardana
 * Date created: Aprill 23, 2021
 * Time created: 9:11 AM
 */


public abstract class CollidableEntity extends Entity implements Updatable{
	protected int radius;
	protected int health;
	protected double angle;
	
	public boolean collideWith(CollidableEntity o)
	{
		return Math.hypot(this.x-o.x, this.y-o.y) <= this.radius+o.radius;
	}
	
	public abstract void hit();
	
}
