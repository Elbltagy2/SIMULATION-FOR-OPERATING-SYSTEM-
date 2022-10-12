package os;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;

public class process {
	String ID;
	String state;
	int count =0;
	int pc=0;
	int start =0;
	int end=0;
	HashMap<String, String>v=new HashMap<String, String>(); 
	ArrayList<String> bReader;
	String memString[]=new String[2];
	 int size() {
		return bReader.size();
	}
}

