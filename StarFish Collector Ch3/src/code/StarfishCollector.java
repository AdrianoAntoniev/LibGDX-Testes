package code;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class StarfishCollector extends GameBeta {
	private Turtle turtle;
	private boolean win;
		
	@Override
	public void initialize() {
		BaseActor ocean = new BaseActor(0,0, mainStage);
		ocean.loadTexture("assets/water.jpg");
		ocean.setSize(1200, 900);
		
		// Arrumar num futuro proximo, pois nao esta conciso.
		BaseActor.setWorldBounds(ocean);
		
		new Starfish(400,400, mainStage);
		new Starfish(500,100, mainStage);
		new Starfish(100,450, mainStage);
		new Starfish(200,250, mainStage);
		
		new Rock(200,150,mainStage);
		new Rock(100,300,mainStage);
		new Rock(300,350,mainStage);
		new Rock(400,200,mainStage);
		
		turtle = new Turtle(20, 20, mainStage);
		
		win = false;
	}

	@Override
	public void update(float dt) {
		for(BaseActor rockActor : BaseActor.getList(mainStage, "code.Rock"))
			turtle.preventOverlap(rockActor);
		
		for(BaseActor starfishActor : BaseActor.getList(mainStage, "code.Starfish")){
			Starfish starfish = (Starfish)starfishActor;
			if(turtle.overlaps(starfish) && !starfish.isCollected()) {
				starfish.collect();
				
				Whirlpool whirl = new Whirlpool(0,0, mainStage);
				whirl.centerAtActor( starfish );
				whirl.setOpacity(0.25f);		
	
			}
		}
			
		if(BaseActor.count(mainStage, "code.Starfish") == 0 && !win) {
			win = true;
			BaseActor youWinMessage = new BaseActor(0,0, uiStage);
			youWinMessage.loadTexture("assets/you-win.png");
			youWinMessage.centerAtPosition(400, 300);
			youWinMessage.setOpacity(0);
			youWinMessage.addAction(Actions.delay(1));
			youWinMessage.addAction(Actions.after(Actions.fadeIn(1)));
		}

	}

}
