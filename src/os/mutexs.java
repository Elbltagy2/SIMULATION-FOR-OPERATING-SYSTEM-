package os;

import java.util.LinkedList;
import java.util.Queue;

public class mutexs {
	String name;
	Queue<process>blokedProcesses=new LinkedList<process>();
	
	boolean take=true;
	public mutexs(String name) {
		this.name=name;
	}

}
