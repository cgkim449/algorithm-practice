package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Date: 2021-12-17
 * Time: 23:37
 */
public class B1003_피보나치함수 {
    public static void main(String[] args) throws IOException {
        int[][] cache = new int[40+1][40+1];
        cache[0][0] = 1;
        cache[0][1] = 0;
        cache[1][0] = 0;
        cache[1][1] = 1;

        for (int i = 2; i < 41; i++) {
            cache[i][0] = cache[i-1][0] + cache[i-2][0];
            cache[i][1] = cache[i-1][1] + cache[i-2][1];
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            sb.append(cache[x][0]).append(" ").append(cache[x][1]).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

}
