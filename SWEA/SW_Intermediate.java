/* 210802 SW Intermediate 문제풀이
- 요구사항 : 2차원 배열 지도에 위치한 기지국으로 커버되지 않는 집의 수를 구해라
- 함수
    - 입력 : 첫째줄 ~ 테케 수 T
            둘째줄 각 테케 배열 크기 N
            그 다음 줄부터 + N줄 ~ 2차원 배열의 각 행
    - 출력 : 각 테케 별 기지국에 커버되지 않는 집의 수
    - 제약 : 집이 위치한 원소 : 'H'
            기지국 : 'A', 'B', 'C'
                - 'A' : 상하좌우 각 한칸씩 커버 
                - 'B' : 상하좌우 각 두칸씩 커버
                - 'C' : 상하좌우 각 세칸씩 커버
            아무것도 없는 원소 : 'X'
- 손코딩
    - 로직
        기지국을 만나면 새로운 배열 생성
            'A'일 때, 바로 위, 바로 아래, 바로 왼쪽, 바로 오른쪽 움직이는 좌표 배열 더하기
            'B'일 때, 바로 위, 위위, 바로 아래, 아래아래, 1칸 왼쪽, 2칸 왼쪽, 1칸 오른쪽, 2칸 오른쪽 좌표 배열 더하기
            'C'일 때, 마찬가지로, 3칸, 2칸, 1칸 상하좌우로 움직이는 좌표 배열 더하기
        더해준 좌표 배열이 범위안에 있고 'H' 라면
            총 집의 개수 - 1, H를 X로 바꾸기
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SW_Intermediate {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			int[] adx = {-1, 1, 0, 0};
			int[] ady = {0, 0, -1, 1};
			int[] bdx = {-2, -1, 1, 2, 0, 0, 0, 0};
			int[] bdy = {0, 0, 0, 0, -2, -1, 1, 2};
			int[] cdx = {-3, -2, -1, 1, 2, 3, 0, 0, 0, 0, 0, 0};
			int[] cdy = {0, 0, 0, 0, 0, 0, -3, -2, -1, 1, 2, 3};
			char[][] map = new char[N][N];
			/* 입력받은 값들을 배열에 저장 */
			for (int i = 0; i < N; i++) {
				char[] row = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = row[j];
					if (map[i][j] == 'H') {
						ans++;
					}
				}
			}
			
			/* 사방 탐색 X1, X2, X3 */
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'A') {
						for (int g = 0; g < 4; g++) {
							int nr = i + adx[g];
							int nc = j + ady[g];
							if (nr >= 0 && nc >= 0 && nc < N && nr < N && map[nr][nc] == 'H') {
								ans--;
								map[nr][nc] = 'X';
							}
						}
					} else if (map[i][j] == 'B') {
						for (int g = 0; g < 8; g++) {
							int nr = i + bdx[g];
							int nc = j + bdy[g];
							if (nr >= 0 && nc >= 0 && nc < N && nr < N && map[nr][nc] == 'H') {
								ans--;
								map[nr][nc] = 'X';
							}
						}
					} else if (map[i][j] == 'C') {
						for (int g = 0; g < 12; g++) {
							int nr = i + cdx[g];
							int nc = j + cdy[g];
							if (nr >= 0 && nc >= 0 && nc < N && nr < N && map[nr][nc] == 'H') {
								ans--;
								map[nr][nc] = 'X';
							}
						}
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
