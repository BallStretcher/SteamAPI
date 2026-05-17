package com.practice;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public class Parser {
    public static PlayerStat account(JsonNode base){
        JsonNode data = base.path("response").path("players").get(0);
        return new PlayerStat(
                data.path("personaname").asText("Имя не найдено"),
                data.path("avatarfull").asText("not found"),
                data.path("personastate").asInt(),
                data.path("lastlogoff").asInt(),
                data.path("gameextrainfo").asText()
        );
    }
    public static GameAchievements achievements (JsonNode base){
return null;
    }




    public static List<Game> gamesOwned(JsonNode base){

        JsonNode data = base.path("response").path("games");
        List<Game> games = new ArrayList<>();

        for(JsonNode a:data)
        {
            games.add(
                    new Game(
                            a.path("appid").asInt(),
                            a.path("name").asText(),
                            a.path("playtime_forever").asInt())
            );
        }
        return games;
    }
}
