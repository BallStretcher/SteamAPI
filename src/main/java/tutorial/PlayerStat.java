package tutorial;

import com.fasterxml.jackson.databind.JsonNode;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class PlayerStat extends SteamAPI {
    private String name,last_seen,game_playing,avatar_link;
    private String current_status = status.get(0);
    private static final Map<Integer,String> status = Map.of(0, "Offline", 1,
            "Online", 2 , "Busy", 3 , "Away", 4 ,
            "Snooze", 5 , "Looking to trade", 6, "Looking to play");

    public String getName() {
        return name;
    }


    public String getLast_seen() {
        return last_seen;
    }


    public String getGame_playing() {
        return game_playing;
    }


    public String getCurrent_status() {
        return current_status;
    }


    public String getAvatar_link() {
        return avatar_link;
    }


    public PlayerStat(String steamID){
        JsonNode stat = getProfileInfo2(steamID);
        this.name = stat.path("personaname").asText("Имя не найдено");
        this.avatar_link = stat.path("avatarfull").asText("not found");
        this.current_status = status.get(stat.path("personastate").asInt());

        Instant instant = Instant.ofEpochSecond(stat.path("lastlogoff").asInt());
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        this.last_seen = zonedDateTime.format(formatter);



    }


}
