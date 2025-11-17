import java.util.ArrayList;

public class MirrorBst {
  
  static class Node {
    int data;
    Node left; 
    Node right;

    Node(int data){
      this.data=data;
      this.left = this.right= null;
    }
  }
  public static Node mirrorImage(Node root){
    if(root == null){
      return null;
    }
    Node leftST = mirrorImage(root.left);
    Node rightST = mirrorImage(root.right);
    root.left=  rightST;
    root.right = leftST;

    return root;
  }

  public static Node createBst(ArrayList<Integer> arr ,int st, int end){
    if(st>end){
      return null;
    }
    int mid = st+(end-st)/2;
    Node root = new Node(arr.get(mid));
    root.left = createBst(arr, st, mid-1);
    root.right = createBst(arr, mid+1, end);
    return root;
  }

  public static void preOrder(Node root){
    if(root == null){
      return;
    }
    System.out.print(root.data+" ");
    preOrder(root.left);
    preOrder(root.right);
  }

 public static void inOrder(Node root , ArrayList<Integer> arr ){

  if(root == null){
    return;
  }
  inOrder(root.left ,arr);
  arr.add(root.data);
  inOrder(root.right,arr);
 }



  
  public static void main(String[] args) {

    // int arr[]={3,5,6,8,10,11,12};
    // Node root = new Node(8);
    // root.left = new Node(5);
    // root.right = new Node(10);
    // root.left.left = new Node(3);
    // root.left.right = new Node(6);
    // root.right.right = new Node(11);

    // Node root = createBst(arr, 0, arr.length-1);
    // preOrder(root);
    

    // Node root = new Node(8);
    // root.left = new Node(6);
    // root.left.left = new Node(5);
    // root.left.left.left = new Node(3);

    // root.right = new Node(10);
    // root.right.right = new Node(11);
    // root.right.right.right = new Node(12);

    // ArrayList<Integer> arr = new  ArrayList<>();
    // inOrder(root, arr);
    // Node newRoot = createBst(arr, 0, arr.size()-1);
    // preOrder(newRoot);

  }
}