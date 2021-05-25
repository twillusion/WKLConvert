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

		//Invokes the Methods class
		Methods M = new Methods();
		
		//Creates the Swing window for logging
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame = new JFrame("Log");
	    frame.setBounds(0, 0, 600, 400);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    textArea = new JTextArea();
	    frame.getContentPane().add(textArea, BorderLayout.CENTER);
	    frame.setVisible(true);
	    
	    textArea.append("Starting program...\r\n");
	    

	    //Gets directory for input files
		File f = new File(System.getProperty("user.dir")+"\\input\\");
	    textArea.append("Scanned Input Directory, now converting...\r\n");
	    
	    //For loop to go through all files in the input folder
		for (File F : f.listFiles()) {
			Scanner sc = new Scanner(F);
			//The Make method creates an ArrayList of "Entry" objects that contain all the info that we want
			ArrayList<Entry> AE = M.Make(sc);
			//FileWriter writes everything we need
			FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\output\\" + F.getName().substring(0,F.getName().length()-4)+".txt");
			fw.write("Data File\tColumn\r\n");
			//Internal For Loop for each output file
			for (Entry e : AE) {
				fw.write(e.getID() + ".d\t" + e.getCol().substring(1,2)+"\r\n");
			}
			fw.flush();
		    textArea.append(F.getName() + " processed\r\n");
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
