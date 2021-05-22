package logic;

import application.Main;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import sharedObject.IRenderable;

public class GameOverlay implements IRenderable {
	
	private boolean isWaveTextVisible;
	private String currentText;
	private String score;
	private String hp;
	private boolean isGameEnd;
	


	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setTextAlign(TextAlignment.LEFT);
		gc.setFill(Color.WHITE);
		gc.setFont(new Font("Arial",25));
		gc.fillText("HP "+hp, 40, 45);
		gc.fillText(score, 40, 75);
		if(isWaveTextVisible) {
			gc.setTextAlign(TextAlignment.CENTER);
			gc.setFont(new Font("Comic Sans MS", 55));
			gc.fillText(currentText, Main.WIDTH/2, Main.HEIGHT/2);
			}
		if(isGameEnd) 
		{
			gc.setTextAlign(TextAlignment.CENTER);
			gc.setFont(new Font("Comic Sans MS", 55));
			gc.fillText("GAME OVER", Main.WIDTH/2, Main.HEIGHT/2);
			gc.setFont(new Font("Comic Sans MS", 35));
			gc.fillText("Click anywhere to exit", Main.WIDTH/2, Main.HEIGHT/2+45);
		}
		
	}


	@Override
	public int getZ() {
		return 99999;
	}
	
	public void setCurrenttext(String text)
	{
		this.currentText = text;
	}
	
	public void setIsWaveTextVisible(boolean visibility)
	{
		this.isWaveTextVisible = visibility;
	}
	
	public void setScore(int Score)
	{
		score = String.format("%1$" + 7 + "s", String.valueOf(Score)).replace(' ', '0');
	}
	
	public void setIsGameEnd(boolean isGameEnd)
	{
		this.isGameEnd = isGameEnd;
	}
	

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible() {
		return true;
	}
	
	public void setHp(int Hp)
	{
		hp = String.valueOf(Hp);
	}
	
}
