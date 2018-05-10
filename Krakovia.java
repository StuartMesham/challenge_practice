import java.math.BigInteger;
import java.util.Scanner;

public class Krakovia {
	public static void main(String[] args) {
		Scanner scanner = new Scanner((System.in));
		
		int billNumber = 0;
		
		int n, f;
		
		while ((n = scanner.nextInt()) != 0 | (f = scanner.nextInt()) != 0) {
			BigInteger total = BigInteger.ZERO;
			
			for (int i = 0; i < n; i++) {
				total = total.add(scanner.nextBigInteger());
			}
			
			System.out.println("Bill #" + billNumber + " costs " + total + ": each friend should pay " + total.divide(BigInteger.valueOf(f)) + "\n");
			billNumber++;
		}
	}
}
