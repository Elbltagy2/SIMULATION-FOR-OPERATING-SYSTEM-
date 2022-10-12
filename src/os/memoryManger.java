package os;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class memoryManger {
	system system;
	int countfor=0;
	int startPCB=0;
	int startline =0;
	int number=0;
	Queue<String>prQueue=new LinkedList<String>();
	
	void  load(String p) throws IOException {
		
		ArrayList<String>x=system.readfile(p+"2");
		
			unload();
			int m=0;
			System.out.println("to load "+p);
			for (int i = startPCB; i < startPCB+3; i++) {
				system.memoryStrings[i]=x.get(m++);
			}
			m+=2;
			
			
			for (int i = startline; i < startline+x.size()-5; i++) {
				system.memoryStrings[i]=x.get(m++);
				
			}
			
		
		
		
		number++;
		
	}
	
	void unload () throws IOException {
		String string="";
		int start =0;
		int end =0;
		String p=prQueue.poll();
		System.out.print("we unload "+p);
		for (int i = 0; i < system.memoryStrings.length; i++) {
			if (system.memoryStrings[i].equals(p)) {
				string+=system.memoryStrings[i]+"\n";
				startPCB=i;
				string+=system.memoryStrings[i+1]+"\n";
				string+=system.memoryStrings[i+2]+"\n";
				string+=system.memoryStrings[i+3]+"\n";
				string+=system.memoryStrings[i+4]+"\n";
				start=Integer.parseInt(system.memoryStrings[i+3]);
				end=Integer.parseInt(system.memoryStrings[i+4]);
				break;
			}
		}
		startline=start;
		number--;
		for (int i = startline; i < end; i++) {
			string+=system.memoryStrings[i]+"\n";
			system.memoryStrings[i]=null;
		}
		File file = new File("C:\\Users\\Ahmed Elbltagy\\Desktop\\OS_22_Project\\"+p+"2"+".txt");
		  FileWriter fw=new FileWriter("C:\\Users\\Ahmed Elbltagy\\Desktop\\OS_22_Project\\"+p+"2"+".txt");    
         fw.write(string);    
         fw.close();   
		
	}
	void addnewPCB(String s,int b,ArrayList<String>sss) throws IOException {
		
		if (number==0) {
			system.memoryStrings[countfor++]=s;
			system.memoryStrings[countfor++]="Ready";
			system.memoryStrings[countfor++]="0";
			int m=0;
			for (int i = 10; i < 10+b; i++) {
				system.memoryStrings[i]=sss.get(m++);
			}
		system.memoryStrings[countfor++]=10+"";
		system.memoryStrings[countfor++]=10+b+3+"";
		prQueue.add(s);
		}
		if (number==1) {
			system.memoryStrings[countfor++]=s;
			system.memoryStrings[countfor++]="Ready";
			system.memoryStrings[countfor++]="0";
			int m=0;
			for (int i = 25; i < 25+b; i++) {
				system.memoryStrings[i]=sss.get(m++);
			}
			system.memoryStrings[countfor++]=25+"";
			system.memoryStrings[countfor++]=25+b+3+"";
			prQueue.add(s);
			
		}
		if (number==2) {		
			unload();
			int m=0;
			system.memoryStrings[startPCB++]=s;
			system.memoryStrings[startPCB++]="Ready";
			system.memoryStrings[startPCB++]="0";
			system.memoryStrings[startPCB++]=startline+"";
			system.memoryStrings[startPCB++]=startline+b+3+"";
			
			for (int i = startline; i < startline+sss.size(); i++) {
				system.memoryStrings[i]=sss.get(m++);
				
			}
			System.out.println("to load "+s);
		
			prQueue.add(s);
		}
		
		number++;
		
		
		
	}
	

}
