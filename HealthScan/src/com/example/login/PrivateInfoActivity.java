package com.example.login;

import java.util.ArrayList;

import com.example.globaldata.GlobalData;
import com.example.globaldata.Patient;
import com.example.httprequests.GetRequest;
import com.example.login.PublicInfoActivity.GetPublicData;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class PrivateInfoActivity extends Activity{
	
	TextView private_firstNameTextView;
	TextView private_lastNameTextView;
	TextView private_bloodtype;
	TextView private_emergcontact;
	TextView private_dob;
         
                                  
	String privatelink;
	String prvfirstName;
	String prvlastName;
	String bloodtype;
	String emercontact;
	String dob;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patient_info_layout);
		
		privatelink = "http://healthfocus.cn/qrcode/getPatientByAccountID?accountId="+GlobalData.accountId;
		Toast.makeText(getApplicationContext(), privatelink, 1000).show();
		getIntent().getStringExtra("privatelink");
	//Toast.makeText(getApplicationContext(), a, 100000).show();
		
		private_firstNameTextView = (TextView) findViewById(R.id.private_firstNameTextView);
		private_lastNameTextView = (TextView) findViewById(R.id.private_lastNameTextView);
		//private_bloodtype = (TextView) findViewById(R.id.private_bloodtype);
		//private_emergcontact = (TextView) findViewById(R.id.private_emergcontact);
		//private_dob = (TextView) findViewById(R.id.private_dob);
		
		//ArrayList<String> name = GetRequest.getPrivateInfo(privatelink);
		//prvfirstName = name.get(0);
		//Toast.makeText(getApplicationContext(), prvfirstName, 1000).show();
			
		new GetPrivateData().execute("");
	
		}
	
	class GetPrivateData extends AsyncTask<String, String, String>{

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			Patient p=GetRequest.getPrivateInfo(privatelink);
           
			prvfirstName = p.getFname();
			prvlastName = p.getLname();
			Toast.makeText(getApplicationContext(), "Fname"+prvfirstName+"  "+"Lname"+prvlastName,20000).show();
			//bloodtype	= name.get(2);
			//emercontact = name.get(3);
			//dob = name.get(4);
			
			return null;
		}
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
		private_firstNameTextView.setText(prvfirstName);
		private_lastNameTextView.setText(prvlastName);
			//private_bloodtype.setText(bloodtype);
			//private_emergcontact.setText(emercontact);
			//private_dob.setText(dob);
		}
	}
}

