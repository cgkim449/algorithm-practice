package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Date: 2021-12-07
 * Time: 14:23
 * https://www.acmicpc.net/problem/1406
 */
public class Stack1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        char[] charArray = br.readLine().toCharArray();

        for (char c : charArray) {
            leftStack.push(c);
        }

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            String s = br.readLine();
            try {
                switch (s.charAt(0)) {
                    case 'P' : leftStack.push(s.charAt(2)); break;
                    case 'L' : rightStack.push(leftStack.pop()); break;
                    case 'D' : leftStack.push(rightStack.pop()); break;
                    case 'B' : leftStack.pop(); break;
                }
            } catch (EmptyStackException e) {

            }
        }

        StringBuilder sb = new StringBuilder();

        while(!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        while(!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
