import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//UVA 00872

public class TaskOrdering {
	
	static Node[] nodes;
	static Edge[] edges;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		scanner.nextLine();
		scanner.nextLine();
		
		String s = scanner.nextLine();
		String[] parts = s.split(" ");
		
		nodes = new Node[parts.length];
		
		for (int i = 0; i < parts.length; i++) {
			nodes[i] = new Node(parts[i].charAt(0));
		}
		
		s = scanner.nextLine();
		parts = s.split(" ");
		
		edges = new Edge[parts.length];
		
		for (int i = 0; i < edges.length; i++) {
			edges[i] = new Edge(nodeWithLetter(parts[i].charAt(0)), nodeWithLetter(parts[i].charAt(2)));
		}
		
		//Find top nodes
		ArrayList<Node> topNodes = new ArrayList<>();
		for (int i = 0; i < nodes.length; i++) {
			boolean top = true;
			for (int j = 0; j < edges.length; j++) {
				if (edges[i].to == nodes[i]) {
					top = false;
					break;
				}
			}
			
			if (top) {
				topNodes.add(nodes[i]);
			}
		}
		
		
	}
	
	private static void search(Stack<Integer> stack, ArrayList<Node> currentNodes) {
		
		//Search each option
		for (Node currentNode : currentNodes) {
			
			ArrayList<Node> childNodes = new ArrayList<>();
			
			boolean leaf = true;
			for (Edge edge : edges) {
				if (edge.from == currentNode && edge.from.visited) {
					leaf = false;
					childNodes.add(edge.to);
				}
			}
			
			currentNodes.remove(currentNode);
			currentNode.visited = true;
			currentNodes.addAll(childNodes);
			
			if (leaf) {
				//stack.push(currentNode);
			}
			
			//Recursive step
			
			currentNodes.add(currentNode);
			currentNode.visited = false;
			currentNodes.removeAll(childNodes);
			
			if (leaf) {
				stack.pop();
			}
		}
	}
	
	private static Node nodeWithLetter(char c) {
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].letter == c) {
				return nodes[i];
			}
		}
		
		return null;
	}
	
	private static class Node {
		public char letter;
		public boolean visited = false;
		
		public Node(char letter) {
			this.letter = letter;
		}
	}
	
	private static class Edge {
		public Node to;
		public Node from;
		
		public Edge(Node from, Node to) {
			this.from = from;
			this.to = to;
		}
	}
}