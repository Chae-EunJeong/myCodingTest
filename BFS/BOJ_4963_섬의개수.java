import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            int[][] map = new int[h][w];
            boolean[][] visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 0) visited[i][j] = true;
                }
            }

            int count = 0;
            // 모든 맵 돌면서
            // 1이면 bfs
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (visited[i][j]) continue;

                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                    while(!queue.isEmpty()) {
                        int[] temp = queue.poll();
                        int x = temp[0];
                        int y = temp[1];
                        for (int d = 0; d < 8; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if (nx >= h || ny >= w || nx < 0 || ny < 0) continue;
                            if (visited[nx][ny]) continue;

                            queue.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
