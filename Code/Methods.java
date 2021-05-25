import java.io.*;
import java.lang.*;
import java.util.*;

public class Methods {
	
	public Methods() {
		
	}
	
	public String readLine(String s) {
		
		String output = "";
		
		if (s.contains(".m")) {
			int mloc = s.indexOf(".m");
			output = s.substring(mloc-2, mloc);
		}
		
		else if (s.contains(".d")) {
			int mloc = s.indexOf(".d");
			int sloc = s.lastIndexOf("\\");
			output = s.substring(sloc+1, mloc);
		}
		return output;
		
	}
	
	public ArrayList<Entry> Make(Scanner sc) {
		ArrayList<Entry> output = new ArrayList<>();
		while (sc.hasNextLine()) {
			String Line = sc.nextLine();
			if (Line.contains("<SampleInfo>")) {
				Entry e = new Entry();
				Line = sc.nextLine();
				while (!Line.contains("</SampleInfo>")) {
					String l = readLine(Line);
					//System.out.println(Line + " " + l);
					if (!l.equals("")) {
						if(l.contains("C")) {
							String C = l;
							e.setCol(C);
							//System.out.println(C);
						}
						else {
							String I = l;
							e.setID(I);
							//System.out.println(I);
						}
						l = "";
					}
					Line = sc.nextLine();
				}
				output.add(e);
			}
		}
		
		for (int i = 0; i < output.size(); i++) {
			if (output.get(i).getID().contains("Work")) {
				output.remove(i);
				i--;
			}
		}
		
		return output;
	}
}
