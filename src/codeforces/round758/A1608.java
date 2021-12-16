package codeforces.round758;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Date: 2021-12-11
 * Time: 19:04
 */
public class A1608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        boolean[] eratos = new boolean[7919 + 1];
        eratos[0] = true;
        eratos[1] = true;

        for (int i = 2; i * i <= 7919; i++) {
            if (!eratos[i]) {
                for (int j = i + i; j <= 7919; j += i) {
                    eratos[j] = true;
                }
            }
        }

        while(n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if(x == 1) {
                sb.append(1).append("\n");
                continue;
            }
            for (int i = 0; x > 0; i++) {
                boolean e = eratos[i];
                if(!e) {
                    sb.append(i).append(" ");
                    x--;
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
