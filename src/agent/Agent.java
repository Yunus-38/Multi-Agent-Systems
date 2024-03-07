package agent;

import java.util.ArrayList;
import java.util.List;

public class Agent {
    public int agent_id;
    public Position position;
    private int decision;
    private int timeStep; // her bir agent diğer agentla ne zaman görüştüğü, algotimadaki "s" değeri
    public List<Task> bundle;
    public List<Task> path;
    public List<Score> scoreList; //task sayısı kadar utility algoritmadaki "y" değeri olacak, her bir task için sağlanan en fazla fayda
    public List<Integer> scoreListIndex;//utilitylerin indexi algoritmadaki "z" değeri
    //public Score score;
    public MessageBox messageBox;

    public Agent(int agent_id, Position position, List<Task> bundle) {
        this.agent_id = agent_id;
        this.position = position;

    }
    // public Tuple scoringFunction(Task task){

    // }
    public void buildBundle(List<Task> bundle, List<Task> path, List<Score> scoreList, List<Integer> scoreListIndex) {
        //cij değeri=o task için diğerlerine göre daha iyi yapabiliyor mu
        //yij=diğer agentların o task için verdiği değer
        //hij eğer cij>yij den = 1;
            List<Integer> h = new ArrayList<>();
            List<Score> scores = Message.receiveMessage(position);
            Task task=new Task();

            double maxUtility = Double.NEGATIVE_INFINITY;
            int maxUtilityIndex = -1;

            if (scoreList.size() != scores.size()) {
                System.err.println("Error: scoreList and scores must have the same size.");
                return;
            }

            for (int i = 0; i < scoreList.size(); i++) {
                Score score = scoreList.get(i);
                Score outScore = scores.get(i);

                if (score.utility > outScore.utility) {
                    h.add(1);
                    if (score.utility > maxUtility) {
                        maxUtility = score.utility;
                        maxUtilityIndex = i;
                    }
                } else {
                    h.add(0);
                }
            }

            if (maxUtilityIndex != -1) {
                task.setTaskId(maxUtilityIndex);
                Bundle.addTask(task,maxUtility);
                Path.addTask(task);
                System.out.println("En büyük score.utility değeri: " + maxUtility);
                System.out.println("Index: " + maxUtilityIndex);
            }
        }


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

}