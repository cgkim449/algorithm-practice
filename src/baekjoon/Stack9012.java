package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by cgkim449
 * Date: 2021-12-03
 * Time: 10:39
 * https://www.acmicpc.net/problem/9012
 */
public class Stack9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        loop:
        while(n-- > 0) {
            stack.clear();
            char[] charArray = br.readLine().toCharArray();

            for (char c : charArray) {
                if (c == ')') {
                    try {
                        stack.pop();
                    } catch (EmptyStackException e) {
                        sb.append("NO").append("\n");
                        continue loop;
                    }
                } else {
                    stack.push(c);
                }
            }

            if(!stack.isEmpty()) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
