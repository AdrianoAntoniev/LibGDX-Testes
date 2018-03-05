package code.version2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class LauncherBeta {

	public static void main(String[] args) {
		Game mygame = new StarfishCollectorBeta();
		LwjglApplication launcher = new LwjglApplication(mygame, "Starfish Collector", 800, 600);

	}

}
