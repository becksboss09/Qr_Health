package com.example.login;

import la.droid.qr.services.Services;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

public class ScanActivity extends Activity {

	private static final int ACTIVITY_RESULT_QR_DRDROID = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.scan);
		
		//Get Spinner instance
		final Spinner spinner = (Spinner) findViewById(R.id.spin_complete);
		
		//"Scan" button
		final Button button = (Button) findViewById(R.id.button_scan);
		//Set action to button
		button.setOnClickListener( new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Create a new Intent to send to QR Droid
				Intent qrDroid = new Intent( Services.SCAN ); //Set action "la.droid.qr.scan"
				
				//Check whether a complete or displayable result is needed
				if( spinner.getSelectedItemId()==0 ) { //First item selected ("Complete content")
					//Notify we want complete results (default is FALSE)
					qrDroid.putExtra( Services.COMPLETE , true);
				}
				
				//Send intent and wait result
				try {
					startActivityForResult(qrDroid, ACTIVITY_RESULT_QR_DRDROID);
				} catch (ActivityNotFoundException activity) {
					Services.qrDroidRequired(ScanActivity.this);
				}
			}
		});
	}

	@Override
	/**
	 * Reads data scanned by user and returned by QR Droid
	 */
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if( ACTIVITY_RESULT_QR_DRDROID==requestCode && null!=data && data.getExtras()!=null ) {
			//Read result from QR Droid (it's stored in la.droid.qr.result)
			String result = data.getExtras().getString(Services.RESULT);
			
			System.out.println("here");
			
			Intent intent = new Intent(".PUBLICINFOACTIVITY");
			intent.putExtra("link", result);
			startActivity(intent);
		}
	}
	
	@Override
    public void onConfigurationChanged(Configuration newConfig) {
    	super.onConfigurationChanged(newConfig);
    	//Nothing
    }
}
