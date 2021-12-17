package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Date: 2021-12-17
 * Time: 11:50
 * https://www.acmicpc.net/problem/1935
 */
public class Stack1935_후위표기식2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] charArray = br.readLine().toCharArray();

        double[] numbers = new double[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for (int c : charArray) {
            if (c >= 'A') {
                stack.push(numbers[c - 'A']);
            } else {
                double y = stack.pop();
                double x = stack.pop();

                switch (c) {
                    case '*': stack.push(x * y); break;
                    case '+': stack.push(x + y); break;
                    case '-': stack.push(x - y); break;
                    case '/': stack.push(x / y); break;
                }
            }
        }

        System.out.printf("%.2f%n", stack.pop());
        br.close();
    }
}
