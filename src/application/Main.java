package application;



import gui.CreditMenu;

/**
 * Created by: Punya Gunawardana
 * Date created: April 20, 2021
 * Time created: 11:25 AM
 */

import gui.GameScreen;
import gui.HelpMenu;
import gui.Mainmenu;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import logic.AudioHolder;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class Main extends Application{
	
	public final static int WIDTH = 640;
	public final static int HEIGHT = 480;
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		AudioHolder.MENUSONG.setCycleCount(MediaPlayer.INDEFINITE);
		AudioHolder.GAMESONG.setCycleCount(MediaPlayer.INDEFINITE);
		AudioHolder.MENUSONG.play();
		
		Mainmenu  menu = new Mainmenu();
		CreditMenu creditMene = new CreditMenu();
		HelpMenu helpMenu = new HelpMenu();
		StackPane root = new StackPane();
		Scene gamescene = new Scene(root);
		Scene mainMenuScene = new Scene(menu);
		Scene helpMenuScene = new Scene(helpMenu);
		Scene creditMenuScene = new Scene(creditMene);
		
		GameLogic logic = new GameLogic();
		GameScreen gameScreen = new GameScreen(WIDTH, HEIGHT);
		root.getChildren().add(gameScreen);
		
		primaryStage.setScene(mainMenuScene);
		primaryStage.setTitle("Astro");
		primaryStage.setResizable(false);
		primaryStage.show();
		
		menu.getCreditBtn().setOnMouseClicked(e -> {
			primaryStage.setScene(creditMenuScene);
		});
		
		menu.getHelpBtn().setOnMouseClicked(e -> {
			primaryStage.setScene(helpMenuScene);
		});
		
		
		helpMenu.getBackBtn().setOnMouseClicked(e -> {
			primaryStage.setScene(mainMenuScene);
		});
		
		creditMene.getBackBtn().setOnMouseClicked(e -> {
			primaryStage.setScene(mainMenuScene);
		});
		
		menu.getStartBtn().setOnMouseClicked(e -> {
			AudioHolder.MENUSONG.stop();
			AudioHolder.GAMESONG.play();
			primaryStage.setScene(gamescene);
			gameScreen.requestFocus();
			AnimationTimer animation = new AnimationTimer() {
				public void handle(long now) {
					gameScreen.paintComponent();
					logic.logicUpdate();
					if(logic.getIsGameEnd())
					{
						gameScreen.setOnMouseClicked(e -> {
							Platform.exit();
							System.exit(0);
						});
					}
					RenderableHolder.getInstance().update();
				}
			};
			animation.start();
		});
		
		
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
}
