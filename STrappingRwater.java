import java.util.*;

public class STrappingRwater {
    public static int trapWater(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int water = 0;

        for (int i = 0; i < n; i++) {
            // FIX: use >= instead of >
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                int top = stack.pop();  // bottom of the trapped section

                if (stack.isEmpty()) break; // no left boundary
                
                int distance = i - stack.peek() - 1; // width between walls
                int boundedHeight = Math.min(arr[i], arr[stack.peek()]) - arr[top];
                
                water += distance * boundedHeight;
            }
            stack.push(i);
        }

        return water;
    }

    public static void main(String[] args) {
        int[] arr = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
        System.out.println("Total water trapped: " + trapWater(arr));
    }
}


 /* import java.util.*;

public class STrappingRwater {
    public static int trapWater(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int water = 0;

        for (int i = 0; i < n; i++) {
            // Pop only if strictly greater, not equal
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;

                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(arr[i], arr[stack.peek()]) - arr[top];

                // Only count if both sides can hold water (avoid edge overcount)
                if (boundedHeight > 0)
                    water += distance * boundedHeight;
            }

            // Avoid pushing equal height (right-most higher wall handled once)
            if (stack.isEmpty() || arr[i] != arr[stack.peek()])
                stack.push(i);
        }
        return water;
    }

    public static void main(String[] args) {
        int[] arr = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
        System.out.println("Total water trapped: " + trapWater(arr));
    }
}
 */