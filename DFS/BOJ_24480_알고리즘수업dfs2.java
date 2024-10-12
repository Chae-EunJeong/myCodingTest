package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 요구사항 : N개의 정점과 M개의 간선으로 구성된 무방향 그래프가 주어졌을 때, 정점 R에서 시작하는 깊이우선탐색을 한 노드의 방문 순서를 구해라
 *          인접정점은 내림차순으로 방문
 * 입력 : 첫째줄~정점의 수 N, 간선의 수 M, 시작정점 R // 다음 M개줄~ 간선정보 u v
 * 출력 : 첫째줄부터 N개의 줄에 정수 한개씩 출력 (i번째 줄엔 정점i의 방문 순서)
 * 제약 : 시작정점의 방문순서는 1, 시작정점에서 방문할 수 없을 때 0
 *       5 ≤ N ≤ 100,000
 *       1 ≤ M ≤ 200,000
 *       1 ≤ R ≤ N
 * 풀이과정 : LinkedList에 넣은 후 내림차순 정렬, 방문체크 후 제일 앞에 있는 정점으로 이동.
 *          answer배열에 각 정점의 방문순서 넣기
 */
public class BOJ_24480_알고리즘수업dfs2 {
    static int N, M, R, cnt;
    static ArrayList<Integer>[] list;
    static int[] answer;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        answer = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        // 각 ArrayList 내림차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i], Collections.reverseOrder());
        }

        // 시작정점부터 dfs 시작
        // 시작 정점의 ArrayList에서 순차적으로, 방문순서++, 방문한 적 없는 정점으로 이동
        // 더이상 없으면 dfs 종료
        cnt = 0;
        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void dfs(int r) {
        visited[r] = true;
        answer[r] = ++cnt;
        boolean check = false;
        for (int i = 0; i < list[r].size(); i++) {
            int num = list[r].get(i);
            if (!visited[num]) {
                dfs(num);
                check = true;
            }
        }
        if (!check) return;
    }
}
