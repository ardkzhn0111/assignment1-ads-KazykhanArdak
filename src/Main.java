import java.util.Scanner;

public class Main {

    public static int sumSquares(int n) {
        if (n == 1) return 1;
        return n * n + sumSquares(n - 1);
    }

    public static int sumArray(int[] arr, int n) {
        if (n == 0) return 0;
        return arr[n - 1] + sumArray(arr, n - 1);
    }

    public static int sumN(int n) {
        if (n == 1) return 1;
        return n + sumN(n - 1);
    }

    public static int sumPowers(int b, int n) {
        if (n == 0) return 1;
        return (int)Math.pow(b, n) + sumPowers(b, n - 1);
    }

    public static void reverseNumbers(int n, Scanner sc) {
        if (n == 0) return;
        int x = sc.nextInt();
        reverseNumbers(n - 1, sc);
        System.out.print(x + " ");
    }

    public static void reverseStrings(int n, Scanner sc) {
        if (n == 0) return;
        String s = sc.next();
        reverseStrings(n - 1, sc);
        System.out.println(s);
    }

    public static void spiral(int[][] a, int top, int left, int bottom, int right, int num) {
        if (top > bottom || left > right) return;

        for (int i = left; i <= right; i++) a[top][i] = num++;
        for (int i = top + 1; i <= bottom; i++) a[i][right] = num++;
        if (top < bottom)
            for (int i = right - 1; i >= left; i--) a[bottom][i] = num++;
        if (left < right)
            for (int i = bottom - 1; i > top; i--) a[i][left] = num++;

        spiral(a, top + 1, left + 1, bottom - 1, right - 1, num);
    }

    public static void generate(int[] arr, int n, int k, int index) {
        if (index == n) {
            for (int x : arr) System.out.print(x + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= k; i++) {
            arr[index] = i;
            generate(arr, n, k, index + 1);
        }
    }

    public static void permute(char[] arr, int l, int r) {
        if (l == r) {
            System.out.println(new String(arr));
            return;
        }

        for (int i = l; i <= r; i++) {
            swap(arr, l, i);
            permute(arr, l + 1, r);
            swap(arr, l, i);
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n <= 0 || n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1
        System.out.println(sumSquares(4));

        // 2
        int[] arr = {1, 2, 3, 4};
        System.out.println(sumArray(arr, arr.length)); // 10

        // 3
        System.out.println(sumN(5)); // 15

        // 4
        System.out.println(sumPowers(4, 3)); // 85

        // 5
        int n = 3;
        reverseNumbers(n, new Scanner("1 2 3"));
        System.out.println();

        // 6
        reverseStrings(3, new Scanner("Abc bcdh abcdef"));

        // 7
        int size = 3;
        int[][] matrix = new int[size][size];
        spiral(matrix, 0, 0, size - 1, size - 1, 1);
        for (int[] row : matrix) {
            for (int x : row) System.out.print(x + " ");
            System.out.println();
        }

        // 8
        generate(new int[2], 2, 3, 0);

        // 9
        permute("ABC".toCharArray(), 0, 2);

        // 10
        for (int i = 0; i <= 32; i++) {
            if (isPowerOfTwo(i))
                System.out.println(i + " is a power of two");
            else
                System.out.println(i + " is not a power of two");
        }
    }
}