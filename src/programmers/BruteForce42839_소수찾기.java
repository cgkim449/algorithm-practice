package programmers;

import java.io.IOException;
import java.util.HashSet;

/**
 * Date: 2021-12-22
 * Time: 09:04
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 */
public class BruteForce42839_소수찾기 {
    public static void main(String[] args) throws IOException {
        String numbers1 = "17";
        String numbers2 = "011";

        System.out.println(solution(numbers2));
    }

    static int N, count; // 3,
    static int[] selected, counting; // {1, 2}
    static HashSet<Integer> resultsSet; // 00011  0000011
    static boolean[] eratos;

    private static void input(String numbers) throws IOException{
        N = numbers.length(); // 3
        eratos();

        selected = new int[N + 1]; // 0, [1, 2, .., M]
        counting = new int[9 + 1]; // {1, 2}
        for (int i = 0; i < N; i++) counting[Integer.parseInt(numbers.charAt(i)+"")]++;

        resultsSet = new HashSet<>();
    }

    private static void eratos(){
        eratos = new boolean[(int)Math.pow(10, N)]; // 0 ~ 999
        eratos[0] = true;
        eratos[1] = true;

        for (int i = 2; i * i < eratos.length; i++) {
            if (!eratos[i]) {
                for (int j = i + i; j < eratos.length; j += i) {
                    eratos[j] = true;
                }
            }
        }
    }

    public static int solution(String numbers) throws IOException { // 0 1 1 // 3
        input(numbers);

        for (int M = 1; M <= N; M++) { // 3P1 + 3P2 + 3P3
            recurrenceFunction(1, M); // 3PM
        }

        return count;
    }

    private static void recurrenceFunction(int k, int M) {
        if(k == M+1) { // 4 == 4
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= M; i++) sb.append(selected[i]); // 011
            int result = Integer.parseInt(sb.toString()); // 11

            if(!eratos[result] && !resultsSet.contains(result)) { // 11
                count++; //
                resultsSet.add(result); // {11}
            }
        } else {
            for (int candidate = 0; candidate <= 9; candidate++) { // {0~9,0~9,0~9}
                if(counting[candidate] == 0) { //0
                    continue;
                }
                selected[k] = candidate; // {0,1,1}
                counting[candidate]--; //
                recurrenceFunction(k+1, M); // 4
                selected[k] = 0;
                counting[candidate]++;
            }
        }
    }
}
