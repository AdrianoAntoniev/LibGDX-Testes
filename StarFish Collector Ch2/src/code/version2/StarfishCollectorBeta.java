package code.version2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class StarfishCollectorBeta extends Game {
	private Turtle turtle;
	private ActorBeta starfish;
	private ActorBeta ocean;
	private ActorBeta winMessage;
	
	private Stage mainStage;
	private boolean win;

	@Override
	public void create() {
		mainStage = new Stage();
		
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
	public void render() {
		mainStage.act(1/60f);
		
		if(turtle.overlaps(starfish)) {
			starfish.remove();
			winMessage.setVisible(true);
		}
		
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		mainStage.draw();
	}
}
