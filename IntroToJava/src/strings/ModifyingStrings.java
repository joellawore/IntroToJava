package strings;

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
	
	public void stringCheck(String str1, String str2, String str3) {
		
	}
	
	public static void main(String args[]) {
		ModifyingStrings run = new ModifyingStrings();
		
		run.adverbToSuperlative("quickly");
		run.negation("predisposed");
		run.suffixCheck("safer", "ine");
		run.replace("david", 'd', 'm');
	}
}
