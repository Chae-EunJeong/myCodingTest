import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 요구사항 : M명의 주민이 N명의 국회의원 후보 중 뽑을 사람을 미리 알 수 있을 때, 기호1번이 돈으로 매수할 사람의 최솟값을 구해라
 * 입력 : 후보의 수 N / N개의 줄 ~ 번호순으로 각 후보를 찍으려고 하는 사람의 수
 * 제약 : 0 < N <= 50
 *       0 < 득표수 <= 100
 * 출력 : 기호 1번이 매수해야 하는 사람의 최솟값
 * 풀이 :
 *      1)전체 배열에서 최댓값 구하기
 *      2)기호1번이 아니면(i번이면) 기호1번에게 한 표 주기, 기호i번 득표수--, 기호1번 득표수++, answer++ - 다시 1번
 *      3)기호1번이면 answer 출력
 */
public class BOJ_1417_국회의원선거 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int answer = 0;

        for (int n = 0; n < N; n++) {
            int count = Integer.parseInt(br.readLine());
            arr[n] = count;
        }

        while (true) {
            int curMaxNum = findMax();
            if (curMaxNum == 0) {
                break;
            } else {
                arr[0]++;
                arr[curNum]--;
            }
            answer++;
        }
        System.out.println(answer);

    }
    static int curNum;
    private static int findMax() {
        curNum = 0;
        int maxCnt = 0;
        for (int i = 1; i < N; i++) {
            if (maxCnt <= arr[i]) {
                maxCnt = arr[i];
                curNum = i;
            }
        }
        if (arr[0] > arr[curNum]) {
            return 0;
        }

        return curNum;
    }

}
