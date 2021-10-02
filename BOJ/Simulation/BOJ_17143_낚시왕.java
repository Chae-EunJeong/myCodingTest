import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 요구사항 : 낚시왕이 상어 낚시를 하는 격자판 상태가 주어졌을 때, 낚시왕이 잡은 상어 크기의 합을 구해라
 * 규칙 : 낚시왕이 0,0에서 출발, 0,C에 도달할때까지 1초에 한 칸씩 오른쪽 열로 이동
 *	 		낚시왕과 같은 열에있는 상어 중 가까운 상어 잡기
 * 			상어 이동
 * 				1초에 주어진 속도만큼 이동
 * 				칸이 격자판 경계 넘을 때는 방향을 반대로 바꾼다.
 * 				한 칸에 상어가 두마리 있게 된다면 크기가 가장 큰 상어만 남는다.
 * 입력 : 격자판 크기 R, C, 상어 수 M
 * 		M개의 줄 ~ 상어 정보 r, c, s, d, z	: 상어의 위치 (r,c), 속력 s, 이동방향 d, 크기 z
 * 제약 : 2 <= R, C <= 100
 * 		0 <= M <= R X C
 * 		1 <= r <= R
 * 		1 <= c <= C
 * 	 	0 <= s <= 1000
 * 		1 <= d <= 4
 * 		1 <= z <= 10000
 * 		d : 위(1), 아래(2), 오른쪽(3), 왼쪽(4)
 * 출력 : 낚시왕이 잡은 상어 크기의 합
 *  
 * 주의사항 : 
 * - s를 나머지 연산해서 불필요한 연산 줄이기
 * - 상어가 같은 위치에 존재하는지 확인할 때 처음에는 O(M*2) 가 되어서 시간초과났는데
 * 	2차원 배열에 현재 상어 위치 저장하면서, 저장할 때 이미 상어가 있으면 크기비교하도록 해서 O(M)으로 줄였다.
 * 			
 * @author chaeu
 *
 */
public class BOJ_17143_낚시왕 {

	static class Shark {
		int r, c, s, d, z;
		public Shark (int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	static int R, C, M, ans;
	static ArrayList<Shark> state;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		state = new ArrayList<>();
		int r = 0,c = 0,s = 0,d = 0,z = 0;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			state.add(new Shark(r, c, s, d, z));
		}
		int king = 0;
		while (king < C + 1) {
			king++;
			// 같은 열에 있는 상어 중 가장 가까운 상어 잡기
			ans += catchShark(king);
			// 상어 이동
			moveShark();
		}
		
		System.out.println(ans);
	}
	static int[] dir = {0, -1, 1, 1, -1};
	private static void moveShark() {
		int r = 0,c = 0,s = 0,d = 0,z = 0;
		for (int i = 0; i < state.size(); i++) {
			Shark iShark = state.get(i);
			r = iShark.r; c = iShark.c; s = iShark.s; d = iShark.d; z = iShark.z;
			int cnt = s;
			switch (d) {
			case 1: case 2:
				cnt %= 2 * (R -1);
				while(cnt-- > 0) {
					if (r == 1 && d == 1) {
						d = 2;
					} else if (r == R && d == 2) {
						d = 1;
					}
					r += dir[d];
				}
				state.set(i, new Shark(r, c, s, d, z));
				break;
				
			case 3: case 4:
				cnt %= 2 * (C - 1);
				while(cnt-- > 0) {
					if (c == 1 && d == 4) {
						d = 3;
					} else if (c == C && d == 3) {
						d = 4;
					}
					c += dir[d];
				}
				state.set(i, new Shark(r, c, s, d, z));
				break;
			}
		}
		eatenByShark();
	}
	private static void eatenByShark() {
		Shark[][] map = new Shark[R + 1][C + 1];
		for (int i = state.size() - 1; i >= 0; i--) {
			Shark iShark = state.get(i);
			if (map[iShark.r][iShark.c] == null) {
				map[iShark.r][iShark.c] = iShark;
				continue;
			}
			if (map[iShark.r][iShark.c].z > iShark.z) {
				state.remove(i);
			} else {
				state.remove(map[iShark.r][iShark.c]);
				map[iShark.r][iShark.c] = iShark;
			}
		}
	}
	private static int catchShark(int king) {
		int close = R + 1;
		Shark s = null;;
		for (int i = 0; i < state.size(); i++) {
			Shark iShark = state.get(i);
			if (iShark.c == king && iShark.r < close) {
				// 가장 가까운 상어
				close = iShark.r;
				s = iShark;
			}
		}
		if (s == null) return 0;
		int size = s.z;
		state.remove(s);
		return size;
	}
}

