import java.util.Random;

public class Ex2 {

	public static void main(String[] args) {
		check();
	}
	
	private static void check() {
		int[] numbers = {50,100,125,75,25,30,10,80,15,60,1,20,19,3,91,90,921,92,12,4,};
		shuffleArray(numbers);
		
		BinaryTree tree = new BinaryTree();
		for (int i = 0; i < numbers.length; i++) {
			tree.insert(numbers[i]);
			System.out.println("\nThis is the tree");
			tree.printTree();
			System.out.println();
		}
		
		printAncestors(tree, new TreeNode(12));
		
		TreeNode node1 = new TreeNode(92);
		TreeNode node2 = new TreeNode(60);
		
		System.out.println(lowestCommonAncestor(tree, node1, node2));
		
	}

	private static void shuffleArray(int[] array)
	{
	    int index, temp;
	    Random random = new Random();
	    for (int i = array.length - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        temp = array[index];
	        array[index] = array[i];
	        array[i] = temp;
	    }
	}
	
	public static void printAncestors(BinaryTree tree, TreeNode value) {
		if (tree == null || tree.getRoot() == null) {
			System.out.println("Tree is not initialized yet.");
			return;
		}
		
		if (value == null) {
			System.out.println("Node is not initialized yet.");
			return;
		}
		System.out.println();
		System.out.println("Ancestors list of key " + value + ":");
		tree.printAncestors(value);
		System.out.println("|");
		System.out.println();
		
		/*
		if (!tree.exists(value)) {
			System.out.println("No such item exists in the tree.");
			return;
		}
		
		TreeNode current = tree.getRoot();
		
		while (current.getData() != value.getData()) {
			if (current.getData() < value.getData()) {
				System.out.print(current.getData() + " ");
				current = current.getRight();
			} else {
				System.out.print(current.getData() + " ");
				current = current.getLeft();
			}
		}
		System.out.println(" ");
		*/
	}
	
	public static TreeNode lowestCommonAncestor(BinaryTree tree, TreeNode node1, TreeNode node2) {
		if (tree == null || node1 == null || node2 == null) {
			System.out.println("One of the parameters is not initialized correctly.");
			return null;
		}
		
		if (!tree.getRoot().exists(node1.getData()) || !tree.getRoot().exists(node2.getData())) {
			System.out.println("One of the items is not in the tree.");
			return null;
		}
		
		System.out.println("Lowest common ancestors of " + node1.toString() + " and " + node2.toString() +":");
		return tree.getRoot().lowestCommonAncestor(node1, node2);
	}
}
