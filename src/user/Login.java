package user;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import constant.Constant;
import model.User;
import response.ResponseLogin;



public class Login {
	
	public static String getToken() throws MalformedURLException, ProtocolException, 
	IOException {
	//	System.out.println("Phien ban truyen tham so vao URL");
	    URL url = new URL(Constant.LOGIN + 
	    		"?username=nva1234"//SV thay tham so khac vao day
	    	+ "&password=nguyenvanan"
	    	);
	    
	    
	    
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    connection.setRequestMethod("POST");
	    connection.setDoOutput(true);
	    ResponseLogin rp;
	    
	    try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {
	        
	        StringBuilder content;

	        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
	        	
	        String line;
	        
	        content = new StringBuilder();
	        
	           while ((line = in.readLine()) != null) {
	                content.append(line);
	                content.append(System.lineSeparator());
	            }
	        }
	        
	       // System.out.println("JSON response: " + content.toString());
	        
	        Gson g = new Gson(); 
	        rp = g.fromJson(content.toString(), ResponseLogin.class);
	        
	       // System.out.println(rp.code + " " + rp.message);
	        System.out.println(rp.user.fullname);
	        
	        
	        
	        
	        		
	    } finally {
	        connection.disconnect();
	    }
	    return rp.user.token;
	}
	

	public static void main(String[] args) throws MalformedURLException, ProtocolException, IOException   {
		getToken();
	}
}

