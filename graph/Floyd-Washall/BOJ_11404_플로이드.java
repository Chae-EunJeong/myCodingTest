import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요구사항 : n개의 도시가 있고, 한 도시에서 출발해 다른 도시에 도착할 때 비용이 발생하는 m개의 버스가 있을 때 모든 도시 쌍에 대해
 * 한 도시에서 다른 도시로 가는데 필요한 비용의 최솟값을 구해라 입력 : 도시의 개수 n 버스의 개수 m m개 줄~버스의 출발 도시 번호
 * a, 도착 도시 b, 한번 타는데 필요한 비용 c 제약 : a =/= b 0 < c <= 100,000 출력 : n개의 줄 ~ i번째 줄
 * j번째 숫자는 도시 i에서 j로 가는데 필요한 최소 비용 (i에서 j로 갈 수 없을 때는 0을 출력) 98% 틀림 : 처음에 i에서 i로
 * 가는 비용을 0으로, 나머지는 INF로 설정해놓았는데, 갈 수 없는 곳은 값이 바뀌지 않아서 INF가 그대로 남아있었다. 마지막 출력에
 * 처리해주었다! 사소한 조건 까먹지 않기 - 반례 : 2 1 1 2 1
 * 
 * @author chaeu
 *
 */
public class BOJ_11404_플로이드 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수
        int[][] matrix = new int[n + 1][n + 1];
        final int INF = 987564321;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    matrix[i][j] = 0;
                else
                    matrix[i][j] = INF;
            }
        }

        // 버스 정보 m개 입력받기
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()); // 시작 도시
            int b = Integer.parseInt(st.nextToken()); // 도착 도시
            int c = Integer.parseInt(st.nextToken()); // 한 번 타는데 필요한 비용
            if (matrix[a][b] < c)
                continue; // 더 작은 비용의 버스가 이미 있다면 저장하지 않는다.
            matrix[a][b] = c;
        }

        // 플로이드-와샬
        for (int k = 1; k <= n; k++) { // 경유지
            for (int i = 1; i <= n; i++) { // 출발지
                for (int j = 1; j <= n; j++) { // 도착지
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        // 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i][j] == INF)
                    matrix[i][j] = 0; // 값이 바뀌지 않았다면 갈 수 없는 경우이므로 0으로 세팅한다.
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

}
