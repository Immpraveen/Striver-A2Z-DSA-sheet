import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
         * // Four sum to target
         * int[] nums = { 4, 3, 3, 4, 4, 2, 1, 2, 1, 1 };
         * ArrayList<ArrayList<Integer>> res = fourSum(nums, 9);
         * for (ArrayList<Integer> val : res) {
         * System.out.println(val);
         * }
         */

        /*
         * Longest Subarray with sum zero - count
         * int[] nums = {9, -3, 3, -1, 6, -5};
         * System.out.println(longestSubarrayWithSumZero(nums));
         */

        /*
         * //Overlapping Subarray Implementation
         * int[][] nums = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
         * List<List<Integer>> res = overlappingSubarray(nums);
         * for(List<Integer> item : res){
         * System.out.println(item);
         * }
         */

        /*
         * //MergeSorted Arrays
         * int[] num1 = {1, 4, 8, 10};
         * int[] num2 = {2, 3, 9};
         * 
         * mergeSortedArrays(num1, num2);
         * 
         * for(int i=0;i<num1.length;i++){
         * System.out.print(num1[i]+" ");
         * }
         * System.out.println();
         * for(int i=0;i<num2.length;i++){
         * System.out.print(num2[i]+" ");
         * }
         */

        /*
         * // Find duplicate and missing element from and array
         * int[] nums = {3,1,2,5,3};
         * int[] res = duplicateAndMissing(nums);
         * for (int i=0;i<res.length;i++) {
         * System.out.print(res[i]+" ");
         * }
         */
        /*
         * // Count Inversion where i<j and num[i]>num[j]
         * int[] nums = {5,3,2,4,1};
         * System.out.println(countInversions(nums));
         */

        /*
         * //Count reverse pairs where i<j and arr[i]>2*arr[j]
         * int[] nums = {1,3,2,3,1};
         * System.out.println(countReverse(nums));
         */

        // Max Product Subarray
        int[] nums = { 1, 2, -3, 0, -4, -5 };
        System.out.println(maxProductSubarray(nums));
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

    private static int longestSubarrayWithSumZero(int[] nums) {
        /*
         * //Naive Approach
         * int count = 0;
         * int max=0;
         * for(int i=0;i<nums.length;i++){
         * int sum=nums[i];
         * count=1;
         * for(int j=i+1;j<nums.length;j++){
         * sum += nums[j];
         * count++;
         * if(sum==0)
         * if(count>max)
         * max = count;
         * }
         * }
         * return max;
         */
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0)
                max = i + 1;
            else {
                if (map.get(sum) != null) {
                    max = Math.max(max, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return max;

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

    public static List<List<Integer>> overlappingSubarray(int[][] nums) {

        Arrays.sort(nums, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();
        /*
         * //Bruteforce Approach
         * for(int i=0;i<nums.length;i++){
         * int start = nums[i][0];
         * int end = nums[i][1];
         * 
         * if(!ans.isEmpty() && end<= ans.get(ans.size()-1).get(1)){
         * continue;
         * }
         * for(int j=i+1;j<nums.length;j++){
         * if(nums[j][0] <= end){
         * end = Math.max(end,nums[j][1]);
         * }else{
         * break;
         * }
         * }
         * ans.add(Arrays.asList(start,end));
         * }
         */

        for (int i = 0; i < nums.length; i++) {
            if (ans.isEmpty() || nums[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(nums[i][0], nums[i][1]));
            } else {
                ans.get(ans.size() - 1).set(1,
                        Math.max(ans.get(ans.size() - 1).get(1), nums[i][1]));
            }
        }
        return ans;
    }

    private static void mergeSortedArrays(int[] num1, int[] num2) {

        int iteration = Math.max(num1.length, num2.length);
        int num1Pointer = 0;
        int num2Pointer = 0;

        for (int i = 0; i < iteration; i++) {
            while (num1[num1Pointer] < num2[num2Pointer]) {
                if (num1Pointer == num1.length - 1) {
                    break;
                }
                num1Pointer++;
            }
            swap(num1, num2, num1Pointer, num2Pointer);

            Arrays.sort(num2);
        }
        swap(num1, num2, num1Pointer, num2Pointer);
    }

    private static void swap(int[] num1, int[] num2, int num1Pointer, int num2Pointer) {
        int temp = num1[num1Pointer];
        num1[num1Pointer] = num2[num2Pointer];
        num2[num2Pointer] = temp;
    }

    private static int[] duplicateAndMissing(int[] nums) {

        // Better Approach

        int count = 0;
        int missing = -1, duplicate = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], count);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (map.get(i) == 0) {
                missing = i;
            } else if (map.get(i) == 2) {
                duplicate = i;
            }

        }
        int[] ans = { missing, duplicate };
        return ans;

        // int n = nums.length; // size of the array
        // int repeating = -1, missing = -1;

        // //Find the repeating and missing number:
        // for (int i = 1; i <= n; i++) {
        // //Count the occurrences:
        // int cnt = 0;
        // for (int j = 0; j < n; j++) {
        // if (nums[j] == i) cnt++;
        // }

        // if (cnt == 2) repeating = i;
        // else if (cnt == 0) missing = i;

        // if (repeating != -1 && missing != -1)
        // break;
        // }
        // int[] ans = {repeating, missing};
        // return ans;
    }

    private static int countInversions(int[] nums) {

        // Bruteforce approach && For optimal solution use Merge sort logic
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i < j && nums[i] > nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int countReverse(int[] nums) {
        // Bruteforce Approach && use Merge Sort Algorithm for Optimal Approach
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > 2 * nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int maxProductSubarray(int[] nums) {
        int product = 1;

        /*
         * //Better Approach
         * for (int i = 0; i < nums.length - 1; i++) {
         * int mul = nums[i];
         * for (int j = i + 1; j < nums.length; j++) {
         * mul *= nums[j];
         * product = Math.max(mul, product);
         * }
         * 
         * }
         */
        // Optimal Approach
        int prefix = 1, suffix = 1;
        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;
            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length-i-1];
            product = Math.max(product,Math.max(prefix,suffix));
        }
        return product;
    }

}
