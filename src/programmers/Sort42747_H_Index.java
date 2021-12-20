package programmers;

/**
 * Date: 2021-12-20
 * Time: 12:26
 */
public class Sort42747_H_Index {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));

    }
    public static int solution(int[] citations) {
        int answer = 0;

        int[] counting = new int[10001];
        for (int citation : citations) {
            counting[citation]++;
        }
        int sum = 0;
        for (int i = counting.length-1; i >= 0; i--) {
            int x = counting[i];
            sum += x;
            if(sum >= i){
                answer=i;
                break;
            }
        }
        return answer;
    }
}
