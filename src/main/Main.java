package main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.NoSuchAlgorithmException;
import javax.json.Json;
import javax.json.JsonObject;
import multiship_v1.MultiShip;

/**
 *
 * @author ah
 */

public class Main {
    public static void main(String[] args)
    {          
        // TODO: CHANGE LAST URL PART WITH METOD YOU WANT TO RUN
        String api_url = "https://multiship.ru/openAPI_v3/searchDeliveryList";
        
        // Read it if you have problems with HTTPS certificate check
        // http://stackoverflow.com/questions/4302686/import-startcom-ca-certificates-in-windows-jre

        // Get Delivery Methods List from Moscow to Samara for order with weight 1 kg and size 1x1x1 sm
        
        // Build query
        JsonObject request = Json.createObjectBuilder()
                .add("city_from", "москва")
                .add("city_to", "самара")
                .add("delivery_type", "todoor")
                .add("weight", "1")
                .add("height", "1")
                .add("width", "1")
                .add("length", "1")
                .add("format", "json")
        // TODO: FILL WITH YOUR CLIENT ID        
                .add("client_id", "")
                .build();
        
        // TODO: FILL WITH YOUR SECURITY CODE FOR searchDeliveryList METHOD
        String secure_key = "";
        
        // Make API request to SDK
        JsonObject result = null;
        
        try {
            result = MultiShip.request(api_url, request, secure_key);
        } catch (MalformedURLException ex) {
            // Wrong URL 
        } catch (IOException ex) {
            // Problems with connection
        } catch (NoSuchAlgorithmException ex) {
            // Can't calculate MD5
        }

        // Show result - you must process it in your implementation
        System.out.println(result);
        
    }
}
