package baekjoon.dp;

import java.util.Scanner;

/**
 * Date: 2021-12-24
 * Time: 17:25
 */
public class B003_바텀업_쉬운계단수 {
    public static long mod = 1000000000L;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] d = new long[n+1][10];
        for (int i=1; i<=9; i++) {
            d[1][i] = 1;
        }
        for (int i=2; i<=n; i++) {
            for (int j=0; j<=9; j++) {
                d[i][j] = 0;
                if (j-1 >= 0) {
                    d[i][j] += d[i-1][j-1];
                }
                if (j+1 <= 9) {
                    d[i][j] += d[i-1][j+1];
                }
                d[i][j] %= mod;
            }
        }
        long ans = 0;
        for (int i=0; i<=9; i++) {
            ans += d[n][i];
        }
        ans %= mod;
        System.out.println(ans);
    }
}
/*
 * 1
 * 2
 * 3
 * 6
 * 10
 *
 * 9 17 32 61
 */