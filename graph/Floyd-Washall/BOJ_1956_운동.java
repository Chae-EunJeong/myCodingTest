import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요구사항 : 도로의 정보가 주어졌을 때, 도로의 길이의 합이 가장 작은 사이클을 찾아라. 입력 : 마을 개수 V, 도로 개수 E E개 줄
 * ~ 마을 a, 마을 b, a->b의 도로 거리 c (a마을에서 b마을로 가는 거리가 c인 도로) 제약 : 2 <= V <= 400 0 <=
 * E <= V(V-1) 0 < c <= 10,000 출력 : 최소 사이클의 도로 길이 합 (경로 없을 때는 -1)
 * 
 * 주의사항 - 방향 그래프라는 점 - 최소 사이클의 도로 길이의 합이므로 전체 마을간 최소 거리를 구해서 (i,i)의 값중 최소를 구하면 됨
 * 
 * @author chaeu
 *
 */
public class BOJ_1956_운동 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken()); // 마을 개수
        int E = Integer.parseInt(st.nextToken()); // 도로 개수
        final int INF = 987654321;
        int ans = INF;
        int[][] map = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                map[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = c;
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j)
                    ans = Math.min(ans, map[i][j]);
            }
        }
        if (ans == INF)
            ans = -1;
        System.out.println(ans);
    }

}
