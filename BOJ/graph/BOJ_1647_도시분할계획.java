import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 요구사항 : 하나의 마을을 두 개의 마을로 분할하고자 한다.
 * 			1) 각 분리된 마을 안에 임의의 두 집 사이에는 경로가 항상 존재하고,
 * 			2) 나머지 길의 유지비의 합을 최소로 하고 싶을 때
 * 			위 조건을 모두 만족하도록 필요 없는 길들을 모두 없애고 남은 길 유지비의 합의 최솟값을 구해라
 * 입력 : 집의 개수 N, 길의 개수 M
 * 		M개 줄 ~ A B C -> A번 집과 B번 집을 연결하는 길의 유지비 C
 * 제약 : 2 <= N <= 100,000
 * 		1 <= M <= 1,000,000
 * 		1 <= C <= 1,000
 * 출력 : 없애고 남은 길 유지비의 합의 최솟값
 * 
 * 최소 신장 트리
 * 
 * 두 개로 마을 분리한다고 헷갈릴 것 없이 최소 신장 트리 특징 생각하기
 */
public class BOJ_1647_도시분할계획 {

	static class Edge implements Comparable<Edge> {
		int start, end, weight;
		public Edge (int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	static int N, M;
	static Edge[] edgeList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edgeList = new Edge[M];
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
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
				if (++cnt == N - 2) break;
			}
		}
		System.out.println(result);
	}
	static int[] parents;
	
	private static void make() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if (parents[a] == a) return a;
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
