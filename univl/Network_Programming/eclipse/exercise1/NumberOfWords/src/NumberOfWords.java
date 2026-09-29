import java.util.Scanner;

public class NumberOfWords {

	public static void main(String[] args) {
		Scanner input  = new Scanner(System.in);
		System.out.println("Insert the words string that you want to store: ");
		String words = input.nextLine();
		System.out.println("Insert the string that you want to search: ");
		String ch = input.nextLine();
		String[] split = words.split(" ");
		int tot = 0;
		for(int i = 0; i < split.length; i++) {
			if(search(split[i], ch)) {
				tot+=1;
			}
		}
		System.out.println("Tot: " + tot);
	}
	
	public static boolean search(String word, String ch) {
		if(word.startsWith(ch) || word.endsWith(ch)) {
			return true;
		}else {
			return false;
		}
	}
}