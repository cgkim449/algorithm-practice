package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11365
 */

public class B11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Stack<Character> stack = new Stack<>();

        while(true) {
            String s = br.readLine();

            if(s.equals("END")) {
                break;
            }

            char[] chars = s.toCharArray();

            for (char aChar : chars) {
                stack.push(aChar);
            }

            while(!stack.empty()) {
                sb.append(stack.pop());
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}
