public class OptimalMiddleSubsequence {
    public static int optimalMiddleSum(int[] arr) {
        int n = arr.length;
        int ans = Integer.MAX_VALUE;
        boolean found = false;

        for (int j = 1; j < n - 1; j++) {
            int leftMin = Integer.MAX_VALUE;
            int rightMin = Integer.MAX_VALUE;

            // Find smallest arr[i] < arr[j] on the left
            for (int i = 0; i < j; i++) {
                if (arr[i] < arr[j]) {
                    leftMin = Math.min(leftMin, arr[i]);
                }
            }

            // Find smallest arr[k] < arr[j] on the right
            for (int k = j + 1; k < n; k++) {
                if (arr[k] < arr[j]) {
                    rightMin = Math.min(rightMin, arr[k]);
                }
            }

            // If valid triplet exists for this j
            if (leftMin != Integer.MAX_VALUE && rightMin != Integer.MAX_VALUE) {
                found = true;
                ans = Math.min(ans, leftMin + arr[j] + rightMin);
            }
        }

        return found ? ans : -1;
    } 

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2,3,1};
        System.out.println(optimalMiddleSum(arr)); // Output: 6
    }
}
