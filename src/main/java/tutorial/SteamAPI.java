package tutorial;

import com.fasterxml.jackson.databind.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import java.util.*;


    public class SteamAPI{
    private static final String API_KEY = "CB76C482937B0AC695B62EBB16D3A64C";
    private static final String BASE_URL = "https://api.steampowered.com/";
    private static final Map<Integer,String> status = Map.of(0, "Offline", 1, "Online", 2 , "Busy", 3 , "Away", 4 ,
            "Snooze", 5 , "Looking to trade", 6, "Looking to play");


    public static void main(String[] args) {

        getProfileInfo2("76561198145570899");
    }
    public static JsonNode getProfileInfo2(String steamId){
        String url = BASE_URL + "ISteamUser/GetPlayerSummaries/v2/?key=" +
                API_KEY + "&steamids=" + steamId;
        try
        {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            System.out.println("Ответ сервера - "+ response.getStatusLine().getStatusCode());
            String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println(responseBody);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode utility = mapper.readTree(responseBody);
            //gameid
            return utility.path("response").path("players").get(0);




        } catch (Exception e) {
            System.out.println("Connection failed");
        }
        return null;
    }
}