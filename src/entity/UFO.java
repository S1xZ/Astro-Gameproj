package entity;

import application.Main;
import entity.base.Enemy;
import exception.OutOfBoundsException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import logic.AudioHolder;
import logic.SpritesHolder;

public class UFO extends Enemy {
	
	private final static int HEALTH = 1;
	private final static Image SPRITE = SpritesHolder.UFO_SPRITE;
	private final static int SPEED = 1;
	
	private int angleDelay = 0;
	private int shootDelay = 0;
	
	public UFO() {
		super(-20, -20, HEALTH);
		this.radius = (int) (SPRITE.getWidth()/2);
		this.speed = SPEED;
		this.score = 500;
		randomPos();
	}


	@Override
	public void update() throws OutOfBoundsException {
		// TODO Auto-generated method stub
		forward();
		
		if(angleDelay <= 0)
		{
			angleDelay = 120;
			AudioHolder.UFO_ALIVE.play();;
			randomAngle();
		}
		else 
		{
			angleDelay--;
		}
		if(shootDelay > 0) 
		{
			shootDelay--;
		}
		
		if(this.x < 0 || this.x > Main.WIDTH || this.y < 0 || this.y > Main.HEIGHT)
		{
			throw new OutOfBoundsException();
		}
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.TRANSPARENT);
		gc.fillArc(x - radius, y - radius, radius * 2, radius * 2, 0, 360, ArcType.OPEN);
		gc.translate(x, y);
		gc.setFill(Color.YELLOW);
		gc.drawImage(SPRITE, -SPRITE.getWidth()/2, -SPRITE.getHeight()/2, SPRITE.getWidth(), SPRITE.getHeight());
		gc.translate(-x, -y);
	}
	
	private void randomAngle() 
	{
		angle = RAND.nextDouble()*360;
	}
	
	public boolean canShoot()
	{
		if(RAND.nextInt(10) < 5 && shootDelay <= 0)
		{
			shootDelay = 120;
			return true;
		}
		return false;
	}
	
	public double getPlayerAngle(Player player)
	{
		double playerX = player.getX();
		double playerY = player.getY();
		
		float angle = (float) Math.toDegrees(Math.atan2(playerY - y, playerX - x));

	    if(angle < 0){
	        angle += 360;
	    }

	    return angle;
	}
	
	
}
