package os;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class mutualExclusion {
	
	public ArrayList<mutexs>mutexs1=new ArrayList<mutexs>();
	Queue<process>blockedQueue=new LinkedList<process>();
	public  mutualExclusion() {
	mutexs userInput=new mutexs("userInput");
	mutexs userOutput=new mutexs("userOutput");
	mutexs file=new mutexs("file");
	mutexs1.add(userInput);
	mutexs1.add(userOutput);
	mutexs1.add(file);
	}
	void addtobloked (process p) {
		blockedQueue.add(p);
		
	}


}
