package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-17
 * Time: 17:46
 */
public class Math2581_소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        boolean[] eratos = new boolean[n + 1];
        eratos[0] = true;
        eratos[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!eratos[i]) {
                for (int j = i + i; j <= n; j += i) {
                    eratos[j] = true;
                }
            }
        }
        int min = 0;
        int sum = 0;
        boolean minmin = false;
        for (int i = m; i <= n; i++) {
            boolean eratoseratos = eratos[i];
            if(!eratoseratos) {
                if(!minmin) {
                    min = i;
                    minmin = true;
                }
                sum+=i;
            }
        }
        if(min == 0) {
            System.out.println(-1);
            return;
        }
        sb.append(sum).append("\n").append(min);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
