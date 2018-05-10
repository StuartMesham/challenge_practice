import java.util.Arrays;
import java.util.Scanner;

public class IntervalCovering {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n; //Number of intervals
		double l; //l=length of field
		
		double start;
		double end;
		
		while (scanner.hasNextLine()) {
			n = scanner.nextInt();
			l = scanner.nextDouble();
			scanner.nextLine();
			
			Interval[] intervals = new Interval[n];
			
			for (int i = 0; i < n; i++) {
				start = scanner.nextDouble();
				end = scanner.nextDouble();
				scanner.nextLine();
				
				intervals[i] = new Interval(start, end);
			}
			
			//And awaaay we go!
			
			Arrays.sort(intervals);
			
			int count = 0;
			int currentIntervalNo = 0;
			double right = 0; //Furthest "covered" position to the right
			
			while (count != -1 && right < l) {
				
				double newRight = right;
				
				//Find the greatest interval.right of intervals with interval.left <= right
				while (currentIntervalNo < n && intervals[currentIntervalNo].left <= right) {
					if (intervals[currentIntervalNo].right > newRight) {
						newRight = intervals[currentIntervalNo].right;
					}
					currentIntervalNo++;
				}
				
				//currentInterval now contains the next "un-visited" interval
				
				//If we could not increase our "covered" area
				if (newRight == right) {
					count = -1;
				} else {
					right = newRight;
					count++;
				}
			}
			
			System.out.println(count);
		}
	}
	
	static class Interval implements Comparable<Interval> {
		public double left, right;
		
		public Interval(double a, double b) {
			this.left = a;
			this.right = b;
		}
		
		
		@Override
		public int compareTo(Interval interval) {
			return Double.compare(left, interval.left);
		}
	}
}
