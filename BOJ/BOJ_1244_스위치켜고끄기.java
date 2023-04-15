package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요구사항 : 스위치에서 학생의 성별과 받은 수에 따라 차례로 조작한 후, 스위치의 마지막 상태를 출력해라
 *          - 남학생 : 스위치번호가 받은 수의 배수인 경우 그 스위치의 상태 바꾸기
 *          - 여학생 : 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서,
 *                   그 구간에 속한 스위치의 상태를 모두 바꾸기
 * 입력 : 스위치 개수/스위치 상태/학생 수/{성별, 학생이 받은 수}
 * 제약 : 0 < 스위치 개수 <= 100
 *      스위치 상태 : 켜져있음(1), 꺼져있음(0)
 *      0 < 학생 수 <= 100
 *      학생의 성별 : 남학생(1), 여학생(2)
 *      0 < 학생이 받은 수 <= 스위치 개수
 * 출력 : 스위치의 상태를 1번 스위치부터 마지막 스위치까지 한 줄에 20개씩
 */
public class BOJ_1244_스위치켜고끄기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] switchState = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            switchState[i] = Integer.parseInt(st.nextToken());
        }

        int studentNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int gen = Integer.parseInt(st.nextToken());
            int getNum = Integer.parseInt(st.nextToken());

            if (gen == 1) {
                int mult = getNum;
                while(getNum <= N) {
                    switchState[getNum] = switchState[getNum] == 1 ? 0 : 1;
                    getNum += mult;
                }
            } else {
                switchState[getNum] = switchState[getNum] == 1 ? 0 : 1;
                int temp = 1;
                while(getNum + temp <= N && getNum - temp > 0) {
                    if (switchState[getNum + temp] != switchState[getNum - temp]) break;
                    switchState[getNum + temp] = switchState[getNum + temp] == 1 ? 0 : 1;
                    switchState[getNum - temp] = switchState[getNum - temp] == 1 ? 0 : 1;
                    temp++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(switchState[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }

}
