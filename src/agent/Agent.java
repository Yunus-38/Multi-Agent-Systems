package agent;

import java.util.ArrayList;
import java.util.List;

import static simulation.LifeCycle.AGENT_CAPACITY;

public class Agent {
    
    private List<Task> taskList;
    private int agent_id;
    private Position position;
    private int decision;
    private int timeStep; // her bir agent diğer agentla ne zaman görüştüğü, algotimadaki "s" değeri
    private List<Task> bundle;
    private List<Task> path;
    private List<Double> y; // her task için max performance
    private List<Integer> z;//utilityi veren agentin indexi
    //public Score score;

    public MessageBox messageBox;

    public Agent(int agent_id, Position position, List<Task> bundle) {
        this.agent_id = agent_id;
        this.position = position;

    }
    // public Tuple scoringFunction(Task task){

    // }

    public void updateTaskList(){
    }
/*    public void buildBundle(List<Task> bundle, List<Task> path, List<Double> scoreList, List<Integer> scoreListIndex) {
        //cij değeri=o task için diğerlerine göre daha iyi yapabiliyor mu
        //yij=diğer agentların o task için verdiği değer
        //hij eğer cij>yij den = 1;
        List<Integer> h = new ArrayList<>();
        while(bundle.size()< AGENT_CAPACITY){
            double maxAgentIndex;
            double maxValue = 0;
            int task_id=-1;
            List<Double>
            for(int i=0; i< taskList.size() ; i++ ) {
                if (!bundle.contains(task_id)) {
                    double taskScore = scoringFunction(path, taskList.get(i));

                }
                else {

                }
            }
            for(int i=0; i< taskList.size() ; i++ ) {
                if (taskScore > y.get(i)) {
                    h.add(1);
                    if (taskScore > maxValue) {
                        maxValue = taskScore;
                        maxAgentIndex = z.get(i);
                        task_id = i;
                    }
                } else {
                    h.add(0);
                }
            }
            }
            if(task_id != -1) {
                bundle.add(taskList.get(task_id));
                path.add(taskList.get(task_id));
                int selectedTaskScoreIndex = scoreListIndex.get(task_id);
                // Update the scoreList with the new maxValue
                scoreList.set(selectedTaskScoreIndex, maxValue);
                scoreListIndex.set(selectedTaskScoreIndex,agent_id);
            }
        }
    }*/
public void buildBundle() {
    double[] c= new double[taskList.size()];
    while(bundle.size()< AGENT_CAPACITY){

        for(int i=0; i< taskList.size() ; i++ ) {
            if (!bundle.contains(taskList.get(i).getTaskId())) {
                c[i] = scoringFunction(taskList.get(i).getTaskId());
            }
            else {
                c[i]= y.get(taskList.get(i).getTaskId());
                //index==task id mi?
            }
        }
        int[] h =  new int[taskList.size()];
        for(int i=0; i< taskList.size() ; i++ ){
            if(c[i]> y.get(taskList.get(i).getTaskId())){
                h[i]=1;
            }
            else{
                h[i]=0;
            }
        }
        double maxValue=0;
        int maxIndex=-1;
        for(int i=0;i< taskList.size();i++){
                if(h[i]*c[i]>maxValue){
                    maxValue=c[i];
                    maxIndex=taskList.get(i).getTaskId();
                }
        }
        //ni,j=argmaxN...
        //ni = pathde nereye ekleyeceğim index
        bundle.add(taskList.get(maxIndex));
        path.add(taskList.get(maxIndex));
        y.set(maxIndex,maxValue);
        z.set(maxIndex,agent_id);
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
    public double scoringFunction(int taskId){
    //path
        //pathde nereye ekleyeceğimin fonksiyonunu içerir
        return 1;
    }

}