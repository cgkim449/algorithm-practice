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
public class A001_탑다운_1로만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] memo;

    public static void main(String[] args) throws IOException {
        /* go(1) = 0;
         * go(2) = 1;
         * go(3) = 1;
         * go(n) = Math.min(go(n/3), go(n/2), go(n-1)) + 1;
         * go(2) = Math.min(go(1), go(1)) + 1;
         * go(3) = Math.min(go(1), go(2)) + 1;
         */
        int n = Integer.parseInt(br.readLine());
        memo = new int[n +1];
        memo[1] = 0;
        sb.append(go(n));
        output();
    }

    private static int go(int n) {
        if(n == 1) {
            return 0;
        }
        if(memo[n] != 0) {
            return memo[n];
        }
        memo[n] = go(n-1) + 1;
        if(n % 2 == 0) {
            int temp = go(n/2)+1;
            if(memo[n]>temp) memo[n] = temp;
        }
        if(n%3==0){
            int temp = go(n/3)+1;
            if(memo[n]>temp)memo[n]=temp;
        }
        return memo[n];
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
