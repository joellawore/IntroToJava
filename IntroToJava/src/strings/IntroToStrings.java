package strings;

public class IntroToStrings {

	static String str = "hi there", str1 = "hello", str2 = "there", str3 = "happily", str4 = "hippo", str5 = "hi", str6 = "hello", str7 = "", str8 = "hello";
	
	public void halfString(String str) {
		System.out.println(str.substring(str.length()/2));
	}
	
	public void concatenation(String str1, String str2) {
		System.out.println(str1.substring(1) + str2.substring(1));
	}
	
	public void adverbCheck(String str3) {
		System.out.println( (str3.substring(str3.length()-2)).equals("ly") ? "yes" : "no" );
	}

	public void containsSecond(String str4, String str5) {
		System.out.println( (str4.indexOf(str5) >= 0) ? "yes" : "no");
	}
	
	public void reverse(String str6) {
		for (int i = str6.length(); i > 0; i--) {
			str7 += str6.substring(i-1,i);
		}
		System.out.println(str7);
	}
	
	public void wordSquare(String str8) {
		for (int i = 0; i < str8.length(); i++) {
			System.out.println(str8.substring(i) + str8.substring(0,i));
		}
	}
	
	public static void main(String args[]) {
		IntroToStrings run = new IntroToStrings();
		
		run.halfString(str);
		run.concatenation(str1, str2);
		run.adverbCheck(str3);
		run.containsSecond(str4, str5);
		run.reverse(str6);
		run.wordSquare(str8);
	}
}
