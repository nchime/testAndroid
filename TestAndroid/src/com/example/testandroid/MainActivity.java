package com.example.testandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity implements android.widget.RadioGroup.OnCheckedChangeListener {

	private Button showToastButton;
	private EditText textToShow;
//	private EditText textMessage;
	private RadioGroup radioGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
//		textMessage = (EditText) findViewById(R.id.textView1);
		
		textToShow = (EditText) findViewById(R.id.autoCompleteTextView1);
		showToastButton = (Button) findViewById(R.id.button1);
		
		
		showToastButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(MainActivity.this,
						textToShow.getText().toString(), Toast.LENGTH_SHORT).show();
				
				textToShow.setText("처리 완료.."); 
			}
		});
		
		radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
		
		radioGroup.setOnCheckedChangeListener(this); 
		
		
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
	public void onCheckedChanged(RadioGroup group, int checkedId) {

		switch(checkedId) {
		
		case R.id.radio0 : 
			
			Toast.makeText(MainActivity.this,
					textToShow.getText().toString() + "1111", Toast.LENGTH_SHORT).show();
			break;  
			
		case R.id.radio1 : 
			
			Toast.makeText(MainActivity.this,
					textToShow.getText().toString() + "2222", Toast.LENGTH_SHORT).show();
			break;

		case R.id.radio2 : 
			
			Toast.makeText(MainActivity.this,
					textToShow.getText().toString() + "3333", Toast.LENGTH_SHORT).show();
			break;
		
		}
		
		
	}
	
	
}
