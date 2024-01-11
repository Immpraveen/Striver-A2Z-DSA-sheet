public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {11,22,33,44,55,66,77,88,99};
        int key = 99;
        int pos = binarySearch(nums,0,nums.length-1,key);
         System.out.println("Key: "+ key+"\tPosition: "+pos);
        //System.out.println("Lower Bound : "+ lowerBound(nums, pos, pos, key));
    }

    private static int binarySearch(int[] nums,int low, int high, int key) {
        while(low<=high){
            int mid = (high-low+1) / 2;
            if(nums[mid]==key){
                return mid+1;
            }
            else if(nums[mid]<key){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
    // private static int lowerBound(int[] nums, int low, int high, int key){
    //     int mid = (low + high) / 2;;
    //     while(low<high){
    //          mid = (low + high) / 2;
    //         if(nums[mid]==key){
    //             return mid+1;
    //         }
    //         else if(nums[mid]<key){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }
    //     return mid;
    // }
}
