
public class TreeNode  {
	
	private int data;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int data) {
		this.data = data;
	}
	
	public int getData() {
		return this.data;
	}
	
	public TreeNode getLeft() {
		return this.left;
	}
	
	public TreeNode getRight() {
		return this.right;
	}
	
	public void insert(Integer key) {
		boolean hasRight = (this.right != null);
		boolean hasLeft = (this.left != null);
		
		boolean goLeft = Math.random() < 0.5;
		
		if (!hasRight && !hasLeft) {
			if (goLeft) {
				left = new TreeNode(key);
			} else {
				right = new TreeNode(key);
			}
			return;
		}
		
		if (hasRight && hasLeft) {
			if (goLeft) {
				this.left.insert(key);
			} else {
				this.right.insert(key);
			}
			return;
		}
		
		if (hasLeft && !hasRight)
		{
			boolean createNew = Math.random() < 0.5;
			if (createNew) {
				right = new TreeNode(key);
			} else {
				left.insert(key);
			}
			return;
		}
		
		if (!hasLeft && hasRight)
		{
			boolean createNew = Math.random() < 0.5;
			if (createNew) {
				left = new TreeNode(key);
			} else {
				right.insert(key);
			}
			return;
		}
	}
	
	public void printAncestors(TreeNode value) {
		if (this.data == value.getData()) {
			System.out.print("Key - ");
		}
		
		boolean hasRight = (this.right != null);
		boolean hasLeft = (this.left != null);
		
		if (hasRight && right.exists(value)) {
			right.printAncestors(value);
			System.out.print(this.data + " - ");
			return;
		}
		
		if (hasLeft && left.exists(value)) {
			left.printAncestors(value);
			System.out.print(this.data + " - " );
		}	
	}
	
	
	public TreeNode find(TreeNode value) {

		if (this.data == value.getData()) {
			return this;
		}
		
		if (value.getData() < this.data && left != null)
		return left.find(value);
		
		if (right != null) {
			return right.find(value);
		}
		
		return null;
	}
	
	public TreeNode find(int value) {
		
		if (this.data == value) {
			return this;
		}
		
		boolean leftExists = (left != null);
		boolean rightExists = (right != null);
			
		if (leftExists && !rightExists) {
			TreeNode nodeLeft = left.find(value);
			TreeNode nodeRight = right.find(value);
			
			return (nodeLeft == null) ? nodeRight : nodeLeft;
		}
		
		if (leftExists && !rightExists) {
			return left.find(value);
		}
		
		if (!leftExists && rightExists) {
			return right.find(value);
		}
		
		return null;
	}
	
	public String printAncestors(Integer value) {
		return (this.data == value) ? "" : this.toString(); 
	}
	
	public boolean exists(TreeNode node) {
		if (this.data == node.getData()) {
			return true;
		}
		
		boolean leftExists = (left != null);
		boolean rightExists = (right != null);
		
		if (leftExists && rightExists) {
			return (left.exists(node) || right.exists(node));
		}
		
		if (leftExists && !rightExists) {
			return left.exists(node);
		}
		
		if (!leftExists && rightExists) {
			return right.exists(node);
		}
		
		return false;
	}
	
	public boolean exists(int key) {
		if (this.data == key) {
			return true;
		}
		
		boolean leftExists = (left != null);
		boolean rightExists = (right != null);
		
		if (leftExists && rightExists) {
			return (left.exists(key) || right.exists(key));
		}
		
		if (leftExists && !rightExists) {
			return left.exists(key);
		}
		
		if (!leftExists && rightExists) {
			return right.exists(key);
		}
		
		return false;
	}
	
	public TreeNode lowestCommonAncestor(TreeNode node1, TreeNode node2) {
		if (this.data == node1.getData() || this.data == node2.getData()) {
			return this;
		}
		
		boolean existsInLeftSubtree = (left.exists(node1) || left.exists(node2));
		boolean existsInRightSubtree = (right.exists(node1) || right.exists(node2));
		
		if (existsInLeftSubtree && existsInRightSubtree) {
			return this;
		}
		
		if (existsInLeftSubtree) {
			return left.lowestCommonAncestor(node1, node2);
		} else  {
			return right.lowestCommonAncestor(node1, node2);
		}
	}
	
	@Override
	public String toString() {
		return String.valueOf(data);
	}
	
	public StringBuilder doToTree(StringBuilder prefix, boolean isTail, StringBuilder sb) {
	    if(right!=null) {
	        right.doToTree(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
	    }
	    sb.append(prefix).append(isTail ? "└── " : "┌── ").append(this.toString()).append("\n");
	    if(left!=null) {
	        left.doToTree(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
	    }
	    return sb;
	}

	public void printTree() {
	    System.out.println(doToTree(new StringBuilder(), true, new StringBuilder()).toString());
	}

}
