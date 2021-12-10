package programmers;

import java.util.Arrays;
import java.util.Stack;

/**
 * Date: 2021-12-10
 * Time: 10:24
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 */

public class StackQueue42584 {
    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = prices.length - 1, j = 0; i >= 0; i--, j++) {
            answer[j] = i; // answer[] = [4, 3, 2, 1, 0]
        }

        Stack<Integer> stack = new Stack<>(); // 스택에 prices[]의 index 를 push

        for (int i = 0; i < prices.length; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
            } else {
                if(prices[i] < prices[stack.peek()]) { // 현재 스택 맨 위에 있는 애보다 더 작은 애를 만나면 pop
                    while(!stack.isEmpty()) {
                        if(prices[i] >= prices[stack.peek()]) {
                            break;
                        }
                        int x = stack.pop();
                        answer[x] = i - x;
                    }
                }
                stack.push(i);
            }
        }
        return answer;
    }
}
