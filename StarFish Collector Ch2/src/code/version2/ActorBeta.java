package code.version2;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;


/**
 * Classe que estende Actor para incluir graficos e deteccao de colisao.
 * Classe Actor armazena dados como posicao e rotacao
 *
 */
public class ActorBeta extends Actor {
	//Texture region possibilita maior flexibilidade que a Texture
	//Ela pode ser usada para guardar uma textura que contem diverasa
	// imagens ou quadros de animacao.
	//TR também guarda coordenadas, as quais determinam qual subarea
	//da Texture esta sendo usada.
	private TextureRegion textureRegion;
	private Rectangle rectangle;
	
	public ActorBeta() {
		super();
		this.textureRegion = new TextureRegion();
		this.rectangle = new Rectangle();
	}
	
	public void setTexture(Texture t) {
		this.textureRegion.setRegion(t);
		setSize(t.getWidth(), t.getHeight());
		this.rectangle.setSize(t.getWidth(), t.getHeight());
	}
	
	public Rectangle getRectangle() {
		this.rectangle.setPosition(getX(), getY());
		return  this.rectangle;
	}
	
	public boolean overlaps(ActorBeta other) {
		return this.getRectangle().overlaps(other.getRectangle());
	}
	
	public void act(float dt) {
		super.act(dt);
	}
	
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		Color c = getColor();
		batch.setColor(c.r, c.g, c.b, c.a);
		
		if(isVisible()) {
			batch.draw(textureRegion, getX(), getY(), getOriginX(), getOriginY(),
					   getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
		}
	}
}
