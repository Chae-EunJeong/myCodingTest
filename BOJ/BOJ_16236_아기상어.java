package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

/**
 * 요구사항 : N X N 크기의 공간에 물고기 M마리와 아기 상어 1마리가 있을 때, 아기 상어가 몇 초동안 물고기를 잡아먹을 수 있는지 구해라
 *          처음 아기상어의 크기는 2이고, 아기상어는 1초에 상하좌우로 인접한 한 칸씩 이동
 *          아기상어는 자기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다.
 *          아기상어는 자기보다 작은 물고기만 먹을 수 있고, 크기가 같은 물고기는 먹을 수는 없다.
 *          먹을 수 있는 물고기가 1마리보다 많다면 거리가 가장 가까운 물고기를 먹으러 간다.
 *          아기상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다.
 *          거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
 * 입력 : 첫째줄 ~ 공간의 크기 N
 *       N개줄 ~ 공간의 상태
 *              (0 : 빈칸 / 1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기 / 9 : 아기 상어의 위치)
 * 출력 : 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간
 * 제약 : 2 ≤ N ≤ 20
 * 종류 : simulation, bfs
 */
public class BOJ_16236_아기상어 {

    static class Shark {
        int x; int y; int dist;
        public Shark(int x, int y, int dist) {
            super();
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int N, babySize, ans;
    static int[][] space;
    static Shark babyShark;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        babySize = 2;
        ans = 0;
        space = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] == 9) {
                    babyShark = new Shark(i, j, 0);
                }
            }
        }
        bfs();
        System.out.println(ans);
    }

    private static void bfs() {
        int cnt = 0; // 크기 증가 조건 : 자신의 크기와 같은 수의 물고기를 먹을 때
        int x = babyShark.x;
        int y = babyShark.y;
        while (true) {
            ArrayList<Shark> list = new ArrayList<>();  // 먹을 수 있는 물고기 리스트(상어의 새로운 위치)
            Queue<Shark> queue = new LinkedList<>();
            boolean[][] visited = new boolean[N][N];
            queue.offer(new Shark(x, y, 0));
            visited[x][y] = true;

            while (!queue.isEmpty()) {
                Shark current = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || space[nx][ny] > babySize) continue;
                    Shark newShark = new Shark(nx, ny, current.dist + 1);
                    if (space[nx][ny] < babySize && space[nx][ny] != 0) list.add(newShark);
                    queue.offer(newShark);
                    visited[nx][ny] = true;
                }
            }

            if (list.isEmpty()) return;

            // 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
            Collections.sort(list, new Comparator<Shark>() {
                @Override
                public int compare(Shark o1, Shark o2) {
                    if (o1.dist == o2.dist) {
                        if (o1.x == o2.x) {
                            return o1.y - o2.y;
                        }
                        return o1.x - o2.x;
                    }
                    return o1.dist - o2.dist;
                }
            });

            Shark eaten = list.get(0);
            ans += eaten.dist;
            space[x][y] = 0;
            space[eaten.x][eaten.y] = 9;
            cnt++;
            if (babySize == cnt) {
                cnt = 0;
                babySize++;
            }
            x = eaten.x;
            y = eaten.y;
        }

    }
    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(space[i][j] + " ");
            }
            System.out.println();
        }

    }
}