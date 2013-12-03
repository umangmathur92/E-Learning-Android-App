package com.example.e_learningdemo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void openthis(View view)
	{
		//Toast.makeText(getApplicationContext(), "exception",Toast.LENGTH_LONG).show();
		
		Intent i = new Intent(this, TaskActivity.class);
		startActivity(i);
	}
}
