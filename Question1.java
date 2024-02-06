class ListNode{
    ListNode next;
    int val;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

public class Question1 {
    private static int size(ListNode head){
        ListNode iterator = head;
        int count = 0;
        while(iterator!=null){
            count++;
            iterator = iterator.next;
        }
        return count;
    }
    private static ListNode createLL(int[] nums) {

        ListNode head = new ListNode(nums[0]);
        ListNode iterator = head;

        for (int i = 1; i < nums.length; i++) {
            ListNode add = new ListNode(nums[i]);
            iterator.next = add;
            iterator = iterator.next;
        }
        return head;
    }
    public static ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode iterator = head, prev = null;;
        while(iterator!=null){
            size++;
            prev = iterator;
            iterator = iterator.next;
        }
        prev.next = head;
        int iterations = size-k;
        iterator = head;
        int pos = 0;
        while(iterations!=pos){
            pos++;
            prev = iterator;
            iterator = iterator.next;
        }
        prev.next = null;
        return iterator;
    }

    public static void iterate(ListNode head){
        ListNode iterator = head;
        while(iterator!=null){
            System.out.print(iterator.val +" ");
            iterator = iterator.next;
        }
    }
    public static ListNode rotateRight1(ListNode head){
        ListNode iterator = head,prev = null;
        if(head==null){
            return null;
        }
        while(iterator.next!=null){
            prev = iterator;
            iterator = iterator.next;
        }
        iterator.next = head;
        head = iterator;
        prev.next= null;
        return head;
    }
    public static ListNode reachPos(ListNode head1, int pos){
        if(head1==null || head1.next == null){
            return head1;
        }
        ListNode iterator1 = head1;
        int curr = 0;
        while(curr!=pos && iterator1!=null){
            iterator1 = iterator1.next;
            curr++;
        }
        return iterator1;
    }
    public static double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        if(n<0){
            x = 1/x;
            n = -n;
        }
        double res=x;
        for(int i=1;i<Math.floor(n);i++){
            res *= x; 
        }
        if(n-Math.floor(n)>0){
            res += Math.pow(x,n-Math.floor(n));
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {5,6,7};
        ListNode listSize = createLL(nums);

        // System.out.println(size(listSize));
        // // iterate(rotateRight(listSize, 4));
        // for(int i=1;i<=4;i++){
        //   listSize = rotateRight1(listSize);
        // }
        // iterate(listSize);

        // System.out.println(reachPos(listSize,1).val);

        System.out.println(myPow(34.00515, -3));
    }

    
}
