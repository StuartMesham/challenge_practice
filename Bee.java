public class Bee {
	
	public static void main(String[] args) {
		int[] xValues = new int[100000];
		int[] yValues = new int[100000];
		
		int x = 0;
		int y = 0;
		
		int willi = 1;
		
		xValues[willi] = 0;
		yValues[willi] = 0;
		
		for (int i = 1; i < 23; i++) {
			
			//Down i
			for (int j = 0; j < i; j++) {
				y += 1;
				
				willi++;
				xValues[willi] = x;
				yValues[willi] = y;
			}
			
			//Diagonal down/left i - 1
			for (int j = 0; j < i - 1; j++) {
				y += 1;
				x -= 1;
				
				willi++;
				xValues[willi] = x;
				yValues[willi] = y;
			}
			
			//Left i
			for (int j = 0; j < i; j++) {
				x -= 1;
				
				willi++;
				xValues[willi] = x;
				yValues[willi] = y;
			}
			
			//Up i
			for (int j = 0; j < i; j++) {
				y -= 1;
				
				willi++;
				xValues[willi] = x;
				yValues[willi] = y;
			}
			
			//Diagonal up/right i
			for (int j = 0; j < i; j++) {
				x += 1;
				y -= 1;
				
				willi++;
				xValues[willi] = x;
				yValues[willi] = y;
			}
			
			//Diagonal right i
			for (int j = 0; j < i; j++) {
				x += 1;
				
				willi++;
				xValues[willi] = x;
				yValues[willi] = y;
			}
		}
	}
}