package API_Serch;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import Data.Data_API;

public class API_Serch {
	public API_Serch(String name){
        String clientId = "YxeeJvFtaqrCPgLea0ak"; //애플리케이션 클라이언트 아이디
        String clientSecret = "ydMsIRUSKr"; //애플리케이션 클라이언트 시크릿
        
        String text = null;
        try {
            text = URLEncoder.encode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }


        String apiURL = "https://openapi.naver.com/v1/search/book?query=" + text;    // JSON 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // XML 결과

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);
        setData(responseBody);
        
        
    }


    private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }


            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출            	
                return readBody(con.getInputStream());
            } else { // 오류 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }


    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }


    private static String readBody(InputStream body){
    	
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(body,"UTF-8"))) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
        }
    }
    
	private static void setData(String responseBody) {
    	JSONObject JO = new JSONObject(responseBody);
        JSONArray itemsArr = JO.getJSONArray("items");
        Data_API data = new Data_API();
        ArrayList<Data_API> list = data.getList();
        list.clear();
        try {
	        for(int i = 0; i < itemsArr.length(); i++) {
	        	data.setTitle((String) itemsArr.getJSONObject(i).get("title"));
	        	data.setLink((String) itemsArr.getJSONObject(i).get("link"));
	        	data.setImage((String) itemsArr.getJSONObject(i).get("image"));
	        	data.setAuthor((String) itemsArr.getJSONObject(i).get("author"));
	        	data.setDiscount((String) itemsArr.getJSONObject(i).get("discount"));
	        	data.setPublisher((String) itemsArr.getJSONObject(i).get("publisher"));
	        	data.setPubdate((String) itemsArr.getJSONObject(i).get("pubdate"));
	        	data.setDescription((String) itemsArr.getJSONObject(i).get("description"));
	        	
	        	list.add(new Data_API(data.getTitle(), data.getLink(), data.getImage(), data.getAuthor(), data.getDiscount(), data.getPublisher(), data.getPubdate(), data.getDescription()));
	        }
	        data.setList(list);
	        	
        }catch (Exception e) {
			System.out.println(e);
		}
    }
}