package os;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import jdk.nashorn.api.tree.ForInLoopTree;


public class Engine {

	public static void main(String[] args) throws IOException {
		Scanner scanner=new Scanner(System.in);
		system system=new system();
		Scheduler scheduler=new Scheduler();
		interpreter p=new interpreter();
		memoryManger MM=new memoryManger();
		MM.system=system;
		p.system=system;
		system.scheduler=scheduler;

		int i=0;
		while (true) {
		
		if (i==0) {
		process p1=new process();
		
		 ArrayList<String>ss=system.readfile("Program_1");
		 MM.addnewPCB("Program_1", ss.size(),ss);
		 p1.ID="Program_1";
		 scheduler.premited(p1);
		 system.curentProcess=scheduler.choose();
	//	 System.out.println(p1.ID+" is chosen");
		 }
	if (i==2) {
			process p2=new process();
			 ArrayList<String>ss=system.readfile("Program_2");
			 p2.ID="Program_2";
			 MM.addnewPCB("Program_2", ss.size(),ss);
			 scheduler.premited(p2);
	}
	if (i==4) {	
			process p3=new process();
			 ArrayList<String>ss=system.readfile("Program_3");
			 MM.addnewPCB("Program_3", ss.size(),ss);
			 p3.ID="Program_3";
			 scheduler.premited(p3);
	}
	if(system.curentProcess.count>=2) {
		if (!scheduler.readyQueue.isEmpty()) {
			
			system.curentProcess.count=0;
			scheduler.premited(system.curentProcess);
			for(process pp:scheduler.readyQueue) {
				if (pp==null) {
					continue;	
				}	
			}
			 system.curentProcess=scheduler.choose();	 
		}
	}
	if (!system.curentProcess.ID.equals(system.memoryStrings[0])){
		if (!system.curentProcess.ID.equals(system.memoryStrings[5])){
			MM.load(system.curentProcess.ID);
		}
	}
	print(system.memoryStrings);
			 i=p.run(system.curentProcess.ID,i);
		}
	}
	
public static void print(String []x) {
	System.out.print("{");
	for (int i = 0; i < x.length; i++) {
		System.out.print(x[i]+" ");
	}
	System.out.println("}");
}

}
