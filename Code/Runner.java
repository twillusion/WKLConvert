import java.io.*;
import java.lang.*;
import java.util.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;


public class Runner {
	

	static JTextArea textArea;
	static JFrame frame;
	static JTextPane P;
	
	public void appendText(String text) {
        textArea.append(text);
    }
    
    
	public static void main(String[] args) throws IOException {

		
		Methods M = new Methods();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame = new JFrame("Log");
	    frame.setBounds(0, 0, 600, 400);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    textArea = new JTextArea();
	    frame.getContentPane().add(textArea, BorderLayout.CENTER);
	    frame.setVisible(true);
	    
	    textArea.append("Starting program...\r\n");
	    

		File f = new File(System.getProperty("user.dir")+"\\input\\");
		/*
		Process process = Runtime.getRuntime().exec("ping www.stackabuse.com");
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	    String line = "";
	    while ((line = reader.readLine()) != null) {
	        System.out.println(line);
	    }
	    */
	    textArea.append("Scanned Input Directory, now converting...\r\n");
	    
		for (File F : f.listFiles()) {
			Scanner sc = new Scanner(F);
			ArrayList<Entry> AE = M.Make(sc);
			FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\output\\" + F.getName().substring(0,F.getName().length()-4)+".txt");
			fw.write("Data File\tColumn\r\n");
			for (Entry e : AE) {
				fw.write(e.getID() + ".d\t" + e.getCol().substring(1,2)+"\r\n");
			}
			fw.flush();
		    textArea.append(F.getName() + " processed\r\n");
			/*
			for (Entry e : AE) {
				System.out.println(e.getID());
			}
			*/
		}

	    textArea.append("\r\n");

	    textArea.append("Completed\r\n");
		
		
		//System.out.println(System.getProperty("user.dir"));
		
		//System.out.println(AE.size());
	
		/*
		for (Entry e : AE) {
			System.out.println(e.getCol());
		}
		*/
		
	}
	

}
