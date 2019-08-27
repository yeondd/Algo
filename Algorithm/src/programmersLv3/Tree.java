package programmersLv3;

class TreeNode {
	protected Node data;
	protected TreeNode left;
	protected TreeNode right;
	
	public TreeNode(Node data) {
		left = null;
		right = null;
		this.data = data;
	}

	public Node getData() {
		return data;
	}

}

class BinaryTree {
	private TreeNode root;

    public BinaryTree() {
           this.root = null;
    }

    public TreeNode makeBT(TreeNode bt1, Node data, TreeNode bt2){
    	TreeNode newNode = new TreeNode(data);
        newNode.left = bt1;
        newNode.right = bt2;

        return newNode;
    }
    
    public void preorder(TreeNode root) {
    	if(root != null) {
    		System.out.println(root.getData().getI() + ", " + root.getData().getJ());
    		preorder(root.left);
    		preorder(root.right);
    	}
    }

    public void inorder(TreeNode root){
        if(root != null){
        	inorder(root.left);
            System.out.println(root.getData().getI() + ", " + root.getData().getJ());
            inorder(root.right);
        }
    }

}

public class Tree {
    public static void main(String[] args) {
           BinaryTree bt = new BinaryTree();

           Node node = new Node(0, 0);
           node = new Node(0, 7);
           TreeNode n7 = bt.makeBT(null, node, null);
           
//           node.setI(6);
           node = new Node(0, 6);
           TreeNode n6 = bt.makeBT(null, node, null);
           
//           node.setI(5);
           node = new Node(0, 5);
           TreeNode n5 = bt.makeBT(null, node, null);
           
//           node.setI(4);
           node = new Node(0, 4);
           TreeNode n4 = bt.makeBT(null, node, null);
           
//           node.setI(3);
           node = new Node(0, 3);
           TreeNode n3 = bt.makeBT(n6, node, n7);
           
//           node.setI(2);
           node = new Node(0, 2);
           TreeNode n2 = bt.makeBT(n4, node, n5);
           
//           node.setI(1);
           node = new Node(0, 1);
           TreeNode n1 = bt.makeBT(n2, node, n3);

           System.out.print("preorder : ");
           bt.preorder(n1);
           System.out.println();

           System.out.print("inorder : ");
           bt.inorder(n1);
           System.out.println();
    }
}