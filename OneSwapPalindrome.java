public class OneSwapPalindrome {

    static boolean canBecomePalindromeByOneSwap(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        // Step 1: Already palindrome → try all swaps
        if (isPalindrome(arr)) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    swap(arr, i, j);
                    if (isPalindrome(arr)) return true;
                    swap(arr, i, j); // undo
                }
            }
            return false; // no swap produces a palindrome
        }

        // Step 2: Not palindrome → find mismatches
        int left = 0, right = n - 1;
        int[] mismatch = new int[4]; // store at most 2 mismatches
        int mismatchCount = 0;

        while (left < right) {
            if (arr[left] != arr[right]) {
                mismatchCount++;
                if (mismatchCount == 1) {
                    mismatch[0] = left;
                    mismatch[1] = right;
                } else if (mismatchCount == 2) {
                    mismatch[2] = left;
                    mismatch[3] = right;
                } else {
                    return false; // >2 mismatches cannot fix with 1 swap
                }
            }
            left++;
            right--;
        }

        // Step 3: Exactly 1 mismatch → odd length special case
        if (mismatchCount == 1) {
            if (n % 2 == 1) {
                int l = mismatch[0], r = mismatch[1];
                int mid = n / 2;
                if (swapCheck(arr, l, mid)) return true;
                if (swapCheck(arr, r, mid)) return true;
            }
            return false;
        }

        // Step 4: Exactly 2 mismatches → try all 4 possible swaps
        if (mismatchCount == 2) {
            int l1 = mismatch[0], r1 = mismatch[1], l2 = mismatch[2], r2 = mismatch[3];
            if (swapCheck(arr, l1, l2)) return true;
            if (swapCheck(arr, l1, r2)) return true;
            if (swapCheck(arr, r1, l2)) return true;
            if (swapCheck(arr, r1, r2)) return true;
        }

        return false;
    }

    // Swap i and j, check palindrome, undo
    static boolean swapCheck(char[] arr, int i, int j) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr.length || i == j) return false;
        swap(arr, i, j);
        boolean res = isPalindrome(arr);
        swap(arr, i, j); // undo
        return res;
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static boolean isPalindrome(char[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] != arr[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] tests = {"abab", "abca", "aabb", "abcba", "abcd", "aaab", "aabba","abceddcba","aabbcdcaa","abcdefedcba"};
        for (String t : tests) {
            System.out.println(t + " → " + canBecomePalindromeByOneSwap(t));
        }
    }
}
