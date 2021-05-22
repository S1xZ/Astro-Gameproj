package entity;

import entity.base.Meteor;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import logic.SpritesHolder;

public class MediumMeteor extends Meteor{
	
	private final static int HEALTH = 1;
	private final static Image[] SpriteArr = {SpritesHolder.METEORMEDIUM1_SPRITE,SpritesHolder.METEORMEDIUM2_SPRITE};
	private Image Sprite;
	private final static int SPEED = 2;
	
	public MediumMeteor() {
		super(-20,-20,HEALTH,SPEED);
		int index = RAND.nextInt(SpriteArr.length);
		Sprite = SpriteArr[index];
		this.radius = (int) (Sprite.getWidth()/2);
		this.score = 100;
		randomPos();
	}
	
	public MediumMeteor(double x, double y) {
		super(x, y, HEALTH,SPEED);
		angle = RAND.nextDouble()*360;
		this.radius = (int) (SpriteArr[0].getWidth()/2);
		int index = RAND.nextInt(SpriteArr.length);
	    Sprite = SpriteArr[index];
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.TRANSPARENT);
		gc.fillArc(x - radius, y - radius, radius * 2, radius * 2, 0, 360, ArcType.OPEN);
		gc.translate(x, y);
		gc.setFill(Color.YELLOW);
		gc.drawImage(Sprite, -Sprite.getWidth()/2, -Sprite.getHeight()/2, Sprite.getWidth(), Sprite.getHeight());
		gc.translate(-x, -y);

	}
	


}
