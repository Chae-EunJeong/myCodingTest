import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 요구사항 : 4개 자석의 자성 정보가 주어졌을 때, 자석을 한 칸씩 k번 회전시킨 후 획득하는 점수의 총 합을 구해라
 * 입력 : 총 테케 수 T
 * 		각 테케 ~ 자석을 회전시키는 횟수 K
 * 				(4개의 줄에 걸쳐) 각 자석의 8개 날의 자성 정보
 * 				(K개 줄에 걸쳐) 자석을 회전시키려는 자석 번호, 회전 방향
 * 제약 : 자석은 4개, 각 자석은 8개의 날 가짐
 * 		1 <= K <= 20
 * 		자석 회전 방향 : 시계방향 = 1, 반시계 방향 = -1
 * 		자성 : N극 = 0, S극 = 1
 * 		하나의 자석이 1칸 회전될 때, 붙어 있는 자석은 서로 붙어 있는 날의 자성과 다를 경우에만 반대 방향으로 1칸 회전된다.
 * 		각 자석의 자성 정보는 빨간색 화살표 위치의 날부터 시계방향 순서로 입력됨
 * 		점수 계산 방법
		- 1 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 1 점을 획득한다.
		- 2 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 2 점을 획득한다.
		- 3 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 4 점을 획득한다.
		- 4 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 8 점을 획득한다.
 * 출력 : 각 테케 별 모든 자석의 회전이 끝난 후 획득 점수의 총합
 * 
 * @author chaeu
 *
 */
public class SWEA_4013_특이한자석 {

	static int[][] fourMagnet, newMagnet;
	static int[] directions;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/com/ssafy/webex/input4013.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 전체 테케 수
		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());	// 자석 회전 횟수
			fourMagnet = new int[4][8];
			newMagnet = new int[4][8];
			for (int i = 0; i < 4; i++) {
				String[] data = br.readLine().split(" ");
				for (int j = 0; j < 8; j++) {
					fourMagnet[i][j] = Integer.parseInt(data[j]);
				}
			}
			// k번 자석 돌리기
			for (int k = 0; k < K; k++) {
				String[] data = br.readLine().split(" ");
				int which = Integer.parseInt(data[0]) - 1;
				int way = Integer.parseInt(data[1]);
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 8; j++) {
						newMagnet[i][j] = fourMagnet[i][j];
					}
				}
				directions = new int[4];
				for (int i = 0; i < 4; i++) {
					if (i % 2 == which % 2) directions[i] = way;
					else directions[i] = way * (-1);
				}
				// which번 자석보다 왼쪽에 있는 자석이 있을 때
				int num = which;
				while (num - 1 > -1) {
					if (fourMagnet[num][6] == fourMagnet[num - 1][2]) {
						break;
					} else {	// 다르면 회전
						if (directions[num - 1] == 1) turnRight(num - 1);
						else turnLeft(num - 1);
						num--;
					}
				}
				
				// which번 자석보다 오른쪽에 있는 자석이 있을 때
				num = which;
				while (num + 1 < 4) {
					if (fourMagnet[num][2] == fourMagnet[num + 1][6]) {
						break;
					} else {	// 다르면 회전
						if (directions[num + 1] == 1) turnRight(num + 1);
						else turnLeft(num + 1);
						num++;
					}
				}
				
				// which 자석도 회전
				if (directions[which] == 1) turnRight(which);
				else turnLeft(which);
				
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 8; j++) {
						fourMagnet[i][j] = newMagnet[i][j];
					}
				}
			}
			int ans = 0;
			for (int i = 0; i < 4; i++) {
				ans += (fourMagnet[i][0] * Math.pow(2, i));
			}
			System.out.println("#" + t + " " + ans);
		}
	}
	private static void turnRight(int w) {
		newMagnet[w][0] = fourMagnet[w][7];
		for (int i = 1; i < 8; i++) {
			newMagnet[w][i] = fourMagnet[w][i - 1];
		}
	}
	private static void turnLeft(int w) {
		newMagnet[w][7] = fourMagnet[w][0];
		for (int i = 1; i < 8; i++) {
			newMagnet[w][i - 1] = fourMagnet[w][i];
		}
	}
}
