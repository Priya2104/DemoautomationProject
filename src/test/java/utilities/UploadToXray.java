package utilities;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.stream.Stream;



public class UploadToXray {
	
	

	//String ENV = PropertiesFile.getConfigProperty("Environment");


    public void RemonteResultats() throws Exception {
      //  Map<String,String> JiraBaseData = ExcelUtils.getData("JiraUrl","Configs");
        //Map<String,String> JiraTokenData = ExcelUtils.getData("JiraKey","Configs");
       // String BASEJIRA_URL = "https://jira.pepkor.co.za/rest/raven/1.0/import/execution/cucumber";
       // String JiraToken = "MjQ2NTgxMDA1MTA2OroFebzqe6+/52U1EFD8dhOGxqMt";
            SSLContext sslContext = SSLContexts.custom().loadTrustMaterial((chain, authType) -> true).build();
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext,
                    new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}, null,
                    NoopHostnameVerifier.INSTANCE);
            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).build();
            /*     
            
            String content = new String(Files.readAllBytes(Paths.get("Report/cucumber/cucumber.json")));
            JSONObject json = new JSONObject(content);
            System.out.println(json.toString(4));
            
            */
            Path path = Path.of("Report/cucumber");
            
            try (Stream<Path> walk = Files.walk(path)) {
                walk.filter(Files::isRegularFile)
                        .filter(p -> p.getFileName().toString().endsWith(".json"))
                        .forEach(file -> {
                            try {
                                uploadFileToXray(httpClient, file);
                                System.out.println("Exported to Xray");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
            } catch (IOException e) {
                e.printStackTrace();
            }
            

    }

    private void uploadFileToXray(CloseableHttpClient httpClient, Path file) throws Exception {
       // Map<String,String> JiraBaseData = BASEJIRA_URL;
        //Map<String,String> JiraTokenData = ExcelUtils.getData("JiraKey","Configs");
        String BASEJIRA_URL = "https://jira.pepkor.co.za";
        String JiraToken = "MjQ2NTgxMDA1MTA2OroFebzqe6+/52U1EFD8dhOGxqMt";
        HttpPost request2 = new HttpPost(BASEJIRA_URL+"/rest/raven/1.0/import/execution/cucumber");

        request2.addHeader("Content-Type", "application/json");
        request2.addHeader("Authorization", "Bearer "+JiraToken);
        Thread.sleep(1000);
        System.out.println("report path =" + file);
        StringEntity params = new StringEntity(Files.readString(file, StandardCharsets.UTF_8));
        request2.setEntity(params);

        try (CloseableHttpResponse response = httpClient.execute(request2)) {
            System.out.println("Response code: " + response.getStatusLine().getStatusCode());
            HttpEntity entity2 = response.getEntity();
            Object result2 = EntityUtils.toString(entity2);
            System.out.println(result2);
        }
    }

}
