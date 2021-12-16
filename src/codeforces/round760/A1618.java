package codeforces.round760;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-14
 * Time: 23:13
 */
public class A1618 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()); // x+z
            int e = Integer.parseInt(st.nextToken()); // y+z

            int t = Integer.parseInt(st.nextToken());

            int z = d - x;
            int y = t - x - z;
            sb.append(x).append(" ").append(y).append(" ").append(z).append(" ").append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static  int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a % b);
    }

    static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}
