import java.util.*;
class Exercise22_3 {
	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		System.out.print("Enter a string s1: ");
		String s1 = user.nextLine();
		System.out.print("Enter a string s2: ");
		String s2 = user.nextLine();
		int matched = match(s1, s2);
		if(matched == -1) {
			System.out.println("no matches found");
		}
		else {
			System.out.println("matched at index " + matched);
		}
	}
	static int match(String s1, String s2) {
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) == s2.charAt(0)) {
				String test = s1.substring(i, i + s2.length());
				if(test.equals(s2)) {
					return i;
				}
			}
		}
		return -1;
	}
	/**
	Time Complexity 
	T(n) = O(n)
	**/
}