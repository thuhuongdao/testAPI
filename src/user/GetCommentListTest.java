package user;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

import constant.Constant;
import response.ResponseCommentList;

public class GetCommentListTest {
	//tham so chinh xac nhung so luong comment tra ve k dung
	public void wrongNumbersOfComment() throws IOException {
	URL url = new URL(Constant.COMMENT_LIST + 
				"?post_id=60c8154ffc8cac001504fbb2"
				+"&index=1"
				+"&count=5");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		
		try(DataOutputStream write = new DataOutputStream (connection.getOutputStream())){
			StringBuilder content;
			try(BufferedReader in = new BufferedReader (new InputStreamReader(connection.getInputStream()))){
				String line;
				content = new StringBuilder();
				
				while((line = in.readLine()) != null) {
					content.append(line);
					content.append(System.lineSeparator());
					
				}
			}
			System.out.println("JSON response: " + content.toString());
			
			Gson g = new Gson();
			ResponseCommentList rp = g.fromJson(content.toString(), ResponseCommentList.class);
			
			//System.out.println(rp.comment_list[2]._id);
			//System.out.println(rp.comment_list.length);
			
			assert(rp.code.equals("1000") && rp.message.equals("OK"));
			assert(rp.comment_list.length != 5);
			
		}finally {
			connection.disconnect();
		}
		
	}
	//post_id trong
	public void lackOfPostId() throws IOException {
		URL url = new URL(Constant.COMMENT_LIST + 
					"?post_id="
					+"&index=1"
					+"&count=5");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			
			try(DataOutputStream write = new DataOutputStream (connection.getOutputStream())){
				StringBuilder content;
				try(BufferedReader in = new BufferedReader (new InputStreamReader(connection.getInputStream()))){
					String line;
					content = new StringBuilder();
					
					while((line = in.readLine()) != null) {
						content.append(line);
						content.append(System.lineSeparator());
						
					}
				}
				System.out.println("JSON response: " + content.toString());
				
				Gson g = new Gson();
				ResponseCommentList rp = g.fromJson(content.toString(), ResponseCommentList.class);
				
				//System.out.println(rp.comment_list[2]._id);
				//System.out.println(rp.comment_list.length);
				
				assert(rp.code.equals("1004") && rp.message.equals("Parameter value is invalid"));
				
				
			}finally {
				connection.disconnect();
			}
			
		}
	//post khong ton tai
	public void notExistPost() throws IOException {
		URL url = new URL(Constant.COMMENT_LIST + 
					"?post_id=60c8154ffc8cac001504fbb5"
					+"&index=1"
					+"&count=5");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			
			try(DataOutputStream write = new DataOutputStream (connection.getOutputStream())){
				StringBuilder content;
				try(BufferedReader in = new BufferedReader (new InputStreamReader(connection.getInputStream()))){
					String line;
					content = new StringBuilder();
					
					while((line = in.readLine()) != null) {
						content.append(line);
						content.append(System.lineSeparator());
						
					}
				}
				System.out.println("JSON response: " + content.toString());
				
				Gson g = new Gson();
				ResponseCommentList rp = g.fromJson(content.toString(), ResponseCommentList.class);
				
				//System.out.println(rp.comment_list[2]._id);
				//System.out.println(rp.comment_list.length);
				
				assert(rp.code.equals("9994") && rp.message.equals("No data or end of list data entry"));
				
				
			}finally {
				connection.disconnect();
			}
			
		}
	//get comment list cua post da xoa
		public void postDeleted() throws IOException {
			URL url = new URL(Constant.COMMENT_LIST + 
						"?post_id=60cb4ec2fd6f680015cc2eef"
						+"&index=0"
						+"&count=3");
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("POST");
				connection.setDoOutput(true);
				
				try(DataOutputStream write = new DataOutputStream (connection.getOutputStream())){
					StringBuilder content;
					try(BufferedReader in = new BufferedReader (new InputStreamReader(connection.getInputStream()))){
						String line;
						content = new StringBuilder();
						
						while((line = in.readLine()) != null) {
							content.append(line);
							content.append(System.lineSeparator());
							
						}
					}
					System.out.println("JSON response: " + content.toString());
					
					Gson g = new Gson();
					ResponseCommentList rp = g.fromJson(content.toString(), ResponseCommentList.class);
					
					//System.out.println(rp.comment_list[2]._id);
					//System.out.println(rp.comment_list.length);
					
					assert(!rp.code.equals("1000") && !rp.message.equals("OK"));
					
					
				}finally {
					connection.disconnect();
				}
				
			}
	//index trong
	public void lackOfIndex() throws IOException {
		URL url = new URL(Constant.COMMENT_LIST + 
					"?post_id=60c8154ffc8cac001504fbb2"
					+"&index="
					+"&count=5");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			
			try(DataOutputStream write = new DataOutputStream (connection.getOutputStream())){
				StringBuilder content;
				try(BufferedReader in = new BufferedReader (new InputStreamReader(connection.getInputStream()))){
					String line;
					content = new StringBuilder();
					
					while((line = in.readLine()) != null) {
						content.append(line);
						content.append(System.lineSeparator());
						
					}
				}
				System.out.println("JSON response: " + content.toString());
				
				Gson g = new Gson();
				ResponseCommentList rp = g.fromJson(content.toString(), ResponseCommentList.class);
				
				//System.out.println(rp.comment_list[2]._id);
				//System.out.println(rp.comment_list.length);
				
				assert(rp.code.equals("1004") && rp.message.equals("Parameter value is invalid"));
				
				
			}finally {
				connection.disconnect();
			}
	}
	//index khong phai la so
	public void indexIsNotDigital() throws IOException {
		URL url = new URL(Constant.COMMENT_LIST + 
					"?post_id=60c8154ffc8cac001504fbb2"
					+"&index=abc"
					+"&count=5");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			
			try(DataOutputStream write = new DataOutputStream (connection.getOutputStream())){
				StringBuilder content;
				try(BufferedReader in = new BufferedReader (new InputStreamReader(connection.getInputStream()))){
					String line;
					content = new StringBuilder();
					
					while((line = in.readLine()) != null) {
						content.append(line);
						content.append(System.lineSeparator());
						
					}
				}
				System.out.println("JSON response: " + content.toString());
				
				Gson g = new Gson();
				ResponseCommentList rp = g.fromJson(content.toString(), ResponseCommentList.class);
				
				//System.out.println(rp.comment_list[2]._id);
				//System.out.println(rp.comment_list.length);
				
				assert(rp.code.equals("1004") && rp.message.equals("Parameter value is invalid"));
				
				
			}finally {
				connection.disconnect();
			}
	}
	//index la so am 
	public void negativeIndex() throws IOException {
		URL url = new URL(Constant.COMMENT_LIST + 
					"?post_id=60c8154ffc8cac001504fbb2"
					+"&index=-4"
					+"&count=5");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			
			try(DataOutputStream write = new DataOutputStream (connection.getOutputStream())){
				StringBuilder content;
				try(BufferedReader in = new BufferedReader (new InputStreamReader(connection.getInputStream()))){
					String line;
					content = new StringBuilder();
					
					while((line = in.readLine()) != null) {
						content.append(line);
						content.append(System.lineSeparator());
						
					}
				}
				System.out.println("JSON response: " + content.toString());
				
				Gson g = new Gson();
				ResponseCommentList rp = g.fromJson(content.toString(), ResponseCommentList.class);
				
				//System.out.println(rp.comment_list[2]._id);
				//System.out.println(rp.comment_list.length);
				
				assert(rp.code.equals("1004") && rp.message.equals("Parameter value is invalid"));
				
				
			}finally {
				connection.disconnect();
			}
	}
	//index qua lon
		public void bigIndex() throws IOException {
			URL url = new URL(Constant.COMMENT_LIST + 
						"?post_id=60c8154ffc8cac001504fbb2"
						+"&index=25"
						+"&count=5");
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("POST");
				connection.setDoOutput(true);
				
				try(DataOutputStream write = new DataOutputStream (connection.getOutputStream())){
					StringBuilder content;
					try(BufferedReader in = new BufferedReader (new InputStreamReader(connection.getInputStream()))){
						String line;
						content = new StringBuilder();
						
						while((line = in.readLine()) != null) {
							content.append(line);
							content.append(System.lineSeparator());
							
						}
					}
					System.out.println("JSON response: " + content.toString());
					
					Gson g = new Gson();
					ResponseCommentList rp = g.fromJson(content.toString(), ResponseCommentList.class);
					
					//System.out.println(rp.comment_list[2]._id);
					//System.out.println(rp.comment_list.length);
					
					assert(rp.code.equals("9994") && rp.message.equals("No data or end of list data entry"));
					
					
				}finally {
					connection.disconnect();
				}
		}
	//count trong
		public void lackOfCount() throws IOException {
			URL url = new URL(Constant.COMMENT_LIST + 
						"?post_id=60c8154ffc8cac001504fbb2"
						+"&index=1"
						+"&count=");
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("POST");
				connection.setDoOutput(true);
				
				try(DataOutputStream write = new DataOutputStream (connection.getOutputStream())){
					StringBuilder content;
					try(BufferedReader in = new BufferedReader (new InputStreamReader(connection.getInputStream()))){
						String line;
						content = new StringBuilder();
						
						while((line = in.readLine()) != null) {
							content.append(line);
							content.append(System.lineSeparator());
							
						}
					}
					System.out.println("JSON response: " + content.toString());
					
					Gson g = new Gson();
					ResponseCommentList rp = g.fromJson(content.toString(), ResponseCommentList.class);
					
					//System.out.println(rp.comment_list[2]._id);
					//System.out.println(rp.comment_list.length);
					
					assert(rp.code.equals("1004") && rp.message.equals("Parameter value is invalid"));
					
					
				}finally {
					connection.disconnect();
				}
		}
	//count khong phai la so
		public void countIsNotDigital() throws IOException {
			URL url = new URL(Constant.COMMENT_LIST + 
						"?post_id=60c8154ffc8cac001504fbb2"
						+"&index=1"
						+"&count=acc");
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("POST");
				connection.setDoOutput(true);
				
				try(DataOutputStream write = new DataOutputStream (connection.getOutputStream())){
					StringBuilder content;
					try(BufferedReader in = new BufferedReader (new InputStreamReader(connection.getInputStream()))){
						String line;
						content = new StringBuilder();
						
						while((line = in.readLine()) != null) {
							content.append(line);
							content.append(System.lineSeparator());
							
						}
					}
					System.out.println("JSON response: " + content.toString());
					
					Gson g = new Gson();
					ResponseCommentList rp = g.fromJson(content.toString(), ResponseCommentList.class);
					
					//System.out.println(rp.comment_list[2]._id);
					//System.out.println(rp.comment_list.length);
					
					assert(rp.code.equals("1004") && rp.message.equals("Parameter value is invalid"));
					
					
				}finally {
					connection.disconnect();
				}
		}
		//count la so am
				public void negativeCount() throws IOException {
					URL url = new URL(Constant.COMMENT_LIST + 
								"?post_id=60c8154ffc8cac001504fbb2"
								+"&index=1"
								+"&count=-5");
						HttpURLConnection connection = (HttpURLConnection) url.openConnection();
						connection.setRequestMethod("POST");
						connection.setDoOutput(true);
						
						try(DataOutputStream write = new DataOutputStream (connection.getOutputStream())){
							StringBuilder content;
							try(BufferedReader in = new BufferedReader (new InputStreamReader(connection.getInputStream()))){
								String line;
								content = new StringBuilder();
								
								while((line = in.readLine()) != null) {
									content.append(line);
									content.append(System.lineSeparator());
									
								}
							}
							System.out.println("JSON response: " + content.toString());
							
							Gson g = new Gson();
							ResponseCommentList rp = g.fromJson(content.toString(), ResponseCommentList.class);
							
							//System.out.println(rp.comment_list[2]._id);
							//System.out.println(rp.comment_list.length);
							
							assert(rp.code.equals("1004") && rp.message.equals("Parameter value is invalid"));
							
							
						}finally {
							connection.disconnect();
						}
				}
		
