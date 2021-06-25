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



public class Vd02 {

	public static void main(String[] args) throws MalformedURLException, ProtocolException, 
	IOException {
		
		System.out.println("Phien ban truyen tham so vao URL");
	    URL url = new URL(Constant.SIGN_UP + 
	    		"?username=huong"//SV thay tham so khac vao day
	    	+ "&fullname=daothuhuong"
	    	+ "&email=huong@gmail.com"
	    	+"&password=123456"
	    	+ "&mobile=0399429273"
	    	+ "&role=khachthue");
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    connection.setRequestMethod("POST");
	    connection.setDoOutput(true);
	    
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
	        
	        System.out.println("JSON response: " + content.toString());
	        
	        Gson g = new Gson(); 
	        ResponseSignUp rp = g.fromJson(content.toString(), ResponseSignUp.class);
	        
	        System.out.println(rp.code + " " + rp.message);
	        
	        System.out.println("Unit test 1: The code and message strings shall be not NULL as well as non-empty:");
	        assert(rp.code != null && !"".equals(rp.code));
	        assert(rp.message != null && !"".equals(rp.message));
	        System.out.println("Finished! Satisfied!");
	        		
	    } finally {
	        connection.disconnect();
	    }
	}

}

class ResponseSignUp{
	public String code;
	public String message;
}
