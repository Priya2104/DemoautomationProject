package utilities;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import org.openqa.selenium.WebDriver;

public class Apiutilities 
{
	String Secret_filePath = "src/test/resources/secrets.properties";
    String TestData_filePath = "testData/TestData.properties";
    String Config_filePath ="src/test/resources/config.properties";
    
    PropertiesReader secret = new PropertiesReader(Secret_filePath);
    PropertiesReader testdata = new PropertiesReader(TestData_filePath);
    PropertiesReader config = new PropertiesReader(Config_filePath);
	
    WebDriver driver;
	final private CloseableHttpClient client;
	private static final Logger LOGGER = Logger.getLogger(Apiutilities.class.getName());
    public Apiutilities() {
        this.client = HttpClients.createDefault();
    }

    GenericUtilities utils = new GenericUtilities(driver);
    public String BaseAPIurl = config.getProperty("BaseAPIurl");
    public String bearer = secret.getProperty("bearer");
    public String refreshToken = secret.getProperty("refreshToken");
    public String G_API_KEY = secret.getProperty("G_API_KEY");
    public String G_API_URL = config.getProperty("G_API_URL");

    public String refreshIdToken(String refreshToken) throws IOException {
        String url = G_API_URL + G_API_KEY;
        HttpPost request = new HttpPost(url);
        JSONObject json = new JSONObject();
        json.put("grant_type", "refresh_token");
        json.put("refresh_token", refreshToken);

        StringEntity entity = new StringEntity(json.toString());
        request.setEntity(entity);
        request.setHeader("Content-Type", "application/json");
        HttpResponse response = client.execute(request);

        String responseString = EntityUtils.toString(response.getEntity());
        JSONObject jsonResponse = new JSONObject(responseString);
        String idToken = jsonResponse.getString("id_token");

        System.out.println("Refresh token generated successfully");
        secret.setProperty("bearer", idToken);

        return idToken;
    }

    public String sendGetRequest(String url) throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            request.setHeader("Content-Type", "application/json, text/plain, */*");
            request.setHeader("Authorization", "Bearer " + bearer);
            System.out.println("GET Request: " + request.toString()); // print request
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            int retryCount = 0;
            while (statusCode == 401 && retryCount < 3) {
                bearer = refreshIdToken(refreshToken);
                request.setHeader("Authorization", "Bearer " + bearer);
                response = client.execute(request);
                statusCode = response.getStatusLine().getStatusCode();
                retryCount++;
            }

            String responseString = EntityUtils.toString(response.getEntity());
            System.out.println("Response: " + responseString); // print response

            // Check if the response contains an error
            JSONObject jsonResponse = new JSONObject(responseString);
            if (jsonResponse.has("error")) {
                JSONArray errors = jsonResponse.getJSONArray("error");
                for (int i = 0; i < errors.length(); i++) {
                    JSONObject error = errors.getJSONObject(i);
                    System.out.println("Error Message: " + error.getString("message"));
                }
            }
            return responseString;
        }
    }

    public String sendPostRequest(String url, String json) throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost request = new HttpPost(url);
            StringEntity entity = new StringEntity(json);
            request.setEntity(entity);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Authorization", "Bearer " + bearer);
            System.out.println("POST Request: " + request.toString()); // print request
            System.out.println("POST Data: " + json); // print posted data
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();

            // If status code is 401, refresh the token and retry the request
            int retryCount = 0;
            while (statusCode == 401 && retryCount < 3) {
                bearer = refreshIdToken(refreshToken);
                request.setHeader("Authorization", "Bearer " + bearer);
                response = client.execute(request);
                statusCode = response.getStatusLine().getStatusCode();
                retryCount++;
            }

            String responseString = EntityUtils.toString(response.getEntity());
            System.out.println("Response: " + responseString); // print response

            // Check if the response contains an error
            JSONObject jsonResponse = new JSONObject(responseString);
            if (jsonResponse.has("error")) {
                JSONArray errors = jsonResponse.getJSONArray("error");
                for (int i = 0; i < errors.length(); i++) {
                    JSONObject error = errors.getJSONObject(i);
                    System.out.println("Error Message: " + error.getString("message"));
                }
            }

            return responseString;
        }
    }

}
