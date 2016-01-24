package com.example.sunil_karan.breakout;

import android.util.Log;

import static android.opengl.GLES20.GL_COMPILE_STATUS;
import static android.opengl.GLES20.GL_FRAGMENT_SHADER;
import static android.opengl.GLES20.GL_LINK_STATUS;
import static android.opengl.GLES20.GL_VERTEX_SHADER;
import static android.opengl.GLES20.glAttachShader;
import static android.opengl.GLES20.glCompileShader;
import static android.opengl.GLES20.glCreateProgram;
import static android.opengl.GLES20.glCreateShader;
import static android.opengl.GLES20.glDeleteProgram;
import static android.opengl.GLES20.glDeleteShader;
import static android.opengl.GLES20.glGetProgramiv;
import static android.opengl.GLES20.glGetShaderInfoLog;
import static android.opengl.GLES20.glGetShaderiv;
import static android.opengl.GLES20.glLinkProgram;
import static android.opengl.GLES20.glShaderSource;

public class ShaderHelper {
    // Compiles a shader
	private static int compileShader(int type, String shader) {
        // First create the shader
		final int shaderObject = glCreateShader(type);

		if(shaderObject == 0) {
			return 0;
		}
        // Add the source and compile it
		glShaderSource(shaderObject, shader);
		glCompileShader(shaderObject);
        // Check the status of the compile
		final int[] compileStatus = new int[1];
		glGetShaderiv(shaderObject, GL_COMPILE_STATUS, compileStatus, 0);
				
		if(compileStatus[0] == 0) {
			Log.v("Shader", "Results of compiling source:" + "\n:"
                    + glGetShaderInfoLog(shaderObject));
			glDeleteShader(shaderObject);
			
			return 0;
		}
				
		return shaderObject;

	}
    // Link the two shadrs together
	public static int linkProgram(int vertexShader, int fragmentShader) {
		int programObject = glCreateProgram();
		if(programObject == 0) {
			return 0;
		}

		glAttachShader(programObject, vertexShader);
		glAttachShader(programObject, fragmentShader);
				
		glLinkProgram(programObject);

		final int[] linkStatus = new int[1];
		glGetProgramiv(programObject, GL_LINK_STATUS, linkStatus, 0);
		if(linkStatus[0] == 0) {
			glDeleteProgram(programObject);
			return 0;
		}
				
		return programObject;

	}
    // Build the program
	public static int build(String vertexShaderCode, String fragmentShaderCode)
	{
		int vertexShader = compileShader(GL_VERTEX_SHADER, vertexShaderCode);
		int fragmentShader = compileShader(GL_FRAGMENT_SHADER, fragmentShaderCode);
			
		return linkProgram(vertexShader, fragmentShader);
	}



}
