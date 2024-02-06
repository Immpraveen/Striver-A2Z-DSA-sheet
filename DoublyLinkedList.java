class DoublyNode {
    int val;
    DoublyNode prev;
    DoublyNode next;

    DoublyNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {
       
        // DoublyNode head = new DoublyNode(1);
        // DoublyNode mid = new DoublyNode(3);
        // head.next = mid;
        // mid.prev = head;
        // DoublyNode end = new DoublyNode(5);
        // mid.next = end;
        // end.prev = mid;
        
        // head = insert(head,0,0);
        // head = insert(head, 2,2);
        // head = insert(head, 4,4);
        // head = insert(head, 5,4);
        // head = insert(head,6,6);
        // iterate(head);

        int[] nums = {20, 10, 10};
        DoublyNode head = creatDoublyLL(nums);
        // head = delete(head,4);
        // head = delete(head, 30);
        head = deleteAllOccurrences(head, 10);
        iterate(head);
         
    }

    private static DoublyNode creatDoublyLL(int[] nums){
        if(nums.length == 0)
        return null;
        else {
            DoublyNode head = new DoublyNode(nums[0]);
            for(int i=1;i<nums.length;i++){
                insert(head,i,nums[i]);
            }
            return head;
        }
    }

    private static DoublyNode delete(DoublyNode head, int val){
        if(head==null){
            return null;
        }
        else if(head.val==val){
            head.next.prev = null;
            head = head.next;
        }
        else if(head!=null){
            DoublyNode iterator = head;
            DoublyNode prev = null;
            while(iterator.val!=val && iterator.next!=null){
                prev = iterator;
                iterator=iterator.next;
            }
            if(iterator.next==null){
                prev.next = null;
            }else{
                iterator.prev.next = iterator.next;
                iterator.next.prev = iterator.prev;
            }
            
        }
        return head;
    }

    // private static DoublyNode deleteAll(DoublyNode head, int k){
        
    //     if(head==null){
    //         return null;
    //     }
    //     else{
    //         DoublyNode curr = head;
    //         while(curr.val==k){
    //             curr = curr.next;
    //         }
    //         head = curr;
    //         while(curr.next!=null){
    //             if(curr.val == k){
    //                 head = delete(head, k);
    //             }
    //             curr = curr.next;
    //         }
    //     }
    //     return head;
    // }

    public static DoublyNode deleteAllOccurrences(DoublyNode head, int k){
        // Node prev = null;
        DoublyNode curr = head;
        // DoublyNode temp = null;

        while(curr!=null){
            if(curr.val == k && curr == head ){
                head = curr.next;
                curr = curr.next;
                if(curr.prev!=null)
                curr.prev = null;
            }
            else if(curr.next!=null && curr.val == k){
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                curr = curr.next;
            }
            else if(curr.val==k && curr.next==null){
                curr.prev.next = null;
                curr = curr.next;
            }
            else{
                curr=curr.next;
            }
        }
        return head;
    }       

    private static void iterate(DoublyNode head){
        DoublyNode iterator = head;
        while (iterator != null) {
            System.out.print(iterator.val+" ");
            iterator = iterator.next;
        }
    }

    private static DoublyNode insert(DoublyNode head,int pos,int val){
        DoublyNode add = new DoublyNode(val);
        if(pos==0){
           add.next = head;
           head = add;
        }
        else {
            int count = 0;
            DoublyNode iterator = head;
            DoublyNode temp = null;
            while(count!=pos && iterator!=null){
                count++;
                temp = iterator;
                iterator = iterator.next; 
            }
            if(iterator!=null){
            temp.next = add;
            iterator.prev = add;
            add.next = iterator;
            add.prev = temp;
            }
            else{
                temp.next = add;
                add.prev = temp;
            }    
        }
        return head;
    }   
}
