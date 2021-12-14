package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Date: 2021-12-08
 * Time: 10:23
 */
public class A263 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            int x = s.indexOf("1");
            if(x != -1) {
                System.out.println(Math.abs(2-i)+Math.abs((x-4)/2));
                return;
            }
        }

        br.close();
    }
}