				//count qua lon
				public void bigCount() throws IOException {
					URL url = new URL(Constant.COMMENT_LIST + 
								"?post_id=60c8154ffc8cac001504fbb2"
								+"&index=1"
								+"&count=26");
						HttpURLConnection connection = (HttpURLConnection) url.openConnection();
						connection.setRequestMethod("POST");
						connection.setDoOutput(true);
						
						try(DataOutputStream write = new DataOutputStream (connection.getOutputStream())){
							StringBuilder content;
							try(BufferedReader in = new BufferedReader (new InputStreamReader(connection.getInputStream()))){
								String line;
								content = new StringBuilder();
								
								while((line = in.readLine()) != null) {
									content.append(line);
									content.append(System.lineSeparator());
									
								}
							}
							System.out.println("JSON response: " + content.toString());
							
							Gson g = new Gson();
							ResponseCommentList rp = g.fromJson(content.toString(), ResponseCommentList.class);
							
							//System.out.println(rp.comment_list[2]._id);
							//System.out.println(rp.comment_list.length);
							
							assert(rp.code.equals("1004") && rp.message.equals("Parameter value is invalid"));
							
							
						}finally {
							connection.disconnect();
						}
				}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		GetCommentListTest getCommentListTest = new GetCommentListTest();
		//getCommentListTest.wrongNumbersOfComment();
		//getCommentListTest.lackOfPostId();
		//getCommentListTest.notExistPost();
		//getCommentListTest.postDeleted();
		
		//getCommentListTest.lackOfIndex();
		//getCommentListTest.indexIsNotDigital();
		//getCommentListTest.negativeIndex();
		//getCommentListTest.bigIndex();
		
		//getCommentListTest.lackOfCount();
		//getCommentListTest.countIsNotDigital();
		//getCommentListTest.negativeCount();
		//getCommentListTest.bigCount();
		
		
		
		

	}

}
