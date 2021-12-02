package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Created by cgkim449
 * Date: 2021-12-01
 * Time: 19:05
 * https://www.acmicpc.net/problem/2935
 */
public class B2935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String x = br.readLine();
        String operator = br.readLine();
        String y = br.readLine();


        if(operator.equals("*")) {
            sb.append("1");
            sb.append("0".repeat(Math.max(0, x.length() + y.length() - 2)));
        } else {
            if(x.length() > y.length()) {
                sb.append(x.substring(0, x.length() - y.length())).append(y);
            } else if(x.length() < y.length()) {
                sb.append(y.substring(0, y.length() - x.length())).append(x);
            } else {
                sb.append("2");
                sb.append("0".repeat(Math.max(0, x.length() - 1)));
            }
        }

        bw.write(sb.toString());
        bw.close();
    }
}
