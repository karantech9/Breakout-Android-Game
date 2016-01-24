package com.example.sunil_karan.breakout;

import static android.opengl.GLES20.glUseProgram;

public abstract class ShaderProgram {
    // Name of the matrices in the shader
    protected static final String U_WMATRIX = "u_WMatrix";
	protected static final String U_WVPMATRIX = "u_WVPMatrix";
    // Name of position, normal and colour attributes in the shader
	protected static final String A_POSITION = "a_Pos";
	protected static final String A_NORMAL = "a_Normal";
	protected static final String A_COLOUR = "a_Colour";
    // Name of eye position in shader
	protected static final String U_EYEPOS = "u_EyePos";
    // Name of directional light attributes in the shader
    protected static final String U_DIRLIGHTCOL = "gDirectionalLight.Base.Colour";
	protected static final String U_DIRLIGHTAMB = "gDirectionalLight.Base.AmbientIntensity";
	protected static final String U_DIRLIGHTDIR = "gDirectionalLight.Direction";
	protected static final String U_DIRLIGHTDIFF = "gDirectionalLight.Base.DiffuseIntensity";
    // Name of texture coordinate in the shader
	protected static final String A_TEXCOORD = "a_TexCoord";
    // Name of uniform texture in the shader
	protected static final String U_TEXUNIT = "a_TexUnit";

	protected final int program;

	protected ShaderProgram(String vertexShader, String fragmentShader) {
		program = ShaderHelper.build(vertexShader, fragmentShader);
	}

	public void useProgram() {
		glUseProgram(program);
	}

}
