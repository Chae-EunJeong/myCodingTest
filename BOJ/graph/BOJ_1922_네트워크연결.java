import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 요구사항 : 각 컴퓨터를 연결하는데 필요한 비용이 주어졌을 때, 모든 컴퓨터를 연결하는데 필요한 최소 비용을 구해라.
 * 입력 : 컴퓨터의 수 N
 * 		연결할 수 있는 선의 수 M
 * 		M개의 줄 ~ 각 컴퓨터를 연결하는 데 드는 비용 a b c -> a와 b 컴퓨터를 연결하는데 드는 비용이 c
 * 제약 : a와 b는 같을 수 있음
 * 		1 <= N <= 1000
 * 		1 <= M <= 100,000
 * 		1 <= c <= 10,000
 * 출력 : 모든 컴퓨터를 연결하는데 필요한 최소비용
 * 
 * 최소신장트리
 *
 */
public class BOJ_1922_네트워크연결 {

	static class Edge implements Comparable<Edge> {
		int start, end, weight;
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static int[] parents;
	
	private static void make() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	static int N, M;
	static Edge[] edgeList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		edgeList = new Edge[M];
		for (int m = 0; m < M; m++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[m] = new Edge(start, end, weight);
		}
		
		Arrays.sort(edgeList);
		
		make();
		
		int cnt = 0;
		int result = 0;
		for (Edge edge : edgeList) {
			if (union(edge.start, edge.end)) {
				result += edge.weight;
				if (++cnt == N - 1) break;
			}
		}
		
		System.out.println(result);
	}

}
