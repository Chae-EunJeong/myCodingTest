package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 요구사항 : 평탄화작업을 위해 상자를 옮기는 횟수에 제한이 있을 때, 제한된 횟수만큼 옮긴 후 최고점과 최저점의 차이를 반환해라
 *         평탄화 : 높은 곳의 상자를 낮은 곳에 옮기는 방식으로 최고점과 최저점의 간격을 줄이는 작업
 * 입력 : 총 10개의 테케, 각 테케의 첫째줄은 덤프 횟수, 다음줄은 각 상자의 높이값
 * 출력 : 테케의 최고점과 최저점의 높이 차
 * 제약 : 가로 길이는 100
 *      1 <= 상자의 높이 <= 100
 *      1 <= 덤프 횟수 <= 1000
 *      평탄화가 완료되어 더이상 덤프를 수행할 수 없을 때 그때의 최고점과 최저점의 차이 (0 또는 1)
 */
public class SWEA_1208_Flatten {

    static int maxIndex, minIndex;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int dump = Integer.parseInt(br.readLine());
            int[] boxes = new int[100];
            int answer = 100;
            maxIndex = minIndex = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                boxes[i] = Integer.parseInt(st.nextToken());
            }

            while(true) {

                findMinMax(boxes);
                answer = boxes[maxIndex] - boxes[minIndex];

                if (answer <= 1 || dump == 0) break;

                boxes[minIndex]++;
                boxes[maxIndex]--;
                dump--;

            }

            System.out.println("#" + t + "  " + answer);
        }
    }

    private static void findMinMax(int[] boxes) {
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] <= boxes[minIndex]) {
                minIndex = i;
            }
            if (boxes[i] >= boxes[maxIndex]) {
                maxIndex = i;
            }
        }
    }
}
