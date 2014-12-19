package com.example.testandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class IntroActivity extends Activity {

	Handler h;
	
	
	// 인트로 로딩 시간 설정 2초
	private final int INTRO_DELAY_TIME = 2000; 
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 타이틀 삭제
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_intro);

		h = new Handler();
		h.postDelayed(irun, INTRO_DELAY_TIME);
	}

	Runnable irun = new Runnable() {

		@Override
		public void run() {

//			Intent i = new Intent(IntroActivity.this, MainActivity.class);
			Intent i = new Intent(IntroActivity.this, MainActivityTest1.class);
			startActivity(i);
			finish();

			overridePendingTransition(android.R.anim.fade_in,
					android.R.anim.fade_out);
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();

		h.removeCallbacks(irun);
	}
}
