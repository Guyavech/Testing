
public class BinaryTree {

	
	private TreeNode root;
	
	public BinaryTree () {
		 this.root = null;
	}
	
	public BinaryTree (Integer value) {
		if (root == null) {
			root = new TreeNode(value);
		}
		root.insert(value);
	}
	
	public void printAncestors(TreeNode value) {
		if (this.root.getData() == value.getData()) {
			System.out.println("No ancestors! you're at the root!");
			return;
		}
		
		root.printAncestors(value);
		
	}
	
	public TreeNode getRoot() {
		return this.root;
	}
	
	public TreeNode find(Integer value) {
		if (root != null) {
			return root.find(value);
		}
		
		return null;
	}
	
	public boolean exists(Integer value) {
		if (root != null) {
			return root.exists(value);
		}
		
		return false;
	}
	
	public boolean exists(TreeNode value) {
		if (root != null) {
			return root.exists(value);
		}
		
		return false;
	}
	
	public void insert(Integer value) {
		if (root == null) {
			root = new TreeNode(value);
		} else {
			root.insert(value);
		}
	}
	
	public void printTree() {
		this.root.printTree();
	}
	
	
}

