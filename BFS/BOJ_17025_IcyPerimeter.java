import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 요구사항 : '.'은 빈칸, '#'은 아이스크림을 나타낼 때, 가장 큰 아이스크림의 area와 perimeter를 구해라
 * 
 * 풀이 방법
 * 	- #이고 아직 방문하지 않았다면 bfs
 * 		- 주어진 N x N 크기의 가장자리이면서 #인 경우 둘레 세기
 * 		- 사방탐색
 * 			- 범위 체크
 * 			- 방문 체크 (이미 방문한 아이스크림 cell인 경우)
 * 			- . 체크 (둘레를 세기 위해 카운팅 후 이어서 사방탐색)
 * 			- 방문하지 않은 #인 경우 (이어서 큐에 넣고, 면적 카운팅) 
 * 
 * 주의 사항 
 * 	- 출력할 때, area가 같다면 그 중 perimeter가 가장 작은 둘레를 출력해야함
 * @author chaeu
 *
 */
public class BOJ_17025_IcyPerimeter {

	static int N;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		int maxArea = 0, maxPerimeter = 0;
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) continue;
				if (map[i][j] == '.') continue;
				if (map[i][j] == '#') {
					
					int[] answers = bfs(i, j);
					if (maxArea == answers[0]) {
						// area가 같다면 그 중 perimeter가 가장 작은 둘레를 저장
						maxPerimeter = maxPerimeter < answers[1] ? maxPerimeter : answers[1];
					} else {
						maxArea = maxArea > answers[0] ? maxArea : answers[0];
						maxPerimeter = maxPerimeter > answers[1] ? maxPerimeter : answers[1];
					}
				}
			}
		}
		System.out.println(maxArea + " " + maxPerimeter);
		
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	private static int[] bfs(int x, int y) {
		int[] answers = new int[2];
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		answers[0]++;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			
			// 주어진 N X N 에서 가장자리인 아이스크림의 경우 둘레 세주기
			// 범위 체크에서 걸리기 때문에 사방탐색 전 미리 카운트
			if (curX == 0 || curX == N - 1) answers[1]++;
			if (curY == 0 || curY == N - 1) answers[1]++;
			for (int d = 0; d < 4; d++) {
				int nx = dx[d] + curX;
				int ny = dy[d] + curY;
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if (visited[nx][ny]) continue;
				if (map[nx][ny] == '.') { // 아이스크림의 둘레 세기
					answers[1]++;
					continue;
				}
				
				// 방문하지 않은 '#'인 경우
				queue.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
				answers[0]++;
			}
		}
		
		return answers;
		
	}

}

