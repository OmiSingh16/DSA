import java.util.*;

// TreeNode Class Definition
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) { 
        this.val = val; 
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    // Optional: toString method for better printing
    @Override
    public String toString() {
        return String.valueOf(val);
    }
}

public class Solutionn {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        serialize(root, count, result);
        return result;
    }
    
    private String serialize(TreeNode node, Map<String, Integer> count, List<TreeNode> result) {
        if (node == null) return "#";
        String left = serialize(node.left, count, result);
        String right = serialize(node.right, count, result);
        String serial = node.val + "," + left + "," + right;
        if (count.getOrDefault(serial, 0) == 1) result.add(node);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        return serial;
    }
    
    // LOCAL TESTING KE LIYE MAIN METHOD
    public static void main(String[] args) {
        Solutionn sol = new Solutionn();
        
        // Test tree: [1,2,3,4,2,4,4]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        
        List<TreeNode> result = sol.findDuplicateSubtrees(root);
        System.out.println("Duplicate subtrees: " + result.size());
        
        // Print the values of duplicate subtree roots
        System.out.print("Duplicate subtree roots: ");
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }
}