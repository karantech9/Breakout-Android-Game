package com.example.sunil_karan.breakout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class GameCompleteActivity extends Activity implements OnTouchListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_complete);
		View v = (View) findViewById(R.id.view1);
		v.setOnTouchListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_over, menu);
		return true;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
        final Intent menu = new Intent(this, MainMenu.class);
        startActivity(menu);
        return false;
	}
}
