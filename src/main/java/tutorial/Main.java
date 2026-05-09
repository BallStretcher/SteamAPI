package tutorial;


public class Main {
    public static void main(String[] args) {
        //SteamAPI e = SteamAPI.getProfileInfo("76561198145570899");
        String and = "сделать так чтобы стимапи метод возвращал джосину с коротой будет работать плеерстат";
        //PlayerStat artem = new PlayerStat("76561198145570899");

        //System.out.println(artem.getLast_seen());
        PlayerStat sergey = new PlayerStat("76561198057186747");
        System.out.println(sergey.getName()+" "+sergey.getCurrent_status()+" "+sergey.getLast_seen());
        PlayerStat SS = new PlayerStat("76561198078418116");
        System.out.println(SS.getName()+" "+SS.getCurrent_status()+" "+SS.getLast_seen());


    }
}