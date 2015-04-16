package com.example.login;

import com.example.globaldata.GlobalData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PatientHomePageActivity extends Activity{
	
	Button patientInfoButton;
	Button suggestionsButton;
	Button educationalMaterialButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patient_home_layout);
		
		patientInfoButton = (Button) findViewById(R.id.patientInfoButton);
		suggestionsButton = (Button) findViewById(R.id.suggestionsButton);
		educationalMaterialButton = (Button) findViewById(R.id.educationalMaterialButton);
		
		patientInfoButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(".PRIVATEINFOACTIVITY");
				startActivity(intent);
				
			}
		});
		
		suggestionsButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(".SUGGESTIONSACTIVITY");
				startActivity(intent);
				
			}
		});
		
		educationalMaterialButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(".EDUCATIONALMATERIALACTIVITY");
				startActivity(intent);
				
			}
		});
	}
}
