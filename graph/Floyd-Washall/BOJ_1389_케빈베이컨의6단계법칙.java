import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요구사항 : 모든 유저 간 케빈 베이컨의 수의 합이 가장 작은 사람을 구해라
 * - 케빈 베이컨의 6단계 법칙 : 지구에 있는 모든 사람들은 최대 6단계 이내에서 서로 아는 사람으로 연결될 수 있다
 * 
 * 입력 : 유저의 수 N, 친구 관계의 수 M
 * 		M개의 줄 ~ 친구 관계
 * 제약 : 2 <= N <= 100
 * 		1 <= M <= 5000
 * 		사람의 번호는 1부터 N까지
 * 		모든 사람은 친구 관계로 연결되어져있음
 * 출력 : 유저 중 케빈 베이컨의 수가 가장 작은 사람, 단 그런 사람이 여럿이면 번호가 가장 작은 사람
 * @author chaeu
 *
 */
public class BOJ_1389_케빈베이컨의6단계법칙 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// 유저의 수(정점)
		int M = Integer.parseInt(st.nextToken());	// 친구 관계의 수(간선)
		final int INF = 987654321;	
		int minSum = INF;	
		int ans = -1;
		int[][] matrix = new int[N][N];
		// 친구관계 이차원 배열을 모두 가장 큰 값으로 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = INF;
			}
		}
		// 입력받기(관계가 연결되어있으면 양방향으로 1 값 넣기)
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			matrix[a][b] = matrix[b][a] = 1;
		}
		
		// 플로이드-와샬로 출발지 i에서 도착지 j까지 거쳐갈 수 있는 경유지 k가 있을 때 가장 짧은 거리 구하기
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
				}
			}
		}
		
		// N명의 유저의 케빈 베이컨의 수를 구하고, 전체 유저 중 최솟값일 때 유저 번호 저장하기
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				sum += matrix[i][j];
			}
			if (minSum > sum) {
				minSum = sum;
				ans = i;
			}
		}
		System.out.println(ans + 1);
	}

}
