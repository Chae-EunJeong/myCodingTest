package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 요구사항 : 각 레벨을 클리어할 때 주는 점수를 증가하게 만들려면 주어진 각 점수를 몇번 감소시켜야하는지 구해라
 * 입력 : 레벨의 수 N / N개줄~각 레벨을 클리어하면 주는 점수
 * 출력 : 점수를 감소시켜야하는 횟수
 * 제약 : 1 <= N <= 100
 *      0 < 점수 < 20000
 * 풀이 : 그리디
 *      다음 요소보다 크거나 같으면, 이전 요소들이 다음 요소보다 작아질때까지 감소, 횟수 카운트
 *      4 3 3 5
 *      2 3 3 5
 *      1 2 3 5
 */
public class BOJ_2847_게임을만든동준이 {
    static int answer = 0;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                decreaseLevel(i + 1);
            }
        }


    }

    // arr 배열의 index보다 작아질 때까지 index-1 감소시키기
    private static void decreaseLevel(int index) {
        while (arr[index] <= arr[index - 1]) {
            arr[index - 1]--;
            answer++;
        }
    }
}
