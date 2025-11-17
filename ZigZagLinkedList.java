public class ZigZagLinkedList {

    // Node class (our own)
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of linked list
    Node head;

    // Add node at end
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

    // Zigzag function
    public void zigzag() {
        boolean flag = true; // true means '<' expected, false means '>'

        Node curr = head;
        while (curr != null && curr.next != null) {
            if (flag) {
                if (curr.data > curr.next.data) {
                    // swap
                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            } else {
                if (curr.data < curr.next.data) {
                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            }
            flag = !flag;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        ZigZagLinkedList list = new ZigZagLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Original List:");
        list.printList();

        list.zigzag();

        System.out.println("Zigzag List:");
        list.printList();
    }
}
