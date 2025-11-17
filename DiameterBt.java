public class DiameterBt {
  
  public static class Node{
    int data;
    Node left;
    Node right;
     Node(int data){
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }
  static class BTree{
    static int idx =-1;
    public static Node buildTree(int nodes[]){
      idx++;
      if(nodes[idx]==-1) return null;
      Node newNode = new Node(nodes[idx]);
      newNode.left = buildTree(nodes);
      newNode.right = buildTree(nodes);
      return newNode;
    }
  }

  // Better approach - calculate height and diameter together
public static class TreeInfo {
    int height;
    int diameter;
    
    TreeInfo(int height, int diameter) {
        this.height = height;
        this.diameter = diameter;
    }
      @Override
    public String toString() {
        return "TreeInfo {height = " + height + " , diameter = " + diameter + "}";
    }
}

public static TreeInfo diameterOptimized(Node root) {
    if(root == null) {
        return new TreeInfo(0, 0);
    }
    
    TreeInfo left = diameterOptimized(root.left);
    TreeInfo right = diameterOptimized(root.right);
    
    int myHeight = Math.max(left.height, right.height) + 1;
    
    int diam1 = left.diameter;
    int diam2 = right.diameter;
    int diam3 = left.height + right.height + 1;
    
    int myDiam = Math.max(Math.max(diam1, diam2), diam3);
    
    return new TreeInfo(myHeight, myDiam);
}

// Usage:
// TreeInfo info = diameterOptimized(root);
// System.out.println("Diameter: " + info.diameter);

  public static void main(String[] args) {
    /* 
              1
             / \
            2   3
           / \ / \
          4  5 6  7
     */   
    
     Node root = new Node(1);
     root.left = new Node(2);
     root.right = new Node(3);
     root.left.left = new Node(4);
     root.left.right = new Node(5);
     root.right.left = new Node(6);
     root.right.right = new Node(7);
     System.out.println(diameterOptimized(root));
  }
}

