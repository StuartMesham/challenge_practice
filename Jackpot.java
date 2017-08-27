import java.util.Scanner;

/**
 * UVA 10684
 */
public class Jackpot {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int length;
		while ((length = scanner.nextInt()) != 0) {
			
			int[] bets = new int[length];
			
			for (int i = 0; i < length; i++) {
				bets[i] = scanner.nextInt();
			}
			
			int streak = maxStreak(bets);
			
			if (streak > 0) {
				System.out.println("The maximum winning streak is " + streak + ".");
			} else {
				System.out.println("Losing streak.");
			}
		}
	}
	
	/**
	 * <p>Finds the maximum streak that could be achieved out of the given wins/losses.</p>
	 *
	 * Uses <a href="https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane.27s_algorithm">Kadane's algorithm</a>.
	 *
	 * @param bets array containing wins/losses
	 * @return Total amount won/lost from the maximum streak that could be achieved
	 */
	private static int maxStreak(int[] bets) {
		if (bets.length == 0) return 0;
		
		int maxStreakEndingHere = bets[0], maxStreakSoFar = bets[0];
		
		for (int i = 1; i < bets.length; i++) {
			maxStreakEndingHere = max(bets[i], maxStreakEndingHere + bets[i]);
			maxStreakSoFar = max(maxStreakSoFar, maxStreakEndingHere);
		}
		
		return maxStreakSoFar;
	}
	
	private static int max(int a, int b) {
		return a > b ? a : b;
	}
}