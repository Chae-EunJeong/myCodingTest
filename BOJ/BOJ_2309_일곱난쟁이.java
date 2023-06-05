package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 요구사항 : 일곱 난쟁이 키의 합은 100 이다. 아홉 난쟁이가 주어졌을 때 진짜 일곱 난쟁이를 구해라.
 * 입력 : 아홉개의 줄에 걸쳐 난쟁이들의 키가 주어짐
 * 출력 : 일곱 난쟁이의 키를 오름차순으로 출력
 * 제약 : 각 난쟁이의 키는 100을 넘지 않는 자연수
 *      아홉 난쟁이의 키는 모두 다름
 *      가능한 정답이 여러개일 때는 아무거나 출력
 */

public class BOJ_2309_일곱난쟁이 {

    static int[] nine;
    static int[] seven;
    static boolean print;   // 10% 틀렸습니다
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nine = new int[9];
        seven = new int[7];
        for (int i = 0; i < 9; i++) {
            nine[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nine);
        comb(0, 0);

    }

    private static void comb(int cnt, int start) {
        if (cnt == 7) {
            int sum = 0;
            for (int i = 0; i < 7; i++) {
                sum += seven[i];
            }
            if (sum == 100 && !print) {
                for (int i = 0; i < 7; i++) {
                    System.out.println(seven[i]);
                }
                print = true;
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            seven[cnt] = nine[i];
            comb(cnt + 1, i + 1);
        }
    }
}
