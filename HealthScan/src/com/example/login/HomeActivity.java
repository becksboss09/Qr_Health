package com.example.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity{
	
	Button qrCodeButton;
	Button loginButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_activity_layout);
		
		qrCodeButton = (Button) findViewById(R.id.qrCodeButton);
		qrCodeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent qrDroid = new Intent( ".SCANACTIVITY" );
				startActivityForResult(qrDroid, 0);
			}
		});
		
		loginButton = (Button) findViewById(R.id.loginButton);
		loginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(".LOGINACTIVITY");
				startActivity(intent);
			}
		});
		
	}

}
