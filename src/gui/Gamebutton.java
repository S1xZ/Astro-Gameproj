package gui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.AudioHolder;

public class Gamebutton extends Button{
	
	private Font font = new Font("Comic Sans MS",20);
	private Background bg = new Background(new BackgroundFill(Color.TRANSPARENT, null, null));
	
	public Gamebutton(String name)
	{
		this.setFont(font);
		this.setText(name);
		this.setTextFill(Color.WHITE);
		this.setBackground(bg);
		
		this.setOnMouseEntered(e -> {
			AudioHolder.BUTTON_ENTER.play();
			this.setCursor(Cursor.HAND);
		});
		
	}

}
