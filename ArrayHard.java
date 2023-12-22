import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ArrayHard {
    public static void main(String[] args) {

        /*
         * //Pascal Triangle
         * Scanner sc = new Scanner(System.in);
         * //int row = sc.nextInt();
         * //pascalTriangle(row);
         * // pascalTriangleNumberAndSeries(5, 5, 3);
         * // sc.close();
         */

        /*
         * //MajorityElement i.e more the n/3 times in an array
         * int[] nums = {11,33,33,11,33,11};
         * ArrayList<Integer> ans = majorityElement(nums);
         * for(Integer val: ans){
         * System.out.print(val+" ");
         * }
         */

        /*
         * // Triplets that sum to zero
         * int[] nums = { -1, 0, 1, 2, -1, -4 };
         * ArrayList<ArrayList<Integer>> ans = tripleSumZero(nums);
         * for (ArrayList<Integer> val : ans) {
         * System.out.println(val + " ");
         * }
         */
        
        /* 
        // Four sum to target
        int[] nums = { 4, 3, 3, 4, 4, 2, 1, 2, 1, 1 };
        ArrayList<ArrayList<Integer>> res = fourSum(nums, 9);
        for (ArrayList<Integer> val : res) {
            System.out.println(val);
        }
        */
       
        int[] nums = {9, -3, 3, -1, 6, -5};
        System.out.println(longestSubarrayWithSumZero(nums));
    }

    private static ArrayList<ArrayList<Integer>> tripleSumZero(int[] nums) {

        /*
         * //Bruteforce
         * Set<ArrayList<Integer>> res = new HashSet<>();
         * for(int i=0;i<nums.length;i++){
         * for(int j=i+1;j<nums.length;j++){
         * for(int k=j+1;k<nums.length;k++){
         * if(nums[i]+nums[j]+nums[k]==0 && i!=j && j!=k && k!=i){
         * ArrayList<Integer> triplets = new
         * ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
         * triplets.sort(null);
         * res.add(triplets);
         * }
         * }
         * }
         * }
         * ArrayList<ArrayList<Integer>> rest = new ArrayList<>(res);
         * return rest;
         */

        // Better solution
        Set<ArrayList<Integer>> res = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> hashset = new HashSet<>();
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (i != j) {
                    int number = -(nums[i] + nums[j]);

                    if (hashset.contains(number)) {
                        ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], number));
                        temp.sort(null);
                        res.add(temp);
                    }
                    hashset.add(nums[j]);
                }
            }
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(res);
        return ans;

    }

    private static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {

        /*
         * //Bruteforce
         * Set<ArrayList<Integer>> val = new HashSet<>();
         * 
         * for(int i=0;i<nums.length;i++){
         * for(int j=i+1;j<nums.length;j++){
         * for(int k=j+1;k<nums.length;k++){
         * for(int l=k+1;l<nums.length;l++){
         * if(i!=j && j!=k && k!=l && i!=k && nums[i]+nums[j]+nums[k]+nums[l]==target){
         * ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j],
         * nums[k], nums[l]));
         * temp.sort(null);
         * val.add(temp);
         * }
         * }
         * }
         * }
         * }
         * ArrayList<ArrayList<Integer>> res = new ArrayList<>(val);
         * return res;
         */

        /*
         * // Better solution
         * Set<ArrayList<Integer>> val = new HashSet<>();
         * for (int i = 0; i < nums.length; i++) {
         * for (int j = i + 1; j < nums.length; j++) {
         * Set<Long> hashset = new HashSet<>();
         * for (int k = j + 1; k < nums.length; k++) {
         * long sum = nums[i] + nums[j] + nums[k];
         * long forth = target - sum;
         * if (hashset.contains(forth)) {
         * ArrayList<Integer> temp = new ArrayList<>(
         * Arrays.asList(nums[i], nums[j], nums[k], (int) forth));
         * temp.sort(null);
         * val.add(temp);
         * }
         * hashset.add((long) nums[k]);
         * }
         * }
         * }
         * ArrayList<ArrayList<Integer>> ans = new ArrayList<>(val);
         * return ans;
         */

        // Optimal Solution
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    long sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        ans.add(temp);
                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;

                    } else if (sum < target)
                        k++;
                    else
                        l--;
                }
            }
        }
        return ans;
    }

    private static int longestSubarrayWithSumZero(int[] nums){
        /* 
        //Naive Approach
        int count = 0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            int sum=nums[i];
            count=1;
            for(int j=i+1;j<nums.length;j++){
                sum += nums[j];
                count++;
                if(sum==0)
                if(count>max)
                max = count;
            }   
        }
        return max;
        */

        
    }

    private static int factorial(int num) {
        int ans = 1;
        for (int i = num; i > 1; i--) {
            ans = ans * i;
        }
        return ans;
    }

    private static void pascalTriangle(int row) {
        int i, j;
        for (i = 0; i < row; i++) {
            for (j = 0; j <= i; j++) {
                System.out.print((factorial(i)) / (factorial(j) * factorial(i - j)) + " ");
            }
            System.out.println();
        }
    }

    private static void pascalTriangleNumberAndSeries(int iteration, int row, int col) {
        row -= 1;
        col -= 1;

        // For Specific number
        System.out.println(factorial(row) / (factorial(col) * factorial(row - col)));

        // For complete series
        for (int i = 0; i < iteration; i++)
            System.out.print(factorial(iteration - 1) / (factorial(i) * factorial((iteration - 1) - i)) + " ");
    }

    private static ArrayList<Integer> majorityElement(int[] nums) {
        int minlength = nums.length / 3;
        HashMap<Integer, Integer> map = new HashMap();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], count);
        }
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > minlength) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

}
