package com.example.testandroid;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivityTest1 extends Activity {

	private WebView webViewMain;
	private Button btn1, btn2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_test1);

		
		// 다이얼로그 팝업 표시 예제 
		btn1 = (Button) findViewById(R.id.button1);

		btn1.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				
				Log.i("kwaktest", "MainActivityTest1 - btn1 Dialog ");
				
				AlertDialog.Builder bid = new AlertDialog.Builder(
						MainActivityTest1.this);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss", Locale.KOREA);
				Date date = new Date();
				String sdate = sdf.format(date);    

				bid.setTitle("현재 시간 : " + sdate);
				bid.setMessage("대화상자 테스트입니다.");
				bid.setIcon(R.drawable.ic_launcher);

				bid.setPositiveButton("확인",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
							}
						});

				bid.setPositiveButton("취소",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
							}
						});
				bid.show(); 
			}
		});
		
		
		
		
		// 다른 Activity 이동 
		btn2 = (Button) findViewById(R.id.button2);

		btn2.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Log.i("onClick", "IntroActivity");
				
				Intent intentSubActivity = 
						new Intent(MainActivityTest1.this, IntroActivity.class);
				startActivity(intentSubActivity);
				
			}
			
			
		}); 

		
		
		
		
		

		/*
		 * webViewMain = (WebView) findViewById(R.id.webView1);
		 * 
		 * WebSettings webSettings = webViewMain.getSettings();
		 * webSettings.setJavaScriptEnabled(true);
		 * webSettings.setBuiltInZoomControls(false); // Zoom 컨트롤러는 표시 설정
		 * 
		 * webViewMain.setWebViewClient(new WebViewClient() {});
		 * webViewMain.setWebChromeClient(new WebChromeClient() {});
		 * 
		 * webViewMain.loadUrl("file:///android_asset/www/index.html");
		 */
		ArrayList<String> arGeneral = new ArrayList<String>();
		arGeneral.add("테스트메뉴1");
		arGeneral.add("테스트메뉴2");
		arGeneral.add("테스트메뉴3");
		arGeneral.add("테스트메뉴4");

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_checked, arGeneral);

		ListView list = (ListView) findViewById(R.id.listView1);
		list.setAdapter(adapter);

	}

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
		if (webViewMain.canGoBack()) {
			webViewMain.goBack();
		} else {
			finish();
		}
	}

}
