package strings;

import java.util.Arrays;

public class ModifyingStrings {

	public void adverbToSuperlative(String adv) {
		String superlative = adv.substring(0, adv.indexOf("ly")) + "est";
		System.out.println(superlative);
	}

	public void negation(String pre) {
		String un = "un" + pre.substring(pre.indexOf("pre")+3);
		System.out.println(un);
	}
	
	public void suffixCheck(String word, String suffix) {
		if (word.indexOf(suffix)+1 > word.length()-suffix.length()) {
			word = word.substring(0, word.indexOf(suffix)) + "ine";
		}
		else {
			word = word + suffix;
		}
		System.out.println(word);
	}
	
	public void replace(String look, char find, char replace) {
		for (int i = 0; i< look.length(); i++) {
			if (look.charAt(i) == find) {
				look = look.substring(0,i) + replace + look.substring(i+1);
			}
		}
		System.out.println(look);
	}
	
	public int wordCount(String str) {
		int wC = 1;
		for (int i = 0; i < str.length()-1; i++) {
			if (str.charAt(i) == ' ')
				wC++;
		}
		return(wC);
	}
	
	public void sentenceToArray(String str) {
		String[] arr = new String[wordCount(str)];
		for (int k = 0; k < arr.length; k++) {
			arr[k] = "";
		}
		
		int i = 0;
		for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == ' ') {
					i++;
					j++;
				}
				arr[i] += str.charAt(j);
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String args[]) {
		ModifyingStrings run = new ModifyingStrings();
		
		run.adverbToSuperlative("quickly");
		run.negation("predisposed");
		run.suffixCheck("safer", "ine");
		run.replace("david", 'd', 'm');
		run.sentenceToArray("I like CS");
	}
}
