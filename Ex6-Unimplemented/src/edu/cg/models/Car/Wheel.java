package edu.cg.models.Car;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;

import edu.cg.models.IRenderable;

public class Wheel implements IRenderable {

	private void drawRim(GL2 gl){
		for(int i = 0; i < 20; i++){
			gl.glBegin(3);
			gl.glVertex3d(0.0,0.0,0.0);
			gl.glVertex3d(0.0,0.0,0.0);
			gl.glVertex3d(0.0,0.0,0.0);
			gl.glEnd();
		}
	}

	@Override
	public void render(GL2 gl) {
		GLU glu = new GLU();
		GLUquadric quad = glu.gluNewQuadric();
		Materials.setMaterialRims(gl);

		gl.glPushMatrix();
		gl.glTranslated(0.0, 0.0, Specification.TIRE_DEPTH / 2.0);
		glu.gluDisk(quad,Specification.TIRE_RADIUS / 1.5, Specification.TIRE_RADIUS,20, 1);
		glu.gluDisk(quad, 0.0, Specification.TIRE_RADIUS / 1.5, 20, 1);
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glTranslated(0.0,0.0,-Specification.TIRE_DEPTH / 2.0);
		gl.glRotated(180.0, 1.0, 0.0, 0.0);
		glu.gluDisk(quad, 0.0, Specification.TIRE_RADIUS / 1.5, 20, 1);
		glu.gluDisk(quad, Specification.TIRE_RADIUS / 1.5, Specification.TIRE_RADIUS, 20, 1);
		gl.glPopMatrix();

		Materials.setMaterialTire(gl);
		gl.glPushMatrix();
		gl.glTranslated(0.0, 0.0, - Specification.TIRE_DEPTH / 2.0);
		glu.gluCylinder(quad, Specification.TIRE_RADIUS, Specification.TIRE_RADIUS, Specification.TIRE_DEPTH, 20, 1);
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
		return "Wheel";
	}

}
