package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * Date: 2021-12-12
 * Time: 19:42
 * https://www.acmicpc.net/problem/17413
 */
public class Stack17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        if(s.lastIndexOf('>') != s.length() - 1) {
            s += " ";
        }
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        boolean flag = false;

        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (c == '<') {
                flag = true;
                if (!stack.isEmpty()) {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                }
                sb.append(c);
                continue;
            }
            if (flag) {
                if (c == '>') {
                    flag = false;
                    sb.append(c);
                    continue;
                }
                sb.append(c);
                continue;
            }

            if(c == ' ') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
                continue;
            }
            stack.push(c);
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
