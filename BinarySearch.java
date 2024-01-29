public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        int key = 1;
        // int pos = binarySearch(nums, 0, nums.length - 1, key);
        // System.out.println("Key: "+ key+"\tPosition: "+pos);
        // System.out.println("Lower Bound : " + lowerBound(nums, 0, nums.length - 1,
        // key));
        // System.out.println("Upper Bound : " + upperBound(nums, 0, nums.length - 1,
        // key));
        // System.out.println("Index position to insert " + key + " : " +
        // searchInsertPosition(nums, 0, nums.length - 1, key));
        // System.out.print("Ceiling and Floor of "+key+ ": ");
        // int[] res = floorAndCeil(nums,key);
        // for(int num:res){
        // System.out.print(num+" ");
        // }
        // System.out.println(key +" at position : "+positionOfRotation(nums,key));
        // System.out.println("Occurrences of "+key+" : "+countOccurrences(nums, key));
        // Print True/False based on presence of key element in a rotated sorted array
        // where duplicate element is present
        // System.out.println(positionOfRotationI(nums, key));
        // Min element in rotated sorted array
        // System.out.println("Min in rotated sorted array : " +
        // minInRotatedArray(nums));
        // Number of types the array is rotated
        // System.out.println("Number of times numes is rotated : " +
        // timesOfRotation(nums));
        // System.out.println(singleElement(nums));
        System.out.println(peakElement(nums));
    }

    private static int binarySearch(int[] nums, int low, int high, int key) {
        while (low <= high) {
            int mid = (high + low + 1) / 2;
            if (nums[mid] == key) {
                return mid + 1;
            } else if (nums[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int lowerBound(int[] nums, int low, int high, int key) {
        int ans = nums.length;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (nums[mid] >= key) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int upperBound(int[] nums, int low, int high, int key) {
        int ans = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > key) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int searchInsertPosition(int[] nums, int low, int high, int key) {
        int ans = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= key) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int[] floorAndCeil(int[] nums, int key) {
        int[] ans = { -1, -1 };

        /*
         * //Bruteforce Approach
         * for(int i=0;i<nums.length-1;i++){
         * if(nums[i]<key && nums[i+1]>key){
         * ans[0] = nums[i];
         * ans[1] = nums[i+1];
         * return ans;
         * }
         * else if(nums[i]==key){
         * ans[0] = nums[i];
         * ans[1] = nums[i];
         * return ans;
         * }
         * }
         * return ans;
         */

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= key) {
                ans[0] = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= key) {
                ans[1] = nums[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int positionOfRotation(int[] nums, int key) {

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[low] < nums[mid]) {
                if (nums[low] <= key && nums[mid] >= key) {
                    high = mid - 1;
                } else
                    low = mid + 1;
            } else {
                if (nums[mid] <= key && nums[high] >= key) {
                    low = mid + 1;
                } else
                    high = mid - 1;
            }
        }
        return -1;
    }

    private static int countOccurrences(int[] nums, int key) {
        int lower = -1, upper = -1;
        int low = 0, high = nums.length - 1;

        // Hint : Find upper bound and lower bound and calculate the difference between
        // both and add one

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == key) {
                lower = mid;
                high = mid - 1;
            } else if (nums[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(lower);
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == key) {
                upper = mid;
                low = mid + 1;
            } else if (nums[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(upper);
        return (upper - lower) + 1;
    }

    private static boolean positionOfRotationI(int[] nums, int key) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == key) {
                return true;
            }
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            } else if (nums[mid] > nums[low]) {
                if (nums[mid] >= key && nums[low] <= key) {
                    high = mid - 1;
                } else
                    low = mid + 1;
            } else {
                if (nums[mid] <= key && nums[high] >= key) {
                    low = mid + 1;
                } else
                    high = mid - 1;
            }
        }
        return false;
    }

    private static int minInRotatedArray(int[] nums) {
        int low = 0, high = nums.length - 1;
        int min_val = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[low] <= nums[mid]) {
                min_val = Math.min(min_val, nums[low]);
                low = mid + 1;
            } else {
                min_val = Math.min(min_val, nums[mid]);
                high = mid - 1;
            }
        }
        return min_val;
    }

    private static int timesOfRotation(int[] nums) {
        int min_index = -1;
        int low = 0, high = nums.length - 1;
        int min_val = Integer.MAX_VALUE;
        if (nums[low] <= nums[high]) {
            return 0;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[low] <= nums[mid]) {
                if (min_val >= nums[low]) {
                    min_val = Math.min(min_val, nums[low]);
                    min_index = low;
                }
                low = mid + 1;
            } else {
                if (min_val >= nums[mid]) {
                    min_val = Math.min(min_val, nums[mid]);
                    min_index = mid;
                }

                high = mid - 1;
            }
        }
        // System.out.println("Min-Index: " + min_index + "\t Min-value: " + min_val);
        return min_index;

    }

    private static int singleElement(int[] nums) {
        int low = 0, high = nums.length - 2;

        if (nums.length == 1) {
            return nums[0];
        } else if (nums[0] != nums[1]) {
            return nums[0];
        } else if (nums[nums.length - 2] != nums[nums.length - 1]) {
            return nums[nums.length - 1];
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if ((mid % 2 == 0 && nums[mid] == nums[mid + 1])
                    || (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int peakElement(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }
        else if(nums[0]>nums[1]){
            return 0;
        }
        if (nums[nums.length - 2] < nums[nums.length - 1]) {
            return nums.length - 1;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if ((mid % 2 == 0)
                    || (mid % 2 == 1)) {
                if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1])
                    return mid;
                else
                    low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
