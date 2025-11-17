import java.util.*;

class BinaryTree{

  public static class Node{
    int data;
    Node left;
    Node right;

     Node (int data){
     this.data = data;
     this.left = null;
     this.right= null; 
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
  public static void preOrderT(Node root){
    if(root == null) return;
    //1st step is to print the root
    System.out.print(root.data+" ");
    // 2nd step to print leftsubtree 
    preOrderT(root.left);
    // 3rd step to print rightsubtree 
    preOrderT(root.right);
  }
  public static void inOrderT(Node root){
    if(root == null) return;
    inOrderT(root.left);
    System.out.print(root.data+" ");
    inOrderT(root.right);
  }

  public static void postOrderT(Node root){
    if(root == null) return;
    postOrderT(root.left);
    postOrderT(root.right);
    System.out.print(root.data+" ");
  }
  //Level Order Traversal...
  public static void levelOrderT(Node root){
    if(root == null) return;
    Queue<Node> q =new LinkedList<>();
    q.add(root);
    q.add(null);

    while(!q.isEmpty()){
      Node currNode = q.remove();
      if(currNode == null){
        System.out.println();
        if(q.isEmpty()){
          break;
        }else{
          q.add(null);
        }
      }else{
        System.out.print(currNode.data+" ");
        if(currNode.left != null){
          q.add(currNode.left);
        }
        if(currNode.right != null){
          q.add(currNode.right);
        }
      }
    }
  }
//  calc height of tree..
  public static int height (Node root){
    if(root == null){
      return 0;
    }
    int lh = height(root.left);
    int rh = height(root.right);
    return Math.max(lh ,rh)+1;
  }

  // calc count of nodes of a BT
  public static int count(Node root){
    if(root == null) return 0;
    int leftCount = count(root.left);
    int rightCount = count(root.right);
    return leftCount+rightCount+1;
  }
  // Sum of nodes of a BT
  public static int sum(Node root){
    if(root == null) return 0;
    int leftSum = sum(root.left);
    int rightSum = sum(root.right);
    return leftSum+rightSum+root.data;
  }

  // diameter of tree.
  public static int diameter(Node root){
    if(root == null) return 0;
    int ld = diameter(root.left);
    int lh = height(root.left);
    int rd = diameter(root.right);
    int rh = height(root.right);
    int selfdia = lh+rh+1;

    return Math.max(selfdia , Math.max(ld ,rd));
  }
   // Subtree present or not..
  public static boolean isIdentical(Node node , Node subRoot){
    if(node == null && subRoot == null){
      return true;
    }else if(node == null || subRoot == null || node.data != subRoot.data){
      return false;
    }
    if(!isIdentical(node.left, subRoot.left)) return false;
    if(!isIdentical(node.right, subRoot.right))return false;
    return true;
  }

  public static boolean isSubTree(Node root , Node subRoot){
    if(root == null) return false;
    if(root.data == subRoot.data){
      if(isIdentical(root ,subRoot)){
        return true;
      }
    }
    return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
  }

  //  Top view of a Binary Tree..
  static class Info{
    Node node;
    int hd;
    public Info(Node node , int hd){
      this.node = node;
      this.hd = hd;
    }
  }

  public static void topView(Node root){
    //Level order
    Queue<Info> qi = new LinkedList<>();
    HashMap<Integer , Node> map = new HashMap<>();

    int  min=0 , max=0;
    qi.add(new Info(root ,0));
    qi.add(null);

    while(!qi.isEmpty()){
      Info curr = qi.remove();
      if(curr == null){
        if(qi.isEmpty()) break;
        else qi.add(null);
      }else{
        if(!map.containsKey(curr.hd)){
        map.put(curr.hd, curr.node );
      }
      if(curr.node.left != null){
        qi.add(new Info(curr.node.left, curr.hd-1));
        min = Math.min(min , curr.hd-1);
      }
      if(curr.node.right != null){
        qi.add(new Info(curr.node.right, curr.hd+1));
        max = Math.max(max, curr.hd+1);
      }
      } 
    }
    for(int i=min ; i<=max ; i++){
      System.out.print(map.get(i).data+" ");
    }
    System.out.println();
  }
  //  Print Kth level nodes
  public static void kLevel(Node node , int level , int k){
    if(node == null) return;

    if(level == k){
      System.out.print(node.data+" ");
      return;
    }
    kLevel(node.left, level+1, k);
    kLevel(node.right, level+1, k);
  }

  public static int KAncestor(Node root, int n , int k){
    if(root==null){
      return -1;
    }
    if (root.data == n){
      return 0;
    }

    int leftDist = KAncestor(root.left, n, k);
    int rightDist = KAncestor(root.right, n, k);

    if(leftDist  == -1 && rightDist ==-1){
      return -1;
    }
    int max = Math.max(leftDist,rightDist);
    if(max+1 ==k){
      System.out.println(root.data);
    }

    return max+1;
  }

  public  static int TfSumTree(Node root){

    if(root == null){
      return 0;
    }
    int leftChild = TfSumTree(root.left);
    int rightChild = TfSumTree(root.right);
    int data = root.data;
    int newleft = root.left == null? 0: root.left.data;
    int newright = root.right == null? 0: root.right.data;
    root.data = newleft+leftChild + newright+rightChild;
    return data; 
  }



  public static void main(String[] args) {
    /* int nodes[]= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
    Node root = BTree.buildTree(nodes);
    BinaryTree.preOrderT(root); 
    System.out.println();
    BinaryTree.inOrderT(root);
    System.out.println();
    BinaryTree.postOrderT(root);
    System.out.println();
    BinaryTree.levelOrderT(root); */

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

         /*     
              2
             / \ 
            4   5 
        */ 
    //  Node subRoot = new Node(2);
    //  subRoot.left = new Node(4);
    //  subRoot.right = new Node(5);

    //  System.out.println("The height of the Binary Tree is : "+height(root)+" unit.");
    //  System.out.println("The count of nodes of Binary Tree is : "+count(root));
    //  System.out.println("The Sum of nodes of Binary Tree is : "+sum(root));

    // System.out.println("Diameter of BinaryTree is : "+diameter(root));
    // System.out.println(isSubTree(root, subRoot));
    // topView(root);

    // int k =3;
    // kLevel(root, 1, k);

    // int n=1, k=1;
    // KAncestor(root, n, k);

    TfSumTree(root);
    preOrderT(root);
  }
}