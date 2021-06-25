package user;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.Gson;

import constant.Constant;
import response.ResponseComment;


public class CommentTest {
	String token;
	
	public CommentTest(String token) {
		this.token = token;
	}
	//tham so chinh xac
	public void validParams() throws IOException {
		URL url = new URL(Constant.COMMENT + 
	    		"?post_id=60c8154ffc8cac001504fbb2"
	    	+ "&comment=aaaaa"
	    	);
	    
	    
	    
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
	        ResponseComment rp = g.fromJson(content.toString(), ResponseComment.class);
	        
	        System.out.println(rp.code + " " + rp.message);
	     //   System.out.println(rp.user.fullname);
	        assert(rp.code.equals("1000") && rp.message.equals("OK"));
	        
	        
	        
	        
	        		
	    } finally {
	        connection.disconnect();
	    }

	}
	
	//thieu token
	public void lackToken() throws IOException {
		URL url = new URL(Constant.COMMENT + 
	    		"?post_id=60c8154ffc8cac001504fbb2"
	    	+ "&comment=dddd"
	    	);
	    
	    
	    
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    connection.setRequestMethod("POST");
	    connection.setDoOutput(true);
	 
	  
	
	    
	    try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {
	        
	        StringBuilder content;

	        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"))) {
	        	
	        String line;
	        
	        content = new StringBuilder();
	        
	           while ((line = in.readLine()) != null) {
	                content.append(line);
	                content.append(System.lineSeparator());
	            }
	        }
	        
	        System.out.println("JSON response: " + content.toString());
	        
	        Gson g = new Gson(); 
	        ResponseComment rp = g.fromJson(content.toString(), ResponseComment.class);
	        
	       // System.out.println(rp.code + " " + rp.message);
	     //   System.out.println(rp.user.fullname);
	        assert(rp.message.equals("không có token "));
	        
	        
	        
	        
	        		
	    } finally {
	        connection.disconnect();
	    }

	}
	
	//sai token
	public void invalidToken() throws IOException {
		URL url = new URL(Constant.COMMENT + 
	    		"?post_id=60c8154ffc8cac001504fbb2"
	    	+ "&comment=dddd"
	    	);
	    
	    
	    
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    connection.setRequestMethod("POST");
	    connection.setDoOutput(true);
	    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYwNzYyN2E4ZGNmNzMwMDAxNWI0MzQ2MSIsInVzZXJuYW1lIjoibnZhMTIzNCIsInJvbGUiOiJndWVzdCIsImlhdCI6MTYyMzc2NjAwOSwiZXhwIjoxNjIzNzg3NjA5fQ.4pJa4oRw36q-ffdqDGhKheaPAtuRPHbiNi-GTlacdRI";
	    connection.setRequestProperty("Authorization", token);
	 
	  
	
	    
	    try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {
	        
	        StringBuilder content;

	        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"))) {
	        	
	        String line;
	        
	        content = new StringBuilder();
	        
	           while ((line = in.readLine()) != null) {
	                content.append(line);
	                content.append(System.lineSeparator());
	            }
	        }
	        
	        System.out.println("JSON response: " + content.toString());
	        
	        Gson g = new Gson(); 
	        ResponseComment rp = g.fromJson(content.toString(), ResponseComment.class);
	        
	       // System.out.println(rp.code + " " + rp.message);
	     //   System.out.println(rp.user.fullname);
	        assert(rp.code.equals("9998") && rp.message.equals("Token is invalid"));
	        
	        
	        
	        
	        		
	    } finally {
	        connection.disconnect();
	    }

	}
	
	//thieu tham so post_id
		public void lackPostId() throws IOException {
			URL url = new URL(Constant.COMMENT + 
		    		"?comment=dddd"
		    	);
		    
		    
		    
		    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		    connection.setRequestMethod("POST");
		    connection.setDoOutput(true);
		    connection.setRequestProperty("Authorization", token);
		 
		  
		
		    
		    try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {
		        
		        StringBuilder content;

		        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"))) {
		        	
		        String line;
		        
		        content = new StringBuilder();
		        
		           while ((line = in.readLine()) != null) {
		                content.append(line);
		                content.append(System.lineSeparator());
		            }
		        }
		        
		        System.out.println("JSON response: " + content.toString());
		        
		        Gson g = new Gson(); 
		        ResponseComment rp = g.fromJson(content.toString(), ResponseComment.class);
		        
		       // System.out.println(rp.code + " " + rp.message);
		     //   System.out.println(rp.user.fullname);
		        assert(rp.code.equals("1002") && rp.message.equals("Parameter is not enought"));
		        
		        
		        
		        
		        		
		    } finally {
		        connection.disconnect();
		    }

		}
		//thieu tham so comment
				public void lackComment() throws IOException {
					URL url = new URL(Constant.COMMENT + 
				    		"?post_id=60c8154ffc8cac001504fbb2"
				    	);
				    
				    
				    
				    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

				    connection.setRequestMethod("POST");
				    connection.setDoOutput(true);
				    connection.setRequestProperty("Authorization", token);
				 
				  
				
				    
				    try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {
				        
				        StringBuilder content;

				        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"))) {
				        	
				        String line;
				        
				        content = new StringBuilder();
				        
				           while ((line = in.readLine()) != null) {
				                content.append(line);
				                content.append(System.lineSeparator());
				            }
				        }
				        
				        System.out.println("JSON response: " + content.toString());
				        
				        Gson g = new Gson(); 
				        ResponseComment rp = g.fromJson(content.toString(), ResponseComment.class);
				        
				       // System.out.println(rp.code + " " + rp.message);
				     //   System.out.println(rp.user.fullname);
				        assert(rp.code.equals("1002") && rp.message.equals("Parameter is not enought"));
				        
				        
				        
				        
				        		
				    } finally {
				        connection.disconnect();
				    }

				}
				
	// post_id trống
	public void emptyPostId() throws IOException {
		URL url = new URL(Constant.COMMENT + 
	    		"?post_id=&comment=dddd"
	    	);
	    
	    
	    
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    connection.setRequestMethod("POST");
	    connection.setDoOutput(true);
	    connection.setRequestProperty("Authorization", token);
	 
	  
	
	    
	    try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {
	        
	        StringBuilder content;

	        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"))) {
	        	
	        String line;
	        
	        content = new StringBuilder();
	        
	           while ((line = in.readLine()) != null) {
	                content.append(line);
	                content.append(System.lineSeparator());
	            }
	        }
	        
	        System.out.println("JSON response: " + content.toString());
	        
	        Gson g = new Gson(); 
	        ResponseComment rp = g.fromJson(content.toString(), ResponseComment.class);
	        
	       // System.out.println(rp.code + " " + rp.message);
	     //   System.out.println(rp.user.fullname);
	        assert(rp.code.equals("1004") && rp.message.equals("Parameter value is invalid"));
	        
	        
	        
	        
	        		
	    } finally {
	        connection.disconnect();
	    }

	}
	//comment trống
		public void emptyComment() throws IOException {
			URL url = new URL(Constant.COMMENT + 
		    		"?post_id=60c8154ffc8cac001504fbb2&comment="
		    	);
		    
		    
		    
		    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		    connection.setRequestMethod("POST");
		    connection.setDoOutput(true);
		    connection.setRequestProperty("Authorization", token);
		 
		  
		
		    
		    try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {
		        
		        StringBuilder content;

		        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"))) {
		        	
		        String line;
		        
		        content = new StringBuilder();
		        
		           while ((line = in.readLine()) != null) {
		                content.append(line);
		                content.append(System.lineSeparator());
		            }
		        }
		        
		        System.out.println("JSON response: " + content.toString());
		        
		        Gson g = new Gson(); 
		        ResponseComment rp = g.fromJson(content.toString(), ResponseComment.class);
		        
		       // System.out.println(rp.code + " " + rp.message);
		     //   System.out.println(rp.user.fullname);
		        assert(rp.code.equals("1004") && rp.message.equals("Parameter value is invalid"));
		        
		        
		        
		        
		        		
		    } finally {
		        connection.disconnect();
		    }

		}
		//post khong ton tai
		public void notExistPost() throws IOException {
			URL url = new URL(Constant.COMMENT + 
		    		"?post_id=60c8dfa27e88b300152ba207&comment=thttt"
		    	);
		    
		    
		    
		    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		    connection.setRequestMethod("POST");
		    connection.setDoOutput(true);
		    connection.setRequestProperty("Authorization", token);
		 
		  
		
		    
		    try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {
		        
		        StringBuilder content;

		        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"))) {
		        	
		        String line;
		        
		        content = new StringBuilder();
		        
		           while ((line = in.readLine()) != null) {
		                content.append(line);
		                content.append(System.lineSeparator());
		            }
		        }
		        
		        System.out.println("JSON response: " + content.toString());
		        
		        Gson g = new Gson(); 
		        ResponseComment rp = g.fromJson(content.toString(), ResponseComment.class);
		        
		       // System.out.println(rp.code + " " + rp.message);
		     //   System.out.println(rp.user.fullname);
		        assert(rp.code.equals("9992") && rp.message.equals("Post is not existed"));
		        
		        
		        
		        
		        		
		    } finally {
		        connection.disconnect();
		    }

		}
		
		
			
		
	

	

	public static void main(String[] args) throws MalformedURLException, ProtocolException, IOException {
		// TODO Auto-generated method stub
		
		CommentTest commentTest = new CommentTest(Login.getToken());
		//commentTest.validParams();
		//commentTest.lackToken();
		//commentTest.invalidToken();
		//commentTest.lackPostId();
		//commentTest.lackComment();
		//commentTest.emptyPostId();
		//commentTest.emptyComment();
		//commentTest.notExistPost();
		
		
		
	}

}
