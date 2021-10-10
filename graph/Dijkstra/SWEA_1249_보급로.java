import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 요구사항 : 깊이가 1일 때 복구에 드는 시간이 1이다. 
 * 			각 칸마다 파인 도로의 깊이가 주어진 지도 정보가 주어졌을 때 
 * 			도로 복구 시간을 최소로 하는 경로를 따라 출발지에서 도착지까지 걸리는 시간을 구해라.
 * 입력 : 전체 테케 수 T
 * 		각 테케 별 ~ 지도의 크기 N
 * 				지도의 크기만큼 2차원 배열 형태의 지도 정보
 * 제약 : 0 <= 깊이 < 10
 * 		지도의 크기는 최대 100 X 100
 * 출력 : 각 테케 별 출발지에서 도착지까지 가는 경로 중 복구 작업에 드는 시간이 가장 작은 경로의 복구 시간
 * 
 * 다익스트라 최단 경로 (가중치가 있으므로 최소 비용)
 * 			
 * @author chaeu
 *
 */
public class SWEA_1249_보급로 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 전체 테케 수
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());	// 지도의 크기	
			final int INFINITY = Integer.MAX_VALUE;		
			int[][] map = new int[N][N];	// 지도 생성
			int[][] distance = new int[N][N];	// 각 정점 별 출발지에서 정점까지의 최단 시간 정보를 담을 배열
			boolean[][] visited = new boolean[N][N];	// 탐색할 때 방문 체크 할 배열 생성
			
			for (int i = 0; i < N; i++) {
				char[] data = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = data[j] - '0';
					distance[i][j] = INFINITY;	
				}
			} // 입력 받기 완료
			
			int currentX = 0, currentY = 0;		// 현재 위치를 출발지로 초기화
			int endX = N - 1, endY = N - 1;		// 도착지 초기화
			
			distance[currentX][currentY] = 0;
			
			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0, -1, 1};
			int min = 0;
			// 사방탐색을 하면서 지도에서 방문하지 않은 정점이 있을 때 출발점에서 각 정점까지의 최소 비용 비교하기
			while(true) {
				min = INFINITY;
				// 정점들을 모두 탐색
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!visited[i][j] && distance[i][j] < min) { // 방문하지 않은 정점일 때
							min = distance[i][j]; 
							currentX = i;
							currentY = j;
						}
					}
				}
				
				visited[currentX][currentY] = true;	// 방문체크
				if (currentX == endX && currentY == endY) break;	// 도착지면 탈출
				
				// 사방탐색으로 인접한 지점 방문
				for (int d = 0; d < 4; d++) {
					int nx = dx[d] + currentX;
					int ny = dy[d] + currentY;
					// 범위 체크
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					// 방문 체크
					if (visited[nx][ny]) continue;
					// 저장된 최소 시간 비용보다 작을 때 업데이트
					if (distance[nx][ny] > min + map[nx][ny])
						distance[nx][ny] = min + map[nx][ny];
				}
			}
			System.out.println("#" + t + " " + distance[endX][endY]);
		}
	}

}
