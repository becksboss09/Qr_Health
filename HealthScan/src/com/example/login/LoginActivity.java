package com.example.login;

import java.util.HashMap;

import com.example.httprequests.GetRequest;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	
	//Username 
		private EditText user_txt;
		 // Password
	    private EditText pwd_txt;
	    // Sign In
	    private Button bLogin;
	    // Message
	//    private TextView tv_status;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Initialization
        user_txt = (EditText) findViewById(R.id.user_txt);
        pwd_txt = (EditText) findViewById(R.id.pwd_txt);
        bLogin = (Button) findViewById(R.id.bLogin);
      //  tv_status = (TextView) findViewById(R.id.tv_status);
        
        bLogin.setOnClickListener(new View.OnClickListener() {
						          
            @Override
            public void onClick(View view) {
                // Stores User name
                //String username = String.valueOf(user_txt.getText());
                // Stores Password
                //String password = String.valueOf(pwd_txt.getText());
                
                new AccoutInfo().execute("");
            }
        });
	}
	
	class AccoutInfo extends AsyncTask<String, String, String>{

		@Override
		protected String doInBackground(String... params) {
			
			// TODO Auto-generated method stub
			GetRequest getRequest = new GetRequest("healthfocus.cn", "/account/");
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("loginEmail", String.valueOf(user_txt.getText()));
			map.put("loginPassword", String.valueOf(pwd_txt.getText()));
			
			if(getRequest.getAccountInfo(map)){
				Intent intent = new Intent(".PATIENTHOMEPAGEACTIVITY");
				startActivity(intent);
			}
			else{
				Intent qrDroid = new Intent( ".SCANACTIVITY" );
				startActivityForResult(qrDroid, 0);
			}
				/*runOnUiThread(new Runnable() {
					@Override
					public void run() {
						Toast.makeText(getApplicationContext(), "Not a Patient", Toast.LENGTH_LONG).show();
					}
				});*/
			
			return null;
		}
		
	}
}
