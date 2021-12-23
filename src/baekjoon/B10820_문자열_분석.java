package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Date: 2021-12-23
 * Time: 10:46
 * https://www.acmicpc.net/problem/10820
 */

public class B10820_문자열_분석 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
 
        String input = "";
 
        while ((input = br.readLine()) != null ) {
            int[] arr = new int[4];
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                    arr[0] += 1;
                }
                if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                    arr[1] += 1;
                }
                if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                    arr[2] += 1;
                }
                if (input.charAt(i) == ' ') {
                    arr[3] += 1;
                }
            }
 
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
 
    }
 
}