package com.example.sunil_karan.breakout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import static android.opengl.GLES20.GL_LINEAR;
import static android.opengl.GLES20.GL_LINEAR_MIPMAP_LINEAR;
import static android.opengl.GLES20.GL_TEXTURE_2D;
import static android.opengl.GLES20.GL_TEXTURE_MAG_FILTER;
import static android.opengl.GLES20.GL_TEXTURE_MIN_FILTER;
import static android.opengl.GLES20.glBindTexture;
import static android.opengl.GLES20.glDeleteTextures;
import static android.opengl.GLES20.glGenTextures;
import static android.opengl.GLES20.glGenerateMipmap;
import static android.opengl.GLES20.glTexParameteri;
import static android.opengl.GLUtils.texImage2D;

public class Texture {
    // Function that loads the texture
	public static int loadTexture(Context context, int id) {
		final int[] textureID = new int [1];
		glGenTextures(1, textureID, 0);
				
		if(textureID[0] == 0) {
			return 0;
		}

		final Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), id);

		if(bitmap == null) {
			glDeleteTextures(1, textureID, 0);
			return 0;
		}

		glBindTexture(GL_TEXTURE_2D, textureID[0]);
        // Set the texture filtering to trilinear filtering
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

		texImage2D(GL_TEXTURE_2D, 0, bitmap, 0);
        // Generate the mipmaps for the texture
		glGenerateMipmap(GL_TEXTURE_2D);
		
		bitmap.recycle();
		glBindTexture(GL_TEXTURE_2D, 0);

		return textureID[0];
	}
}
