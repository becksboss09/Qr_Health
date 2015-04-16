package com.example.login;

import java.util.ArrayList;

import com.example.httprequests.GetRequest;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class PublicInfoActivity extends Activity{
	
	TextView firstNameTextView;
	TextView lastNameTextView;
	
	String link;
	String firstName;
	String lastName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.public_info_layout);
		
		link = getIntent().getStringExtra("link");
		firstNameTextView = (TextView) findViewById(R.id.firstNameTextView);
		lastNameTextView = (TextView) findViewById(R.id.lastNameTextView);
		
		new GetPublicData().execute("");
		
	}
	
	class GetPublicData extends AsyncTask<String, String, String>{

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			
			ArrayList<String> name = GetRequest.getPublicInfo(link);
			
			firstName = name.get(0);
			lastName = name.get(1);
			
			return null;
		}
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			firstNameTextView.setText(firstName);
			lastNameTextView.setText(lastName);
		}
		
	}
}
