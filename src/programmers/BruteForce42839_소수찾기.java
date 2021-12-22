package programmers;

import java.util.HashSet;

/**
 * Date: 2021-12-22
 * Time: 09:04
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 */
public class BruteForce42839_소수찾기 {
    public static void main(String[] args) {
        String numbers1 = "17";
        String numbers2 = "011";

        System.out.println(solution(numbers2));
    }

    static int N, count;
    static int[] selected, counting;
    static HashSet<Integer> resultsSet; // 00011  0000011
    static boolean[] eratos;

    private static void input(String numbers) {
        N = numbers.length();
        eratos();

        selected = new int[N + 1];
        counting = new int[9 + 1]; // 0~9
        for (int i = 0; i < N; i++) counting[Integer.parseInt(numbers.charAt(i)+"")]++;

        resultsSet = new HashSet<>();
    }

    private static void eratos() {
        eratos = new boolean[(int)Math.pow(10, N)]; // 0 ~ 9,999
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

    public static int solution(String numbers) {
        input(numbers);

        for (int M = 1; M <= N; M++) {
            recurrenceFunction(1, M);
        }

        return count;
    }

    private static void recurrenceFunction(int k, int M) {
        if(k == M+1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= M; i++) sb.append(selected[i]);
            int result = Integer.parseInt(sb.toString());

            if(!eratos[result] && !resultsSet.contains(result)) {
                count++;
                resultsSet.add(result);
            }
        } else {
            for (int candidate = 0; candidate <= 9; candidate++) {
                if(counting[candidate] == 0) {
                    continue;
                }
                selected[k] = candidate;
                counting[candidate]--;
                recurrenceFunction(k+1, M);
                selected[k] = 0;
                counting[candidate]++;
            }
        }
    }
}
