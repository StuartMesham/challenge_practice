//import java.util.Scanner;
//
//public class CellphoneTyping {
//
//
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//
//		while (scanner.hasNext()) {
//			int n = scanner.nextInt();
//
//			Node rootNode = new Node();
//			Node currentNode;
//
//			for (int i = 0; i < n; i++) {
//				char[] letters = scanner.next().toCharArray();
//
//				currentNode = rootNode;
//
//				for (int j = 0; j < letters.length; j++) {
//					if (currentNode.getChildNodeForLetter(letters[j]) == null) {
//						currentNode.addChildNodeForLetter(letters[j]);
//						System.out.println("Added a node");
//					}
//
//					currentNode = currentNode.getChildNodeForLetter(letters[j]);
//				}
//
//				currentNode.terminating = true;
//			}
//
//			System.out.println("Finding the average tree depth");
//			System.out.println(totalKeypresses(rootNode));
//		}
//
//
//
//
//
//
//
//
//		System.out.println("Enter words you want to search");
//
//		while (!(line = scanner.nextLine()).equals("-1")) { //Repeat until the input line is not "-1"
//			char[] letters = line.toCharArray();
//
//			Node currentNode = rootNode;
//
//			for (int i = 0; i < letters.length && currentNode != null; i++) {
//				currentNode = currentNode.getChildNodeForLetter(letters[i]);
//			}
//
//			if (currentNode != null && currentNode.terminating) {
//				System.out.println("It's in the tree");
//			} else {
//				System.out.println("It's not in the tree");
//			}
//		}
//	}
//
//	private static long totalKeypresses(Node node) {
//		int total = 0;
//
//		if (node.terminating) {
//			for (int i = 0; i < 26; i++) {
//				if (node.children[i] != null) {
//
//				}
//			}
//		}
//	}
//}
//
//class Node {
//	public boolean terminating;
//	public Node[] children;
//	public int childCount;
//
//	public Node() {
//		terminating = false;
//		children = new Node[26];
//		childCount = 0;
//	}
//
//	public Node getChildNodeForLetter(char c) {
//		return children[c - 'a'];
//	}
//
//	public void addChildNodeForLetter(char c) {
//		children[c - 'a'] = new Node();
//		childCount++;
//	}
//}