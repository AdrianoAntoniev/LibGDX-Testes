package code.version2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class ActorBuilder {
	private ActorBuilder() {}
	
	public static ActorBeta createActor(String filename) {
		ActorBeta entity = new ActorBeta();
		return configureActor(filename, entity);
	}

	public static Turtle createTurtle(String filename) {
		Turtle turtle = new Turtle();
		return (Turtle)configureActor(filename, turtle);
	}
	
	private static ActorBeta configureActor(String filename, ActorBeta actor) {		
		filename = "assets/" + filename; 
		actor.setTexture(new Texture(Gdx.files.internal(filename)));
		return actor;
	}
}
