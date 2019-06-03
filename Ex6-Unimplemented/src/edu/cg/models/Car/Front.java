package edu.cg.models.Car;

import com.jogamp.opengl.GL2;
import edu.cg.models.IRenderable;
import edu.cg.models.SkewedBox;

public class Front implements IRenderable {
	private SkewedBox hoodBox1 = new SkewedBox(Specification.F_HOOD_LENGTH_1,Specification.F_HOOD_HEIGHT_1,Specification.F_HOOD_HEIGHT_2,Specification.F_HOOD_DEPTH_1,Specification.F_HOOD_DEPTH_2);
	private SkewedBox hoodBox2 = new SkewedBox(Specification.F_HOOD_LENGTH_2,Specification.F_HOOD_HEIGHT_2,Specification.F_BUMPER_HEIGHT_1,Specification.F_HOOD_DEPTH_2,Specification.F_HOOD_DEPTH_3);
	private SkewedBox bumperBox = new SkewedBox(Specification.F_BUMPER_LENGTH,Specification.F_BUMPER_HEIGHT_1,Specification.F_BUMPER_HEIGHT_2,Specification.F_BUMPER_DEPTH,Specification.F_BUMPER_DEPTH);
	private SkewedBox bumperWingsBox = new SkewedBox(Specification.F_BUMPER_LENGTH,Specification.F_BUMPER_WINGS_HEIGHT,Specification.F_BUMPER_HEIGHT_2,Specification.F_BUMPER_WINGS_DEPTH,Specification.F_BUMPER_WINGS_DEPTH);
	private PairOfWheels wheels = new PairOfWheels();


	@Override
	public void render(GL2 gl) {
		Materials.SetRedMetalMaterial(gl);

		gl.glPushMatrix();
		gl.glTranslated(- Specification.F_HOOD_LENGTH_2 / 2.0 - Specification.F_BUMPER_LENGTH / 2.0,0.0,0.0);
		hoodBox1.render(gl);
		gl.glTranslated(Specification.F_HOOD_LENGTH_1 / 2.0 + Specification.F_HOOD_LENGTH_2 / 2.0, 0.0, 0.0);
		this.hoodBox2.render(gl);
		gl.glTranslated(0.0, 0.05, 0.0);
		this.wheels.render(gl);
		gl.glPopMatrix();


		gl.glPushMatrix();
		Materials.SetDarkRedMetalMaterial(gl);
		gl.glTranslated(0.01 + Specification.F_HOOD_LENGTH_2 + Specification.F_BUMPER_LENGTH / 2.0, 0.0, 0.0);
		this.bumperBox.render(gl);
		gl.glPopMatrix();

		Materials.SetRedMetalMaterial(gl);

		gl.glPushMatrix();
		gl.glTranslated(0.01 + Specification.F_HOOD_LENGTH_2 + Specification.F_BUMPER_LENGTH / 2.0, 0.0, 0.0);
		gl.glTranslated(0.0, 0.0, Specification.F_BUMPER_DEPTH / 2.0 + Specification.F_BUMPER_WINGS_DEPTH / 2.0);
		this.bumperWingsBox.render(gl);
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glTranslated(0.01 + Specification.F_HOOD_LENGTH_2 + Specification.F_BUMPER_LENGTH / 2.0, 0.0, 0.0);
		gl.glTranslated(0.0, 0.0, -Specification.F_BUMPER_DEPTH / 2.0 - Specification.F_BUMPER_WINGS_DEPTH / 2.0);
		this.bumperWingsBox.render(gl);
		gl.glPopMatrix();
	}

	@Override
	public void init(GL2 gl) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy(GL2 gl) {

	}

}
