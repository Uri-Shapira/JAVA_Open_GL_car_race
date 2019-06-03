package edu.cg.models.Car;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;

import edu.cg.models.IRenderable;

public class PairOfWheels implements IRenderable {

	private final Wheel wheel = new Wheel();
	private double z_posit = (Specification.PAIR_OF_WHEELS_ROD_DEPTH + Specification.TIRE_DEPTH) / 2.0;
	
	@Override
	public void render(GL2 gl) {
		GLU glu = new GLU();
		GLUquadric quad = glu.gluNewQuadric();
		Materials.SetDarkGreyMetalMaterial(gl);
		gl.glPushMatrix();
		gl.glTranslated(0.0, 0.0, z_posit);
		wheel.render(gl);
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glTranslated(0.0, 0.0, -z_posit);
		wheel.render(gl);
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glTranslated(0.0, 0.0, - Specification.PAIR_OF_WHEELS_ROD_DEPTH / 2.0);
		glu.gluCylinder(quad, Specification.PAIR_OF_WHEELS_ROD_RADIUS, Specification.PAIR_OF_WHEELS_ROD_RADIUS,
				Specification.PAIR_OF_WHEELS_ROD_DEPTH, 20, 1);
		gl.glPopMatrix();
	}

	@Override
	public void init(GL2 gl) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy(GL2 gl) {

	}

	@Override
	public String toString() {
		return "PairOfWheels";
	}

}
