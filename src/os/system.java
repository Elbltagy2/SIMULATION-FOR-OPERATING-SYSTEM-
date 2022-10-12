package os;

import java.util.ArrayList;

import java.io.*;


public class system {
	ArrayList<variable>memory=new ArrayList<variable>();
	ArrayList<String>files=new ArrayList<String>();
	mutualExclusion mutualExclusion=new mutualExclusion();
	String []memoryStrings=new String [40];
	process curentProcess;
	Scheduler scheduler=new Scheduler();
	public system() {
		
			
	}
	void assign(String  x,String y,int a) {
		for (int i = a; i < memoryStrings.length; i++) {
			if (memoryStrings[i]==null) {
				memoryStrings[i]=x+" "+y;
				break;
			}
		}
	}

	 void printFromTo(int x,int y) {
		for (int i = x; i <=y; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	 void Print(String x) {
		System.out.println(x);
	}
	ArrayList<String> readfile(String x) throws IOException {
		for(variable a:memory) {
			if (a.Name.equals(x)&&a.vProcess.equals(curentProcess.ID)) {
				x=a.data;
			}
		}
		ArrayList<String>arrayList=new ArrayList<String>();
		 File file = new File("C:\\Users\\Ahmed Elbltagy\\Desktop\\OS_22_Project\\"+x+".txt");
		 BufferedReader br= new BufferedReader(new FileReader(file));
		  String st;
	        // Condition holds true till
	        // there is character in a string
	        while ((st = br.readLine()) != null) {
	    // Print the string
	            arrayList.add(st);
	        }		 
		return arrayList;
	}
	void writefile(String x,String y) throws IOException {
		String s1="";
		String s2="";
		for(variable aVariable :memory) {
			if (aVariable.Name.equals(x)&&aVariable.vProcess.equals(curentProcess.ID)) {
				s1=aVariable.data;
			}
			if (aVariable.Name.equals(y)&&aVariable.vProcess.equals(curentProcess.ID)) {
				s2=aVariable.data;
			}
		}
		if (files.contains(s1)) {   
              FileWriter fw=new FileWriter("C:\\Users\\Ahmed Elbltagy\\Desktop\\OS_22_Project\\"+s1+".txt");    
              fw.write(s2);    
              fw.close();    
		}else {
  			File file = new File("C:\\Users\\Ahmed Elbltagy\\Desktop\\OS_22_Project\\"+s1+".txt");
			 files.add(s1);
			  FileWriter fw=new FileWriter("C:\\Users\\Ahmed Elbltagy\\Desktop\\OS_22_Project\\"+s1+".txt");    
              fw.write(s2);    
              fw.close();   
			 
		}
             }    
	
	void semWait(String x,int ll) {
		
		for(mutexs m:mutualExclusion.mutexs1) {
			if (m.name.equals(x)) {
				if (m.take==false) {
					m.blokedProcesses.add(curentProcess);
					memoryStrings[ll-1]="Blocked";
					memoryStrings[ll]=Integer.parseInt(memoryStrings[ll])+1+"";
					curentProcess.count=0;
					mutualExclusion.blockedQueue.add(curentProcess);
					curentProcess=scheduler.choose();
					curentProcess.count=-1;
				}
				else {
				m.take=false;}
			}
		}
	}
	void semSignal(String x) {
		boolean f=true;
		for(mutexs m:mutualExclusion.mutexs1) {
			if (m.name.equals(x)) {
				if (m.take==false) {
					 if (!m.blokedProcesses.isEmpty()) {
						 f=false;
						process p= m.blokedProcesses.poll();
						 mutualExclusion.blockedQueue.remove(p);
						 scheduler.premited(p);	
							
					 }
				}
				m.take=f;
			}
		}
	}
	

	
}
class variable {
	public String data;
	public String Name ;
	public String vProcess;
	public variable(String name) {
		this.Name=name;
	}
	public static void main(String[] args) throws IOException {
		system system=new system();
		system.readfile("ahmed");
	}
	
	
	
}


