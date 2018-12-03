import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonToJavaObject {
	
	public static void main(String[] args) throws ParseException {
		
		
		JSONParser parser = new JSONParser();
	      String s = "{\"coord\":{\"lon\":-0.13,\"lat\":51.51},"
	      		+ "\"weather\":[{\"id\":741,\"main\":\"Fog\",\"description\":\"fog\",\"icon\":\"50d\"}"
	      		+ ",{\"id\":721,\"main\":\"Haze\",\"description\":\"haze\",\"icon\":\"50d\"}],\"base\":\"stations\",\"main\":{\"temp\":280.76,\"pressure\":1028,\"humidity\":82,\"temp_min\":277.15,\"temp_max\":286.15},\"visibility\":10000,\"wind\":{\"speed\":2.6},\"clouds\":{\"all\":0},\"dt\":1538029200,\"sys\":{\"type\":1,\"id\":5091,\"message\":0.0065,\"country\":\"GB\",\"sunrise\":1538027693,\"sunset\":1538070422},\"id\":2643743,\"name\":\"London\",\"cod\":200} ";
	      
	      Object obj=JSONValue.parse(s); 
	      JSONObject jsonObject = (JSONObject) obj;
	      System.out.println(jsonObject.get("weather"));
	     JSONArray a=(JSONArray)jsonObject.get("weather");
	     System.out.println(a.get(1));
	     Map<String, Object> m=(Map<String, Object>) a.get(1);
	     m.forEach((k,v)->System.out.println(k+":"+v));
	}
}
