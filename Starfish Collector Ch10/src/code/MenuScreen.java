package code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputEvent.Type;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MenuScreen extends BaseScreen {

	@Override
	public void initialize() {
		BaseActor ocean = new BaseActor(0, 0, mainStage);
		ocean.loadTexture("assets/water.jpg");
		ocean.setSize(800, 600);
		
		BaseActor title = new BaseActor(0, 0, mainStage);
		title.loadTexture("assets/starfish-collector.png");
		//title.centerAtPosition(400, 300);
		//title.moveBy(0, 100);
		
		/*
		 * BaseActor start = new BaseActor(0,0, mainStage);
		 * start.loadTexture("assets/message-start.png");
		 * start.centerAtPosition(400, 300); start.moveBy(0, -100);
		 */
		
		TextButton startButton = new TextButton("Start", BaseGame.textButtonStyle);
		//startButton.setPosition(150, 150);
		//uiStage.addActor(startButton);
		
		startButton.addListener((Event e) -> {
			if ((e instanceof InputEvent)) {
				InputEvent ie = (InputEvent)e;
				if (ie.getType().equals(Type.touchDown)) {
					StarfishGame.setActiveScreen(new StoryScreen());
					return true;
				}
			}
			return false;
		});
		
		TextButton quitButton = new TextButton("Quit", BaseGame.textButtonStyle);
		
		//quitButton.setPosition(530, 150);
		//uiStage.addActor(quitButton);
		quitButton.addListener((Event e) -> {
			if ((e instanceof InputEvent)) {
				InputEvent ie = (InputEvent)e;
				if (ie.getType().equals(Type.touchDown)) {
					Gdx.app.exit();					
				}
			}
			return false;
		});
		
		uiTable.add(title).colspan(2);
		uiTable.row();
		uiTable.add(startButton);
		uiTable.add(quitButton);
		
	}

	@Override
	public void update(float dt) {
		
	}
	
	@Override
	public boolean keyDown(int keyCode) {
		if(Gdx.input.isKeyPressed(Keys.ENTER))
			StarfishGame.setActiveScreen(new StoryScreen());
		if(Gdx.input.isKeyPressed(Keys.ESCAPE))
			Gdx.app.exit();
		return false;
	}

}
