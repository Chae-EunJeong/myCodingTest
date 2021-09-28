import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 요구사항 : 도둑루피가 가득한 N X N 크기의 동굴이 주어지고, 도둑루피가 있는 칸을 지날때마다 도둑루피 크기만큼 소지금을 잃게된다.
 * 			[0][0]칸에서 제일 오른쪽 아래칸인 [N-1][N-1]까지 상하좌우로 인접한 곳으로만 이동해야할 때, 
 * 			잃을 수 밖에 없는 최소 금액을 구해라
 * 입력 : 여러 개의 테스트 케이스 ~ 첫째줄 : 동굴의 크기 N
 * 						   N개의 줄에 걸쳐 : 각 칸의 도둑 루피의 크기
 * 		0이 입력되면 전체 입력 종료
 * 제약 : 도둑루피의 크기가 k면 그 칸을 지날 때 k루피를 잃는다.
 * 		0 <= 도둑루피의 크기 <= 9
 * 		2 <= N <= 125
 * 출력 : 각 테스트케이스 별 잃을 수 밖에 없는 최소금액
 * 
 * 그래프 - 최단경로 - 다익스트라
 * 
 * - 풀이 과정
 * 	다익스트라 기본 틀은 유지하면서
 * 	사방탐색 범위 내이면서 방문 체크 하고, 그 위치 도둑루피 값 더한게 더 작을 때 최소 루피값 초기화시켜간다.
 * @author chaeu
 *
 */
public class BOJ_4485_녹색옷입은애가젤다지 {

	public static void main(String[] args) throws Exception {
		int tc = 0;	// 테케 번호
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			tc++;	// 몇 번째 테케인지
			int N = Integer.parseInt(br.readLine());	// 동굴의 크기 
			if (N == 0) break;	// 0이 입력되면 전체 입력 종료
			int[] end = {N - 1, N - 1};		// 도착점 좌표
			final int INFINITY = Integer.MAX_VALUE;
			
			int[][] matrix = new int[N][N];	// 입력받을 동굴의 도둑루피 크기 이차원 배열
			boolean[][] visited = new boolean[N][N];	// 도둑루피가 위치한 각 칸을 방문했는지 따질 이차원 배열
			int[][] rupee = new int[N][N];	// 각 칸까지의 잃는 최소 루피 값을 저장할 배열
			
			StringTokenizer st = null;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
					rupee[i][j] = INFINITY;
				}
			}	// 입력받기
			
			rupee[0][0] = matrix[0][0]; // 출발점 루피값 초기화
			
			// 사방탐색용 
			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0, -1, 1};
			
			int min = 0;	
			int[] current = {0, 0};
			for (int k = 0; k < N * N; k++) {
				// 방문하지 않은 칸 중 최소 가중치의 좌표 선택
				min = INFINITY;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!visited[i][j] && rupee[i][j] < min) {
							min = rupee[i][j];
							current[0] = i;
							current[1] = j;
						}
					}
				}
				visited[current[0]][current[1]] = true;
				if (current[0] == end[0] && current[1] == end[1]) break;
				
				// current를 경유지로 해서 갈 수 있는, 다른 방문하지 않은 칸들에 대한 처리
				for (int d = 0; d < 4; d++) {
					int nx = dx[d] + current[0];
					int ny = dy[d] + current[1];
					// 범위 체크
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					// 방문 체크
					if (visited[nx][ny]) continue;
					// 갈 수 있는 곳이 기존 최소 루피값보다 작으면 업데이트
					if (rupee[nx][ny] > min + matrix[nx][ny])
						rupee[nx][ny] = min + matrix[nx][ny];
				}
			}
			
			System.out.println("Problem " + tc + ": " + rupee[end[0]][end[1]]);
		}
	}

}
