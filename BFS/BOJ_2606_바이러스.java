import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 요구사항 : 한 컴퓨터가 바이러스에 걸리면 그 컴퓨터와 연결된 모든 컴퓨터가 바이러스에 걸릴때, 바이러스에 걸리게되는 컴퓨터의 수를 구해라
 * 입력 : 컴퓨터의 수 / 연결되어있는 컴퓨터 쌍의 수 / 쌍의 수만큼 ~ 연결되어있는 컴퓨터의 번호 쌍
 * 출력 : 1번 컴퓨터가 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 바이러스에 걸리게 되는 컴퓨터의 수
 * 제약 : 0 < 컴퓨터의 수 <= 100
 */
public class BOJ_2606_바이러스 {
    static List[] network;
    static int answer;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine());    // 연결되어있는 컴퓨터 쌍의 수
        network = new List[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            network[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            network[a].add(b);
            network[b].add(a);
        }
        bfs(1);

        System.out.println(answer - 1);

    }

    private static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            if (!visited[current]) {
                answer++;
                visited[current] = true;
                for (int i = 0; i < network[current].size(); i++) {
                    queue.add((Integer)network[current].get(i));
                }
            }
        }
    }
}
