package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-23
 * Time: 01:03
 * https://www.acmicpc.net/problem/11653
 */
public class Math11653_소인수분해 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] counting;
    static int N;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        counting = new int[N+1];
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    private static void solution() {
        factorization(N);

        for (int i = 1; i <= N; i++) {
            int count = counting[i];
            while(count-- > 0) {
                sb.append(i).append('\n');
            }
        }

    }
    private static void factorization(int N){
        for (int i = 2; i*i <= N; i++) {
            while (N % i == 0) {
                N /= i;
                counting[i]++;
            }
        }
        if(N!=1) {
            counting[N]++;
        }
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
