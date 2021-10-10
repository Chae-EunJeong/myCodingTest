import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 요구사항 : 그래프가 주어졌을 때, 최소 스패닝 트리(최소비용)를 구해라
 * 입력 : 정점의 개수 V
 * 		간선의 개수 E
 * 		E개 줄 ~ 간선에 대한 정보 A B C -> A번 정점과 B번 정점이 가중치 C인 간선으로 연결됨
 * 제약 : 1 <= V <= 10,000
 * 		1 <= E <= 100,000
 * 		C의 절댓값 <= 1,000,000	
 * 출력 : 최소 스패닝 트리의 가중치
 * 
 * 최소 신장 트리
 *
 */
public class BOJ_1197_최소스패닝트리 {

	static class Edge implements Comparable<Edge> {
		int start, end, weight;
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int V, E;
	static Edge[] edgeList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edgeList = new Edge[E];
		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[e] = new Edge(start, end, weight);
		}
		Arrays.sort(edgeList);
		
		make();
		
		int cnt = 0;
		int result = 0;
		for (Edge edge : edgeList) {
			if (union(edge.start, edge.end)) {
				result += edge.weight;
				if (++cnt == V - 1) break;
			}
		}
		
		System.out.println(result);
	}
	

	static int[] parents;
	
	private static void make() {
		parents = new int[V + 1];
		for (int i = 1; i <= V; i++) {
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
}
