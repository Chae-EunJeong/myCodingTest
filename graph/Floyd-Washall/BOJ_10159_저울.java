import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요구사항 : 물건의 개수 N과 일부 물건쌍의 무게 비교 결과가 주어졌을 때, 각 물 입력 : 물건의 개수 N 미리 측정된 물건쌍의 개수 M
 * M개 줄~ 측정된 물건 번호 a b (a의 무게 > b의 무게) 제약 : 5 <= N <= 100 0 <= M <= 2000 출력 :
 * N개의 줄 ~ i번째 줄에는 물건 i와 비교 결과를 알 수 없는 물건의 개수
 * 
 * 주의사항 : 플로이드 와샬로 나보다 무게가 큰 물건과의 차이를 최단경로 개념으로 구할 수 있었다. 주의해야할 점은 비교 결과를 알 수
 * 있는지의 여부이므로, (i,j)가 나타내는 더 큰 무게로의 차이 뿐만이 아니라 (j,i)에서 구해진 크기 비교가 있다면 "내가 더 작다"는
 * 비교 결과를 알 수 있다. 그래서 최종적으로 값이 변하지 않은 값들만 그 물건과의 비교가 안 된 것이므로 해당 개수만 세어주면 된다.
 * 
 * @author chaeu
 *
 */
public class BOJ_10159_저울 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 물건의 개수
        int M = Integer.parseInt(br.readLine()); // 측정된 물건쌍의 개수
        int[][] matrix = new int[N + 1][N + 1];
        final int INF = 987654321;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j)
                    matrix[i][j] = 0;
                else
                    matrix[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[a][b] = 1;
        }

        // 플로이드 와샬 (i보다 j가 더 무거운지 바로 비교할 수 없고, i보다 무거운 k 보다 j가 더 무거운지를 따질 수 있을 때 비교
        // 가능하다!)
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                // i보다 j가 더 무겁진 않지만, j보다 i가 더 무겁다는 결과가 있으면, 비교 가능하므로 값을 넣어준다.
                if (matrix[j][i] != INF)
                    matrix[i][j] = matrix[j][i];
                // 비교 불가능할 때 개수 세기
                if (matrix[i][j] == INF)
                    cnt++;
            }
            System.out.println(cnt);
        }
    }

}
