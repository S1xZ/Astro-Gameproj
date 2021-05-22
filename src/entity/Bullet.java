package entity;

import application.Main;
import entity.base.CollidableEntity;
import exception.OutOfBoundsException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.AudioHolder;

public class Bullet extends CollidableEntity{
	
	private final static int SPEED = 3;
	private final static int TIMECAP = 200;
	
	private int CurrentTime = 0;
	private double angle;
	public boolean isPlayerBullet;
	
	public Bullet(double x, double y,double d,boolean playerBullet) {
		this.x = x;
		this.y = y;
		this.angle = d;
		this.isPlayerBullet = playerBullet;
		this.health = 1;
		this.radius = 1;
		AudioHolder.BULLET_SHOOT.play();
	}
	
	private void forward() {
		this.x += Math.cos(Math.toRadians(angle)) * SPEED;
		this.y += Math.sin(Math.toRadians(angle)) * SPEED;
	}
	
	public void update() throws OutOfBoundsException {
		forward();

		if(CurrentTime >=  TIMECAP) { //MaximumBulletTraveltime
			CurrentTime = 0;
			this.hit();
		} else {
			CurrentTime++;
		}
		
		if(this.x < 0 || this.x > Main.WIDTH || this.y < 0 || this.y > Main.HEIGHT)
		{
			throw new OutOfBoundsException();
		}
	}
	
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.fillRect(x, y, 3, 3);
	}

	@Override
	public void hit() {
		this.destroyed = true;
		this.visible = false;
	}

}
