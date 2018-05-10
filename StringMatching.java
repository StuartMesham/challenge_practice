import java.util.Scanner;

public class StringMatching {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		char[] p = scanner.nextLine().toCharArray();
		int[] b = kmpPreProcess(p);
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%3c", p[i]);
		}
		System.out.println();
		
		for (int i = 0; i < b.length; i++) {
			System.out.printf("%3d", b[i]);
		}
		System.out.println();
	}
	
	//Assumes length of p is greater than 0
	private static int[] kmpPreProcess(char[] p) {
		
		int[] b = new int[p.length + 1];
		b[0] = -1;
		
		int i = 0, j = -1;
		
		while (i < p.length) {
			while (j >= 0 && p[i] != p[j]) j = b[j];
			
			i++; j++;
			b[i] = j;
		}
		
		return b;
	}
}
