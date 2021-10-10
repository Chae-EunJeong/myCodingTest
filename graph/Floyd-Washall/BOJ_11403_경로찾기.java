import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요구사항 : 가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점 (i, j)에 대해서 i에서 j로 가는 경로가 있는지 없는지를 구해라
 * 입력 : 정점의 개수 N N개 줄 ~ 그래프의 인접행렬(N X N) 제약 : 인접행렬의 숫자가 1일 때는 i에서 j로 가는 간선이
 * 존재한다, 0일 때는 간선이 없다. 인접행렬의 (i,i)는 항상 0이다. 1 <= N <= 100 출력 : N개의 줄에 걸쳐 인접 행렬
 * 형식으로 출력 ( i에서 j로 가는 경로 있으면 1, 없으면 0)
 * 
 * 주의사항 : 가중치 없는 방향 그래프 라는 점! (처음에 행렬을 괜히 [i][j] = [j][i]로 해서 저장했다.) 경로 있으면 1,
 * 없으면 0이라는 점. (간선 하나당 1로 해서 괜히 최단 경로를 저장했는데, 처음 초기화한 값과 변화한 값을 이용해 0과 1만 출력하도록
 * 하면 된다.) 실버1이었는데 괜히 시간 많이 썼다..
 * 
 * @author chaeu
 *
 */
public class BOJ_11403_경로찾기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        final int INF = 987654321;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    map[i][j] = INF;
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == INF)
                    map[i][j] = 0;
                else
                    map[i][j] = 1;
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}
