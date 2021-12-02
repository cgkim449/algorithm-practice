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
 * Time: 18:48
 */
public class B2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String word = br.readLine();

        char[] chars = word.toCharArray();

        for (char c : chars) {
            if (c < 'a') {
                sb.append((char) (c + 32));
            } else {
                sb.append((char) (c - 32));
            }
        }

        bw.write(sb.toString());
        bw.close();
    }
}
