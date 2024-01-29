class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }

    Node(int val, Node node) {
        this.val = val;
        this.next = node;
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        Node start = new Node(23);
        Node temp = new Node(24);
        Node end = new Node(25);
        start.next = temp;
        temp.next = end;

        // Insert in the last
        Node insert = new Node(26);
        insert_last(insert, start);

        // Insert in the begin
        Node insert_begin = new Node(22);
        start = insert_begin(insert_begin, start);

        // Deletion in LL
        start = delete(26, start);

        // Insert at a location
        start = insert(29, 4, start);

        // System.out.println(midElement(start));

        // reverse
        start = reverse(start);
        // Traverse all the elements in the LL
        traverse(start);

    }

    private static void traverse(Node iterator) {
        while (iterator != null) {
            System.out.print(iterator.val + "->");
            iterator = iterator.next;
        }
        System.out.println("null");
    }

    private static void insert_last(Node node, Node start) {
        Node iterator = start;
        while (iterator != null) {
            if (iterator.next == null) {
                iterator.next = node;
                break;
            }
            iterator = iterator.next;
        }
    }

    private static Node insert_begin(Node node, Node start) {
        node.next = start;
        return node;
    }

    private static Node delete(int num, Node start) {
        Node iterator = start;

        if (iterator.val == num) {
            return iterator.next;
        } else {
            while (iterator != null) {
                if (iterator.next.next == null && iterator.next.val == num) {
                    iterator.next = null;
                    return start;
                }
                if (iterator.next.val == num) {
                    iterator.next = iterator.next.next;
                    break;
                }
                iterator = iterator.next;
            }
            return start;
        }
    }

    private static Node insert(int num, int pos, Node start) {
        Node iterator = start;
        int count = 0;
        if (pos == count) {
            Node x = new Node(num);
            return insert_begin(x, start);
        } else {
            count = 1;
            while (count <= pos) {
                count++;
                iterator = iterator.next;
                Node x = new Node(num);
                if (count == pos) {
                    x.next = iterator.next;
                    iterator.next = x;
                    return start;
                } else if (iterator.next == null) {
                    iterator.next = x;
                    x.next = null;
                    return start;
                }
            }
        }
        return start;
    }

    private static int midElement(Node start) {
        if (start == null) {
            return -1;
        }
        Node slow = start, fast = start;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.val;
    }

    private static Node reverse(Node start) {
        Node prev = null;
        Node curr = start;
        Node temp = start;
        while (curr != null) {
            temp = temp.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        start = prev;
        return start;
    }

    /**
     * This method is used to create linked-list. This method
     * utilises Array to create a Linked list with present elements.
     * 
     * @param nums[] This is the first paramter to createLL method
     * @return This returns created linkedlist head.
     */
    private static Node createLL(int[] nums) {

        Node head = new Node(nums[0]);
        Node iterator = head;

        for (int i = 1; i < nums.length; i++) {
            Node add = new Node(nums[i]);
            iterator.next = add;
            iterator = iterator.next;
        }
        return head;
    }

}
