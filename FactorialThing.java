import java.math.BigInteger;

public class FactorialThing {
	public static void main(String[] args) {
		
		PrimeProduct.initialisePrimes();
		
		PrimeProduct a = new PrimeProduct();
		PrimeProduct b = new PrimeProduct();
		PrimeProduct c = new PrimeProduct();
		PrimeProduct d = new PrimeProduct();
		
		for (int m = 1; m < 35; m++) {
			a.setToFactorialOf(m);
			b.setToFactorialOf(65 - m);
			a.multiplyByAndModify(b);

			c.setToFactorialOf(m + 33);
			d.setToFactorialOf(32 - m);
			c.multiplyByAndModify(d);

			if (a.equals(c)) {
				System.out.println(m);
				break;
			}
		}
	}
}
class PrimeProduct {
	private static int[] primes = new int[100];
	private int[] exponents = new int[100];
	public int nExponents = 0;
	
	public static void initialisePrimes() {
		
		int n = 1;
		
		boolean prime = false;
		
		int sqrt;
		
		for (int i = 0; i < primes.length; i++) {
			while (!prime) {
				n++;
				prime = true;
				sqrt = (int)Math.sqrt(n);
				for (int j = 0; primes[j] <= sqrt && j < i; j++) {
					if (n % primes[j] == 0) {
						prime = false;
						break;
					}
				}
			}
			primes[i] = n;
			prime = false;
		}
	}
	
	public PrimeProduct() {};
	
	public void setToFactorialOf(int n) {
		int x;
		for (nExponents = 0; primes[nExponents] <= n; nExponents++) {
			x = n;
			exponents[nExponents] = 0;
			do {
				x /= primes[nExponents];
				exponents[nExponents] += x;
			} while (x > 1);
		}
		
		for (int i = nExponents; i < exponents.length; i++) {
			exponents[i] = 0;
		}
	}
	
	public void multiplyByAndModify(PrimeProduct primeProduct) {
		for (int i = 0; i < primeProduct.nExponents; i++) {
			exponents[i] += primeProduct.exponents[i];
		}
		
		if (primeProduct.nExponents > nExponents) {
			nExponents = primeProduct.nExponents;
		}
	}
	
	//DO NOT USE THIS METHOD, IT IS NOT FINISHED
	public void divideByAndModify(PrimeProduct primeProduct) {
		
		//TODO update nExponents
		
		for (int i = 0; i < primeProduct.nExponents; i++) {
			exponents[i] -= primeProduct.exponents[i];
		}
	}
	
	public boolean isDivisibleBy(PrimeProduct primeProduct) {
		if (primeProduct.nExponents > nExponents) return false;
		
		for (int i = 0; i < primeProduct.nExponents; i++) {
			if (exponents[i] < primeProduct.exponents[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean equals (PrimeProduct primeProduct) {
		if (primeProduct.nExponents != nExponents) return false;
		
		for (int i = 0; i < primeProduct.nExponents; i++) {
			if (exponents[i] != primeProduct.exponents[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public String toString() {
		String s = "";
		BigInteger product = BigInteger.ONE;
		for (int i = 0; i < nExponents; i++) {
			s += primes[i] + "^" + exponents[i] + " * ";
			product = product.multiply(BigInteger.valueOf(primes[i]).pow(exponents[i]));
		}
		
		return s.substring(0, Math.max(0, s.length() - 3)) + " = " + product;
	}
}