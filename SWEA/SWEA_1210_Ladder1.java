package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요구사항 : 2차원배열의 사다리가 주어졌을 때, 지정된 도착점에 대응하는 출발점을 구해라
 * 입력 : 총 10개의 테케, 각 테케의 첫째줄은 테케 번호, 다음줄은 각 테스트케이스
 * 출력 : 도착하게 되는 출발점의 X좌표
 * 제약 : 한 막대에서 출발한 가로선이 다른 막대를 가로질러서 연속하여 이어지는 경우는 없음
 *      '0’으로 채워진 평면상에 사다리는 연속된 ‘1’로 표현된다. 도착 지점은 '2'로 표현
 *      
 */
public class SWEA_1210_Ladder1 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            int answer = -1;
            int[][] ladder = new int[100][100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 100; k++) {
                    ladder[i][k] = Integer.parseInt(st.nextToken());
                }
            }
            // 도착점부터 시작
            int desc = 0;
            for (int j = 0; j < 100; j++) {
                if (ladder[99][j] == 2) {
                    desc = j;
                    break;
                }
            }


            for (int i = 98; i >= 0; i--) {

                if (desc - 1 >= 0 && ladder[i][desc - 1] == 1) {    // 왼쪽에 1이 있으면
                    while(desc - 1 >= 0 && ladder[i][desc - 1] == 1) {
                        if(ladder[i][desc] == 0) {
                            desc++;
                            break;
                        }
                        desc--;
                    }
                } else if (desc + 1 < 100 && ladder[i][desc + 1] == 1) {    // 오른쪽에 1이 있으면
                    while (desc + 1 < 100 && ladder[i][desc + 1] == 1) {
                        if (ladder[i][desc] == 0) {
                            desc--;
                            break;
                        }
                        desc++;
                    }
                }
            }

            System.out.println("#" + tc + " " + desc);
        }
    }
}
