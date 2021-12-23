package baekjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-23
 * Time: 13:57
 * https://www.acmicpc.net/problem/1463
 */
public class 연습001_탑다운_1로만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] memo;

    public static void main(String[] args) throws IOException {
        /* f(1) = 0;
         * f(2) = 1;
         * f(3) = 1;
         * f(n) = Math.min(f(n/3), f(n/2), f(n-1)) + 1;
         * f(2) = Math.min(f(1), f(1)) + 1;
         * f(3) = Math.min(f(1), f(2)) + 1;
         */
        int n = Integer.parseInt(br.readLine());
        memo = new int[n +1];
        memo[1] = 0;
        sb.append(f(n));
        output();
    }

    private static int f(int n) {
        if(n == 1) {
            return 0;
        }
        if(n % 3 == 0 && n % 2 == 0) {
            if(memo[n /3] == 0)  memo[n /3] = f(n /3);
            if(memo[n /2] == 0)  memo[n /2] = f(n /2);
            if(memo[n -1] == 0)  memo[n -1] = f(n -1);

            return Math.min(Math.min(memo[n /3], memo[n /2]), memo[n -1]) +1;
        } else if(n % 3 == 0) {
            if(memo[n /3] == 0)  memo[n /3] = f(n /3);
            if(memo[n -1] == 0)  memo[n -1] = f(n -1);

            return Math.min(memo[n /3], memo[n -1]) +1;
        }  else if(n % 2 == 0) {
            if(memo[n /2] == 0)  memo[n /2] = f(n /2);
            if(memo[n -1] == 0)  memo[n -1] = f(n -1);

            return Math.min(memo[n /2], memo[n -1]) +1;
        }else {
            if(memo[n -1] == 0)  memo[n -1] = f(n -1);

            return memo[n -1] + 1;
        }
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
