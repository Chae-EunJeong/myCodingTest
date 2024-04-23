import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 요구사항 : 모눈종이 위에서 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나뉘는지, 그리고 분리된 각 영역의 넓이가 얼마인지를 구하라.
 * 입력 : 모눈종이 크기 M X N, K개의 직사각형
 *      K개줄 ~ 직사각형의 왼쪽 아래 꼭짓점의 x,y 좌표값, 오른쪽 위 꼭짓점의 x,y 좌표값
 * 출력 : 분리되어 나누어지는 영역의 개수
 *      각 영역의 넓이를 오름차순으로 정렬
 * 제약 : 모눈종이의 왼쪽 아래 꼭짓점의 좌표는 (0,0) 오른쪽 위 꼭짓점의 좌표는 (N,M)
 *      눈금의 간격은 1
 *      M,N <= 100
 * 풀이 : 모눈종이를 좌표로 풀 것 -> K개 줄에 0 2 4 4 이면 0,2 / 4-1, 4-1 로 좌표 찍기
 */
public class BOJ_2583_영역구하기 {
    private static int[][] area;
    private static boolean[][] visited;
    private static int M, N;
    private static ArrayList<Integer> answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        area = new int[N][M];
        visited = new boolean[N][M];
        answer = new ArrayList<>();


        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int fromX = Integer.parseInt(st.nextToken());
            int fromY = Integer.parseInt(st.nextToken());
            int toX = Integer.parseInt(st.nextToken());
            int toY = Integer.parseInt(st.nextToken());
            fillSquare(fromX, fromY, toX, toY);
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (area[j][i] == 0 && !visited[j][i]) {
                    bfs(j, i);
                    count++;
                }
            }
        }

        System.out.println(count);
        Collections.sort(answer);
        for(Integer i : answer) {
            System.out.print(i + " ");
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {y, x});
        visited[y][x] = true;
        int size = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int d = 0; d < 4; d++) {
                int ny = current[0] + dy[d];
                int nx = current[1] + dx[d];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if (visited[ny][nx]) continue;
                if (area[ny][nx] == 1) continue;
                queue.offer(new int[] {ny, nx});
                visited[ny][nx] = true;
                size++;
            }
        }
        answer.add(size);
    }

    private static void fillSquare(int fromX, int fromY, int toX, int toY) {
        for (int i = fromY; i < toY; i++) {
            for (int j = fromX; j < toX; j++) {
                area[j][i] = 1;
                visited[j][i] = true;
            }
        }
    }
}
