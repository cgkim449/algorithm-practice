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
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            String[] strings = new String[n-2];
            int i = 0;
            while (st.hasMoreTokens()) {
                strings[i++] = st.nextToken();
            }
            boolean find = false;
            for (int j = 0; j < strings.length; j++) {
                if(j == strings.length - 1) {
                    sb.append(strings[j]);
                    break;
                }
                if(strings[j].charAt(1) != strings[j+1].charAt(0)) {
                    sb.append(strings[j].charAt(0)).append(strings[j].charAt(1));
                    find = true;
                    continue;
                }
                sb.append(strings[j].charAt(0));
            }
            if(!find) {
                sb.append(sb.toString().charAt(sb.toString().length() - 1));
            }
            sb.append("\n");
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
