import java.util.Scanner;

public class SumOfPrimes {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int MAX = scanner.nextInt() + 1;
		scanner.close();
		
		boolean prime[] = new boolean[MAX];
		
		for (int i = 2; i < MAX; i++) {
			prime[i] = true;
		}
		
		for (int i = 2; i < MAX; i++) {
			if (prime[i]) {
				for (int j = i * 2; j < MAX; j += i) {
					prime[j] = false;
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i < MAX; i++) {
			if (prime[i]) {
				sum += i;
			}
		}
		
		System.out.println(sum);
	}
}
