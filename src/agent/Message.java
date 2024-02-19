package agent;

public class Message { // y z ve s(bakiden alacaksın) yi gönder
    public int agentId;
    public Score score; //utility
    public Position position;

    public Message(int agentId, Score score, Position position) {
        this.agentId = agentId;
        this.score= score;
        this.position = position;
    }
}
