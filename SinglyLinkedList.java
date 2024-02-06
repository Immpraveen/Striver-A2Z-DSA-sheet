import java.util.ArrayList;

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
       /*  
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

        */
        int[] num1 = {2,4,9};
        int[] num2 = {5,6,4,9};
        // int[] nums = {9,9,9};
        //Node head = createLL(nums);
        // traverse(head);
        // head = doubleIt(head);
        // traverse(head);
        Node head1 = createLL(num1);
        Node head2 = createLL(num2);

        traverse(addTwoNumbers(head1,head2));
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

    private static Node doubleIt(Node head){
        String s = "";
        Node iterator = head;
        while(iterator!=null){
            s += iterator.val;
            iterator = iterator.next;
        }  
        iterator = head;
        Long intialNumber = Long.parseLong(s);
        Long num = Long.parseLong(s) * 2;
        s = "";
        s += num;

        System.out.println(s);
        iterator = head;
        Node pre = null;

        if(intialNumber.toString().length()==num.toString().length()){
            for(int i = 0;i<s.length();i++){
            int val = Character.getNumericValue(s.charAt(i));
            iterator.val = val;
            iterator = iterator.next;
            if(iterator==null)
            break;
            }
            return head;
        }
        else{
            for(int i = 0;i<s.length();i++){
                int val = Character.getNumericValue(s.charAt(i));
                if(iterator==null){
                    Node temp = new Node(val,null);
                    pre.next = temp;
                    return head;
                }
                pre=iterator;
                iterator.val = val;
                iterator = iterator.next;
            }
        }
        return head;
    }    

    private static Node addTwoNumbers(Node l1, Node l2) {
        if(l1==null|| l2==null){
            if(l1==null){
                return l2;
            }
            else return l1;
        }
        else{
            String s = "";
            Node iterator1 = l1;
            Node iterator2 = l2; 
            long res = 0;
            while(iterator1!=null){
                s += iterator1.val;
                iterator1 = iterator1.next;
            }
            long val1 = Long.parseLong(s);
            s="";
            while(iterator2!=null){
                s += iterator2.val;
                iterator2 = iterator2.next;
            }
            long val2 = Long.parseLong(s);
            s="";
            res = val1 + val2;
            s += res;

            Node head = new Node(Integer.parseInt(s.substring(0,1)));
            Node iterator = head;

            for(int i=1;i<s.length();i++){
            Node temp = new Node(Integer.parseInt(s.substring(i,i+1)));
            iterator.next = temp;
            iterator=iterator.next;
            }
            Node curr = head;
            Node prev= null;
            Node tempNext = head;
            while(curr!=null){
                tempNext=tempNext.next;
                curr.next=prev;
                prev=curr;
                curr=tempNext;
            }
            return prev;
        }
    }
}
