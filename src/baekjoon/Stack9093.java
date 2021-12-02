package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/9093
 */
public class Stack9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            char[] chars = (br.readLine() + " ").toCharArray();
            Stack<Character> stack = new Stack<>();

            for (char c : chars) {
                if (c == ' ') {
                    while (!stack.empty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                    continue;
                }
                stack.push(c);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
