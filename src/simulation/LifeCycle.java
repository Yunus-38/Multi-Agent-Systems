package simulation;

public class LifeCycle {
	
	//private static MessageBox messageBox;
	//private static Map map;
	private static int timeStep =0;
	public static void main(String[] args) {
		
		while(true) {
			
			broadcastTasks();
			
			timeStep++;
		}

	}
	
	public static void broadcastTasks() {
		//inform all agents of all tasks one by one.
	}
	
	public static void generateTasks() {
		//call the generate task method of every cell in map.
	}
	
	public static void moveAgents() {
		//call the move function of every agent.
	}

}
