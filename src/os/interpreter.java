package os;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class interpreter {
	static Scanner scanner=new Scanner(System.in);
	public BufferedReader br;
	public system system;
	public interpreter() throws IOException {
		system=new system();
        	
        }
	int run(String p,int i) throws NumberFormatException, IOException {
		int startpc=0;
		int start=0;
		int end=0;
		int pc=0;
		for (int j = 0; j < system.memoryStrings.length; j++) {
			if (p.equals(system.memoryStrings[j])) {
				startpc=j+2;
				system.memoryStrings[j+1]="Running";
				start=Integer.parseInt(system.memoryStrings[j+3]);
				end=Integer.parseInt(system.memoryStrings[j+4]);
				pc=Integer.parseInt(system.memoryStrings[j+2]);
				break;
			}
		}
		int pcn=pc+start;
		String st=system.memoryStrings[pc+start];
		String string[]=st.split(" ");
    	if (string[0].equals("semWait")) {
    		system.semWait(string[1],startpc);
    	}
    	
    	if (string[0].equals("assign")) {
    		String s1=string[1];
    		if (string[2].equals("input")) {
    		System.out.println("Please enter  value");
    		String s2=scanner.next();
    		system.assign(s1,s2,start);}
    		else {
    			ArrayList<String> s2= system.readfile(string[3]);
    			system.assign(s1,s2.get(0),start);
    		}	
    	}
    	if (string[0].equals("semSignal")) {
    		system.semSignal(string[1]);
    	}
    	if (string[0].equals("print")) {
    		for (int j = 0; j <system.memoryStrings.length; j++) {
				if (system.memoryStrings[j].equals(string[1])) {
					
					System.out.println(system.memoryStrings[i]);
					break;
				}
				
			}
    		
    	}
    	if (string[0].equals("printFromTo")) {
    	//	System.out.println(system.memory);
//    		int a=0;
//    		int b=0;
//    		for (int j = start; j <system.memoryStrings.length; j++) {
//				if (system.memoryStrings[j].equals(string[1])) {
//				a=Integer.parseInt(system.memoryStrings[j+1]);
//				}
//				if (system.memoryStrings[j].equals(string[2])) {
//					
//					b=Integer.parseInt(system.memoryStrings[j+1]);
//					break;
//				}
//			}
//    		 system.printFromTo(a,b);
    	}
    	if (string[0].equals("writeFile")) {	
//    		system.writefile(string[1], string[2]);
    	}
    	pc++;
    	system.memoryStrings[startpc]=pc+"";
        i++;
        system.curentProcess.count++;
		return i;
	}
	
	
	
	}
	


