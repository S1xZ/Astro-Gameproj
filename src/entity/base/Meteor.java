package entity.base;

/**
 * Created by: Punya Gunawardana
 * Date created: April 21, 2021
 * Time created: 11:16 AM
 */

import application.Main;
import exception.OutOfBoundsException;

public abstract class Meteor extends Enemy{

	

	public Meteor(double x, double y, int health,double speed) {
		super(x, y, health);
		angle = RAND.nextDouble()*360;
		this.speed = speed;
	}

	
	@Override
	public void update() throws OutOfBoundsException {
		forward();
		
		if(this.x < 0 || this.x > Main.WIDTH || this.y < 0 || this.y > Main.HEIGHT)
		{
			throw new OutOfBoundsException();
		}
	}
		
	

}
