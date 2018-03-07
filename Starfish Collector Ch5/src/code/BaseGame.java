package code;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public abstract class BaseGame extends Game {
	private static BaseGame game;
	public static LabelStyle labelStyle;
	
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
		labelStyle.font = new BitmapFont(Gdx.files.internal("assets/meuteste.fnt"));
		
	}
	
	public static void setActiveScreen(BaseScreen s) {
		game.setScreen(s);
	}
			
}
