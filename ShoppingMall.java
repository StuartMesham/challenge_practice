import java.util.Scanner;

/**
 * UVA 12680
 */
public class ShoppingMall {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt(), m = scanner.nextInt(); //n = places and m = connections
		
		Node[] nodes = new Node[n];
		Edge[] edges = new Edge[m * 2];
		
		for (int i = 0; i < n; i++) {
			int floor = scanner.nextInt();
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			
			nodes[i] = new Node(floor, x, y, i);
		}
		
		for (int i = 0; i < m * 2; i++) {
			int from = scanner.nextInt();
			int to = scanner.nextInt();
			
			String description = scanner.next();
			
			if (description.equals("walking")) {
				double distance = distance2d(nodes[from], nodes[to]);
				
				edges[i] = new Edge(nodes[from], nodes[to], distance);
				i++;
				edges[i] = new Edge(nodes[to], nodes[from], distance);
			} else if (description.equals("stairs")) {
				double distance = distance3d(nodes[from], nodes[to]);
				
				edges[i] = new Edge(nodes[from], nodes[to], distance);
				i++;
				edges[i] = new Edge(nodes[to], nodes[from], distance);
			} else if (description.equals("lift")) {
				edges[i] = new Edge(nodes[from], nodes[to], 1);
				i++;
				edges[i] = new Edge(nodes[to], nodes[from], 1);
			} else if (description.equals("escalator")) {
				double distance = distance3d(nodes[from], nodes[to]);
				
				edges[i] = new Edge(nodes[from], nodes[to], 1);
				i++;
				edges[i] = new Edge(nodes[to], nodes[from], 3*distance);
			} else {
				System.out.println("FAIL!");
			}
		}
		
		int q = scanner.nextInt(); //Queries
		
		for (int i = 0; i < q; i++) {
			
			//"Resets" the nodes so they don't have values from previous searches
			for (int j = 0; j < nodes.length; j++) {
				nodes[j].prepare();
			}
			
			Node startNode = nodes[scanner.nextInt()], destinationNode = nodes[scanner.nextInt()];
			
			Node currentNode = startNode;
			
			currentNode.distanceTo = 0;
			
			boolean uncheckedNodes = true;
			
			//Keeps getting stuck in an infinite loop, too lozay to make this more optimised.
			for(int i=0;i<edges.length*2;i++) {
				for (Edge edge : edges) {
					if (edge.from != currentNode || edge.to.checked) continue;
					
					if (currentNode.distanceTo + edge.distance < edge.to.distanceTo) {
						edge.to.distanceTo = currentNode.distanceTo + edge.distance;
						edge.to.from = currentNode;
					}
				}
				
				currentNode.checked = true;
				
				//Choose next node to "check"
				uncheckedNodes = false;
				for (Node node : nodes) {
					if (!node.checked) {
						if (!uncheckedNodes) { //First time we find a node we can go to
							currentNode = node;
							uncheckedNodes = true;
						}
						
						if (node.distanceTo < currentNode.distanceTo) {
							currentNode = node;
						}
					}
				}
			}
			
			//Print solution (follow trail of "from"s from destination node back to start node)
			currentNode = destinationNode;
			String path = currentNode.number + "";
			
			while (currentNode != startNode) {
				currentNode = currentNode.from;
				path = currentNode.number + " " + path;
			}
			
			System.out.println(path);
		}
	}
	
	private static double distance2d(Node node1, Node node2) {
		return Math.sqrt(Math.pow(node1.x - node2.x, 2) + Math.pow(node1.y - node2.y, 2));
	}
	
	private static double distance3d(Node node1, Node node2) {
		return Math.sqrt(Math.pow(node1.x - node2.x, 2) + Math.pow(node1.y - node2.y, 2) + Math.pow((node1.floor - node2.floor)*5, 2));
	}
	
	private static class Node {
		public int number;
		public double distanceTo;
		public Node from;
		public boolean checked;
		public int x;
		public int y;
		public int floor;
		
		public Node(int floor, int x, int y, int number) {
			this.x = x;
			this.y = y;
			this.floor = floor;
			this.number = number;
		}
		
		public void prepare() { //Resets the node (so we can dijkstra again)
			//Double.MAX_Value causes overflow errors sometimes
			distanceTo = 100000;
			checked = false;
		}
	}
	
	private static class Edge {
		public Node from;
		public Node to;
		public double distance;
		
		public Edge(Node from, Node to, double distance) {
			this.from = from;
			this.to = to;
			this.distance = distance;
		}
	}
}
