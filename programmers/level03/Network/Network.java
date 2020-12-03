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

*/

public class Network {
    public int network(int n, int[][] computers) {
        int answer = 0;
        int row = computers.length;
        int col = computers[0].length;
        int networks = computers.length;
        
        for(int i = 0; i < row-1; i++) {
                if(computers[i][i+1] == 1){
                    if(i > 0){
                        if(computers[i-1][i] == 1 && computers[i-1][i+1] == 1)
                            continue;
                        i--;
                    }                
                    networks -= 1;
                } 
        }
        
        return networks;
    }
    public static void main(String[] args) {
        Network n1 = new Network();
        
    }
}