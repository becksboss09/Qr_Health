	package com.example.login;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.Button;

public class EducationalMaterialActivity extends Activity{

	Button button_edu;
	int diseaseId;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.educational_material_layout);
		
		button_edu = (Button)findViewById(R.id.button_edu);
		
		if (diseaseId==1)	
		{
		
		}
				
		button_edu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String strURL="http://www.safekidneycare.org/";
			Intent viewIntent = new Intent (Intent.ACTION_VIEW,Uri.parse(strURL));
		
	          startActivity(viewIntent);
				
			}
		});
		
				
	}
}
		
		
