
public class BinarySearchTreeImplementationIterative {
	 class Node {
	        int key;
	        Node left, right;
	 
	        public Node(int item) {
	            key = item;
	            left = right = null;
	        }
	    }
	 
	    // Root of BST
	    Node root;
	 
	    // Constructor
	    public BinarySearchTreeImplementationIterative() {
	        root = null; 
	    }
	 
	    // This method mainly calls insertRec()
	    void insert(int key) {
	    	if(root==null)
	       root = insertRec(root, key);
	    	else
	    		insertRec(root, key);
	    }
	     
	    /* A recursive function to insert a new key in BST */
	    Node insertRec(Node root, int key) {
	 
	    	 
	    	while(root!=null) {
	    	 if (key < root.key) {
	    		 if(root.left==null) {
	    			 root.left=new Node(key);
	    			 return root;
	    		 }
		         root=root.left;
	    	 }   
	    	 else {
	    		 if(root.right==null) {
	    			 root.right=new Node(key);
	    			 return root;
	    		 }
	    		 root=root.right;
	    	 }
	    	}
	        /* If the tree is empty, return a new node */
	    	if (root == null) {
		           root = new Node(key);
		          }
	        return root;
	    }
	 
	    void searchElement(int key)
	    {
	    	Node temp=search(root, key);
	    	 if(temp!=null)
	    		 System.out.println(temp.key);
	    	 else
	    		 System.out.println("Key Not found");
	    }
	    public Node search(Node root, int key)
	    {
	    	if(root==null || root.key==key)
	    		return root;
	           
	            while(root !=null) {
		        if (root.key > key) {
		            root=root.left;
		            if(root!=null && root.key==key)
		            	return root;
		        }
		        else {
		        	root=root.right;
		        	if(root!=null && root.key==key)
		            	return root;
		             }
	            }
	        return root;
	    }
	   
	 
	    // A utility function to do inorder traversal of BST
	    void inOrder(Node root) {
	        if (root != null) {
	            inOrder(root.left);
	            System.out.println(root.key);
	            inOrder(root.right);
	        }
	    }
	 
	    // Driver Program to test above functions
	    public static void main(String[] args) {
	    	BinarySearchTreeImplementationIterative tree = new BinarySearchTreeImplementationIterative();
	 
	        /* Let us create following BST
	              50
	           /     \
	          30      70
	         /  \    /  \
	       20   40  60   80 */
	        tree.insert(50);
	        tree.insert(30);
	        tree.insert(20);
	        tree.insert(40);
	        tree.insert(70);
	        tree.insert(60);
	        tree.insert(80);
	 
	        // print inorder traversal of the BST
	        tree.inOrder(tree.root);
	        System.out.println("---------------------------");
	        //search element
	        tree.searchElement(20);
	    }
	}


