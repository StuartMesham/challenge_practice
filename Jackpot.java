import java.util.Scanner;

/**
 * UVA 10684
 */
public class Jackpot {
	private static int[][] streaks;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int length;
		while ((length = scanner.nextInt()) != 0) {
			
			int[] bets = new int[length];
			
			streaks = new int[length][length];
			
			for (int i = 0; i < length; i++) {
				bets[i] = scanner.nextInt();
			}
			
			int streak = maxStreak(bets, 0, bets.length);
			
			if (streak > 0) {
				System.out.println("The maximum winning streak is " + streak + ".");
			} else {
				System.out.println("Losing streak.");
			}
		}
	}
	
	private static int maxStreak(int[] bets, int start, int end) { //Include start, exclude end
		if (streaks[start][end - 1] != 0) {
			return streaks[start][end - 1];
		}
		
		int length = end - start;
		
		if (length == 1) {
			streaks[start][end - 1] = bets[start];
			return streaks[start][end - 1];
		}
		
		if (end == bets.length) {
			streaks[start][end - 1] = max(
					total(bets, start, end),             //as-is
					maxStreak(bets, start, end - 1) //shorten
			);
			
			return streaks[start][end - 1];
		}
		
		streaks[start][end - 1] = max(
				total(bets, start, end),                       //as-is
				maxStreak(bets, start, end-1),            //shorten
				maxStreak(bets, start + 1, end + 1) //move along one
		);
		
		return streaks[start][end - 1];
	}
	
	private static int max(int... ints) {
		int max = Integer.MIN_VALUE;
		
		for (int n : ints) {
			if (n > max) {
				max = n;
			}
		}
		
		return max;
	}
	
	private static int total(int[] bets, int start, int end) {
		int total = 0;
		for (int i = start; i < end; i++) {
			total += bets[i];
		}
		return total;
	}
}
