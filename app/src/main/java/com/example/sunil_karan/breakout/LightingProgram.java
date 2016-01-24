package com.example.sunil_karan.breakout;

import static android.opengl.GLES20.glGetAttribLocation;
import static android.opengl.GLES20.glGetUniformLocation;
import static android.opengl.GLES20.glUniform1f;
import static android.opengl.GLES20.glUniform3f;
import static android.opengl.GLES20.glUniform4f;
import static android.opengl.GLES20.glUniformMatrix4fv;

public class LightingProgram extends ShaderProgram {
    // World matrix and World View Projection matrix locations
	private final int uWMatrixLocation;
	private final int uWVPMatrixLocation;
    // Locations for position, normals and colour
	private final int aPositionLocation;
	private final int aNormalLocation;
	private final int aColourLocation;
    // Eye position location
	private final int uEyePosLocation;
    // Directional light locations
	private final int uDirLightColLocation;
	private final int uDirLightAmbLocation;
	private final int uDirLightDirectLocation;
	private final int uDirLightDiffuseLocation;
	
	protected LightingProgram(String vertexShader, String fragmentShader) {
		super(vertexShader, fragmentShader);
        // Get matrix locations
		uWMatrixLocation = glGetUniformLocation(program, U_WMATRIX);
		uWVPMatrixLocation = glGetUniformLocation(program, U_WVPMATRIX);
				
		aPositionLocation = glGetAttribLocation(program, A_POSITION);
		aNormalLocation = glGetAttribLocation(program, A_NORMAL);
		aColourLocation = glGetAttribLocation(program, A_COLOUR);

		uEyePosLocation = glGetUniformLocation(program, U_EYEPOS);
		uDirLightColLocation = glGetUniformLocation(program, U_DIRLIGHTCOL);
		uDirLightAmbLocation = glGetUniformLocation(program, U_DIRLIGHTAMB);
		uDirLightDirectLocation = glGetUniformLocation(program, U_DIRLIGHTDIR);
		uDirLightDiffuseLocation = glGetUniformLocation(program, U_DIRLIGHTDIFF);
	}

	public void setEyePos(Vector3f eye) {
		glUniform3f(uEyePosLocation, eye.x, eye.y, eye.z);
	}
    // Set the directional lights attributes
	public void setDirectionalLight(DirectionalLight d) {
		glUniform3f(uDirLightColLocation, d.colour.x, d.colour.y, d.colour.z);
		glUniform1f(uDirLightAmbLocation, d.ambientIntens);
		Vector3f dir = d.direction;
		dir.normalize();
		glUniform4f(uDirLightDirectLocation, dir.x, dir.y, dir.z, 1.0f);
		glUniform1f(uDirLightDiffuseLocation, d.diffuseIntens);
	}

    // Set the world matrix and WVP matrix
	public void setUniform(Matrix4f world, Matrix4f WVP) {
		float[] w = world.convertShader();
		float[] wvp = WVP.convertShader();
				
		glUniformMatrix4fv(uWMatrixLocation, 1, false, w, 0);
		glUniformMatrix4fv(uWVPMatrixLocation, 1, false, wvp, 0);
				
	}

	public int getPositionAttribLocation() {
		return aPositionLocation;
	}

	public int getColourAttribLocation() {
		return aColourLocation;
	}

	public int getNormalAttribLocation() {
		return aNormalLocation;
	}

}
