package logic;

import javafx.scene.media.AudioClip;

public class AudioHolder {
	
	private static String Gamesong_Path = ClassLoader.getSystemResource("audio/Gamesong.wav").toString();
	private static String Menusong_Path = ClassLoader.getSystemResource("audio/Menusong.wav").toString();
	private static String bullet_hit_Path = ClassLoader.getSystemResource("audio/bullet_hit.wav").toString();
	private static String bullet_shoot_Path = ClassLoader.getSystemResource("audio/bullet_shoot.wav").toString();
	private static String button_enter_Path = ClassLoader.getSystemResource("audio/button_enter.wav").toString();
	private static String deadsound_Path = ClassLoader.getSystemResource("audio/deadsound.wav").toString();
	private static String enemy_dead_Path = ClassLoader.getSystemResource("audio/enemy_dead.wav").toString();
	private static String ship_hit_Path = ClassLoader.getSystemResource("audio/ship_hit.wav").toString();
	private static String ufo_alive_Path = ClassLoader.getSystemResource("audio/ufo_alive.wav").toString();
	private static String newwave_Path = ClassLoader.getSystemResource("audio/newwave.wav").toString();
	
	public final static AudioClip GAMESONG = new AudioClip(Gamesong_Path);
	public final static AudioClip MENUSONG = new AudioClip(Menusong_Path);
	public final static AudioClip BULLET_HIT = new AudioClip(bullet_hit_Path);
	public final static AudioClip BULLET_SHOOT = new AudioClip(bullet_shoot_Path);
	public final static AudioClip BUTTON_ENTER = new AudioClip(button_enter_Path);
	public final static AudioClip DEADSOUND = new AudioClip(deadsound_Path);
	public final static AudioClip ENEMY_DEAD = new AudioClip(enemy_dead_Path);
	public final static AudioClip SHIP_HIT = new AudioClip(ship_hit_Path);
	public final static AudioClip UFO_ALIVE = new AudioClip(ufo_alive_Path);
	public final static AudioClip NEWWAVE = new AudioClip(newwave_Path);
	
}
