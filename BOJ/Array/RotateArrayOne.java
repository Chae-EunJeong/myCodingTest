/* 17406. 배열돌리기 1
- 요구사항 : N X M 배열을 R번 반시계 방향으로 돌린 결과를 구해라
- 함수
    - 입력 : 배열의 크기 N M 수행해야하는 회전 수 R
            N개의 줄 ~ 배열의 원소 Aij
    - 제약 : 2 <= N, M <= 300
            1 <= R <= 1000
            min(N, M) mod 2 = 0
            1 <= Aij <= 10^8
    - 출력 : 배열을 R번 회전시킨 결과
*/

package Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RotateArrayOne {
    static int N, M, R;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split(" ");
		N = Integer.parseInt(data[0]);
		M = Integer.parseInt(data[1]);
		R = Integer.parseInt(data[2]);
		arr = new int[N][M];
		
		// 배열 입력 받기
		for (int n = 0; n < N; n++) {
			data = br.readLine().split(" ");
			for (int m = 0; m < M; m++) {
				arr[n][m] = Integer.parseInt(data[m]);
			}
		}
		
		// R만큼 회전시키기
		for (int r = 0; r < R; r++) {
			rotateMap();
		}
		
		// R만큼 회전한 배열 출력
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				System.out.print(arr[n][m] + " ");;
			}
			System.out.println();
		}
	}
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	private static void rotateMap() {

		// cnt는 회전해야 하는 그룹의 시작점
		for (int cnt = 0, loopCnt = Math.min(N, M) / 2; cnt < loopCnt; cnt++) {
			
			int temp = arr[cnt][cnt];
			int x = cnt;
			int y = cnt;
			
			for (int i = 0; i < 4; i++) {
				while(true) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx < cnt || nx >= N - cnt || ny < cnt || ny >= M - cnt) break;
					
					arr[x][y] = arr[nx][ny];
					x = nx;
					y = ny;
					
				}
			}
			arr[cnt + 1][cnt] = temp;
		}
		
	}
}
