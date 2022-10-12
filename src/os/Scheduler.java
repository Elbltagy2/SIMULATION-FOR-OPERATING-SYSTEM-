package os;

import java.util.LinkedList;
import java.util.Queue;


public class Scheduler {
	Queue<process>readyQueue=new LinkedList<process>();

	public Scheduler() {
		
	}

	void premited(process p) {
		readyQueue.add(p);
	}
	process choose() {
		return  readyQueue.poll();
	}
	
	

}
