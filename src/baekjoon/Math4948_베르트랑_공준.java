package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-17
 * Time: 21:29
 * https://www.acmicpc.net/problem/4948
 */
public class Math4948_베르트랑_공준 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        boolean[] eratos = new boolean[123456*2 + 1];
        eratos[0] = true;
        eratos[1] = true;

        for (int i = 2; i * i <= 123456*2; i++) {
            if (!eratos[i]) {
                for (int j = i + i; j <= 123456*2; j += i) {
                    eratos[j] = true;
                }
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if(n==0)break;
            int count = 0;
            for (int i = n+1; i <= 2*n; i++) {
                boolean e = eratos[i];
                if(!e) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
