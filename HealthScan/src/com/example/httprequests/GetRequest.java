package com.example.httprequests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.globaldata.GlobalData;
import com.example.globaldata.Patient;

public class GetRequest {
	
	String hostName;
	String folderAddress;

	public GetRequest(String hostName, String folderAddress) {
		this.hostName = hostName;
		this.folderAddress = folderAddress;
	}
	
	public boolean getAccountInfo(HashMap<String, String> arguments){
		
		boolean isPatient = false;
		
		String url = "http://" + hostName + folderAddress + "?";
		ArrayList<String> result = new ArrayList<>();
		
		for (Map.Entry<String, String> entry : arguments.entrySet()) {
			url = url + "&" + entry.getKey() + "=" + entry.getValue();
		}
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		
		System.out.println("\nSending 'GET' request to URL : " + url);
 
		HttpResponse response;
		try {
			response = client.execute(request);
			InputStream instream = response.getEntity().getContent();
			BufferedReader in = new BufferedReader(new InputStreamReader(instream));
	    	StringBuilder responseStrBuilder = new StringBuilder();
    	    String inputStr;
    	    while ((inputStr = in.readLine()) != null)
    	    	responseStrBuilder.append(inputStr);
    	    System.out.println(responseStrBuilder.toString());
    	    		JSONObject object = new JSONObject(responseStrBuilder.toString());
    	    		
    	    	    		
    	    		
    	    		GlobalData.accountId = object.getInt("account_id");
    	    		if(object.getString("dp").compareToIgnoreCase("p") == 0)
    	    			isPatient = true;
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isPatient;
	}
	
	public static ArrayList<String> getPublicInfo(String link){
		
		ArrayList<String> pubinfo = new ArrayList<>();
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(link);
		
		System.out.println("\nSending 'GET' request to URL : " + link);
 
		HttpResponse response;
		try {
			response = client.execute(request);
			InputStream instream = response.getEntity().getContent();
			BufferedReader in = new BufferedReader(new InputStreamReader(instream));
	    	StringBuilder responseStrBuilder = new StringBuilder();
    	    String inputStr;
    	    while ((inputStr = in.readLine()) != null)
    	    	responseStrBuilder.append(inputStr);
    	    System.out.println(responseStrBuilder.toString());
    	    		JSONObject object = new JSONObject(responseStrBuilder.toString()).getJSONObject("patient");
    	    		
    	    		pubinfo.add(object.getString("patient_first_name"));
    	    		pubinfo.add(object.getString("patient_last_name"));
    	    		
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pubinfo;
	}
	
public static Patient getPrivateInfo(String privatelink){
	//System.out.println("\nSending 'GET' request to URL private  : ");
	
	 Patient p= new Patient();
		
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(privatelink);
		
		System.out.println("\nSending 'GET' request to URL private  : " + privatelink);
 
		HttpResponse response;
		try {
			
			response = client.execute(request);
			InputStream instream = response.getEntity().getContent();
			BufferedReader in = new BufferedReader(new InputStreamReader(instream));
	    	StringBuilder responseStrBuilder = new StringBuilder();
    	    String inputStr;
    	    while ((inputStr = in.readLine()) != null)
    	    	responseStrBuilder.append(inputStr);
    	   // System.out.println(responseStrBuilder.toString()); 	    
    	     	        	     
    	    JSONObject object = new JSONObject(responseStrBuilder.toString());
            JSONArray array = object.getJSONArray("patients");
            System.out.println("Ithe Ala"+array);
           
            for(int i = 0; i < array.length(); i++){
            	
            	
             JSONObject fmane=(array.getJSONObject(i));
              String lname=fmane.getString("patient_last_name");
              //p.setFname(fmane);
              p.setLname(lname);
              System.out.println("Ithe "+lname);
            	
            	
            								} 
            
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}



//
/*
 * public static ArrayList<String> getPublicInfo1(String link){
 
	
	ArrayList<String> pubinfo = new ArrayList<>();
	
	HttpClient client = new DefaultHttpClient();
	HttpGet request = new HttpGet(link);
	
	System.out.println("\nSending 'GET' request to URL : " + link);

	HttpResponse response;
	try {
		System.out.println("HI***");
		response = client.execute(request);
		System.out.println("HI112"+response);
		InputStream instream = response.getEntity().getContent();
		BufferedReader in = new BufferedReader(new InputStreamReader(instream));
    	StringBuilder responseStrBuilder = new StringBuilder();
	    String inputStr;
	    
	    while ((inputStr = in.readLine()) != null)
	    	responseStrBuilder.append(inputStr);
	    System.out.println(responseStrBuilder.toString());
	    
	   
	    JSONObject object = new JSONObject(responseStrBuilder.toString()).getJSONObject("patients");
        JSONArray array = object.getJSONArray("patients");
        for(int i = 0; i < array.length(); i++){
          //  CampaignView camp = new CampaignView();
        	pubinfo.add(array.getJSONObject(i).getString("patient_first_name"));
        	pubinfo.add(array.getJSONObject(i).getString("patient_last_name"));
           
	
	     * JSONArray a=new JSONObject(responseStrBuilder.toString()).getJSONArray("patients");
	     
	    JSONObject object = new JSONObject(responseStrBuilder.toString()).getJSONObject("patients");
	            JSONObject object=a.getJSONObject(0);
	    		pubinfo.add(object.getString("patient_first_name"));
	    		System.out.println("HI");
	    		pubinfo.add(object.getString("patient_last_name"));
			
	    		
	    		
	
	 catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return pubinfo;
}
*/

public String DiseaseInfo(HashMap<String, String> arguments) {
	
		
	String url = "http://" + hostName + folderAddress + "?";
	String suggest = "";
	
	for (Map.Entry<String, String> entry : arguments.entrySet()) {
		url = url + "&" + entry.getKey() + "=" + entry.getValue();
	}
	
	HttpClient client = new DefaultHttpClient();
	HttpGet request = new HttpGet(url);
	
	System.out.println("\nSending 'GET' request to URL : " + url);

	HttpResponse response;
	try {
		response = client.execute(request);
		InputStream instream = response.getEntity().getContent();
		BufferedReader in = new BufferedReader(new InputStreamReader(instream));
    	StringBuilder responseStrBuilder = new StringBuilder();
	    String inputStr;
	    while ((inputStr = in.readLine()) != null)
	    	responseStrBuilder.append(inputStr);
	    System.out.println(responseStrBuilder.toString());
	    
	    		JSONArray array = new JSONObject(responseStrBuilder.toString()).getJSONArray("suggestion");
	    		
	    		for(int i = 0; i < array.length(); i++){
	    		JSONObject object = (JSONObject) array.get(i);
	    		
	    		suggest = suggest + object.getString("disease_id") + ". " + object.getString("title") + " : " + object.getString("content");
	    		}
	
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return suggest ;

}

}
