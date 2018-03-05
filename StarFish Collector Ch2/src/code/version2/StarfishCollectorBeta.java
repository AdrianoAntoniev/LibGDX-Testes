package code.version2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class StarfishCollectorBeta extends GameBeta {
	private Turtle turtle;
	private ActorBeta starfish;
	private ActorBeta ocean;
	private ActorBeta winMessage;
	
	private boolean win;

	@Override
	public void initialize() {
		ocean = ActorBuilder.createActor("water.jpg");				
		mainStage.addActor(ocean);
		
		starfish = ActorBuilder.createActor("starfish.png");
		starfish.setPosition(380, 380);
		mainStage.addActor(starfish);
		
		turtle = ActorBuilder.createTurtle("turtle-1.png");
		turtle.setPosition(20, 20);
		mainStage.addActor(turtle);
		
		winMessage = ActorBuilder.createActor("you-win.png");
		winMessage.setPosition(180, 180);
		winMessage.setVisible(false);
		mainStage.addActor(winMessage);
		
		win = false;
	}
	
	@Override
	public void update(float dt) {
		if(turtle.overlaps(starfish)) {
			starfish.remove();
			winMessage.setVisible(true);
		}
		
	}
}
