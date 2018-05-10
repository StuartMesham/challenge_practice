import java.util.Arrays;
import java.util.Scanner;

public class WordDistance {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String sourceString;
		String targetString;
		
		while (!(sourceString = scanner.next()).equals("-1")) {
			targetString = scanner.next();
			
			char[] source = sourceString.toUpperCase().toCharArray();
			char[] target = targetString.toUpperCase().toCharArray();
			
			int[][] costs = new int[target.length + 1][source.length + 1];
			
			//Fill in starting values
			costs[0][0] = 0;
			for (int s = 0; s < source.length; s++) {
				costs[0][s + 1] = s + 1;
			}
			for (int t = 0; t < target.length; t++) {
				costs[t + 1][0] = t + 1;
			}
			
			for (int t = 0; t < target.length; t++) {
				for (int s = 0; s < source.length; s++) {
					int min = min(
							costs[t][s + 1],
							costs[t + 1][s],
							costs[t][s]
					);
					
					if (min == costs[t][s] && source[s] != target[t]) { //If we did nothing
						costs[t + 1][s + 1] = min;
					} else {
						costs[t + 1][s + 1] = min + 2; //Everything else costs 2
					}
				}
			}
			
			System.out.print("  _ ");
			for (int i = 0; i < source.length; i++) {
				System.out.print(source[i] + " ");
			}
			System.out.println();
			
			for (int t = 0; t < costs.length; t++) {
				//System.out.println(Arrays.toString(costs[t]));
				if (t == 0) {
					System.out.print("_ ");
				} else {
					System.out.print(target[t - 1] + " ");
				}
				for (int s = 0; s < costs[t].length; s++) {
					System.out.print(costs[t][s] + " ");
				}
				System.out.println();
			}
			
			//System.out.println(costs[target.length][source.length]);
		}
	}
	
	private static int min(int a, int b, int c) {
		if (a < b) {
			if (c < a) {
				return c;
			} else {
				return a;
			}
		} else {
			if (c < b) {
				return c;
			} else {
				return b;
			}
		}
	}
}
