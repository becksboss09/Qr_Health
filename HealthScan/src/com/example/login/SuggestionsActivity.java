package com.example.login;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.httprequests.GetRequest;
import com.example.login.LoginActivity.AccoutInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class SuggestionsActivity extends Activity{
	
	String suggestions = new String();
	TextView suggestionsSection;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.suggestions_layout);
		
		suggestionsSection = (TextView) findViewById(R.id.suggestionsSection);
		
		new DiseaseInfo().execute("");
	}
	class DiseaseInfo extends AsyncTask<String, String, String>{

		@Override
		
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			GetRequest getRequest = new GetRequest("healthfocus.cn", "/suggestion/");
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("diseaseId", "1");
			
			suggestions = getRequest.DiseaseInfo(map);
				
			return null;
		}
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			suggestionsSection.setText(suggestions + "");
		}
		
	}
}



