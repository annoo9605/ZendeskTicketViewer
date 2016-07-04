package tickets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class DAO {

	// connect to ZEN Api server with authentication
	public JSONArray getTicketList() throws JSONException, IOException {
		String zen ="https://wooyoung.zendesk.com/api/v2/tickets.json";
		URL url;
		StringBuilder sb = new StringBuilder();  
		
		try {
			url = new URL(zen);
		    URLConnection uc = url.openConnection();
		    String userpass = "s3588086@student.rmit.edu.au" + ":" + "An6281868";
		    String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
		    uc.setRequestProperty ("Authorization", basicAuth);
		    	
			int HttpResult = ((HttpURLConnection) uc).getResponseCode(); 
				if (HttpResult == HttpURLConnection.HTTP_OK) {
				    BufferedReader br = new BufferedReader(
				            new InputStreamReader(uc.getInputStream(), "utf-8"));
				    String line = null;  
				    while ((line = br.readLine()) != null) {  
				        sb.append(line + "\n");  
				    }
				    br.close();
				} else {
					
					// To show the error message of connection  (unauthorized or not connected)
				    System.out.println(((HttpURLConnection) uc).getResponseMessage());  
				}
		    	
			} catch (MalformedURLException e) {
					e.printStackTrace();
			}
			
			// return the received ticketlist as JSONArray for parsing
			JSONObject obj = new JSONObject(sb.toString());
				
			JSONArray arr = obj.getJSONArray("tickets");
		
				return  arr;
		    }
	
	}




