import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 요구사항 : 마당에 양과 늑대가 있다. 울타리 안에서 규칙에 따라 살아남은 양과 늑대의 수를 출력해라
 * 규칙 : 양의 수가 늑대의 수보다 많다면 양이 이긴다. 그렇지 않으면 늑대가 모든 양을 먹는다.
 *      글자 '#'는 울타리를, 'o'는 양, 'v'는 늑대를 의미
 * 입력 : 마당의 행과 열 R, C
 *      다음 R개줄~ 마당의 구조
 * 출력 : 살아있는 양과 늑대의 수
 * 제약 : 3 ≤ R, C ≤ 250
 * 풀이 : 마당 전체를 돌면서, o나 v를 만나면 bfs 진행
 *      bfs ~ o와 v의 수를 각각 센 후 최종 수를 비교
 */

public class BOJ_3184_양 {
    static int R, C;
    static char[][] backyard;
    static boolean[][] visited;
    static int answerO = 0, answerV = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        backyard = new char[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            char[] temp = br.readLine().toCharArray();
            for (int c = 0; c < C; c++) {
                backyard[r][c] = temp[c];
                if (backyard[r][c] == '#') {
                    visited[r][c] = true;
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (!visited[r][c]) {
                    bfs(r, c);
                }
            }
        }
        System.out.println(answerO + " " + answerV);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    private static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {r, c});

        int oCnt = 0;
        int vCnt = 0;
        if (backyard[r][c] == 'o') oCnt++;
        if (backyard[r][c] == 'v') vCnt++;
        visited[r][c] = true;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (visited[nx][ny]) continue;
                if (backyard[nx][ny] == 'o') oCnt++;
                if (backyard[nx][ny] == 'v') vCnt++;
                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
            }
        }
        if (oCnt > vCnt) answerO += oCnt;
        else answerV += vCnt;
    }
}
