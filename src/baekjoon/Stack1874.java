package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * Created by cgkim449
 * Date: 2021-12-06
 * Time: 10:18
 * https://www.acmicpc.net/problem/1874
 */
public class Stack1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int i = 0; // 스택에 어떤 숫자까지 들어갔는지
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (!stack.isEmpty()) {
                int peek = stack.peek();
                if (peek > x) {
                    System.out.println("NO");
                    return;
                }
                if (peek == x) {
                    sb.append("-").append("\n");
                    stack.pop();
                    continue;
                }
                if (i > x) {
                    System.out.println("NO");
                    return;
                }
                if (i < x) {
                    do {
                        stack.push(++i);
                        sb.append("+").append("\n");
                    } while (i != x);
                    stack.pop();
                    sb.append("-").append("\n");
                }
            } else { // 스택이 비어있을때
                if (i >= x) {
                    System.out.println("NO");
                    return;
                }

                do {
                    stack.push(++i);
                    sb.append("+").append("\n");
                } while (i != x);
                stack.pop();
                sb.append("-").append("\n");
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
