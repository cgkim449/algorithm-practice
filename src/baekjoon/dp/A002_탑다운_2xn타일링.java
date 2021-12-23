package baekjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-23
 * Time: 15:37
 * https://www.acmicpc.net/problem/11726
 */
public class A002_탑다운_2xn타일링 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] memo;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        memo = new int[n+2];
        memo[1] = 1;
        memo[2] = 2;

        sb.append(go(n));
        output();
    }
    public static int go(int n) {
        if (memo[n] == 0) {
            memo[n] = (go(n - 1) + go(n - 2)) % 10007;
        }
        return memo[n];
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
