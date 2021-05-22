package gui;

import application.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import logic.SpritesHolder;

public class HelpMenu extends StackPane{
	private Font font = new Font("Comic Sans MS",20);
	private Gamebutton backBtn = new Gamebutton("Back");

	public HelpMenu()
	{
		Background bg = new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY));
		ImageView title = new ImageView(SpritesHolder.MENUBG_SPRITE);
		ImageView bgVdo = new ImageView(SpritesHolder.BGVDO);
		bgVdo.setFitHeight(Main.HEIGHT);
		bgVdo.setFitWidth(Main.WIDTH);
	
		this.setPrefSize(Main.WIDTH, Main.HEIGHT);
		this.getChildren().add(bgVdo);
		this.getChildren().add(title);
		this.setBackground(bg);
		
		VBox elements = new VBox(10);

		elements.setTranslateY(70);
		elements.setAlignment(Pos.CENTER);
		
		Text credit = new Text("Steer left: A\n\nSteer right: D\n\nEngage thruster: W\n\nShoot: J\n\n");
		credit.setFill(Color.WHITE);
		credit.setFont(font);

		
		credit.setTextAlignment(TextAlignment.CENTER);
		
		elements.getChildren().addAll(credit,backBtn);

		
		this.getChildren().add(elements);
	}
	
	public Gamebutton getBackBtn()
	{
		return backBtn;
	}
}
