import java.util.Scanner;

public class RecursiveSum {
	private static int sumFromOneTo(int n) {
		if (n < 1)
			return 0;
		if (n == 1)
			return 1;
		
		return n + sumFromOneTo(n - 1);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(sumFromOneTo(scanner.nextInt()));
	}
}
