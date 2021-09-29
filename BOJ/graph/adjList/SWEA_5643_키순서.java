import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요구사항 : 두 학생끼리 키를 비교한 결과들로부터 자신의 키가 몇 번째인지 알 수 있는 학생 수를 구해라
 * 입력 : 전체 테케 수 T
 * 		각 테케 ~ 학생 수 N
 * 				두 학생의 키를 비교한 횟수 M
 * 				M개 줄 ~ 두 학생의 키를 비교한 결과를 나타내는 a b (a가 b보다 키가 작다)
 * 제약 : 1 <= T <= 15
 * 		2 <= N <= 500
 * 		0 <= M <= N*(N-1)/2
 * 출력 : 각 테케 별 자신의 키가 몇 번째인지 알 수 있는 학생 수
 *
 */
public class SWEA_5643_키순서 {
	
	static class Node {
		int vertex;	// 인접 정점의 인덱스
		Node link;	// 다음 노드를 가리키는 링크
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}
	
	static int N, M;	// 학생 수, 두 학생 간 키 비교 횟수
	static Node[] tallerList;	// 나보다 키가 큰 인접 정점 저장할 리스트
	static Node[] shorterList;	// 나보다 키가 작은 인접 정점 저장할 리스트
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int ans = 0;	// 자신의 키가 몇 번째인지 알 수 있는 학생 수
			
			N = Integer.parseInt(br.readLine());	
			M = Integer.parseInt(br.readLine());
			tallerList = new Node[N + 1];
			shorterList = new Node[N + 1];
			
			StringTokenizer st = null;
			for (int m = 1; m <= M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				tallerList[a] = new Node(b, tallerList[a]);	// from보다 키가 큰 애들 저장
				shorterList[b] = new Node(a, shorterList[b]);	// from보다 키가 작은 애들 저장
			} // 입력 받기 완료
			
			int[][] myOrder = new int[N + 1][2];    // 학생별로 나보다 작은 애의 수, 나보다 큰 애의 수 저장할 이차원배열
            
			// 정점별로 dfs 탐색해서 현재 학생보다 키가 작은 학생 수 저장
            for (int i = 1; i <= N; i++) {
                boolean[] visited = new boolean[N + 1];	// 정점별 방문 배열 초기화
                dfs(shorterList, i, visited);	// dfs 탐색
                int cnt = -1;	// 자기 자신 방문 수는 제외하고 세기 위해 -1
                
                // dfs 탐색 후 방문 배열 상태 확인
                for (int j = 1; j <= N; j++) {
                	// 방문 한 곳이면 cnt 1 증가
                    if (visited[j]) {
                        cnt++;
                    }
                }
                myOrder[i][0] = cnt; 	// i 정점보다 키가 작은 학생 수 저장
            }
             
            // 정점별로 dfs 탐색해서 현재 학생보다 키가 큰 학생 수 저장
            for (int i = 1; i <= N; i++) {
            	boolean[] visited = new boolean[N + 1];	// 정점별 방문 배열 초기화
                dfs(tallerList, i, visited);	// dfs 탐색
                int cnt = -1;	// 자기 자신 방문 수는 제외하고 세기 위해 -1
                
                // dfs 탐색 후 방문 배열 상태 확인
                for (int j = 1; j <= N; j++) {
                	// 방문 한 곳이면 cnt 1 증가
                    if (visited[j]) {
                        cnt++;
                    }
                }
                myOrder[i][1] = cnt; 	// i 정점보다 키가 큰 학생 수 저장
            }
             
            for (int i = 1; i <= N; i++) {
                if (myOrder[i][0] + myOrder[i][1] == N - 1) {
                    ans++;
                }
            }
            System.out.println("#" + t + " " + ans);
        }
         
    }
	// adjList의 dfs 탐색 - n은 현재 정점, visited는 방문 배열 상태
    private static void dfs(Node[] adjList, int n, boolean[] visited) {
        visited[n] = true;	// 현재 정점 방문 체크
         
        // 현재 정점에서 이어진 링크들을 쭉 탐색
        for (Node temp = adjList[n]; temp != null; temp = temp.link) {
            if (!visited[temp.vertex]) {	// 방문한 정점이 아니면
                dfs(adjList, temp.vertex, visited);	// 그 정점에서 dfs 탐색
            }
        }
    }
}

/*
1
6
6
1 5
3 4
5 4
4 2
4 6
5 2
*/
