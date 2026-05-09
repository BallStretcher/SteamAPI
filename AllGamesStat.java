package com.practice;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.HashMap;
import java.util.Map;

public class AllGamesStat extends SteamAPI {
    private String gameName;
    private int timePlayed;
    private Map<String,Integer> allGames = new HashMap<String,Integer>();



    public AllGamesStat(String steamID) {
        JsonNode games = getGamesInfo(steamID);
        for(JsonNode game:games){
            String name = game.path("name").asText();
            int playtime = game.path("playtime_forever").asInt();
            allGames.put(name,playtime);
        }
        System.out.println(allGames.isEmpty());
        System.out.println(allGames);
    }


}
