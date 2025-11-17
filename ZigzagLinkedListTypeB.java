public class ZigzagLinkedListTypeB {

    // Node definition
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Add at end
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Print list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Step 1: Find middle of the linked list
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // slow will be mid
    }

    // Step 2: Reverse the second half
    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; // new head
    }

    // Step 3: Zigzag merge
    public void zigzag() {
        // Find mid
        Node mid = findMid(head);

        Node secondHalf = mid.next;
        mid.next = null; // Split the list into 2 halves

        // Reverse 2nd half
        Node rev = reverse(secondHalf);

        // Merge both halves alternately
        Node left = head;
        Node right = rev;

        Node nextL, nextR;
        while (left != null && right != null) {
            nextL = left.next;
            nextR = right.next;

            left.next = right;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    // Main method
    public static void main(String[] args) {
        ZigzagLinkedListTypeB list = new ZigzagLinkedListTypeB();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Original List:");
        list.printList();

        list.zigzag();

        System.out.println("Zigzag List (Type B):");
        list.printList();
    }
}
