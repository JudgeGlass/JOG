package net.zicron.jol;

import net.zicron.jol.gfx.Renderer;
import net.zicron.jol.gfx.Screen;
import net.zicron.jol.io.Texture;
import net.zicron.jol.level.Level;
import net.zicron.jol.level.Player;

public class JOG {
	
	public static boolean DRAW_HITBOX = false;
	public static boolean isRunning = false;
	
	public static Texture gameTextures;
	public static Texture fontTextures;
	public static Texture entityTextures;
	
	public static void main(String args[]) {
		Screen gameScreen = new Screen(1200, 800);
		gameScreen.init();
		
		Renderer gameRenderer = new Renderer();
		gameRenderer.setThreadSleep(13);
		
		isRunning = true;
		
		//new Thread(() -> new Server(800).start()).start();
		
		gameTextures = new Texture("res/atlas.png");
		entityTextures = new Texture("res/entityAtlas.png");
		entityTextures.pw = 8;
		entityTextures.ph = 8;
		fontTextures = new Texture("res/fontAtlas.png");
		fontTextures.pw = 8;
		fontTextures.ph = 8;


		new Level();
		new Player();
		
		gameRenderer.startLoop();
	}
}
