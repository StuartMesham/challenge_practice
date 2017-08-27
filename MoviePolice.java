import java.util.Scanner;

/**
 * UVA 12515
 */
public class MoviePolice {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int m = scanner.nextInt(), q = scanner.nextInt();
		scanner.nextLine();
		
		String[] movies = new String[m];
		String[] clips = new String[q];
		
		for (int i = 0; i < m; i++) {
			movies[i] = scanner.nextLine();
		}
		
		for (int i = 0; i < q; i++) {
			clips[i] = scanner.nextLine();
		}
		
		int bestMovie = -1;
		int bestScore = -1;
		
		for (int i = 0; i < movies.length; i++) {
			int currentScore = -1;
			
			for (int k = 0; k < clips.length; k++) {
				for (int j = 0; j < movies[i].length() - clips[k].length(); j++) {
					currentScore = max(currentScore, hemming(movies[i], clips[k], j));
				}
			}
			
			if (currentScore > bestScore) {
				bestScore = currentScore;
				bestMovie = i;
			}
		}
		
		System.out.println(bestMovie + 1);
	}
	
	private static int hemming(String movie, String clip, int start) { //Includes start
		int distance = 0;
		
		for (int i = 0; i < clip.length(); i++) {
			if (movie.charAt(start + i) == clip.charAt(i)) {
				distance++;
			}
		}
		
		return distance;
	}
	
	private static int max(int a, int b) {
		return a > b ? a : b;
	}
}
