package edu.cg.models;

import java.io.File;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import edu.cg.algebra.Vec;

public class SkewedBox implements IRenderable {
    // TODO: Add you implementation from previous exercise.
    //       * Note you may want to enable textures here to render
    //         the wooden boxes.
    private double length, height1, height2, depth1, depth2;

    public SkewedBox() {
        length = .1;
        height1 = .2;
        height2 = .1;
        depth1 = .2;
        depth2 = .1;
    }

    public SkewedBox(double length, double h1, double h2, double d1, double d2) {
        this.length = length;
        this.height1 = h1;
        this.height2 = h2;
        this.depth1 = d1;
        this.depth2 = d2;
    }

    @Override
    public void render(GL2 gl) {
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3d(this.length / 2.0, 0.0, this.depth2 / 2.0);
        gl.glVertex3d(this.length / 2.0, 0.0, -this.depth2 / 2.0);
        gl.glVertex3d(this.length / 2.0, this.height2, -this.depth2 / 2.0);
        gl.glVertex3d(this.length / 2.0, this.height2, this.depth2 / 2.0);
        gl.glEnd();

        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3d(-this.length / 2.0, 0.0, -this.depth1 / 2.0);
        gl.glVertex3d(-this.length / 2.0, 0.0, this.depth1 / 2.0);
        gl.glVertex3d(-this.length / 2.0, this.height1, this.depth1 / 2.0);
        gl.glVertex3d(-this.length / 2.0, this.height1, -this.depth1 / 2.0);
        gl.glEnd();

        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3d(-this.length / 2.0, this.height1, this.depth1 / 2.0);
        gl.glVertex3d(this.length / 2.0, this.height2, this.depth2 / 2.0);
        gl.glVertex3d(this.length / 2.0, this.height2, -this.depth2 / 2.0);
        gl.glVertex3d(-this.length / 2.0, this.height1, -this.depth1 / 2.0);
        gl.glEnd();

        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3d(-this.length / 2.0, 0.0, this.depth1 / 2.0);
        gl.glVertex3d(-this.length / 2.0, 0.0, -this.depth1 / 2.0);
        gl.glVertex3d(this.length / 2.0, 0.0, -this.depth2 / 2.0);
        gl.glVertex3d(this.length / 2.0, 0.0, this.depth2 / 2.0);
        gl.glEnd();

        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3d(-this.length / 2.0, this.height1, this.depth1 / 2.0);
        gl.glVertex3d(-this.length / 2.0, 0.0, this.depth1 / 2.0);
        gl.glVertex3d(this.length / 2.0, 0.0, this.depth2 / 2.0);
        gl.glVertex3d(this.length / 2.0, this.height2, this.depth2 / 2.0);
        gl.glEnd();

        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3d(-this.length / 2.0, 0.0, -this.depth1 / 2.0);
        gl.glVertex3d(-this.length / 2.0, this.height1, -this.depth1 / 2.0);
        gl.glVertex3d(this.length / 2.0, this.height2, -this.depth2 / 2.0);
        gl.glVertex3d(this.length / 2.0, 0.0, -this.depth2 / 2.0);
        gl.glEnd();
    }

    @Override
    public void init(GL2 gl) {

    }

    @Override
    public void destroy(GL2 gl) {

    }
}
