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
public class A004_바텀업_1_2_3더하기 {
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
            for (int i = 3; i <= n; i++) {
                memo[i] = memo[i-1]+memo[i-2]+memo[i-3];
            }
            sb.append(memo[n]).append('\n');
        }
        output();
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
