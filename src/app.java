import java.util.ArrayList;

import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import com.jaunt.util.HandlerForText;

public class app {

	public static void main(String[] args) {
/* Imports & Setup */
		}

	public static String pullProxies() {
		//setup web scraper
				UserAgent userAgent = new UserAgent();   
				HandlerForText handlerForText = new HandlerForText();
				userAgent.setHandler("text/plain", handlerForText);
				
		//declare variables
				String resp="";
				ArrayList<String> respArrFinal = new ArrayList<String>();
				String finalReturnValue="";
				
				//try to reach endpoint and parse .txt file 
				  try {
					  userAgent.sendGET("http://spys.me/proxy.txt");
					  resp = handlerForText.getContent();
					  //split up long string into array
					  String[] respArr = resp.split("\\r?\\n");
					
				     for (int i=0;i<respArr.length;i++) {
				    	 
				    	 //"+" indicates that its google passing. we only want to include these. 
				    	 if (respArr[i].contains("+")) {
				    		 //strip all of the non-digits and period/comma
				    		 respArr[i] = respArr[i].replaceAll("[^[A-Za-z-+,].:]", "");
				    		 //strip all else 
				    		 respArr[i] = respArr[i].replaceAll("[^:\\d.\\n]", "");
				    		 //If a line contains a single colon, remove it from the array
				    		 if(respArr[i].equals(":"))
				    		 {
				    			 continue;
				    		 }
				    		 respArrFinal.add(respArr[i] + "\n"); 
				    		 
				    		 
				    	 }
				     }
				     respArrFinal.remove(0);
				     //convert the final array into a string that we can return
				     finalReturnValue=respArrFinal.toString();
				     //remove the "array varaibles from the string (open/close brackets, comma, spaces etc
				     finalReturnValue =finalReturnValue.replaceAll("[^:\\d.\\n]", "");
				     
				     

				} catch (ResponseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				  return finalReturnValue; 
			}
	
}
