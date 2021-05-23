package entity;

import application.Main;
import entity.base.CollidableEntity;
import exception.OutOfBoundsException;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import logic.AudioHolder;
import logic.SpritesHolder;

public class Player extends CollidableEntity {
	
	private final static int MAXSPEED = 2;
	private final static int SHOOTCOOLDOWN = 40;
	private static Image sprite = SpritesHolder.PLAYERSTATIC_SPRITE;
	
	
	private float accel = (float) 0.05;
	private float decel = (float) 0.01;
	
	private float speed = 0;
	private int speed_angle = 0;
	private int angle = 0;
	private int cooldown = 0;
	
	private boolean flashing = false;
	private int flashCounter = 0;
	private int flashDurationCounter = 0;
	
	public Player(double x, double y) 
	{
		this.x = x;
		this.y = y;
		this.radius = (int) (sprite.getWidth()/2);
		this.health = 5;
	}

	private void forward() 
	{
		this.x += Math.cos(Math.toRadians(speed_angle)) * speed;
		this.y += Math.sin(Math.toRadians(speed_angle)) * speed;
	}

	private void turn(boolean left) 
	{
		if (left) {
			angle -= 3;
			if (angle < 0)
				angle += 360;
		} else {
			angle += 3;
			if (angle >= 360)
				angle -= 360;
		}
	}
	
	@Override
	public void hit()
	{
		AudioHolder.SHIP_HIT.play();
		flashing = true;
		health--;
		if(health <= 0) {
			this.destroyed = true;
		}
		flashCounter = 20;
		flashDurationCounter = 20;
	}
	
	@Override
	public void update() throws OutOfBoundsException 
	{
		if (flashing) { //Flashing logic
			if (flashCounter == 0) {
				this.visible = true;
				flashing = false;
			} else {
				if (flashDurationCounter > 0) {
					this.visible = flashCounter <= 5;
					flashDurationCounter--;
				} else {
					this.visible = true;
					flashDurationCounter = 10;
					flashCounter--;
				}
			}
		} 
		
		if (InputUtility.getKeyPressed(KeyCode.W)) {
			if(speed < MAXSPEED)
			{
				speed += accel; //Add acceleration
			}
			speed_angle = this.angle;
			sprite = SpritesHolder.PLAYERMOVING_SPRITE; //Static Sprite
			forward();
		} else { //Accelerate Sprite
			sprite = SpritesHolder.PLAYERSTATIC_SPRITE;
		}
		if (InputUtility.getKeyPressed(KeyCode.A)) { //Rotation
			turn(true);
		} else if (InputUtility.getKeyPressed(KeyCode.D)) {
			turn(false);
		}
		if (speed > 0 && !InputUtility.getKeyPressed(KeyCode.W)) //Decelerate
		{
			forward();
			speed -= decel;
		}
		else if (speed < 0) 
		{
			speed = 0;
		}
		if(cooldown > 0) {
			cooldown--;
			}
		//Off-Screen position reset
		if(this.x < 0 || this.x > Main.WIDTH || this.y < 0 || this.y > Main.HEIGHT)
		{
			throw new OutOfBoundsException();
		}
		
		
	}
	
	public boolean canShoot() 
	{
		if (InputUtility.getKeyPressed(KeyCode.J) && cooldown <= 0 && !destroyed) {
			cooldown = SHOOTCOOLDOWN;
			return true;
		}
		else {
			return false;
		}
	}
	
	
	@Override
	public void draw(GraphicsContext gc) 
	{
		//HITBOX
//		gc.setFill(Color.TRANSPARENT);
//		gc.fillArc(x - radius, y - radius, radius * 2, radius * 2, 0, 360, ArcType.OPEN);
		gc.translate(x, y);
		gc.rotate(angle);
		gc.drawImage(sprite, -8, -8, 16, 16);
		gc.rotate(-angle);
		gc.translate(-x, -y);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	public double getAngle() {
		return angle;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public boolean getFlashing() {
		return flashing;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void setHealth(int health)
	{
		this.health = health;
	}

}
