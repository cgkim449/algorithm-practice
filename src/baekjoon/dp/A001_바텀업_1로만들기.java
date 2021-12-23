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
public class A001_바텀업_1로만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] memo;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        memo = new int[n +1];
        memo[1] = 0;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i-1]+1;
            if(i%2==0){
                int temp = memo[i/2]+1;
                if(memo[i]>temp) memo[i]=temp;
            }
            if(i%3==0){
                int temp = memo[i/3]+1;
                if(memo[i]>temp) memo[i]=temp;
            }
        }
        sb.append(memo[n]);
        output();
    }


    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
