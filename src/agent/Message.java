package agent;

import java.util.List;

public class Message { // y z ve s(bakiden alacaksın) yi gönder
    public int agentId;
    public double score; //utility
    public Position position;
    public static void sendMessage(Position newPosition) {
        //y ,z ve s vektörlerini döndürür

    }
    public static List<Double> receiveMessage(Position position){
        //diğer agentların score list
        List<Double>score=null;
        return score;
    }
    public Message(int agentId, Double score, Position position) {
        this.agentId = agentId;
        this.score= score;
        this.position = position;
    }

}
