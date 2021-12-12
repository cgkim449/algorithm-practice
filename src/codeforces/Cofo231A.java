package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by cgkim449
 * Date: 2021-12-04
 * Time: 23:34
 * https://codeforces.com/problemset/problem/231/A
 */
public class Cofo231A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int answer = 0;

        StringTokenizer st;

        while(n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int count = 0;
            while(st.hasMoreTokens()) {
                count += Integer.parseInt(st.nextToken());
            }
            if(count >= 2) {
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
