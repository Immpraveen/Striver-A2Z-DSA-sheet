import java.util.Scanner;

public class BasicRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        
        int num = sc.nextInt();
        // int[] arr = { 5, 4, 3, 2, 1 };
        // printNto1(num);
        // print1toN(num, 1);
        // System.out.println("Sum of first "+num+" is: "+sumOfN(num));
        // System.out.println("Factorial of number "+num+" is: "+factorial(num));

        // System.out.print("Array before: ");
        // print(arr);
        // System.out.print("\nArray After: ");
        // reverseArray(arr, 0, arr.length - 1);
        // print(arr);

        // System.out.print("Enter a String: ");
        // String s = sc.next();
        // char[] c = s.toCharArray();
        // System.out.print("Given String is a Palindrome?\nAns: "+palindrome(c, 0, c.length-1));

        System.out.print(fibonacci(num));

        sc.close();
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int printNto1(int num) {

        if (num != 1) {
            System.out.print(num + " ");
            num = num - 1;
            return printNto1(num);
        } else {
            System.out.println(num);
            return num;
        }
    }

    private static int print1toN(int num, int count) {
        if (count == num) {
            System.out.print(num);
            return count;
        }
        System.out.print(count + " ");
        count = count + 1;
        return print1toN(num, count);
    }

    private static int sumOfN(int n) {
        if (n == 1) {
            return 1;
        } else
            return (n + sumOfN(n - 1));
    }

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else
            return (n * factorial(n - 1));
    }

    private static void reverseArray(int[] arr, int start, int end) {

        /*
         * Iterative Method
         * for(int i=0;i<arr.length/2;i++){
         * temp=arr[i];
         * arr[i]=arr[arr.length-i-1];
         * arr[arr.length-i-1]=temp;
         * }
         */
        int temp = 0;
        if (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            reverseArray(arr, start + 1, end - 1);
        }
    }

    private static boolean palindrome(char[] s, int start, int end) {
        if (start < end) {
            if (s[start] != s[end]) {
                return false;
            }
            palindrome(s, start + 1, end - 1);
        }
        return true;
    }

    private static int fibonacci(int num){
        
        if(num<=1){
            return num;
        }
        return fibonacci(num-1)+fibonacci(num-2);
    }
}
