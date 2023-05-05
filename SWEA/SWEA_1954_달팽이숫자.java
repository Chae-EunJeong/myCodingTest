package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * 요구사항 : 달팽이가 1부터 N*N까지의 숫자가 시계방향으로 이루어질 때, N을 입력받아 N크기의 달팽이를 출력해라
 * 입력 : 첫째줄엔 테케 수, 그 아래로 각 테케, 각 테케는 달팽이의 크기 N이 주어짐
 * 출력 : N*N 크기의 달팽이
 * 제약 : 1 <= N <= 10
 *
 */
public class SWEA_1954_달팽이숫자 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] data = new int[N][N];
            int cnt = 1;
            int x = 0, y = 0;
            while(cnt <= N * N) {

                while (y < N && data[x][y] == 0) {
                    data[x][y] = cnt++;
                    y++;
                }
                y--;
                x++;

                while (x < N && data[x][y] == 0) {
                    data[x][y] = cnt++;
                    x++;
                }
                x--;
                y--;

                while (y >= 0 && data[x][y] == 0) {
                    data[x][y] = cnt++;
                    y--;
                }
                y++;
                x--;

                while (x >= 0 && data[x][y] == 0) {
                    data[x][y] = cnt++;
                    x--;
                }
                x++;
                y++;
            }



            System.out.println("#" + t);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(data[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
