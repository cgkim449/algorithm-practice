package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * Date: 2021-12-20
 * Time: 10:33
 */
public class Stack1918_후위표기식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String p = "(" + br.readLine() + ")";  // (A+B*C-D/E)
        char[] charArray = p.toCharArray();

        Stack<String> stack = new Stack<>();
        Stack<String> tempStack = new Stack<>();

        for (char c : charArray) {
            // case 1: 문자인 경우
            if (c >= 'A') {

                // case 1-1: 스택에 아무 것도 경우 (이 case 는 맨처음밖엔 없음)
                if (stack.isEmpty()) {
                    stack.push("" + c);
                    continue;
                }

                String peek = stack.peek();

                // case 1-2: '(' 인 경우
                if (peek.equals("(")) {
                    stack.push("" + c);
                    continue;
                }
                // case 1-3: '+', '-' 인 경우
                if (peek.equals("+") || peek.equals("-")) {
                    stack.push("" + c);
                    continue;
                }
                // case 1-4: '*', '/' 인 경우
                if (peek.equals("*") || peek.equals("/")) {
                    String operator = stack.pop();
                    String x = stack.pop();

                    stack.push(x + c + operator);
                    continue;
                }
            }

            // case 2: ')'인 경우
            if (c == ')') {
                while (true) {
                    String temp = stack.pop();
                    if (temp.equals("(")) {
                        break;
                    }
                    tempStack.push(temp);
                }

                while (tempStack.size() != 1) {
                    String x = tempStack.pop();
                    String operator = tempStack.pop();
                    String y = tempStack.pop();

                    tempStack.push(x + y + operator);
                }

                // 결과
                String result = tempStack.pop();

                // case 2-1: 넣을려 그러는데 스택에 아무거도 없다
                if (stack.isEmpty()) {
                    stack.push(result);
                    continue;
                }

                // case 2-2: 넣을려 그러는데 peek 했더니 연산자가 * 또는 /이다
                // 그럼 또 연산한다
               String peek = stack.peek();

                if (peek.equals("*") || peek.equals("/")) {
                    String operator = stack.pop();
                    String x = stack.pop();

                    stack.push(x + result + operator);
                    continue;
                }

                stack.push(result);
                continue;
            }

            // case 3: '('인 경우
            if (c == '(') {
                stack.push("" + c);
                continue;
            }

            // case 4: 연산자인 경우
            if (c > ')') {
                stack.push("" + c);
                continue;
            }
        }

        bw.write(stack.pop());
        bw.close();
        br.close();
    }
}
/*
 * 연산결과를 다시 스택에 집어넣는다
 * *, / 를 만나면 바로 연산하고
 * +, - 를 만나면 그냥 push 하다가, 닫는 괄호를 만나면, 여는괄호를 만날때까지 pop하면서 동시에 임시스택에 push한다
 * 그럼 임시스택에 괄호안에 있는 수식이 통째로 들어감(예를 들면 A + B - C 이런식으로)
 * +, - 연산자는 우선순위가 없으므로 앞에서부터 차례대로 연산하고 (연산결과를 다시 임시 스택에 넣으면서)
 *
 * 닫는 괄호를 만나면 여는괄호를 만날때까지 pop해야되니까 스택을 사용햇음
 */