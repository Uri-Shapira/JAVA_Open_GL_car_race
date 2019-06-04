package edu.cg.models;

import java.io.File;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GL2ES3;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import edu.cg.algebra.Vec;

public class SkewedBox implements IRenderable {
    // TODO: Add you implementation from previous exercise.
    //       * Note you may want to enable textures here to render
    //         the wooden boxes.
    private double length, height1, height2, depth1, depth2;
    private boolean need_texture = false;
    private Texture texture = null;

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

    public SkewedBox(double squareSize){
        this.length = squareSize;
        this.height1 = squareSize;
        this.height2 = squareSize;
        this.depth1 = squareSize;
        this.depth2 = squareSize;
        this.need_texture = true;
    }

    @Override
    public void render(GL2 gl) {
        if(need_texture){
            texture.bind(gl);
            gl.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP_TO_EDGE);
            gl.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_MODULATE);

            gl.glEnable(GL.GL_TEXTURE_2D);
            gl.glBegin(GL2ES3.GL_QUADS)
                    gl.glTexCoord2f(0,0); gl.glVertex3f(1,2,0);
                    gl.glTexCoord2f(1,0); gl.glVertex3f(2,2,0);
                    gl.glTexCoord2f(0,1); gl.glVertex3f(1,0,1);
                    gl.glTexCoord2f(1,1); gl.glVertex3f(1, 1,1);
                    gl.glEnd();
            gl.glDisable(GL.GL_TEXTURE_2D);
        }else {

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
    }

    @Override
    public void init(GL2 gl) {
        File file = new File("/Users/itayzvi/Documents/Graphics/ex6/natives/macosx-universal/Textures/WoodBoxTexture.jpg");
        Texture texture;
        texture = TextureIO.newTexture(file, true);

    }

    @Override
    public void destroy(GL2 gl) {

    }
}
