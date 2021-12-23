package baekjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-23
 * Time: 16:53
 * https://www.acmicpc.net/problem/9095
 */
public class A004_탑다운_1_2_3더하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] memo;
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            memo = new int[n+2];
            memo[0] = 1;
            memo[1] = 1;
            memo[2] = 2;
            sb.append(go(n)).append('\n');
        }
        output();
    }

    private static int go(int n){
        if (memo[n] == 0) {
            memo[n] = go(n - 3) + go(n - 2) + go(n - 1);
        }
        return memo[n];
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
