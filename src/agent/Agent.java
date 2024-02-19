package agent;

import java.util.List;

public class Agent {
    public int agent_id;
    public Position position;
    private int decision;
    private int timeStep;
    public List<Task> bundle;
    public List<Task> path;
    public Score score;

    public Agent(int agent_id, Position position, List<Task> bundle) {
        this.agent_id = agent_id;
        this.position = position;

    }
    // public Tuple scoringFunction(Task task){

    // }

    public void move(Position destinationPosition) {
        //hareket ettikten sonraki pozisyonu döndürecek
        //sendMessage sendBundle
        Position nearestTaskPosition = findNearestTask();
        if (nearestTaskPosition == null){
            return;
        }
        if (!nearestTaskPosition.equals(position)){
            step(nearestTaskPosition);
        }


    }
    private Position findNearestTask(){

        return null; //en yakın taskin pozisyonunu verecek
    }

    public void step(Position destinationPosition){
        if(destinationPosition.getX() > position.getX()){
            position.setX(position.getX() + 1);
        } else if(destinationPosition.getX() < position.getX()){
            position.setX(position.getX() + -1);
        }
        if(destinationPosition.getY() > position.getY()){
            position.setY(position.getY() + 1);
        }else if(destinationPosition.getY() < position.getY()){
            position.setY(position.getY() - 1);
        }
        //burada hedef pozisyonla şu anki pozisyonu karşılaştırdık
        //eğer hedef pozisyon şu anki pozisyonumuzdan daha büyükse adım adım hedefe ilerleyeceğiz
        //küçükse de aynı mantıkla devam edeceğiz


    }
    public void sendMessage(Position newPosition) {


    }
}