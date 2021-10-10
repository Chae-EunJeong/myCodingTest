package programmers.level03.Network;

/*
- 요구사항 : 컴퓨터들의 연결 정보를 가지고 존재하는 네트워크의 개수를 반환해라.
- 함수
    - input : 컴퓨터의 개수(int n), 연결에 대한 정보(int[][] computers)
    - constraints : 1 <= n <= 200
                    각 컴퓨터의 순번은 0부터 n-1로 표현
                    i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computer[i][j] = 1
                    자기 자신에 대한 연결정보는 항상 1 (computers[i][j] = 1)
    - output : 네트워크의 개수 (int)
- 손코딩
    모든 노드의 방문 여부를 거짓으로 초기화하기
    0번 노드부터 끝 노드까지 반복하면서,
        방문한 적이 없으면
            네트워크 수 증가
            해당 노드의 깊이 우선 탐색 진행
    
    깊이 우선 탐색(노드, 2차원배열, 방문 여부 배열)
        해당 노드의 방문 여부를 참으로 바꾸고
        노드에서 연결된 링크가 있고, 연결된 노드를 방문한 적이 없으면
            그 노드에서 다시 깊이 우선 탐색 진행
- 깊이 우선 탐색(모르겠어서 issue 파놨음)
    이 문제는 깊이 우선 탐색의 근본을 이해하는 것이 중요했다!
    이차원 배열을 가지고 직접 탐색하는 게 아니라, 
    그거와는 상관없이 노드를 중심으로 생각하고 문제를 풀었어야했다.

    처음에는 for문과 if문 3개로, 이차원 배열을 다 탐색하면서, 
    networks수를 전체 노드수 빼기 1의 개수로 복잡하게 계산해나갔고,
    게다가 그 노드랑 연결된 전 노드의 배열에서 1이 두개가 나오면 그냥 pass하는 식으로
    (글로 쓰기 복잡할 정도로 거지같고, 풀어나간 과정은 노트에 있음)
    암튼 이렇게 풀었더니 시간 초과가 나서 실패..
    결국 구글링으로 찾아봐서 dfs를 재귀로 푸는 것과 방문 여부를 체크한다는 걸 힌트로 얻고
    DFS라는 근본 알고리즘 문제로 생각했더니 간단했다.
*/

public class Network {
    public int network(int n, int[][] computers) {
        int answer = 0;
        int nodes = computers.length;
        boolean[] visited = new boolean[nodes];
        
        //모든 노드의 방문 여부를 false로 초기화
        for(int i = 0; i < nodes; i++) {
            visited[i] = false;
        }
        
        for(int j = 0; j < nodes; j++) {
            //해당 노드를 방문한 적이 없으면 깊이우선탐색 진행
            if(!visited[j]) {
                //방문한 적이 없다는 것은 네트워크가 분리되어있음을 의미
                answer++;
                dfs(j, visited, computers);
            }    
        }
        return answer;
    }

    public void dfs(int n, boolean[] visited, int[][] computers) {
        visited[n] = true;
        for(int i = 0; i < computers.length; i++) {
            if(computers[n][i] == 1 && !visited[i])
                dfs(i, visited, computers);
        }
    }

    public static void main(String[] args) {
        Network n1 = new Network();
        int n = 3;
        int[][] computers = {{1,1,0}, {1,1,1}, {0,1,1}};    //Expected return value is 1
        System.out.println(n1.network(n, computers));
    }
}