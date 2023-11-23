class Patterns {
    public static void main(String args[]) {
        // pattern1();
        // pattern2();
        // pattern3();
        // pattern4();
        // pattern5();
        // pattern6();
        // pattern7();
        // pattern8();
        // pattern9();
        // pattern10();
        // pattern11();
        // pattern12();
        // pattern13();
        // pattern14();
        // pattern15();
        // pattern16();
        // pattern17();
        // pattern18();
        // pattern19();
        // pattern20();
        // pattern21();
        pattern22();
    }

    public static void pattern1() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void pattern2() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void pattern3() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println("");
        }
    }

    public static void pattern4() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(i);
            }
            System.out.println("");
        }
    }

    public static void pattern5() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void pattern6() {
        for (int i = 0; i < 5; i++) {
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(j);
            }
            System.out.println("");
        }
    }

    public static void pattern7() {
        for (int i = 0; i < 5; i++) {
            for (int space = 4; space >= i; space--) {
                System.out.print(" ");
            }

            for (int star = 1; star <= (i * 2) + 1; star++) {
                System.out.print("*");
            }

            System.out.println("");
        }
    }

    public static void pattern8() {
        for (int i = 0; i < 5; i++) {
            for (int space = 0; space < i + 1; space++) {
                System.out.print(" ");
            }
            for (int star = 9; star >= (i * 2) + 1; star--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void pattern9() {
        for (int i = 0; i < 5; i++) {
            for (int space = 4; space >= i; space--) {
                System.out.print(" ");
            }

            for (int star = 1; star <= (i * 2) + 1; star++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (int i = 0; i < 5; i++) {
            for (int space = 0; space < i + 1; space++) {
                System.out.print(" ");
            }
            for (int star = 9; star >= (i * 2) + 1; star--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void pattern10() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (int i = 1; i <= 4; i++) {
            for (int j = 4; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern11() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0)
                    System.out.print(1);
                else
                    System.out.print(0);
            }
            System.out.println("");
        }
    }

    public static void pattern12() {
        for (int i = 1; i <= 4; i++) {
            for (int num = 1; num <= i; num++) {
                System.out.print(num);
            }

            for (int space = 1; space <= 8 - (2 * i); space++) {
                System.out.print(" ");
            }
            for (int num = i; num >= 1; num--) {
                System.out.print(num);
            }
            System.out.println(" ");
        }
    }

    public static void pattern13() {
        int num = 1;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num++ + " ");
            }
            System.out.println();
        }
    }

    public static void pattern14() {
        for (int i = 0; i < 5; i++) {
            char ch = 'A';
            for (int j = 0; j <= i; j++) {
                System.out.print((char) (ch + j) + " ");
            }
            System.out.println("");
        }
    }

    public static void pattern15() {
        for (int i = 0; i < 5; ++i) {
            char ch = 'A';
            for (int j = 5; j > i; j--) {
                System.out.print((char) (ch++) + " ");
            }
            System.out.println("");
        }
    }

    public static void pattern16() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char) ('A' + i));
            }
            System.out.println("");
        }
    }

    public static void pattern17() {
        for (int i = 0; i < 5; i++) {
            for (int space = 4; space > i; space--) {
                System.out.print(" ");
            }
            int breakpoint = ((2 * i) + 1) / 2;
            char ch = 'A';
            for (int j = 1; j <= (2 * i) + 1; j++) {
                System.out.print(ch);
                if (j <= breakpoint)
                    ch++;
                else
                    ch--;
            }
            System.out.println("");
        }
    }

    public static void pattern18() {

        for (int i = 1; i <= 5; i++) {
            int start = i - 1;
            for (int j = i; j >= 1; j--) {
                System.out.print((char) ('E' - (start--)));
            }
            System.out.println("");
        }
    }

    public static void pattern19() {
        for (int i = 0; i < 5; i++) {
            for (int star = 4; star >= i; star--) {
                System.out.print("*");
            }

            for (int space = 1; space <= (i * 2) + 1; space++) {
                System.out.print(" ");
            }
            for (int star = 4; star >= i; star--) {
                System.out.print("*");
            }
            System.out.println("");
        }

        for (int i = 0; i < 5; i++) {
            for (int star = 0; star < i + 1; star++) {
                System.out.print("*");
            }
            for (int space = 9; space >= (i * 2) + 1; space--) {
                System.out.print(" ");
            }
            for (int star = 0; star < i + 1; star++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void pattern20() {
        for (int i = 1; i <= 5; i++) {
            for (int star = 0; star < i; star++) {
                System.out.print("*");
            }
            for (int space = 10 - (2 * i); space >= 1; space--) {
                System.out.print(" ");
            }
            for (int star = 0; star < i; star++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (int i = 1; i < 5; i++) {
            for (int star = 4; star >= i; star--) {
                System.out.print("*");
            }
            for (int space = 1; space <= (2 * i); space++) {
                System.out.print(" ");
            }
            for (int star = 4; star >= i; star--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void pattern21() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (i == 1 || j == 1 || j == 4 || i == 4)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public static void pattern22() {
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                if (i == 1 || i == 7 || j == 1 || j == 7)
                    System.out.print("4");
                else if (i == 2 || i == 6 || j == 2 || j == 6) {
                    System.out.print("3");
                } else if (i == 3 || i == 5 || j == 3 || j == 5) {
                    System.out.print("2");
                } else {
                    System.out.print("1");
                }
            }
            System.out.println();
        }
    }
}
