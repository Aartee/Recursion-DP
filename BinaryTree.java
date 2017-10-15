// Java program to find height of tree
  
// A binary tree node
class Node 
{
    int data;
    Node left, right;
  
    Node(int item) 
    {
        data = item;
        left = right = null;
    }
}
  
class BinaryTree 
{
     Node root;
  
    /* Compute the "maxDepth" of a tree -- the number of 
       nodes along the longest path from the root node 
       down to the farthest leaf node.*/
    int maxHeight(Node node) 
    {
        if (node == null)
            return 0;
        return 1 + Math.max(maxHeight(node.left), maxHeight(node.right));
    }
      
    /* Driver program to test above functions */
    public static void main(String[] args) 
    {
        BinaryTree tree = new BinaryTree();
  
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
  
        System.out.println("Height of tree is : " + tree.maxHeight(tree.root));
    }
}