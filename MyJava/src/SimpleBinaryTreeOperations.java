class Node{
	
	int item;
	Node left,right;
	
	 public Node(int item)
	    {
	        this.item = item;
	        left = right = null;
	    }
}

class BinaryTree{
	Node root;
	
  BinaryTree()
  {
      root = null;
  }
}

public class SimpleBinaryTreeOperations {

	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		tree.root=new Node(1);
		tree.root.left=new Node(3);
		tree.root.right=new Node(2);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		tree.root.right.right=new Node(7);
		/*     
		             1
		            / \
		           3   2
		          /\    \
		         4 5     7 
		 */
			TraverseTree(tree.root);
			System.out.println("-------------------");
		System.out.println("TotalNodes="+TotalNodes(tree.root));
		System.out.println("LeafNodes="+LeafNodes(tree.root));
		System.out.println("InternalNodes="+InternalNodes(tree.root));
		System.out.println("FullNodes="+FullNodes(tree.root));
		System.out.println("HeightTree="+HeightTree(tree.root));
	}
	
	public static void TraverseTree(Node t)
	{
		if(t==null)return;
		System.out.println(t.item);
		TraverseTree(t.left);
		TraverseTree(t.right);
		
	}
	
	public static int TotalNodes(Node t)
	{
		if(t==null)return 0;
		return 1+TotalNodes(t.left)+TotalNodes(t.right);
	}
	
	public static int LeafNodes(Node t)
	{
		if(t==null)return 0;
		if(t.left==null && t.right==null)
			return 1;
		return LeafNodes(t.left)+LeafNodes(t.right);
				
	}
	
	public static int InternalNodes(Node t)
	{
		if(t==null)return 0;
		if(t.left==null && t.right==null)
			return 0;
		return 1+InternalNodes(t.left)+InternalNodes(t.right);
		
	}
	
	public static int FullNodes(Node t)
	{
		if(t==null)return 0;
		if(t.left==null && t.right==null)
			return 0;
		return FullNodes(t.left)+FullNodes(t.right)+check(t);
		
		
	}
	
	public static int HeightTree(Node t)
	{
		if(t==null)return 0;
		if(t.left==null && t.right==null)
			return 0;
		return 1+Math.max(HeightTree(t.left), HeightTree(t.right));
	}

	private static int check(Node t) {
		if(t.left!=null && t.right!=null)
		return 1;
		return 0;
	}
	

}
