package logic;

import application.Main;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.IRenderable;

public class Field implements IRenderable {



	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0,0 , Main.WIDTH, Main.HEIGHT);
		}
	
	@Override
	public int getZ() {
		return -9999;
	}
		
	@Override
	public boolean isDestroyed() {
		return false;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

}
