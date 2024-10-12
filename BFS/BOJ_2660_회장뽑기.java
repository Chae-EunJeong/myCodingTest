import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2660_회장뽑기 {
    static boolean[][] map;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 회원의 수
        map = new boolean[N + 1][N + 1];    // 친구 여부 그래프
        int[][] friendBridge = new int[N + 1][N + 1];   // 몇 다리를 건너야 친구인지를 나타내는 이차원 배열
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;
            map[a][b] = map[b][a] = true;
        }

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

    }

    private static void bfs(int num) {

    }
}
