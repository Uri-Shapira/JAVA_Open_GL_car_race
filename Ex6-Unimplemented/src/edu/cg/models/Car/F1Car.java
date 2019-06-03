package edu.cg.models.Car;

import java.util.LinkedList;
import java.util.List;

import com.jogamp.opengl.*;

import edu.cg.algebra.Point;
import edu.cg.models.IRenderable;

/**
 * A F1 Racing Car.
 *
 */
public class F1Car implements IRenderable {
	// TODO: Put your implementation from previous exercise.
	// 		 * We deleted all components source files (Back.java, Center.java...), so put your components implementation as well.
	//       * You also need to setup material properties for different
	//       * components of the car.
    private Back back = new Back();
    private Center center = new Center();
    private Front front = new Front();


    @Override
    public void render(GL2 gl) {
        gl.glPushMatrix();
        gl.glTranslated(- Specification.C_BASE_LENGTH / 2.0 - Specification.B_LENGTH / 2.0, 0.0, 0.0);
        back.render(gl);
        gl.glPopMatrix();

        center.render(gl);

        gl.glPushMatrix();
        gl.glTranslated(Specification.C_BASE_LENGTH / 2.0 + Specification.F_FRONT_LENGTH / 2.0, 0.0, 0.0);
        this.front.render(gl);
        gl.glPopMatrix();
    }

    @Override
    public void init(GL2 gl) {

    }

    @Override
    public void destroy(GL2 gl) {

    }
}
