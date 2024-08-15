
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Scanner;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

// retrieve weather data from API - this backend logic will fetch the latest weather
import org.json.simple.parser.JSONParser;
// data from the external API and return it. The GUI will
// display this data to the user
public class WeatherApp {
    private static TrustManager[] trustAllCerts;
    // fetch weather data for given location
    public static JSONObject getWeatherData(String locationName){
        // get location coordinates using the geolocation API
        JSONArray locationData = getLocationData(locationName);
        return null;
    }
    
    
    public static JSONArray getLocationData(String locationName){
        // replace any whitespace in location name to + to adhere to API's request format
        locationName = locationName.replaceAll(" ", "+");
        
        // build API url with location parameter
        String urlString = "https://geocoding-api.open-meteo.com/v1/search?name=" + locationName + "&count=10&language=en&format=json";
        
        try {
            //sslcontext
            
            
            // call api and get response
            HttpURLConnection conn = fetchApiResponse(urlString);
            
            // check response status
            // 200 means successful connection
            if(conn.getResponseCode() != 200){
                System.out.println("Error: Could not connect to API");
                return null;
            }else{
                //store the API results
                StringBuilder resultJson = new StringBuilder();
                Scanner scanner = new Scanner(conn.getInputStream());
                
                // read and store the resulting json data into our string builder
                while(scanner.hasNext()){
                    resultJson.append(scanner.nextLine());
                }
                
                // close scanner
                scanner.close();
                
                // close url connection
                conn.disconnect();
                
                // parse the JSON string into a JSON obj
                JSONParser parser = new JSONParser();
                JSONObject resultsJsonObj = (JSONObject) parser.parse(String.valueOf(resultJson));
                
                // get the list of location data the API generated from the location name
                JSONArray locationData = (JSONArray) resultsJsonObj.get("results");
                return locationData;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // couldn not find location
        return null;
    }
    
    private static HttpURLConnection fetchApiResponse(String urlString){
        try {
            // attemp to create connection
            URL url = new URL(urlString);
            HttpURLConnection conn =(HttpURLConnection) url.openConnection();
            
            // set request method to get
            conn.setRequestMethod("GET");
            
            // connect to our API
            conn.connect();
            return conn;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // could not make connection
        return null;
        
    }
}
