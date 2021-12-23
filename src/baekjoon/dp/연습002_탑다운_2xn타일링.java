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
public class 연습002_탑다운_2xn타일링 {
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

        sb.append(f(n));
        output();
    }
    public static int f(int n) {
        if(n<=2) {
            return n;
        } else {
            if(memo[n-1] == 0) {
                memo[n-1] = f(n-1);
            }
            if(memo[n-2] == 0) {
                memo[n-2] = f(n-2);
            }
            return (memo[n-1]+memo[n-2])%10007;
        }
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
