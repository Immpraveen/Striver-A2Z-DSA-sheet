import java.util.Scanner;

public class KnowBasicMaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a Number: ");
        int num = sc.nextInt();
        System.out.println("Number of digits: "+countDigits(num));
        System.out.println("The number is: " + (reverseNum(num)));
        System.out.println("Given number is a palindrome?\n"+ "Ans:"+palindrome(num));
        System.out.println(gcd(12,18));
        System.out.println("Given number is palindrome?\nAns: " + armstrong(num));
        divisor(num);
        System.out.println("Number is prime?\nAns: "+prime(num));
        sc.close();
    }

    private static int countDigits(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num / 10;
        }
        return count;
    }

    private static int reverseNum(int num) {
        int reverse = 0;
        while (num != 0) {
            int rem = num % 10;
            reverse = (reverse * 10) + rem;
            num = num / 10;
        }
        return reverse;
    }

    private static boolean palindrome(int num) {
        int temp = num;
        int reverse = 0;
        while (temp != 0) {
            int rem = temp % 10;
            reverse = (reverse * 10) + rem;
            temp = temp / 10;
        }
        if (reverse == num)
            return true;
        else
            return false;
    }

    private static int gcd(int a, int b) {
        int ans = 0;
        if (a > b) {
            ans = b;
            b = a;
        } else {
            ans = a;
        }
        while (ans != 1) {
            if (b % ans == 0 && a % ans == 0)
                return ans;
            else
                ans--;
        }
        return ans;
    }

    public static boolean armstrong(int num) {
        int count = 0;
        int temp = num;
        int armnum = 0;
        while (temp != 0) {
            count++;
            temp = temp / 10;
        }
        temp = num;
        while (temp != 0) {
            int rem = temp % 10;
            armnum += Math.pow(rem, count);
            temp = temp / 10;
        }
        return num == armnum;
    }

    private static void divisor(int num) {
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println(num);
    }

    private static boolean prime(int num){
        if(num==1)
        return false;
        for(int i=2;i<=num/2;i++){
            if(num%i==0)
            return false;
        }
        return true;
    }
}
