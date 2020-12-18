package miniprojects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RemixerFiller {

	private String[] lyrics;
	private String fileName = "Promiscuous";	// this should match your txt file
	
	private String[] wordsToReplace = {"promiscuous", "boy", "girl", "mad", "mean"};	// for part 2, if you finish the main project
	private String[] newWords = {"fergalicious", "guy", "gal", "happy", "nice"};
	
	public void remix() {
		
		// your code here
		for (int i = 0; i < wordsToReplace.length; i++) {
			for (int j = 0; j < lyrics.length; j++) {
				if(lyrics[j].equals(wordsToReplace[i])) {
					lyrics[j] = newWords[i];
				}
			}
		}
	}
	
	// DON'T TOUCH THE BELOW CODE //
	
	public RemixerFiller() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			ArrayList<String> tempLyrics = new ArrayList<String>();
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				
				String[] words = line.split(" ");
				for (String w : words) {
					tempLyrics.add(w.toLowerCase().replaceAll("^[^a-zA-Z0-9\\s]+|[^a-zA-Z0-9\\s]+$", ""));
				}
				tempLyrics.add("\n");
			}
			in.close();
			lyrics = new String[tempLyrics.size()];
			for (int i = 0; i < tempLyrics.size(); i++) {
				lyrics[i] = tempLyrics.get(i);
			}
			

			remix();
			
			if (fileName.substring(fileName.length()-4).equals(".txt")) {
				fileName = fileName.substring(0, fileName.length()-4);
			}
			
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName + "_remixed"));
			
			for (String s : lyrics) {
				out.write(s + (s.equals("\n") ? "" : " "));
			}
			out.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new RemixerFiller();
	}
}
