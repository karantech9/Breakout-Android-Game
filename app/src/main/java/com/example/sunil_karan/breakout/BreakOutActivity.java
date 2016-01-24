package com.example.sunil_karan.breakout;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BreakOutActivity extends Activity {
    // The view for OpenGL
	private GLSurfaceView glSurfaceView;
	private boolean rendererSet = false;
	
	private TextView lives;
	private TextView score;
	private BreakOutRenderer rend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		glSurfaceView = new GLSurfaceView(this);

		glSurfaceView.setEGLContextClientVersion(2);
		rend = new BreakOutRenderer(this);
		glSurfaceView.setRenderer(rend);
		rendererSet = true;

		setContentView(R.layout.activity_breakout_top);
		LinearLayout l = (LinearLayout)findViewById(R.id.rel);

        // Get the lives and score TextViews
		lives = (TextView)findViewById(R.id.lives);
		score = (TextView)findViewById(R.id.score);
        // Start a new runnable that sets the lives and scores TextViews
		final Handler handle = new Handler();
		final Runnable r = new Runnable() {
			public void run() {
				lives.setText("Lives: " + String.valueOf(rend.getLives()));
				score.setText("Score: " + String.valueOf(rend.getScore()));
				handle.postDelayed(this, 1000);
			}
		};
		handle.postDelayed(r, 250);
		score.setTextColor(Color.WHITE);
		lives.setTextColor(Color.WHITE);
		l.addView(glSurfaceView);

		OnTouchListener ontouch = new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				rend.onTouchEvent(event);
				return true;
			}
		};
		glSurfaceView.setOnTouchListener(ontouch);

	}
	
	@Override
	protected void onPause() {
		super.onPause();
		if(rendererSet) {
			glSurfaceView.onPause();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		if(rendererSet) {
			glSurfaceView.onResume();
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.breakout_top, menu);
		return true;
	}

}
