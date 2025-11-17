import java.util.*;

class BinaryTreeBetter {
    
    // Node class
    public static class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    // Tree Builder (Better approach without static idx)
    public static Node buildTree(int[] nodes) {
        int[] index = {0}; // Using array to maintain reference
        return buildTreeHelper(nodes, index);
    }
    
    private static Node buildTreeHelper(int[] nodes, int[] index) {
        if (index[0] >= nodes.length || nodes[index[0]] == -1) {
            index[0]++;
            return null;
        }
        
        Node newNode = new Node(nodes[index[0]]);
        index[0]++;
        
        newNode.left = buildTreeHelper(nodes, index);
        newNode.right = buildTreeHelper(nodes, index);
        
        return newNode;
    }
    
    // Tree Traversals
    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    
    public static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    
    // Level Order Traversal (Better approach)
    public static void levelOrder(Node root) {
        if (root == null) return;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                System.out.print(current.data + " ");
                
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            System.out.println(); // New line after each level
        }
    }
    
    // Tree Properties
    public static int height(Node root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    
    public static int countNodes(Node root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    public static int sumOfNodes(Node root) {
        if (root == null) return 0;
        return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
    }
    
    // Optimized Diameter Approach
    public static class TreeInfo {
        int height;
        int diameter;
        
        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
    
    public static TreeInfo diameterOptimized(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        
        TreeInfo left = diameterOptimized(root.left);
        TreeInfo right = diameterOptimized(root.right);
        
        int currentHeight = Math.max(left.height, right.height) + 1;
        
        int diameterThroughRoot = left.height + right.height + 1;
        int maxDiameter = Math.max(Math.max(left.diameter, right.diameter), diameterThroughRoot);
        
        return new TreeInfo(currentHeight, maxDiameter);
    }
    
    // Main method with examples
    public static void main(String[] args) {
        // Example 1: Build tree from array
        System.out.println("=== Tree from Array ===");
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root1 = buildTree(nodes);
        
        System.out.print("PreOrder: ");
        preOrder(root1);
        System.out.println();
        
        System.out.print("InOrder: ");
        inOrder(root1);
        System.out.println();
        
        System.out.println("LevelOrder:");
        levelOrder(root1);
        
        // Example 2: Manual tree creation
        System.out.println("\n=== Manual Tree ===");
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);
        
        System.out.println("LevelOrder:");
        levelOrder(root2);
        
        // Tree Properties
        System.out.println("\n=== Tree Properties ===");
        System.out.println("Height: " + height(root2));
        System.out.println("Node Count: " + countNodes(root2));
        System.out.println("Sum of Nodes: " + sumOfNodes(root2));
        
        TreeInfo info = diameterOptimized(root2);
        System.out.println("Diameter: " + info.diameter);
    }
}



/* Key Improvements:
✅ Removed unnecessary BTree class

✅ Better buildTree without static variable issues

✅ Cleaner levelOrder without null markers

✅ Optimized diameter with O(n) complexity

✅ Better variable names and code organization

✅ Proper separation of helper methods

✅ Added examples for both tree creation methods

Code ab bilkul clean aur professional lag raha hai! 🚀 */