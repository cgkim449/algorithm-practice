package baekjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-23
 * Time: 16:31
 * https://www.acmicpc.net/problem/11727
 */
public class A003_탑다운_2xn타일링2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] memo;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        memo = new int[n+2];
        memo[1]=1;
        memo[2]=3;

        sb.append(go(n));

        output();
    }
    private static int go(int n) {
        if (memo[n] == 0) {
            memo[n] = (go(n - 1) + 2 * go(n - 2)) % 10007;
        }
        return memo[n];
    }

    /*
     * go(1) = 1
     * go(2) = 2
     * go(3) = go(2) + 2*go(1)
     * go(4) = go(3) + 2*go(2)
     * go(5) = go(4) + 2*go(3)
     */

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
