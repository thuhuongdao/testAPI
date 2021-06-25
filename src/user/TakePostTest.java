package user;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

import com.google.gson.Gson;

import constant.Constant;
import response.ResponseTakePost;

public class TakePostTest {
	public String token;
	public TakePostTest(String token) {
		this.token = token;
	}
	public ResponseTakePost res (HttpURLConnection connection) throws IOException {
		ResponseTakePost rp;
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
	       rp = g.fromJson(content.toString(), ResponseTakePost.class);
	        
	        System.out.println(rp.post_data.content);
	        System.out.println(rp.code);
	        System.out.println(rp.message);
	        
	        
	        
	       
	        
	        
	        
	        		
	    } finally {
	        connection.disconnect();
	    }
		return rp;
	}
	//lay bai dang voi tham so chinh xac
	public void validTakePost() throws IOException {
		
//				System.out.println("Phien ban truyen tham so vao URL");
			    URL url = new URL(Constant.TAKE_POST + 
			    		"?post_id=60c8154ffc8cac001504fbb2" //SV thay tham so khac vao day
			    	
			    	);
			    
			    
			    
			    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			    
			    connection.setRequestMethod("POST");
			    connection.setDoOutput(true);
			   
			   
			    connection.setRequestProperty("Authorization", token);
			    ResponseTakePost rp = res(connection);
			    
			    assert(rp.code.equals("1000")&& rp.message.equals("OK"));
			    
			    
	}
	
	//lay bai dang  thieu token
	public void lackTokenTakePost() throws IOException {
		
	
		    URL url = new URL(Constant.TAKE_POST + 
		    		"?post_id=60c8154ffc8cac001504fbb2" //SV thay tham so khac vao day
		    	
		    	);
		    
		    
		    
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
		        ResponseTakePost rp = g.fromJson(content.toString(), ResponseTakePost.class);
		        
		        System.out.println(rp.post_data.content);
		        
		       
		        

		       // assert(rp.code == "1000" && rp.message == "OK" );
		        
		        
		        		
		    } finally {
		        connection.disconnect();
		    }
	}
	//lay bai dang  sai token
	public void invalidTokenTakePost() throws IOException {
		
	
		    URL url = new URL(Constant.TAKE_POST + 
		    		"?post_id=60c8154ffc8cac001504fbb2" //SV thay tham so khac vao day
		    	
		    	);
		    
		    
		    
		    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		    
		    connection.setRequestMethod("POST");
		    connection.setDoOutput(true);
		    connection.setRequestProperty("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYwNzYyN2cyNTI4OCwiZXhwIjoxNjIzNzQ2ODg4fQ.NcLoOZXVBrl7S5w92XZQmN75fSCSDXiFL5kNZCWOTqI");
		    
		   
		   
		   
		    
		    
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
		        ResponseTakePost rp = g.fromJson(content.toString(), ResponseTakePost.class);
		        
		        System.out.println(rp.post_data.content);
		        
		       
		        

		        assert(rp.code == "1998" && rp.message == "Token is invalid" );
		        
		        
		        		
		    } finally {
		        connection.disconnect();
		    }
	}
	//lay bai dang thieu tham so
	public void lackParamTakePost() throws IOException {
		
		
	    URL url = new URL(Constant.TAKE_POST );
	    
	    
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	    
	    connection.setRequestMethod("POST");
	    connection.setDoOutput(true);
	    connection.setRequestProperty("Authorization", token);
	    
	   
	   
	   
	    
	    
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
	        ResponseTakePost rp = g.fromJson(content.toString(), ResponseTakePost.class);
	        
	        System.out.println(rp.code);
	        System.out.println(rp.message);
	        
	        
	        
	       
	        

	        assert(rp.code == "1002" && rp.message == "Parameter is not enought" );
	        
	        
	        		
	    } finally {
	        connection.disconnect();
	    }
}
	//lay bai dang tham so khong dung
	public void invalidParamTakePost() throws IOException {
		
		System.out.println("heelo");
	    URL url = new URL(Constant.TAKE_POST + "?kkk=60c8154ffc8cac001504fbb2" );
	    
	    
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	    
	    connection.setRequestMethod("POST");
	    connection.setDoOutput(true);
	    connection.setRequestProperty("Authorization", token);
	    
	   
	   
	   
	    
	    
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
	        ResponseTakePost rp = g.fromJson(content.toString(), ResponseTakePost.class);
	        
	        System.out.println(rp.code);
	        System.out.println(rp.message);
	        System.out.println(rp.post_data.content);
	        
	        
	        
	       
	        

	        assert(rp.code == "1003" && rp.message == "Parameter type is invalid" );
	        
	        
	        		
	    } finally {
	        connection.disconnect();
	    }
	}
	//gia tri tham so khong hop le
	public void invalidParamValue() throws IOException {
		
		System.out.println("heelo");
	    URL url = new URL(Constant.TAKE_POST + "?post_id=151f9dd4" );
	    
	    
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	    
	    connection.setRequestMethod("POST");
	    connection.setDoOutput(true);
	    connection.setRequestProperty("Authorization", token);
	    
	   
	   
	   
	    
	    
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
	        ResponseTakePost rp = g.fromJson(content.toString(), ResponseTakePost.class);
	        
	        System.out.println(rp.code);
	        System.out.println(rp.message);
	        System.out.println(rp.post_data.content);
	        
	        
	        
	       
	        

	        assert(rp.code == "1004" && rp.message == "Parameter value is invalid" );
	        
	        
	        		
	    } finally {
	        connection.disconnect();
	    }
	}

	//post khong ton tai
		public void notExisPostTakePost() throws IOException {
				
				System.out.println("heelo");
			    URL url = new URL(Constant.TAKE_POST + "?post_id=60c86e871900d300151f9dd4" );
			    
			    
			    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			    
			    connection.setRequestMethod("POST");
			    connection.setDoOutput(true);
			    connection.setRequestProperty("Authorization", token);
			    
			   
			   
			   
			    
			    
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
			        ResponseTakePost rp = g.fromJson(content.toString(), ResponseTakePost.class);
			        
			        System.out.println(rp.code);
			        System.out.println(rp.message);
			        System.out.println(rp.post_data.content);
			        
			        
			        
			       
			        
		
			        assert(rp.code == "9992" && rp.message == "Post is not existed" );
			        
			        
			        		
			    } finally {
			        connection.disconnect();
			    }
			}

		
	public static void main(String[] args) throws IOException {
		String token = Login.getToken();
		System.out.println(token);
		TakePostTest tp = new TakePostTest(token);
		tp.validTakePost();
		//tp.lackTokenTakePost();
		//tp.invalidTokenTakePost();
		//tp.lackParamTakePost();
		//tp.invalidParamTakePost();
		//tp.invalidParamValue();
		//tp.notExisPostTakePost();
		
		
	}
}


