package programmers.practice;

import java.util.Stack;

public class Q4 {
    public static void main(String[] args) {

    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            answer[i] = prices.length - 1 - i;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                    int tmp = stack.pop();
                    answer[tmp] = i - tmp;
                }
                stack.push(i);
            }
        }

        return answer;
    }
}
