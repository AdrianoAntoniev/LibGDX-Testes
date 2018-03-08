

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

public abstract class BaseGame extends Game {
	private static BaseGame game;
	public static LabelStyle labelStyle;
	public static TextButtonStyle textButtonStyle;
	
	public BaseGame() {
		game = this;
	}
	
	@Override
	public void create() {
		/*
			
		FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("assets/OpenSans.ttf"));
		FreeTypeFontParameter fontParameters = new FreeTypeFontParameter();
		fontParameters.size = 48;
		fontParameters.color = Color.WHITE;
		fontParameters.borderWidth = 2;
		fontParameters.borderColor = Color.BLACK;
		fontParameters.borderStraight = true;
		fontParameters.minFilter = TextureFilter.Linear;
		fontParameters.magFilter = TextureFilter.Linear;
		
		BitmapFont customFont = fontGenerator.generateFont(fontParameters);
		
		*/
		InputMultiplexer im = new InputMultiplexer();
		Gdx.input.setInputProcessor(im);
		labelStyle = new LabelStyle();
		BitmapFont myFont = new BitmapFont(Gdx.files.internal("assets/meuteste.fnt")); 
		labelStyle.font = myFont;
		
		textButtonStyle = new TextButtonStyle();
		Texture buttonTex = new Texture(Gdx.files.internal("assets/button.png"));
		NinePatch buttonPatch = new NinePatch(buttonTex, 24,24,24,24);
		textButtonStyle.up = new NinePatchDrawable(buttonPatch);
		textButtonStyle.font = myFont;
		textButtonStyle.fontColor = Color.GRAY;
	}
	
	public static void setActiveScreen(BaseScreen s) {
		game.setScreen(s);
	}
			
}
