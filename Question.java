public class Question {
    public static void main(String[] args) {
        int[] num = {3,0,9,0,0,0,1,12};
        int[] res = movingZeros(num);
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
        
    }
    private static int[] movingZeros(int[] nums){
        int j=0,k=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                j++;
            }
        }
        for(int i=nums.length-1;i>j-1;i--){
            nums[i]=0;
        }
        return nums;
    }
}
