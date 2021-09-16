import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드5_14502_연구소 {

	public static class Position {
		int x, y;
		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	/**
	 * 연구소
	 * - 빈칸 : 0, 벽 : 1, 바이러스 : 2
	 * - 요구사항 : 벽을 3개 세운 뒤 바이러스가 퍼질 수 없는 안전영역(0의 개수)의 최댓값 구하기
	 */
	static int[][] map;
	static int N, M, safeArea;	// 세로크기, 가로크기, 안전영역 개수
	static ArrayList<Position> empty;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		empty = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					safeArea++;
					empty.add(new Position(i, j));
				}
			}
		}
		// 1을 3개 놓는 모든 경우의 수
		// 경우의 수 마다 2 주위 사방탐색으로 0이면 퍼져나가도록 bfs
		numbers = new int[3];
		minSize = safeArea;
		choose(0, 0);
		System.out.println(safeArea - minSize - 3);
	}
	
	static int[] numbers;
	static int minSize;
	/**
	 * 좌표의 값이 0인 것들 중 3군데를 1로 바꾸는 모든 경우의 수를 구함
	 * 모든 경우의 수 마다 아래 과정 실행
	 * - 3군데를 1로 바꾼 후 그때 bfs로 바이러스를 퍼뜨리고, 
	 * - 안전영역이 최대가 되도록 minSize가 최소가 되는 값 찾아서 저장 후
	 * - 1로 바꾼 좌표의 값을 다시 0으로 되돌리기
	 */
	private static void choose(int cnt, int start) {
		if (cnt == 3) {
			for (int i = 0; i < cnt; i++) {
				map[empty.get(numbers[i]).x][empty.get(numbers[i]).y] = 1;
			}
			bfs();
			minSize = Math.min(spread, minSize);
			for (int i = 0; i < cnt; i++) {
				map[empty.get(numbers[i]).x][empty.get(numbers[i]).y] = 0;
			}
			return;
		}
		
		for (int i = start; i < empty.size(); i++) {
			numbers[cnt] = i;
			choose(cnt + 1, i + 1);
		}
	}
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int spread;
	/**
	 * 바이러스가 사방에 존재하는 빈칸으로 퍼져나갈 때 너비우선탐색 이용
	 */
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		spread = 0;
		// 바이러스인 좌표 큐에 넣기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					queue.offer(new int[] {i, j});
					visited[i][j] = true;
				} 
			}
		}
		
		while (!queue.isEmpty()) {
			int[] data = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = data[0] + dx[d];
				int ny = data[1] + dy[d];
				// 범위 체크
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				// 방문체크
				if (visited[nx][ny]) continue;
				// 갈 수 없는 곳(벽(1))일때
				if (map[nx][ny] == 1) continue;
				// 빈칸(0)일 때 바이러스가 퍼져나감(큐에 넣기)
				visited[nx][ny] = true;
				queue.offer(new int[] {nx, ny});
				spread++;	// 퍼지는 영역을 세서 나중에 안전영역 계산에 사용
			}
		}
		
	}
}
