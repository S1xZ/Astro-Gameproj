package logic;

import javafx.scene.image.Image;

public class SpritesHolder {
	private static String MeteorBig_path = ClassLoader.getSystemResource("image/MeteorBig.png").toString();
	private static String MeteorMedium1_path = ClassLoader.getSystemResource("image/MeteorMedium1.png").toString();
	private static String MeteorMedium2_path = ClassLoader.getSystemResource("image/MeteorMedium2.png").toString();
	private static String MeteorSmall1_path = ClassLoader.getSystemResource("image/MeteorSmall1.png").toString();
	private static String MeteorSmall2_path = ClassLoader.getSystemResource("image/MeteorSmall2.png").toString();
	private static String PlayerStatic_path = ClassLoader.getSystemResource("image/Player.png").toString();
	private static String PlayerMoving_path = ClassLoader.getSystemResource("image/PlayerMove.png").toString();
	private static String UFO_path = ClassLoader.getSystemResource("image/UFO.png").toString();
	private static String MenuBg_path = ClassLoader.getSystemResource("image/MenuBg.png").toString();
	private static String Bgvdo_path = ClassLoader.getSystemResource("image/bgvdo.gif").toString();
	
	public final static Image METEORBIG_SPRITE = new Image(MeteorBig_path);
	public final static Image METEORMEDIUM1_SPRITE = new Image(MeteorMedium1_path);
	public final static Image METEORMEDIUM2_SPRITE = new Image(MeteorMedium2_path);
	public final static Image METEORSMALL1_SPIRTE = new Image(MeteorSmall1_path);
	public final static Image METEORSMALL2_SPRITE = new Image(MeteorSmall2_path);
	public final static Image PLAYERSTATIC_SPRITE = new Image(PlayerStatic_path);
	public final static Image PLAYERMOVING_SPRITE = new Image(PlayerMoving_path);
	public final static Image UFO_SPRITE = new Image(UFO_path);
	public final static Image MENUBG_SPRITE = new Image(MenuBg_path);
	public final static Image BGVDO = new Image(Bgvdo_path);
	
}
