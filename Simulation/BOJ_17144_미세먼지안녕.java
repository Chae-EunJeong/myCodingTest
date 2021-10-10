import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요구사항 : 방의 정보가 주어졌을 때, T초 후 방에 남아있는 미세먼지의 양을 구해라.
 * 			1초동안 
 * 			1) 미세먼지의 확산 (인접한 네 방향으로 확산)
 * 			2) 공기청정기 작동 (공기청정기의 위쪽은 반시계방향, 아래쪽은 시계방향으로 순환)
 * 문제 이해하기 
 * 	- 미세먼지는 미세먼지가 있는 칸에서 인접한 네 방향으로 확산될 수 있다.
 * 	- 미세먼지가 확산 공식 :  x - (x/5) * 확산된 방향 개수
 *  - 공기청정기에서 부는 바람은 공기청정기를 기준으로 시계/반시계로 네모가 되는 부분만 한칸씩 순환됨. (가운데 부분은 그대로)
 *  
 * 입력 : 방의 크기 R, C, 흐른 시간 T
 * 		R개의 줄 ~ 방의 정보 (공기 청정기 : -1, 나머지는 미세먼지의 양)
 * 제약 : 6 <= R, C <= 50
 * 		1 <= T <= 1000
 * 		-1 <= 미세먼지 양 <= 1000
 * 		-1은 가장 윗 행, 아랫행과 두 칸이상 떨어져있음
 * 출력 : T초가 지난 후 방에 남아있는 미세먼지 양(총합)
 * 
 * @author chaeu
 *
 */
public class BOJ_17144_미세먼지안녕 {
	static int R, C;
	static int[][] room, cleaner;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		room = new int[R][C];
		cleaner = new int[2][2];
		int idx = 0;
		
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				room[r][c] = Integer.parseInt(st.nextToken());
				if (room[r][c] == -1) {
					cleaner[idx][0] = r;
					cleaner[idx][1] = c;
					idx++;
				}
			}
		}	// 입력 받기 완료
		
		// T초동안 아래 과정 1초마다 반복
		while(T-- > 0) {
			// 1. 미세먼지의 확산
			spreadDust();
			// 2. 공기 청정기 작동
			airCleaner();
		}
		System.out.println(countDust());
	}
	/**
	 * 공기 청정기 작동시키는 함수
	 */
	private static void airCleaner() {
		// 위쪽 공기청정기 반시계 순환
		int r = cleaner[0][0];
		int c = cleaner[0][1];
		
		int rCnt = r - 1;	
		int cCnt = C - 1;
		int change = -1;
		r += change;	// 공기 청정기 부분 건너뛰기
		
		// 행 훑고 열 훑기를 두 번 반복(사각형 모양으로 순환)
		for (int k = 0; k < 2; k++) {
			// 처음에는 행번호 감소(바람이 위로), 다음은 change 바뀐 후 행번호 증가(바람 아래로)
			while (rCnt-- > 0) {
				room[r][c] = room[r + change][c];
				r += change;
			}
			change *= (-1);
			// 열번호 증가(바람 오른쪽으로), change 바뀐 후 열번호 감소(바람 왼쪽으로)
			while (cCnt-- > 0) {
				room[r][c] = room[r][c + change];
				c += change;
			}
			rCnt = cleaner[0][0];
			cCnt = C - 2;
		}
		room[r][c] = 0;
		
		// 아래쪽 공기청정기 시계 순환(바람이 아래,오른쪽, 위, 왼쪽 으로 순환)
		r = cleaner[1][0];
		c = cleaner[1][1];
		
		rCnt = R - r - 2;
		cCnt = C - 1;
		change = 1;
		r += change;
		for (int k = 0; k < 2; k++) {
			// 처음에는 행번호 증가(바람이 아래로), 다음은 change 바뀐 후 행번호 감소(바람 위로)
			while (rCnt-- > 0) {
				room[r][c] = room[r + change][c];
				r += change;
			}
			// 열번호 증가(바람 오른쪽으로), change 바뀐 후 열번호 감소(바람 왼쪽으로)
			while (cCnt-- > 0) {
				room[r][c] = room[r][c + change];
				c += change;
			}
			change *= (-1);
			rCnt = R - cleaner[1][0] - 1;
			cCnt = C - 2;
		}
		room[r][c] = 0;
	}

	/**
	 * 방에 남아있는 미세먼지의 양 세는 함수
	 * @return 미세먼지 총 양
	 */
	private static int countDust() {
		int total = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (room[r][c] > 0) total += room[r][c];
			}
		}
		return total;
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	/**
	 * 미세먼지 확산 함수
	 * - 인접한 네 방향으로 확산
	 * - 미세먼지가 처음 있던 상태에서 확산해야하기 때문에 
	 * 		확산되기 전 미세먼지 양을 이용해 확산양 계산 후 임의의 배열에 저장하고, 임의 배열을 다시 원래 배열로 복사하는 과정 거침
	 */
	private static void spreadDust() {
		int[][] temp = new int[R][C];
		// 처음 미세먼지가 있던 칸 체크해놓기
		boolean[][] dustCheck = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (room[r][c] > 0) dustCheck[r][c] = true;
			}
		}
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (!dustCheck[r][c]) continue;
				int amount = room[r][c] / 5;	// 인접 칸으로 확산될 미세먼지 양
				int cnt = 0;	// 몇 개의 칸에 확산되는지 세기
				// 인접한 4방향 중 범위 내이고 -1인지 확인
				for (int d = 0; d < 4; d++) {
					int nr = dx[d] + r;
					int nc = dy[d] + c;
					if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
					if (room[nr][nc] == -1) continue;
					// 가능하다면 그 칸에 미세먼지 확산시키기
					temp[nr][nc] += amount;
					cnt++;
				}
				// 확산 후 남은 미세먼지 양
				room[r][c] -= (amount * cnt);
				temp[r][c] += room[r][c];
			}
		}
		// 임의 배열을 다시 복사, 단 공기청정기 부분은 0으로 채워지지 않게 continue 시키기
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (room[r][c] == -1) continue;
				room[r][c] = temp[r][c];
			}
		}
	}

}
