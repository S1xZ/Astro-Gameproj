package gui;


import application.Main;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.SpritesHolder;

public class Mainmenu extends StackPane {
	
	private Gamebutton startBtn = new Gamebutton("Start");
	private Gamebutton helpBtn = new Gamebutton("Help");
	private Gamebutton creditBtn = new Gamebutton("Credit");
	private Gamebutton exitBtn = new Gamebutton("Exit");

	
	public Mainmenu()
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
		
		VBox options = new VBox(30);
		
		options.setAlignment(Pos.CENTER);
		options.setTranslateY(60);
		
		exitBtn.setOnMouseClicked(e -> {
			Platform.exit();
			System.exit(0);
		});
			
		options.getChildren().addAll(startBtn,helpBtn,creditBtn,exitBtn);
		
		this.getChildren().add(options);
	}
	

	public Gamebutton getStartBtn() {
		return startBtn;
	}

	public Gamebutton getHelpBtn() {
		return helpBtn;
	}

	public Gamebutton getCreditBtn() {
		return creditBtn;
	}

	
}
