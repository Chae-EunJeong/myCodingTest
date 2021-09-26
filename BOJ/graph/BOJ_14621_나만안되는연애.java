import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 요구사항 : 남초 대학교와 여초 대학교를 연결하는 도로로만 이루어진 사심 경로는
 * 			1) 어떤 대학교에서든 모든 (이성)대학교로 이동이 가능해야하고,
 * 			2) 최단 거리여야한다.
 * 			사심 경로의 길이를 구해라.
 * 입력 : 학교의 수 N, 학교를 연결하는 도로의 개수 M
 * 		대학 성별 정보 (남초 대학교 : M, 여초 대학교 : W)
 * 		M개의 줄 ~ u v d -> u학교와 v학교가 간의 거리는 d
 * 제약 : 2 <= N <= 1,000
 * 		1 <= M <= 10,000
 * 		1 <= u,v <= N
 * 		1 <= d <= 1,000
 * 출력 : 사심 경로 길이 (모든 학교를 연결하는 경로가 없을 때는 -1)
 * 
 * union 하기 전 같은 성별 대학이면 합치지 않기.
 * 모든 대학 간 연결은 되어있어야함.
 */
public class BOJ_14621_나만안되는연애 {
	static class Edge implements Comparable<Edge> {
		int start, end, weight;
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
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
		
		st = new StringTokenizer(br.readLine(), " ");
		char[] gender = new char[N + 1];
		for (int i = 1; i <= N; i++) {
			gender[i] = st.nextToken().charAt(0);
		}
		
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
		for (int i = 0; i < edgeList.length; i++) {
			int u = edgeList[i].start;
			int v = edgeList[i].end;
			if (gender[u] == gender[v]) continue;
			if (union(u, v)) {
				result += edgeList[i].weight;
				if (++cnt == N - 1) break;
			}
		}
		
        if (cnt < N - 1) result = -1;

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
