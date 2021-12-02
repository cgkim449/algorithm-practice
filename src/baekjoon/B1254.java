package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by cgkim449
 * Date: 20211202
 * Time: 18:35
 */
public class B1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = br.readLine();
        StringBuilder sb = new StringBuilder(s1);
        String s2 = sb.reverse().toString();

        int add = 0;

        for (int i = 0; i < s1.length(); i++) {
            if(s1.substring(i).equals(s2.substring(0, s2.length() - i))) {
                add = i;
                break;
            }
        }

        int answer = 0;

        if(add == 0) {
            if(s1.equals(s2)) {
                answer = s1.length();
            } else {
                answer = s1.length() * 2 - 1;
            }
        } else {
            answer = s1.length() + add;
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
