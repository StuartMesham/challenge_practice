import java.util.Scanner;

public class RemoveDuplicates {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		char[] chars = scanner.nextLine().toCharArray();
		
		scanner.close();
		
		boolean[] used = new boolean[Character.MAX_VALUE];
		
		for (char c : chars) {
			if (c == ' ' || !used[c]) {
				used[c] = true;
				System.out.print(c);
			}
		}
	}
}