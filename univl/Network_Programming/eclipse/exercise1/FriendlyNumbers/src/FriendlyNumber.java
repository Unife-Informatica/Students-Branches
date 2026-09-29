import java.util.Scanner;

public class FriendlyNumber {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Insert a number: ");
		int n = input.nextInt();
		input.close();
		
		for(int i = 1; i <= n; i++) {
			float a1 = abundancy_index(i);
			for(int j = i + 1; j <= n; j++) {
				float a2 = abundancy_index(j);
				if(a1 == a2) {
					System.out.println(i + " " + j);
				}
			}
		}
	}
	
	public static float abundancy_index(int x) {
		int sum = 0;
		for(int i = 1; i <= x; i++) {
			if(x % i == 0) {
				sum+=i;
			}
		};
		return (float) sum/x;
	}
}