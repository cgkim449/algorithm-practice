package baekjoon;

import java.util.Scanner;

/**
 * Date: 2021-12-16
 * Time: 18:17
 * https://www.acmicpc.net/problem/2747
 */
public class DP2747 {
    public static int f(int n) {
        int[] cache = new int[n+1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i < n+1; i++) {
            cache[i] = cache[i-1]+cache[i-2];
        }

        return cache[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(f(n));
        sc.close();
    }
}
