import java.util.*;
class Exercise22_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String in = input.next();
		String sub = maxSub(in);
		System.out.println("Maximum consecutive substring is " + sub);
	}
	static String maxSub(String string) {
		ArrayList<String> list = new ArrayList<>();
		String temp = "" + string.charAt(0);
		String finished = "";
		for(int i = 0; i < string.length() - 1; i++) {
			if(string.charAt(i + 1) > string.charAt(i)) {
				temp += string.charAt(i + 1);
			}
			else {
				list.add(temp);
				temp = "" + string.charAt(i + 1);
			}
			if(i == string.length() - 2) {
				list.add(temp);
			}
		}
		finished = list.get(0);
		for(int i = 1; i < list.size(); i++) {
			if(list.get(i).length() > finished.length()) {
				finished = list.get(i);
			}
		}
		return finished;
		/**
			Time Complexity:		
			T(n) = 0(n)
		**/
	}
}