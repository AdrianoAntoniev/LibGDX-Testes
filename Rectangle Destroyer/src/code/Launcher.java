package code;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class Launcher {
	public static void main(String[] args) {
		Game myGame = new RectangleGame();
		LwjglApplication launcher = new LwjglApplication(myGame, "Rectangle Destroyer", 800, 600);
	}
}