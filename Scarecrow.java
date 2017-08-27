import java.util.Scanner;

/**
 * UVA 12405
 */
public class Scarecrow {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int testCases = scanner.nextInt();
		scanner.nextLine();
		
		String line;
		for (int i = 0; i < testCases; i++) {
			scanner.nextLine();
			
			line = scanner.nextLine();
			
			int scareCrows = 0;
			int j = 0;
			while (j < line.length()) {
				//if we don't need to cover this spot
				if (line.charAt(j) == '#') {
					j++;
				} else {
					scareCrows++;
					j += 3;
				}
			}
			
			System.out.println("Case " + i + ": " + scareCrows);
		}
	}
}
